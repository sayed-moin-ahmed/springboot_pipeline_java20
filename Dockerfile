FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-javaagent:/dd-java-agent.jar","-jar","/app.jar"]
