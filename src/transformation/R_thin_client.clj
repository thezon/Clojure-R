(ns transformation.R-thin-client)

(defn gen-R->raw [data]
  data)

(defn gen-R->def [var-name value]
  (str var-name "<-" value))

(defn gen-R->keyword [value]
   value)
  
(defn gen-R->number [value]
  (str value))
  
(defn gen-R->= [var-name value]
  (str  var-name "=" value))

(defn gen-R->vector [& data]
    (str "c(" (apply str (interpose "," data)) ")"))

(defn gen-R->range [low-val high-val]
  (str low-val ":" high-val ))

(defn gen-R->slurp [path]
  (str "read.table(\"" path "\")"))

(defn gen-R->mean [& data]
     (str "mean(" (apply str (interpose "," data)) ")"))

(defn gen-R->dataframe [& data]
     (str "data.frame(" (apply str (interpose "," data)) ")"))

(defn gen-R->summary [& data]
     (str "summary(" (apply str (interpose "," data)) ")"))

(defn gen-R-post-proc [data]
  (apply str (interpose ";" data)))

(defn gen-R->dataframe? [& data]
  (str "is.data.frame(" (apply str (interpose "," data)) ")"))

(defn gen-R->vector? [data]
  (str "is.vector(" data ")"))

(defn gen-R->rownames [& data]
  (str "row.names(" (apply str (interpose "," data)) ")"))

(defn gen-R->matrix [& data]
  (str "matrix(" (apply str (interpose "," data)) ")"))

(defn gen-R->stripchart [& data]
  (str "stripchart("  (apply str (interpose "," data)) ")"))

(defn gen-R->histogram [& data]
  (str "hist(" (apply str (interpose "," data)) ")"))

(defn gen-R->boxplot [& data]
  (str "boxplot(" (apply str (interpose "," data)) ")"))

(defn gen-R->dotchart [& data]
  (str "dotchart(" (apply str (interpose "," data)) ")"))

(defn gen-R->sample [data]
  (str "sample(" data ")"))