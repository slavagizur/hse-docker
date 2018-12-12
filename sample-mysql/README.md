# Пример запуска Java приложения и MySQL базы данных через Docker

Сборка приложения:

```
mvnw package dependency:copy-dependencies
``` 

Упаковка приложения

```
docker build -t sample-java-jdbc .
```

Запуск базы данных

```
docker run --name mysql-server ./init_database.sql:/docker-entrypoint-initdb.d -e MYSQL_ROOT_PASSWORD=12345678 -e MYSQL_DATABASE=sample -e MYSQL_USER=user -e MYSQL_PASSWORD=user -d -p 3306:3306 mysql:latest 
```

Запуск приложения

```
docker run sample-java-jdbc -e MYSQL_URL= -e MYSQL_USER= -e MYSQL_PASSWORD=user
```