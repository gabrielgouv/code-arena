FROM maven:3.6.2-jdk-8-openj9

VOLUME /tmp

ADD application/target/application-1.0-SNAPSHOT-final.jar app.jar

EXPOSE 8080 5005

RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
