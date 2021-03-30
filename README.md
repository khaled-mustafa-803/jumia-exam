prerequisite intallations:
* java 11 or higher
* maven
* docker engine

steps:
* move to backend folder
* run command: mvn clean install
* run command: docker build -t back/jumia-exam .
* run command: docker run -d -it -p 8080:8080 back/jumia-exam:latest

* move to frontend folder
* run command: docker build -t front/jumia-exam .
* run command: docker run -d -it -p 4200:80/tcp front/jumia-exam:latest

* open browser and go to 'localhost:4200'
