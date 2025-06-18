set -e

git fetch
git checkout main
git pull

mvn clean install package -DskipTests

java -jar target/defensiumapi-0.0.1-SNAPSHOT.jar
