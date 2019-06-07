#!/bin/sh

BASEDIR=$(dirname "$BASH_SOURCE")

echo "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "┃ Building project..."

cd $BASEDIR/../../../
./gradlew :samples:todomvc:core:jsMainClasses --quiet

echo "┃ Copying artifacts..."

cp oolong/build/classes/kotlin/js/main/oolong.js samples/todomvc/js/js/
cp samples/todomvc/core/build/classes/kotlin/js/main/core.js samples/todomvc/js/js

echo "┃ Finished!"
echo "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "┃ $BASEDIR/index.html"
echo "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
