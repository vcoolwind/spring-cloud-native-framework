#!/bin/sh
project=eureka

echo '-------------build '${project}' start-------------------'
mvn  clean package  install
echo '-------------build '${project}' over-------------------'