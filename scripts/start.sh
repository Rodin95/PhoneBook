#!/usr/bin/env bash

mvn clean package

ssh -i ~/.ssh/id_rsa arty@172.01.01.01 << EOF

pgrep java | xargs kill -9
nohup java -jar PhoneBook-0.0.1-SNAPSHOT.jar > log.txt &

EOF

echo 'Bye'