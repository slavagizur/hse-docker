# Пример запуска Java приложения и MySQL базы данных через Docker

Сборка приложения:

```
mvnw package dependency:copy-dependencies
``` 

Упаковка приложения

```
docker build -t sample-java-jdbc .
```

Создание сети для контейнеров

```
docker network create --driver bridge my_test_net
```

Запуск базы данных

```
docker run --name mysql-server --net=my_test_net -v $PWD/sql:/docker-entrypoint-initdb.d -e MYSQL_ROOT_PASSWORD=12345678 -e MYSQL_DATABASE=sample -e MYSQL_USER=user -e MYSQL_PASSWORD=user -d -p 3306:3306 mysql:latest
```

Запуск приложения

```
docker run --net=my_test_net -e MYSQL_URL=jdbc:mysql://10.0.2.15:3306/sample -e MYSQL_USER=user -e MYSQL_PASSWORD=user sample-java-jdbc
```

где 10.0.2.15 адрес PC