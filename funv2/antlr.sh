#!/usr/bin/env bash
pushd src/antlr
java -jar ../../lib/antlr.jar -no-listener -visitor Fun.g4
popd
