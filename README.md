Solr Schema Manager
===================

[![Build Status](https://travis-ci.org/twitterist/solr-schema-manager.svg?branch=master)](https://travis-ci.org/twitterist/solr-schema-manager)  [ ![Download](https://api.bintray.com/packages/twitterist/maven/solr-schema-manager/images/download.svg) ](https://bintray.com/twitterist/maven/solr-schema-manager/_latestVersion)

**A lighweight schema management tool for [Apache Solr](http://lucene.apache.org/solr/) written in Scala**

Example
-------

TBD...

Installation
------------

### Using SBT

Add the jcenter resolver and twitterist library dependency to your ```build.sbt```:

```
resolvers += Resolver.jcenterRepo

libraryDependencies += "org.twitterist" %% "solr-schema-manager" % "VERSION"
```

### Using Gradle

Add the maven url and dependency to your ```build.gralde```:

```
repositories { 
    maven { 
        url "http://dl.bintray.com/twitterist/maven" 
    } 
}

dependencies {
    compile group: 'org.twitterist', name: 'solr-schema-manager', version: 'VERSION'
}
```

### Using Maven

Add the reporistory to your maven settings:

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<settings xsi:schemaLocation='http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd'
          xmlns='http://maven.apache.org/SETTINGS/1.0.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>

    <profiles>
        <profile>
            <repositories>
                <repository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-twitterist-maven</id>
                    <name>bintray</name>
                    <url>http://dl.bintray.com/twitterist/maven</url>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-twitterist-maven</id>
                    <name>bintray-plugins</name>
                    <url>http://dl.bintray.com/twitterist/maven</url>
                </pluginRepository>
            </pluginRepositories>
            <id>bintray</id>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>bintray</activeProfile>
    </activeProfiles>
</settings>
```

Add the depdendency to your ```pom.xml```:

```xml
<dependencies>
    <dependency>
        <groupId>org.twitterist</groupId>
        <artifactId>solr-schema-manager</artifactId>
        <version>VERSION</version>
        <type>jar</type>
        <scope>compile</scope>
        <optional>false</optional>
    </dependency>
</dependencies>
```

Usage
-----

TBD...