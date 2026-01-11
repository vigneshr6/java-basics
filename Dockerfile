FROM ubuntu/jre:21-24.04_stable
COPY ./build/libs/java-basics-0.0.1-SNAPSHOT.jar /app/java-basics.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "java-basics.jar"]