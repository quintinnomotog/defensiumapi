git reset --hard

git fetch && git pull

mvn clean install package -DskipTests

java -jar target/defensiumapi-0.0.1-SNAPSHOT.jar

# nohup mvn clean install package -DskipTests > ../defensiumlog/mvn_v1.4.0.0.log 2>&1 &

# nohup java -jar target/defensiumapi-0.0.1-SNAPSHOT.jar > ../defensiumlog/mvn_v1.4.0.0.txt 2>&1 &
