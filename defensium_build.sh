set -e

git reset --hard > /dev/null 2>&1
git fetch > /dev/null 2>&1
git pull > /dev/null 2>&1 &

nohup mvn clean install package -DskipTests > ../defensiumlog/mvn_v1.4.0.0.log 2>&1 &

nohup java -jar target/defensiumapi-0.0.1-SNAPSHOT.jar > ../defensiumlog/mvn_v1.4.0.0.txt 2>&1 &
