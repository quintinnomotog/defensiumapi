#!/bin/bash

nohup docker compose up -d > docker.log 2>&1 &

nohup mvn clean install package -DskipTests > maven.log 2>&1 &

./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8080"
