FROM maven:3.6.2-jdk-8-openj9

ADD target/code-arena-auth-server-1.0-SNAPSHOT-final.jar app.jar

# Ports:
# 8090 - Code Arena Auth Server Application
# 5007 - Code Arena Auth Server Debugger Socket

EXPOSE 8090 5007

ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5007", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
