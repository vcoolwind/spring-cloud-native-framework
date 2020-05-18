#!/bin/sh
project=eureka

echo '-------------build '${project}' start-------------------'
mvn  clean package
echo '-------------build '${project}' over-------------------'