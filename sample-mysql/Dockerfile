FROM java:8
WORKDIR /
ADD target/SampleMySQL-1.0.0.jar Sample.jar
ADD target/dependency/mysql-connector-java-8.0.13.jar mysql.jar
EXPOSE 8080
CMD java -jar Sample.jar -cp mysql.jar