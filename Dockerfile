FROM debian:latest

RUN apt-get -y update && apt-get install -y openjdk-8-jre-headless openjdk-8-jdk maven git

WORKDIR ekholabs

RUN git clone https://github.com/ekholabs/geoip
WORKDIR geoip
RUN ./gradlew clean build

ENV GEOIP_PORT=80

EXPOSE $GEOIP_PORT

ENTRYPOINT ["java"]
CMD ["-server", "-Xmx256G", "-jar", "build/libs/geoip-0.0.1-SNAPSHOT.jar"]
