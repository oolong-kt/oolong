#!/bin/sh

BASEDIR=$(dirname "$BASH_SOURCE")

echo "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "┃ Building project..."

cd $BASEDIR/../../../
./gradlew :samples:random:core:jsMainClasses --quiet

echo "┃ Copying artifacts..."

cp oolong/build/classes/kotlin/js/main/oolong.js samples/random/js/js/
cp samples/random/core/build/classes/kotlin/js/main/core.js samples/random/js/js

echo "┃ Finished!"
echo "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "┃ $BASEDIR/index.html"
echo "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
