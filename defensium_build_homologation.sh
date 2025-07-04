cd /data/data/com.termux/files/home/home/implantacao/Defensium/homologacao/defensiumapi || exit

git reset --hard
git fetch && git pull

pkill -f 'defensiumapi-0.0.1-SNAPSHOT.jar'

nohup mvn clean install package -DskipTests > /data/data/com.termux/files/home/defensiumlog/maven.log 2>&1

wait

nohup java -jar target/defensiumapi-0.0.1-SNAPSHOT.jar > /data/data/com.termux/files/home/defensiumlog/defensium.log 2>&1 &
