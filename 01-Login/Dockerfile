# Use JAVA image
FROM openjdk:7u121-jdk

# Change dir
WORKDIR /app

# Copy local contents to /app
COPY . /app


# Auth0 Properties passed with --build-arg <name>=<value> on build
ARG DOMAIN
ARG CLIENT_ID
ARG CLIENT_SECRET

# Download Properties Replacer Script
ADD https://gist.githubusercontent.com/lbalmaceda/a7628513f5a084e558f40f08571afc40/raw/4beaca0a4540dbfd25f5ec9d9548f4e75fb8002f/properties_replacer.sh /app/properties_replacer.sh
RUN chmod +x properties_replacer.sh
RUN ./properties_replacer.sh src/main/resources/auth0.properties $DOMAIN $CLIENT_ID $CLIENT_SECRET

# Trigger a Gradle download
RUN chmod +x gradlew
RUN ./gradlew clean

# Define default command
ENTRYPOINT ["./gradlew"]
CMD ["clean", "bootRun"]

# Open 8080 in the container
EXPOSE 8080
