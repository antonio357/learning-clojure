;; this is a comment

(println "Hello World") 

;; -- SYNTAX

;; convencional programming languages
;; function(parameter1, parameter2)
;; clojure, everything is a function and goes in () to execute
;; (function parameter1 parameter2)


;; -- ENVIROMENT AND INTERNAL CLOJURE FUNCTIONALITIES

;; how clojure works
;; clojure has no interpreter
;; clojure code is compiled by the JDK from the java in the enviroment
;; the bytecode generated is executed by th JVM from the java in the enviroment

;; -- PROGRAMAÇÂO FUNCIONAL https://www.youtube.com/watch?v=BWFpUHPqh1g&ab_channel=DevMedia

;; - funções inpuras
;; funções que tem a possibilidade de retornar valores diferentes para os mesmos parametros, exemplo uma função que calcula a área de um circulo e para isso utiliza o valor pi global, teoricamente a função deveria retornar sempre o mesmo valor para certo parametro raio dado, porém como alguém pode mexer no valor de pi e alteralo fazendo com que a função passe a calular novos valores para os mesmos raios anteriores passados por parámetro
;; - funções puras
;; funções que se para os mesmos parametros retornam os mesmos resultados sempre sem possibilidade de fatores externos influenciarem nesses resultados 
;; - imutabilidade
;; dada uma função de aplicar desconto a um pagamento, ao receber o pagamento como parametro ao em vez de fazer pagamento = pagamento - desconto e acabar modificando o pagamento o que causa inconsisténcia nos dados do pagamento, para manter a consistência/imutabilidade dos dados a função deve receber pagamento como uma constante criar uma nova instância de pagamento e nesse instáncia aplicar o desconto e retornando esse novo pagamento   
;; - confiabilidade
;; com funções puras fica mais confiavel e estável criar testes automatizados, a previsibilidade dos comportamentos do codigo é bem maior com funções puras
;; como os dados são imutáveis e consistentes eles podem ser compartilhados por execuções paralelas de forma segura  
;; - otimizações de performance
;; através de referencial transparence (técnica lá de programação dinámica), se em uma função para tais parametros o resultado é sempre o mesmo podemos armazenar esses resultados e quando a função for chamada como esses parametros já memorizados, ao em vez de exercutar toda função novamente só pegamos o valor que temos armazenado e retornamos
;; - funções de primeira classe e funções de alta ordem
;; funções que podem receber funções como parametro e retornar funções além de armazenar funções em veriáveis


;; -- setup clojure

;; use repl to quick test closure code
;; repl stands for read-eval-print-loop and is a console for clojure "just like console in network for javascript" so that u can run and test a clojure code 
;; to run repl go to a terminal then execute lein repl

;; para executar um .clj no terminal coloque #!/usr/bin/env clojure na primeira linha do .clj garanta premissão de execução para o arquivo e depois execute no terminal ./*.clj

;; https://www.youtube.com/watch?v=6uUynWkMDGM&ab_channel=onthecodeagain


;; -- LINKS

;;- topicos gerais, https://www.youtube.com/watch?v=ciGyHkDuPAE&ab_channel=DerekBanas
;;- clojure com web introdução rápida do setup, https://www.youtube.com/watch?v=MQmdWSh2FG4&ab_channel=BetweenTwoParens
;;- setup do vscode para clojure, Developer Ergonomics with VS Code, Clojure, and ClojureScript by Peter Strömberg
;;- tipos em clojure, https://www.youtube.com/watch?v=BWcAn0Utdd0&ab_channel=O%27Reilly-VideoTraining
;;- introdução a clojure, https://www.youtube.com/watch?v=mPn486kxUlQ&ab_channel=ProgramandoComRoger
;;- mini projeto em clojure, https://www.youtube.com/watch?v=HKydOMGTCxE&ab_channel=Filhodanuvem
;;- setup clojure em 5 minutos, https://www.youtube.com/watch?v=4BA1Od_d9Qw&ab_channel=NotJustCode
;; - codumentação do clojure, https://clojure.org/guides/learn/syntax
