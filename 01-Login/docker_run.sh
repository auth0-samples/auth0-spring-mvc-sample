#!/bin/bash

if [ "$#" -le "2" ]; then
  echo "==============================================================="
  echo "Missing Auth0 Properties!!"
  echo "Usage: $0 auth0_domain auth0_client_id auth0_client_secret"
  echo "==============================================================="
  exit
fi

DOCKER_IMAGE_NAME=a0-sample-spring-mvc-login00
DOMAIN=$1
CLIENT_ID=$2
CLIENT_SECRET=$3

docker build -t $DOCKER_IMAGE_NAME . --build-arg DOMAIN=$DOMAIN --build-arg CLIENT_ID=$CLIENT_ID --build-arg CLIENT_SECRET=$CLIENT_SECRET
echo "============ Docker Image Created: '$DOCKER_IMAGE_NAME' ============"
echo "===================================================================="
echo ""
docker run -p 8080:8080 $DOCKER_IMAGE_NAME
