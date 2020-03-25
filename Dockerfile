FROM openjdk:8
ADD target/book-generator-poq-0.0.1-SNAPSHOT.jar /app/book-generator-poq.jar
EXPOSE 8099
CMD ["java", "-Xmx512m", "-jar", "/app/book-generator-poq.jar"]