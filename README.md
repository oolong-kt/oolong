![Travis (.org)](https://img.shields.io/travis/pardom/oolong.svg) ![Maven Central](https://img.shields.io/maven-central/v/com.michaelpardo/oolong.svg) ![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/com.michaelpardo/oolong.svg) ![GitHub](https://img.shields.io/github/license/pardom/oolong.svg)

Oolong 🍵 
=========

TEA for Kotiln.

A Kotlin port of [The Elm Architecture][1] aka Model View Update (MVU) architecture.

Download
--------

Download [the latest JAR][2] or grab via Maven:
```xml
<dependency>
  <groupId>com.michaelpardo</groupId>
  <artifactId>oolong</artifactId>
  <version>version</version>
</dependency>
```
or Gradle:
```groovy
implementation 'com.michaelpardo:oolong:<version>'
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

[1]: https://guide.elm-lang.org/architecture/
[2]: https://search.maven.org/remote_content?g=com.michaelpardo&a=oolong&v=LATEST
[snap]: https://oss.sonatype.org/content/repositories/snapshots/

License
=======

    Copyright 2018 Michael Pardo

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
