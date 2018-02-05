docker build -t auth0-samples/spring-mvc-00login:latest .
docker run -p 3000:3000 -v ~/.m2:/home/gradle/.gradle -it auth0-samples/spring-mvc-00login:latest
