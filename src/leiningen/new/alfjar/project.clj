(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :title "FIXME: write title"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license { :name "Eclipse Public License"
             :url "http://www.eclipse.org/legal/epl-v10.html" }
  :min-lein-version "2.0.0"
  :profiles { :dev { :plugins [] }
              :provided { :dependencies [
                                          [org.clojure/clojure "1.6.0"]
                                          [org.clojars.lambdalf/lambdalf "1.9.999"]   ; Not yet available on clojars...
                                        ] }}
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]                                                                                                          
  :resource-paths    ["src/resource"] 
  :javac-target      "1.7"
;;  :amp-source-path "src/amp"
)
