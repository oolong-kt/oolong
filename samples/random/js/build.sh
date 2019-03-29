#!/bin/sh

BASEDIR=$(dirname "$BASH_SOURCE")

echo "=============================="
echo "Building Kotlin project..."
echo "=============================="

cd $BASEDIR/../../../
./gradlew :samples:random:core:build

echo ""
echo "=============================="
echo "Installing NPM dependencies..."
echo "=============================="
echo ""

cd $BASEDIR
npm install

echo "=============================="
echo "Finished!"
echo ""
echo "$(pwd)/index.html"
echo "=============================="
