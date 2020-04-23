#!/bin/bash

projects=(common ratings configreload reviews details eureka)

for project in "${projects[@]}"
do
  echo "---->build ${project}<----"
  cd ${project}
  cp build.sc.sh build.sh
  chmod +x build.sh
  ./build.sh
  cd ..
done

echo "---->done<----"