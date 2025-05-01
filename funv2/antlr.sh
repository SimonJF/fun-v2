#!/usr/bin/env bash
pushd src/antlr
java -jar ../../lib/antlr.jar -no-listener -visitor LRec.g4
popd
