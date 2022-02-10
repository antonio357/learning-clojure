;; this is a comment

(println "Hello World") 

;; -- SYNTAX

;; convencional programming languages
;; function(parameter1, parameter2)
;; clojure, everything is a function and goes in () to execute
;; (function parameter1 parameter2)


;; -- ENVIROMENT AND INTERNAL CLOJURE FUNCTIONALITIES

;; use repl to quick test closure code
;; repl stands for read-eval-print-loop and is a console for clojure "just like console in network for javascript" so that u can run and test a clojure code 
;; to run repl go to a terminal then execute lein repl

;; how clojure works
;; clojure has no interpreter
;; clojure code is compiled by the JDK from the java in the enviroment
;; the bytecode generated is executed by th JVM from the java in the enviroment

;; -- FUNCIONAL PROGRAMMING https://www.youtube.com/watch?v=BWFpUHPqh1g&ab_channel=DevMedia

;; - funções inpuras
;; funções que tem a possibilidade de retornar valores diferentes para os mesmos parametros, exemplo uma função que calcula a área de um circulo e para isso utiliza o valor pi global, eoricamente a função deveria retornar sempre o mesmo valor para o parametro raio dado, porém como alguém pode mexer no valor de pi e alteralo, isso faz com que a função passe a calular novos valores para os mesmos raios anteriores passados por parámetro
;; - funções puras
;; funções que se para os mesmos parametros retornam os memsmo resultados 
;; immutability
;; confiabilidade
;; otimizações de performance, referencial transparence (técnica lá de programação dinámica)
;; funções de primeira classe 
;; funções de alta ordem

;; -- LINKS
;;- topicos gerais, https://www.youtube.com/watch?v=ciGyHkDuPAE&ab_channel=DerekBanas
;;- clojure com web introdução rápida do setup, https://www.youtube.com/watch?v=MQmdWSh2FG4&ab_channel=BetweenTwoParens
;;- setup do vscode para clojure, Developer Ergonomics with VS Code, Clojure, and ClojureScript by Peter Strömberg
;;- tipos em clojure, https://www.youtube.com/watch?v=BWcAn0Utdd0&ab_channel=O%27Reilly-VideoTraining
;;- introdução a clojure, https://www.youtube.com/watch?v=mPn486kxUlQ&ab_channel=ProgramandoComRoger
;;- mini projeto em clojure, https://www.youtube.com/watch?v=HKydOMGTCxE&ab_channel=Filhodanuvem
;;- setup clojure em 5 minutos, https://www.youtube.com/watch?v=4BA1Od_d9Qw&ab_channel=NotJustCode
;; - codumentação do clojure, https://clojure.org/guides/learn/syntax
