
#Pour eviter de rebuild a chaque fois inclure la commande mvn ici
FROM maven:3.9.9-amazoncorretto


WORKDIR /app

# copier tout ce qu'on trouve a la racine (.) et le mettre egalement a la racine'
COPY . .

RUN mvn clean package


#Creation of the docker image
FROM openjdk:24-ea-1-jdk-slim-bullseye

#COPY target/api-0.0.1-SNAPSHOT.jar app.jar
#RUN ls -l /app
ARG JAR_FILE=target/*.jar
# j'ai un doute je crois y a un / avant app.jar'
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]