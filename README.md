# Running locally

## MacBook / Linux

* ./gradlew clean build
* ./gradlew bootRun

## Windows

* gradlew.bat clean build
* gradlew.bat bootRun

# Service endpoint

* http://localhost:8820/geoip/whois

The service exposes a POST method which can be used to check if a given IP is allowed, given
the allowed locations.

* Request

```
POST:

    {
      "ip" : "54.239.36.155",
      "countriesAllowed" : ["Netherlands", "England"]
    }
```

* Response

```
    {
      "ip": "54.239.36.155",
      "countrName": "Ireland",
      "countryCode": "IE",
      "allowed": false
    }
```

## Postman Example

Use Postman as exhibited in the image below:

[GeoIP with Postman](https://github.com/ekholabs/geoip/blob/master/src/test/resources/geoip_postman.png)

# IPs to test

* 172.217.2.14
* 54.239.36.155
* 176.32.108.186
* 178.236.6.251

Feel free to add more or automate it with several IPs.

# Running with Docker

After cloning the repository, one can run the application by simply typing:

* ```docker build -t geoip --no-cache .```
* ```docker run -p 80:80 geoip```

# Pulling a pre-built Image

The image can be pulled from hub.docker and executed without the need to clone the repository:

* ```docker pull ekholabs/geoip:latest```
* ```docker run -p 80:80 ekholabs/geoip```

# Remarks

The microservice is using http://freegeoip.net, which is free and offers 15k requests
every 60 minutes.

The current implementation is configurable via the ```application.yml``` file.
We can simply change the service URL and use a new IP database.

# Improvements

* Add more IP database services.

Have fun!
