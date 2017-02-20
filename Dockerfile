FROM ekholabs/wercker-jdk8

COPY target/geoip-0.0.1-SNAPSHOT.jar /tmp/GeoIP/geoip.jar

EXPOSE 8820
WORKDIR /tmp/GeoIP

ENTRYPOINT ["java"]
CMD ["-Xmx64M", "-jar", "geoip.jar"]
