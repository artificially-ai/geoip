package com.irdeto.rrm.microservices.geoip.controller;

import com.irdeto.rrm.microservices.geoip.client.GeoIpResource;
import com.irdeto.rrm.microservices.geoip.model.Ip;
import com.irdeto.rrm.microservices.geoip.model.Request;
import com.irdeto.rrm.microservices.geoip.model.Response;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class GeoIpController {

  private GeoIpResource geoIpResource;

  @Autowired
  public GeoIpController(final GeoIpResource geoIpResource) {
    this.geoIpResource = geoIpResource;
  }

  @HystrixCommand(fallbackMethod = "checkIpFallback")
  @RequestMapping(path = "/checkIp", method = POST, produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
  public Response checkIp(@RequestBody final Request request) {
    final Ip location = geoIpResource.checkIp(request.getIp());

    Optional<String> country =
        request.getCountriesAllowed()
            .stream()
            .filter(s -> s.equalsIgnoreCase(location.getCountryName()))
            .findFirst();

    boolean isAllowed = country.isPresent();
    final Response response = new Response(isAllowed, location.getIp(), location.getCountryName(), location.getCountryCode());
    return response;
  }

  public Response checkIpFallback(final Request request) {
    return new Response(false, request.getIp(), null, null);
  }
}
