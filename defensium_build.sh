set -e

git fetch && git checkout main && git pull &

nohup mvn clean install package -DskipTests > ../defensiumlog/mvn.log 2>&1 &

nohup java -jar target/defensiumapi-0.0.1-SNAPSHOT.jar --spring.profiles.active=production > ../defensiumlog/log.txt 2>&1 &
