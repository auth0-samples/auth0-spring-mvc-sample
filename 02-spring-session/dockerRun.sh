#!/bin/bash
docker build -t auth0/auth0-spring-mvc-sample .
docker run -it -p 3099:3099 \
       -v $(pwd):/usr/src/app \
       --name auth0-spring-mvc-sample auth0/auth0-spring-mvc-sample
