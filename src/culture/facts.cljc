(ns culture.facts
  "Regional-culture catalog for Bogotá -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked onto
  this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"bogota"
   [{:culture/id "bogota.dish.ajiaco"
     :culture/name "Ajiaco"
     :culture/name-local "Ajiaco santafereño"
     :culture/municipality "bogota"
     :culture/country "COL"
     :culture/kind :dish
     :culture/summary "Chicken-and-potato soup made with three potato varieties and the herb guasca; called ajiaco santafereño, it is one of the most representative dishes of Bogotá."
     :culture/url "https://en.wikipedia.org/wiki/Ajiaco"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bogota.dish.changua"
     :culture/name "Changua"
     :culture/municipality "bogota"
     :culture/country "COL"
     :culture/kind :dish
     :culture/summary "Hearty breakfast soup of milk and eggs typical of the central Andes region of Colombia, in particular the Boyacá and Cundinamarca area including the capital, Bogotá."
     :culture/url "https://en.wikipedia.org/wiki/Changua"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bogota.dish.almojabana"
     :culture/name "Almojábana"
     :culture/municipality "bogota"
     :culture/country "COL"
     :culture/kind :dish
     :culture/summary "Bread made with cuajada cheese and corn flour, eaten as a traditional breakfast in Bogotá and the surrounding region."
     :culture/url "https://en.wikipedia.org/wiki/Almoj%C3%A1bana"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bogota.beverage.chicha"
     :culture/name "Chicha"
     :culture/municipality "bogota"
     :culture/country "COL"
     :culture/kind :beverage
     :culture/summary "Fermented maize beverage; in Bogotá it is made from cooked maize ground with black panela, and brewing continued underground after Colombia outlawed chicha in 1949."
     :culture/url "https://en.wikipedia.org/wiki/Chicha"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bogota.festival.rock-al-parque"
     :culture/name "Rock al Parque"
     :culture/municipality "bogota"
     :culture/country "COL"
     :culture/kind :festival
     :culture/summary "Free rock music festival held in Bogotá since 1995, typically attracting over 400,000 spectators."
     :culture/url "https://en.wikipedia.org/wiki/Rock_al_Parque"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bogota.festival.festival-iberoamericano-de-teatro"
     :culture/name "Ibero-American Theater Festival of Bogotá"
     :culture/name-local "Festival Iberoamericano de Teatro de Bogotá"
     :culture/municipality "bogota"
     :culture/country "COL"
     :culture/kind :festival
     :culture/summary "Biennial performing-arts festival held in Bogotá that grew into the largest performing-arts festival in the world, with over 800 performances."
     :culture/url "https://es.wikipedia.org/wiki/Festival_Iberoamericano_de_Teatro_de_Bogot%C3%A1"
     :culture/url-provenance :wikipedia-es
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bogota.heritage.la-candelaria"
     :culture/name "La Candelaria"
     :culture/municipality "bogota"
     :culture/country "COL"
     :culture/kind :heritage
     :culture/summary "Historic neighborhood in Bogotá's downtown area and the city's 17th locality, comparable to the old city of other capitals."
     :culture/url "https://en.wikipedia.org/wiki/La_Candelaria,_Bogot%C3%A1"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bogota.heritage.monserrate"
     :culture/name "Monserrate"
     :culture/municipality "bogota"
     :culture/country "COL"
     :culture/kind :heritage
     :culture/summary "Mountain over 3,000 metres high overlooking the city center of Bogotá, whose 17th-century church is a pilgrimage destination and major tourist attraction."
     :culture/url "https://en.wikipedia.org/wiki/Monserrate"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bogota.heritage.gold-museum"
     :culture/name "Gold Museum"
     :culture/name-local "Museo del Oro"
     :culture/municipality "bogota"
     :culture/country "COL"
     :culture/kind :heritage
     :culture/summary "Archaeology museum in Bogotá holding the largest collection of gold artifacts in the world, from pre-Columbian indigenous cultures of Colombia."
     :culture/url "https://en.wikipedia.org/wiki/Gold_Museum,_Bogot%C3%A1"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-municipality-col-bogota culture catalog "
                 "(ADR-2607171400): " (count (get catalog "bogota"))
                 " Bogotá entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
