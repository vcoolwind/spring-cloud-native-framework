#!/bin/sh
project=ratings

echo '-------------build '${project}' start-------------------'
cp pom.sc.xml pom.xml  -f
cp src/main/resources/application.sc.yml src/main/resources/application.yml -f
mvn  clean package  install
echo '-------------build '${project}' over-------------------'