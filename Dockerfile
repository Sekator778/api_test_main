FROM openjdk:17-alpine
WORKDIR /opt
# /home/DN070578NOI/IdeaProjects/api_test_main/target/api-0.0.1.jar
COPY target/api-0.0.1.jar /opt/api-0.0.1.jar

CMD ["java", "-jar", "/opt/api-0.0.1.jar"]

