#!/bin/bash

DOCKER_IMAGE_NAME=auth0-samples/spring-mvc-00login:latest

docker build -t $DOCKER_IMAGE_NAME .
echo "============ Docker Image Created: '$DOCKER_IMAGE_NAME' ============"
echo "===================================================================="
echo ""
docker run --rm -p 8080:8080 $DOCKER_IMAGE_NAME
