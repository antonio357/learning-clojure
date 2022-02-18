;  a compilation directive is a instruction that is executed by the preprocessor before the actual compilation of the code

;  a macro is a compilation directive that replaced by whatever it was defined to represent
;  ex: in C we have the #define instruction to create a macro
;  pi with macro
;  #define pi 3.14
;  printf (pi)
;  pi with function 
;  double pi() return 3.14;
;  printf (pi())
;  the advantages of macros is that it is faster then creating an actual function call since the function will be a memory address with instructions to execute by the CPU and the macro will be replaced by an actual piece of code wich can be anything from that programming language, so creating a function that return pi is actually slower then create a macro for pi