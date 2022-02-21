; if it is a java function call like this with / before the function name
(defn get-uuid [] (java.util.UUID/randomUUID))
(get-uuid)

; if it is a java Constructor call like this with . at the end 
(defn get-date [] (java.util.Date.))
(get-date)

; with import
(import 'java.util.UUID)
(UUID/randomUUID)

; a list of thing to import
(import '(java.util Date))
(Date.)


