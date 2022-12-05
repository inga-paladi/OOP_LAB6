#!/bin/bash

javac -d classes $(find . | grep '\.java')
pushd classes &> /dev/null
java OOP_LAB6
popd &> /dev/null
