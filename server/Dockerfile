FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
ADD target/*.jar /opt/app/fastmate.jar
CMD ["java", "-jar", "/opt/app/fastmate.jar"]
