#!/bin/sh

BASEDIR=$(dirname "$BASH_SOURCE")

echo "=============================="
echo "Building Kotlin project..."
echo "=============================="

cd $BASEDIR/../../../
./gradlew :samples:random:core:jsMainClasses

echo "=============================="
echo "Finished!"
echo ""
echo "$BASEDIR/index.html"
echo "=============================="
