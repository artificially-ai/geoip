package com.irdeto.rrm.microservices.geoip.client;

import com.irdeto.rrm.microservices.geoip.model.Ip;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(serviceId = "geoip")
public interface GeoIpResource {

  @RequestMapping(path = "/json/{ip}", method = GET, produces = APPLICATION_JSON_UTF8_VALUE)
  Ip checkIp(final @PathVariable("ip") String ip);
}