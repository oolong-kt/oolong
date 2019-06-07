#!/bin/sh

BASEDIR=$(dirname "$BASH_SOURCE")

echo "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "┃ Building project..."

cd $BASEDIR/../../../
./gradlew :samples:time:core:jsMainClasses --quiet

echo "┃ Copying artifacts..."

cp oolong/build/classes/kotlin/js/main/oolong.js samples/time/js/js/
cp samples/time/core/build/classes/kotlin/js/main/core.js samples/time/js/js

echo "┃ Finished!"
echo "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "┃ $BASEDIR/index.html"
echo "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
