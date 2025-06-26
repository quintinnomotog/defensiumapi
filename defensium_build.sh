#!/bin/bash

LOG_DIR="/data/data/com.termux/files/home/home/implantacao/Defensium/homologacao/defensiumlog"

TIMESTAMP=$(date +"%Y%m%d%H%M%S")

LOG_MAVEN_FILE="MAVEN_${TIMESTAMP}.log"
LOG_APPLICATION_FILE="DEFENSIUM_${TIMESTAMP}.log"

LOG_MAVEN_PATH="$LOG_DIR/$LOG_MAVEN_FILE"
LOG_APPLICATION_PATH="$LOG_DIR/$LOG_APPLICATION_FILE"

git reset --hard && git pull

nohup mvn clean install package -DskipTests > "$LOG_MAVEN_PATH" 2>&1 &

wait

nohup java -jar target/defensiumapi-0.0.1-SNAPSHOT.jar > "$LOG_APPLICATION_PATH" 2>&1 &

sleep 2

tail -f "$LOG_APPLICATION_PATH"