javac -d out src/ast/*.java
javac -d out -cp "out;lib/antlr.jar;lib/SVM.jar" src/antlr/*.java
javac -d out -cp "out;lib/antlr.jar;lib/SVM.jar" src/*.java
