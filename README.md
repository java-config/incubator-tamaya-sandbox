<!--
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
-->
# Apache Tamaya (incubating) Sandbox

This is the sandbox of [Apache Tamaya](https://tamaya.incubator.apache.org).
The sandbox contains additional modules (extensions)
of Apache Tamaya (incubating) **which are not mature enough**
to be part of Apache Tamaya itself or the official extensions
of Apache Tamaya.

## Rules for sandbox modules

* All modules must be independent of each other.
* A module can be promoted by the PMC of Tamaya
  to be part of the official Tamaya extensions package if it is
  mature enough.
* A sandbox module should have it's own build chain
  in [Tamaya's Jenkins view](https://builds.apache.org/view/S-Z/view/Tamaya/)


## Building Apache Tamaya Sandbox

The Apache Tamaya project is built with [Maven 3](https://maven.apache.org/) and [Java 8](https://java.sun.com/), so you need JDK >=1.8 and a reasonable version of maven
installed on your computer.


Then you can build Tamaya Sandbox via:
```
$ export MAVEN_OPTS="-Xmx512m -XX:PermGenSpace=200m"
$ mvn
```

### Travis / CI

Apart from integration into ASF CI there's a travis build:

[![Build Status](https://travis-ci.org/apache/incubator-tamaya-sandbox.svg?branch=master)](https://travis-ci.org/apache/incubator-tamaya-sandbox/branches)

Sonarcloud integration:

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=apache_incubator-tamaya-sandbox&metric=alert_status)](https://sonarcloud.io/dashboard?id=apache_incubator-tamaya-sandbox)
