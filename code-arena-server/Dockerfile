FROM maven:3.6.2-jdk-8-openj9

ADD application/target/application-1.0-SNAPSHOT-final.jar app.jar

# Ports:
# 8081 - Code Arena Server Application
# 5005 - Code Arena Server Debugger Socket

EXPOSE 8081 5006

ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5006", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
