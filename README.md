# learning-clojure
This repo its meant to save exemples and explanations about programming in clojure.  
Disclaimer: All done in Ubuntu based distribution
## setting up clojure
install vscode  
install <a href="https://marketplace.visualstudio.com/items?itemName=CoenraadS.bracket-pair-colorizer-2">bracket-pair-colorizer-2</a>  
install <a href="https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva">calva</a>   
<code>~/.config/Code/User/keybindings.json</code>
<pre>
{  
  "key": "ctrl+enter",  
  "command": "calva.evaluateSelection",  
  "when": "calva:connected && editorTextFocus && editorLangId == 'clojure'"  
}  
</pre>
<code>~/.config/Code/User/settings.json</code>
<pre>
  // brackets color and selection
  "editor.guides.bracketPairsHorizontal": false,
  "bracket-pair-colorizer-2.showHorizontalScopeLine": false,
  "bracket-pair-colorizer-2.showBracketsInGutter": true,
  "editor.guides.bracketPairs": true,

  // closure related
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
## how to run clojure
## clojure's aspects 
### functional programming paradigm
