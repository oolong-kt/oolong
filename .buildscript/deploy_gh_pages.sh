#!/bin/sh

BASEDIR="$( cd "$(dirname "$0")/.." ; pwd -P )"

cd $BASEDIR
git checkout master

section() {
    echo ""
    echo "╔═══════════════════════════════════════════════════════════════"
    echo "║ $1"
    echo "╚═══════════════════════════════════════════════════════════════"
    echo ""
}

build_sample() {
    cd $BASEDIR
    ./gradlew :samples:$1:core:build -q
    cd $BASEDIR/samples/$1/js
    npm install -s
}

add_sample_files() {
    git checkout master -- samples/$1/js/
    git add samples/$1/core/build/classes/kotlin/js/main/core.js
    git add samples/$1/js/
}

section "Building samples..."
build_sample "counter"
build_sample "random"
build_sample "time"
build_sample "todo"

section "Checking out gh-pages..."
cd $BASEDIR
git checkout gh-pages

section "Adding sample files..."
git add oolong/build/classes/kotlin/js/main/oolong.js
add_sample_files "counter"
add_sample_files "random"
add_sample_files "time"
add_sample_files "todo"

section "Committing and pushing to GitHub..."
git commit . -m "Generate pages."
git push origin gh-pages
git checkout master

section "Checking out master..."
section "Deployment complete!"