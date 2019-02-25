(defproject hk.gavin/tabula-api "1.1.0-SNAPSHOT"
  :description "An API server extracting tables from PDF files via tabula-java."
  :url "https://github.com/gavinkflam/tabula-api"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"
            :key "mit"
            :year 2018}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [commons-cli/commons-cli "1.4"]
                 [io.pedestal/pedestal.service "0.5.5"]
                 [io.pedestal/pedestal.immutant "0.5.5"]
                 [org.apache.tika/tika-core "1.20"]
                 [org.slf4j/slf4j-simple "1.7.26"]
                 [technology.tabula/tabula "1.0.2"]]
  :source-paths ["src/main/clj"]
  :test-paths ["src/test/clj"]
  :resource-paths ["src/main/resources"]
  :profiles {:dev {:dependencies [[clj-http "3.9.1"]
                                  [commons-io/commons-io "2.6"]]
                   :plugins [[jonase/eastwood "0.3.5"
                              :exclusions [org.clojure/clojure]]
                             [lein-bikeshed "0.5.1"]
                             [lein-cloverage "1.0.13"
                              :exclusions [org.clojure/clojure]]
                             [lein-cljfmt "0.6.4"
                              :exclusions [org.clojure/clojure
                                           rewrite-cljs]]
                             [lein-kibit "0.1.6"
                              :exclusions [org.clojure/clojure]]
                             [lein-nvd "0.6.0"]]
                   :resource-paths ["src/test/resources"]
                   ; Temporarily disable nvd failure until pedestal 0.5.4
                   :nvd {:fail-threshold 11}}}
  :main hk.gavin.tabula-api.server
  :aot [hk.gavin.tabula-api.server])
