#!/bin/bash

set -e

git reset --hard

git fetch && git pull

nohup mvn clean install package -DskipTests > ../defensiumlog/mvn_v1.4.0.0.log 2>&1 &

wait

nohup java -jar target/defensiumapi-0.0.1-SNAPSHOT.jar > ../defensiumlog/mvn_v1.4.0.0.txt 2>&1 &