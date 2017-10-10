#! /bin/bash
java -jar ../target/demo-01-service-registry-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer0 &
java -jar ../target/demo-01-service-registry-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1 &
