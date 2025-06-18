set -e

git reset --hard > /dev/null 2>&1
git fetch > /dev/null 2>&1
git checkout main > /dev/null 2>&1
git pull > /dev/null 2>&1 &

nohup mvn clean install package -DskipTests > ../defensiumlog/mvn.log 2>&1 &

# nohup java -jar target/defensiumapi-0.0.1-SNAPSHOT.jar --spring.profiles.active=production > ../defensiumlog/log.txt 2>&1 &

nohup java -jar target/defensiumapi-0.0.1-SNAPSHOT.jar > ../defensiumlog/log.txt 2>&1 &
