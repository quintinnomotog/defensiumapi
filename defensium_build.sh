git fetch && git pull

git checkout branch main

mvn clean install package -DskipTests

java -jar target/defensiumapi-0.0.1-SNAPSHOT.jar