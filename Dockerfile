FROM java:8
COPY "./target/user-0.0.1-SNAPSHOT.jar" "/user-0.0.1-SNAPSHOT.jar"
EXPOSE 21001
CMD ["java", "-jar","user-0.0.1-SNAPSHOT.jar","--spring.profiles.active=product"]