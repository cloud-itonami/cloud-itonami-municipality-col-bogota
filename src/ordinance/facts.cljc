(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Bogotá -- the EIGHTEENTH
  municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago for the first seventeen) per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Mexico City (cdmx.gob.mx) was attempted first this tick but its
  entire hosting cluster was unreachable across three different
  subdomains, all resolving to the same IP (connect ECONNREFUSED
  187.218.8.10:443) -- abandoned without forcing it. Bogotá's usual
  first-choice normative portal, alcaldiabogota.gov.co, was likewise
  unreachable (connect ECONNREFUSED 200.75.50.130:443). Every entry
  here instead cites the Alcaldía Mayor de Bogotá's OFFICIAL
  secretariageneral.gov.co 'acuerdos' listing page -- never fabricated.
  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"bogota"
   [{:ordinance/id "bogota.acuerdo-001-2026-autenticacion-digital"
     :ordinance/title "Acuerdo 001 de 2026 (Estándares Técnicos para la Autenticación Digital)"
     :ordinance/municipality "bogota"
     :ordinance/country "COL"
     :ordinance/kind :ordinance
     :ordinance/number "Acuerdo 001 de 2026"
     :ordinance/url "https://secretariageneral.gov.co/transparencia-y-acceso-la-informacion-publica/normativa-aplicable/acuerdos"
     :ordinance/url-provenance :official-secretariageneral-gov-co
     :ordinance/enacted-date "2026-02-05"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:technology-standards :governance}}
    {:ordinance/id "bogota.acuerdo-002-2025-comision-gasto-calidad"
     :ordinance/title "Acuerdo 002 de 2025 (Reglamento Interno de la Comisión de Gasto de Calidad y Modernización Distrital)"
     :ordinance/municipality "bogota"
     :ordinance/country "COL"
     :ordinance/kind :ordinance
     :ordinance/number "Acuerdo 002 de 2025"
     :ordinance/url "https://secretariageneral.gov.co/transparencia-y-acceso-la-informacion-publica/normativa-aplicable/acuerdos"
     :ordinance/url-provenance :official-secretariageneral-gov-co
     :ordinance/enacted-date "2025-10-28"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-col-bogota Wave 0 (ADR-2607141700): "
                 (count (get catalog "bogota")) " Bogotá entries seeded "
                 "with an official secretariageneral.gov.co citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
