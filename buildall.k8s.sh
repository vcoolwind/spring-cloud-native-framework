#!/bin/bash

kubectl delete namespaces  mybookinfo
kubectl apply -f mybookinfo-k8s.yml
kubectl apply -f mybookinfo-istio.yml

projects=(common ratings configreload reviews details productpage )

for project in "${projects[@]}"
do
  echo "---->build ${project}<----"
  cd ${project}
  cp build.k8s.sh build.sh
  chmod +x build.sh
  ./build.sh
  cd ..
done
kubectl get deploy,svc,pod -o wide -n mybookinfo