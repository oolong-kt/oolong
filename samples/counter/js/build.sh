#!/bin/sh

BASEDIR=$(dirname "$BASH_SOURCE")

echo "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "┃ Building project..."

cd $BASEDIR/../../../
./gradlew :samples:counter:core:jsMainClasses --quiet

echo "┃ Copying artifacts..."

cp oolong/build/classes/kotlin/js/main/oolong.js samples/counter/js/js/
cp samples/counter/core/build/classes/kotlin/js/main/core.js samples/counter/js/js

echo "┃ Finished!"
echo "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "┃ $BASEDIR/index.html"
echo "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
