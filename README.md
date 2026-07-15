# cloud-itonami-municipality-col-bogota

Municipal-ordinance compliance catalog for **Bogotá** — the EIGHTEENTH
municipality-level entry alongside
[`cloud-itonami-municipality-jpn-tokyo`](https://github.com/cloud-itonami/cloud-itonami-municipality-jpn-tokyo),
[`cloud-itonami-municipality-usa-washington-dc`](https://github.com/cloud-itonami/cloud-itonami-municipality-usa-washington-dc),
[`cloud-itonami-municipality-gbr-london`](https://github.com/cloud-itonami/cloud-itonami-municipality-gbr-london),
[`cloud-itonami-municipality-can-toronto`](https://github.com/cloud-itonami/cloud-itonami-municipality-can-toronto),
[`cloud-itonami-municipality-deu-berlin`](https://github.com/cloud-itonami/cloud-itonami-municipality-deu-berlin),
[`cloud-itonami-municipality-fra-paris`](https://github.com/cloud-itonami/cloud-itonami-municipality-fra-paris),
[`cloud-itonami-municipality-nld-amsterdam`](https://github.com/cloud-itonami/cloud-itonami-municipality-nld-amsterdam),
[`cloud-itonami-municipality-esp-madrid`](https://github.com/cloud-itonami/cloud-itonami-municipality-esp-madrid),
[`cloud-itonami-municipality-kor-seoul`](https://github.com/cloud-itonami/cloud-itonami-municipality-kor-seoul),
[`cloud-itonami-municipality-ita-roma`](https://github.com/cloud-itonami/cloud-itonami-municipality-ita-roma),
[`cloud-itonami-municipality-aus-sydney`](https://github.com/cloud-itonami/cloud-itonami-municipality-aus-sydney),
[`cloud-itonami-municipality-arg-buenos-aires`](https://github.com/cloud-itonami/cloud-itonami-municipality-arg-buenos-aires),
[`cloud-itonami-municipality-fin-helsinki`](https://github.com/cloud-itonami/cloud-itonami-municipality-fin-helsinki),
[`cloud-itonami-municipality-dnk-copenhagen`](https://github.com/cloud-itonami/cloud-itonami-municipality-dnk-copenhagen),
[`cloud-itonami-municipality-nor-oslo`](https://github.com/cloud-itonami/cloud-itonami-municipality-nor-oslo),
[`cloud-itonami-municipality-bel-brussels`](https://github.com/cloud-itonami/cloud-itonami-municipality-bel-brussels),
and
[`cloud-itonami-municipality-chl-santiago`](https://github.com/cloud-itonami/cloud-itonami-municipality-chl-santiago).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on the Alcaldía Mayor
de Bogotá's behalf.

Coverage is reported honestly (see `ordinance.facts/coverage`): a
municipality not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/ordinance/facts.cljc` — the catalog, source of truth.
- `schema/ordinance.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Mexico City (`cdmx.gob.mx`) was attempted first this tick, but its
entire hosting cluster was unreachable across three subdomains
(same IP). Bogotá's usual first-choice portal (`alcaldiabogota.gov.co`)
was also unreachable. Both entries here instead cite
[secretariageneral.gov.co](https://secretariageneral.gov.co/transparencia-y-acceso-la-informacion-publica/normativa-aplicable/acuerdos)'s
own "acuerdos" listing page, which rendered fully: **Acuerdo 001 de
2026** (technical standards for digital authentication, 2026-02-05) and
**Acuerdo 002 de 2025** (internal regulations for the Quality Spending
and District Modernization Commission, 2025-10-28).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Ordinance text
itself remains Bogotá's; this repo stores only citation metadata
(id/title/url/dates), not full text.
