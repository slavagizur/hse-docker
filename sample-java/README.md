# Пример запуска Java приложения через Docker

Сборка приложения:

```
mvn package
``` 

Упаковка приложения

```
docker build -t sample-java .
```

Запуск приложения

```
docker run sample-java
```