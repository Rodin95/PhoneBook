#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
    target/PhoneBook-0.0.1-SNAPSHOT.jar \
    arty@172.26.13.15:/home/arty/

echo 'Перезагрузка сервера...'

ssh -i ~/.ssh/id_rsa arty@172.26.13.15 << EOF

pgrep java | xargs kill -9
nohup java -jar PhoneBook-0.0.1-SNAPSHOT.jar > log.txt &

EOF

echo 'Bye'
