(ns leiningen.new.alfjar
  (:require [leiningen.new.templates :refer [renderer year project-name
                                             ->files sanitize-ns name-to-path
                                             multi-segment]]
            [leiningen.core.main :as main]))

(defn alfjar
  "The lein-new template for Alfresco Module Package (ALFJAR) projects."
  [name]
  (let [render  (renderer "alfjar")
        main-ns (multi-segment (sanitize-ns name))
        data    { :raw-name    name
                  :name        (project-name name)
                  :namespace   main-ns
                  :nested-dirs (name-to-path main-ns)
                  :year        (year) }]
    (main/info "Generating a project called" name "based on the 'alfjar' template.")
    (main/info "To see other templates (app, plugin, etc), try `lein help new`.")
    (->files data
             [".gitignore"  (render "gitignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md"   (render "README.md" data)]
             ["LICENSE"     (render "LICENSE" data)]
             "src"
;;             "src/alfjar"
             ["src/resource/alfresco/module/{{namespace}}/module.properties" (render "module.properties" data)]
;;             "src/alfjar/web"
;;             "src/alfjar/web/css/{{namespace}}"
;;             "src/alfjar/web/images/{{namespace}}"
;;             "src/alfjar/web/scripts/{{namespace}}"
;;             "src/alfjar/config"

             "src/resource/alfresco/extension/templates/webscripts/{{namespace}}"
             "src/resource/alfresco/module/{{namespace}}"
             ["src/resource/alfresco/module/{{namespace}}/module-context.xml" (render "module-context.xml" data)]
             "src/resource/alfresco/module/{{namespace}}/context"
             "src/resource/alfresco/module/{{namespace}}/licences"
             "src/clojure"
             ["src/clojure/{{nested-dirs}}.clj" (render "core.clj" data)]
             ["test/{{nested-dirs}}_test.clj" (render "test.clj" data)])))
