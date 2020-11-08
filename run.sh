#!/bin/bash
mvn clean package -DskipTests
docker build -t aselab:user .
docker run -p 21001:21001 -d --name aselabuserservice aselab:user