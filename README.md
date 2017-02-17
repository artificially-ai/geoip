# Running locally

## MacBook / Linux

* ./gradlew clean build
* ./gradlew bootRun

## Windows

* gradlew.bat clean build
* gradlew.bat bootRun

# Service endpoint

* http://localhost:8820/checkIp

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

# IPs to test

* 172.217.2.14
* 54.239.36.155
* 176.32.108.186
* 178.236.6.251

Feel free to add more or automate it with several IPs.

# Remarks

The microservice is using http://freegeoip.net, which is free and offers 15k requests
every 60 minutes.

The current implementation is configurable via the ```application.yml``` file.
We can simply change the service URL and use a new IP database.

# Improvements

* Add more IP database services.

# Unit Tests

* Still to be added.