$profile = $args[0]
Start-Process java -ArgumentList "-jar ../target/demo-01-service-registry-0.0.1-SNAPSHOT.jar --spring.profiles.active=$profile"
