#!/bin/sh

BASEDIR=$(dirname "$BASH_SOURCE")

echo "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "┃ Building samples..."

samples/counter/js/build.sh
samples/random/js/build.sh
samples/time/js/build.sh
samples/todomvc/js/build.sh

echo "┃ Copying artifacts..."
cd $BASEDIR/../../

mkdir -p docs/samples/counter/js
cp -r samples/counter/js/js/* docs/samples/counter/js/
cp samples/counter/js/index.html docs/samples/counter/

mkdir -p docs/samples/random/js
cp -r samples/random/js/js/* docs/samples/random/js/
cp samples/random/js/index.html docs/samples/random/

mkdir -p docs/samples/time/js
cp -r samples/time/js/js/* docs/samples/time/js/
cp samples/time/js/index.html docs/samples/time/

mkdir -p docs/samples/todomvc/js
cp -r samples/todomvc/js/js/* docs/samples/todomvc/js/
cp samples/todomvc/js/index.html docs/samples/todomvc/


echo "┃ Finished!"
echo "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
