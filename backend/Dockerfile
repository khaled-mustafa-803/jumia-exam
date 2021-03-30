FROM openjdk:11
ADD ./target/*.jar /app.jar
ADD ./src/main/resources/sample.db ./src/main/resources/sample.db
CMD java -jar /app.jar
