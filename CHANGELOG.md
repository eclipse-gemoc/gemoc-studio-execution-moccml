# Changelog

## v3.6.0 (06/04/2023)

#### Enhancements:

- [**enhancement**] Manage step return values [#73](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/73)
- [**enhancement**] WIP adding a new filtering strategy rule [#67](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/67)
- [**enhancement**] Initial version of a Webprotocol based EngineAddon server [#68](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/68)
- [**enhancement**] Formal analysis by exhaustive simulation update [#62](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/62)
- [**enhancement**] Formal analysis by exhaustive simulation [#60](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/60)
- [**enhancement**] Add Sirius ELK support [#50](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/50)
- [**enhancement**] update the formal analysis branch wrt changes done in the master [#53](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/53)
- [**enhancement**] Improve default Engine addon launch conf tab [#30](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/30)
- [**enhancement**] ValidationRule added to languageComponent in plugin [#45](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/45)
- [**enhancement**] "metaprog" entry added to dsl files for the MOCCML examples [#42](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/42)
- [**enhancement**] Metaprogramming approach name changed to FullyQualifiedName [#43](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/43)
- [**enhancement**] Metaprog plugin modified to fit new extension point description + added LanguageComponent [#44](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/44)
- [**enhancement**] Validatation plug-in for the MOCCML meta-programming approach in GEMOC Studio [#39](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/39)
- [**enhancement**] Builder supports aspects separated by a comma and whitespace [#40](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/40)
- [**bug**][**enhancement**] Improve RTDAccessor generator [#34](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/34)
- [**enhancement**] Make EventSchedulingModelExecutionTracingAddon not default [#28](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/28)
- [**enhancement**] Adding possible "moccmlmapping" extensions to ecl file [#3](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/3)
- [**enhancement**] Clarifies Eclipse consoles used by the engines [#17](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/17)
- [**enhancement**] Add possibility to express priorities between DSE  [#4](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/4)
- [**enhancement**] Renaming of MelangeXDSMLHelper into XDSMLHelper [#13](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/13)
- [**enhancement**][**documentation**][**releng**] Add sigpml example deployer [#12](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/12)
- [**enhancement**] Add concurrent engine to studio [#1](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/1)

#### Bug Fixes:

- [**bug**] Bump to version of k3 including StepCommand return null fix [#74](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/74)
- [**bug**] Fix moccml examples [#47](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/47)
- [**bug**] Re-enable dispatch call to applyMSEFutureStates [#38](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/38)
- [**bug**] Fix xdsmlFilePath attribute in plugin.xml [#33](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/33)
- [**bug**] Fix the triggering of moccml builder [#31](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/31)
- [**bug**] Fix official sample [#2](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/2)

#### Refactorings

- [**refactoring**] Split commons eclipse pde to remove UI dependency [#70](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/70)
- [**refactoring**] Move moccml metaprog plugin to proper place in repo and deploy in studio [#46](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/46)
- [**refactoring**] Add DefaultConcurrentModelExecutionContext [#27](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/27)
- [**refactoring**] Use general extension point + nature and builder refactoring [#25](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/25)
- [**refactoring**] Simplify concurrent API [#20](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/20)

#### Version upgrades

- [**bump**] Bump to Eclipse 2022-06 [#69](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/69)
- [**bump**] Bump to 3.5.0 [#64](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/64)
- [**bump**] Bump eclipse 2021 12 [#65](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/65)
- [**releng**][**bump**] Bump Studio to 3.4.0 [#55](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/55)
- [**bump**] Bump to Eclipse 2021-06 [#54](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/54)
- [**bump**] Bump eclipse 2020-12 [#49](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/49)
- [**bump**] Bump to Eclipse 2020-03 [#48](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/48)

#### Release Engineering

- [**releng**] Use tpd for defining target platform [#66](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/66)
- [**releng**] Consolidation and automatic bump of K3 versions [#51](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/51)
- [**releng**] Deploy GEMOC artefacts to maven repository (repo.eclipse.org) [#35](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/35)
- [**releng**] Change Timesquare updatesite [#32](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/32)
- [**releng**] Tycho 1.5 and p2 dependencies optimisation [#29](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/29)
- [**releng**] Remove deprecated update site [#23](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/23)
- [**releng**] Add gexpressions to studio/updatesite and restructure update site [#16](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/16)
- [**releng**] Update icons to official branding colors [#14](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/14)

---

## v3.5.0 (30/06/2022)

#### Enhancements:

- [**enhancement**] Manage step return values [#73](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/73)
- [**enhancement**] WIP adding a new filtering strategy rule [#67](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/67)
- [**enhancement**] Initial version of a Webprotocol based EngineAddon server [#68](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/68)
- [**enhancement**] Formal analysis by exhaustive simulation update [#62](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/62)
- [**enhancement**] Formal analysis by exhaustive simulation [#60](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/60)
- [**enhancement**] Add Sirius ELK support [#50](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/50)
- [**enhancement**] update the formal analysis branch wrt changes done in the master [#53](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/53)
- [**enhancement**] Improve default Engine addon launch conf tab [#30](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/30)
- [**enhancement**] ValidationRule added to languageComponent in plugin [#45](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/45)
- [**enhancement**] "metaprog" entry added to dsl files for the MOCCML examples [#42](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/42)
- [**enhancement**] Metaprogramming approach name changed to FullyQualifiedName [#43](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/43)
- [**enhancement**] Metaprog plugin modified to fit new extension point description + added LanguageComponent [#44](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/44)
- [**enhancement**] Validatation plug-in for the MOCCML meta-programming approach in GEMOC Studio [#39](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/39)
- [**enhancement**] Builder supports aspects separated by a comma and whitespace [#40](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/40)
- [**bug**][**enhancement**] Improve RTDAccessor generator [#34](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/34)
- [**enhancement**] Make EventSchedulingModelExecutionTracingAddon not default [#28](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/28)
- [**enhancement**] Adding possible "moccmlmapping" extensions to ecl file [#3](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/3)
- [**enhancement**] Clarifies Eclipse consoles used by the engines [#17](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/17)
- [**enhancement**] Add possibility to express priorities between DSE  [#4](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/4)
- [**enhancement**] Renaming of MelangeXDSMLHelper into XDSMLHelper [#13](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/13)
- [**enhancement**][**documentation**][**releng**] Add sigpml example deployer [#12](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/12)
- [**enhancement**] Add concurrent engine to studio [#1](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/1)

#### Bug Fixes:

- [**bug**] Bump to version of k3 including StepCommand return null fix [#74](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/74)
- [**bug**] Fix moccml examples [#47](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/47)
- [**bug**] Re-enable dispatch call to applyMSEFutureStates [#38](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/38)
- [**bug**] Fix xdsmlFilePath attribute in plugin.xml [#33](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/33)
- [**bug**] Fix the triggering of moccml builder [#31](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/31)
- [**bug**] Fix official sample [#2](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/2)

#### Refactorings

- [**refactoring**] Split commons eclipse pde to remove UI dependency [#70](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/70)
- [**refactoring**] Move moccml metaprog plugin to proper place in repo and deploy in studio [#46](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/46)
- [**refactoring**] Add DefaultConcurrentModelExecutionContext [#27](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/27)
- [**refactoring**] Use general extension point + nature and builder refactoring [#25](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/25)
- [**refactoring**] Simplify concurrent API [#20](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/20)

#### Version upgrades

- [**bump**] Bump to Eclipse 2022-06 [#69](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/69)
- [**bump**] Bump to 3.5.0 [#64](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/64)
- [**bump**] Bump eclipse 2021 12 [#65](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/65)
- [**releng**][**bump**] Bump Studio to 3.4.0 [#55](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/55)
- [**bump**] Bump to Eclipse 2021-06 [#54](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/54)
- [**bump**] Bump eclipse 2020-12 [#49](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/49)
- [**bump**] Bump to Eclipse 2020-03 [#48](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/48)

#### Release Engineering

- [**releng**] Use tpd for defining target platform [#66](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/66)
- [**releng**] Consolidation and automatic bump of K3 versions [#51](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/51)
- [**releng**] Deploy GEMOC artefacts to maven repository (repo.eclipse.org) [#35](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/35)
- [**releng**] Change Timesquare updatesite [#32](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/32)
- [**releng**] Tycho 1.5 and p2 dependencies optimisation [#29](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/29)
- [**releng**] Remove deprecated update site [#23](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/23)
- [**releng**] Add gexpressions to studio/updatesite and restructure update site [#16](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/16)
- [**releng**] Update icons to official branding colors [#14](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/14)

---

## v3.4.0 (10/01/2022)

#### Enhancements:

- [**enhancement**] Formal analysis by exhaustive simulation update [#62](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/62)
- [**enhancement**] Formal analysis by exhaustive simulation [#60](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/60)

#### Version upgrades

- [**releng**][**bump**] Bump Studio to 3.4.0 [#55](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/55)

---

## v3.3.0 (28/07/2021)

#### Enhancements:

- [**enhancement**] Add Sirius ELK support [#50](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/50)
- [**enhancement**] update the formal analysis branch wrt changes done in the master [#53](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/53)

#### Version upgrades

- [**bump**] Bump to Eclipse 2021-06 [#54](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/54)
- [**bump**] Bump eclipse 2020-12 [#49](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/49)
- [**bump**] Bump to Eclipse 2020-03 [#48](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/48)

#### Release Engineering

- [**releng**] Consolidation and automatic bump of K3 versions [#51](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/51)

---

## v3.2.0 (16/06/2020)

#### Enhancements:

- [**enhancement**] Improve default Engine addon launch conf tab [#30](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/30)
- [**enhancement**] ValidationRule added to languageComponent in plugin [#45](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/45)
- [**enhancement**] "metaprog" entry added to dsl files for the MOCCML examples [#42](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/42)
- [**enhancement**] Metaprogramming approach name changed to FullyQualifiedName [#43](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/43)
- [**enhancement**] Metaprog plugin modified to fit new extension point description + added LanguageComponent [#44](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/44)
- [**enhancement**] Validatation plug-in for the MOCCML meta-programming approach in GEMOC Studio [#39](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/39)
- [**enhancement**] Builder supports aspects separated by a comma and whitespace [#40](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/40)
- [**bug**][**enhancement**] Improve RTDAccessor generator [#34](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/34)
- [**enhancement**] Make EventSchedulingModelExecutionTracingAddon not default [#28](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/28)
- [**enhancement**] Clarifies Eclipse consoles used by the engines [#17](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/17)

#### Bug Fixes:

- [**bug**] Re-enable dispatch call to applyMSEFutureStates [#38](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/38)
- [**bug**] Fix moccml examples [#47](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/47)
- [**bug**] Fix xdsmlFilePath attribute in plugin.xml [#33](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/33)
- [**bug**] Fix the triggering of moccml builder [#31](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/31)

#### Refactorings

- [**refactoring**] Move moccml metaprog plugin to proper place in repo and deploy in studio [#46](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/46)
- [**refactoring**] Add DefaultConcurrentModelExecutionContext [#27](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/27)
- [**refactoring**] Use general extension point + nature and builder refactoring [#25](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/25)
- [**refactoring**] Simplify concurrent API [#20](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/20)

#### Release Engineering

- [**releng**] Deploy GEMOC artefacts to maven repository (repo.eclipse.org) [#35](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/35)
- [**releng**] Change Timesquare updatesite [#32](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/32)
- [**releng**] Tycho 1.5 and p2 dependencies optimisation [#29](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/29)
- [**releng**] Remove deprecated update site [#23](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/23)

---

## v3.2.0-20191216 (16/12/2019)

#### Enhancements:

- [**enhancement**] Make EventSchedulingModelExecutionTracingAddon not default [#28](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/28)
- [**enhancement**] Clarifies Eclipse consoles used by the engines [#17](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/17)

#### Bug Fixes:

- [**bug**] Fix the triggering of moccml builder [#31](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/31)

#### Refactorings

- [**refactoring**] Add DefaultConcurrentModelExecutionContext [#27](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/27)
- [**refactoring**] Use general extension point + nature and builder refactoring [#25](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/25)
- [**refactoring**] Simplify concurrent API [#20](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/20)

#### Release Engineering

- [**releng**] Change Timesquare updatesite [#32](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/32)
- [**releng**] Tycho 1.5 and p2 dependencies optimisation [#29](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/29)
- [**releng**] Remove deprecated update site [#23](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/23)

---

## v3.1.0 (29/07/2019)
*No changelog for this release.*

---

## v3.1.0-20190627 (27/06/2019)

#### Enhancements:

- [**enhancement**] Adding possible "moccmlmapping" extensions to ecl file [#3](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/3)
- [**enhancement**] Add possibility to express priorities between DSE  [#4](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/4)
- [**enhancement**] Renaming of MelangeXDSMLHelper into XDSMLHelper [#13](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/13)
- [**documentation**][**enhancement**][**releng**] Add sigpml example deployer [#12](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/12)
- [**enhancement**] Add concurrent engine to studio [#1](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/1)

#### Bug Fixes:

- [**bug**] Fix official sample [#2](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/2)

#### Release Engineering

- [**releng**] Add gexpressions to studio/updatesite and restructure update site [#16](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/16)
- [**releng**] Update icons to official branding colors [#14](https://github.com/eclipse/gemoc-studio-execution-moccml/pull/14)
