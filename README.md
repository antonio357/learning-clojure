# learning-clojure
This repo its meant to save exemples and explanations about programming in clojure.  
Disclaimer: All done in Ubuntu based distribution
## setting up clojure enviroment
> install `brew` and `vscode` 

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
## how to run clojure
in a terminal run `lein new my-cloruje-project`  
open my-cloruje-project dir with vscode
inside vscode open command palette and run  <img src="https://github.com/antonio357/learning-clojure/blob/main/readmeImgs/command-palett-to-run-clojure-1.png" style="height: 100px; width:100px;"><img>
## clojure's aspects 
