# Fun v2

This repository contains my ongoing efforts to modernise the Fun programming
language, used to teach COMPSCI4016 (Programming Languages) at the University of
Glasgow.

It is very much not ready for primetime yet.

The main changes are:
  1. Explicit AST class hierarchy.
  2. Recursion over visitors. My goal is to have a formal specification of
     Fun's abstract syntax, semantics, and typing rules. Recursive definitions
     have a much stronger correspondence to the rules than visitors (even if
     visitors remove some boilerplate).
  3. "Contextual Analysis" is replaced by a proper typechecking pass. Treating
     environments as immutable removes a significant amount of complexity and
     extraneous cognitive load.
  4. I've written a tree-walk interpreter to start, but will of course also port
     the SVM codegen.
  5. As a longer-term plan (i.e., 26-27), I'd like to also write a RISC-V native
     code generator (or supervise a student project to do so :))

