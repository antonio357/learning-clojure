# learning-clojure <br>
This repo its meant to save exemples and explanations about programming in clojure.  
Disclaimer: All done in Ubuntu based distribution  
# summary <br>
- scalar variables  
- collections  
- keywords and symbols   
- aritmetic operators  
- relational operators  
- logical operators  
- conditional operators  
- functions  
- built-in functions and utils  
- loops  
- scope  
- parallelism  
# classes <br>
- first class
  - -> operator
  - \# operator
  - % %1 %3
  - comment
  - map objects
  - functions map reduce filter some
  - destructing
  - importação
  - scopo let, restrição de acessos 
  - utilizar funções java dentro do código clojure, com noitação de .
  - namespace
  - lazy things
  - syn4tdf-reports
  - issue 6391
  - projeto https://git.synchro.com.br/componentes/syn4tdf-report
# setting up clojure enviroment <br>

> install `brew`, `vscode` and `JDK with JAVA_HOME` 

> in a terminal run `brew install clojure lein`  

> in `vscode` install <a href="https://marketplace.visualstudio.com/items?itemName=CoenraadS.bracket-pair-colorizer-2">bracket-pair-colorizer-2</a>
and <a href="https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva">calva</a> to run clojure code statements inside .clj files  

> paste the config below in <code>~/.config/Code/User/settings.json</code> to customize bracket colors and stop calva to override vscode keybindings
<pre>
  // brackets color and selection
  "editor.guides.bracketPairsHorizontal": false,
  "bracket-pair-colorizer-2.showHorizontalScopeLine": false,
  "bracket-pair-colorizer-2.showBracketsInGutter": true,
  "editor.guides.bracketPairs": true,

  // clojure
  "calva.enableJSCompletions": false,
  "calva.fmt.formatAsYouType": false,
  "editor.guides.bracketPairsHorizontal": false,
  "calva.highlight.enableBracketColors": false,
  "calva.highlight.highlightActiveIndent": false,
  "calva.showCalvaSaysOnStart": false,
  "calva.autoOpenJackInTerminal": false,
  "calva.evaluationSendCodeToOutputWindow": true,
  "calva.paredit.defaultKeyMap": "none",
  "calva.paredit.hijackVSCodeDefaults": false,
  "calva.keybindingsEnabled": false, 
</pre>
> paste the config below in <code>~/.config/Code/User/keybindings.json</code> to enable a calva keybinding to run clojure code in .clj files
<pre>
{  
  "key": "ctrl+enter",  
  "command": "calva.evaluateSelection",  
  "when": "calva:connected && editorTextFocus && editorLangId == 'clojure'"  
}  
</pre>
# how to quickly test clojure code <br>
> in a terminal run `lein new my-cloruje-project`  

> open `my-cloruje-project` with vscode  
open command palette and run  
<img src="https://github.com/antonio357/learning-clojure/blob/main/readmeImgs/command-palett-to-run-clojure-1.png"><img>  
then choose  
<img src="https://github.com/antonio357/learning-clojure/blob/main/readmeImgs/command-palett-to-run-clojure-2.png"><img>  
then select uberjar and click in ok  
<img src="https://github.com/antonio357/learning-clojure/blob/main/readmeImgs/command-palett-to-run-clojure-3.png"><img>  

> on the right will appear the `output.calva-repl` tab   
<img src="https://github.com/antonio357/learning-clojure/blob/main/readmeImgs/command-palett-to-run-clojure-4.png"><img>  
click/select on a line of code in any .clj file   
<img src="https://github.com/antonio357/learning-clojure/blob/main/readmeImgs/command-palett-to-run-clojure-5.png"><img>  
then press `ctrl + enter` keybinding to run the code and check its return on the right after the => symbol  
<img src="https://github.com/antonio357/learning-clojure/blob/main/readmeImgs/command-palett-to-run-clojure-6.png"><img>  
on the `output.calva-repl` tab will appear  
output  
code  
return  
<img src="https://github.com/antonio357/learning-clojure/blob/main/readmeImgs/command-palett-to-run-clojure-7.png"><img>  

