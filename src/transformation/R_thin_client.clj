(ns transformation.R-thin-client)

(defn R->raw [data]
  data)

(defn R->def [var-name value]
  (str var-name "<-" value))

(defn R->keyword [value]
   value)
  
(defn R->number [value]
  (str value))

(defn R->string [value]
  (str "\"" value "\"" ))
  
(defn R->print [& data]
  (str "print(" (apply str (interpose "," data)) ")"))

(defn R->= [var-name value]
  (str  var-name "=" value))

(defn R->vector [& data]
    (str "c(" (apply str (interpose "," data)) ")"))

(defn R->range [low-val high-val]
  (str low-val ":" high-val ))

(defn R->slurp [path]
  (str "read.table(\"" path "\")"))

(defn R->mean [& data]
     (str "mean(" (apply str (interpose "," data)) ")"))

(defn R->dataframe [& data]
     (str "data.frame(" (apply str (interpose "," data)) ")"))

(defn R->summary [& data]
     (str "summary(" (apply str (interpose "," data)) ")"))

(defn R-post-proc [data]
  (apply str (interpose ";" data)))

(defn R->dataframe? [& data]
  (str "is.data.frame(" (apply str (interpose "," data)) ")"))

(defn R->vector? [data]
  (str "is.vector(" data ")"))

(defn R->rownames [& data]
  (str "row.names(" (apply str (interpose "," data)) ")"))

(defn R->matrix [& data]
  (str "matrix(" (apply str (interpose "," data)) ")"))

(defn R->stripchart [& data]
  (str "stripchart("  (apply str (interpose "," data)) ")"))

(defn R->histogram [& data]
  (str "hist(" (apply str (interpose "," data)) ")"))

(defn R->boxplot [& data]
  (str "boxplot(" (apply str (interpose "," data)) ")"))

(defn R->dotchart [& data]
  (str "dotchart(" (apply str (interpose "," data)) ")"))

(defn R->sample [data]
  (str "sample(" data ")"))