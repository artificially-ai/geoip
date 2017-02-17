package com.irdeto.rrm.microservices.geoip.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ip {

  @JsonProperty("country_name")
  private String countryName;

  @JsonProperty("country_code")
  private String countryCode;

  @JsonProperty(value = "region_code")
  private String regionCode;

  @JsonProperty(value = "region_name")
  private String regionName;

  @JsonProperty(value = "metro_code")
  private Long metroCode;

  @JsonProperty("time_zone")
  private String timeZone;

  @JsonProperty("zip_code")
  private String zipCode;

  private String ip;

  private String city;

  private Double latitude;

  private Double longitude;

  public Ip(){}

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(final String countryName) {
    this.countryName = countryName;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(final String countryCode) {
    this.countryCode = countryCode;
  }

  public String getRegionCode() {
    return regionCode;
  }

  public void setRegionCode(final String regionCode) {
    this.regionCode = regionCode;
  }

  public String getRegionName() {
    return regionName;
  }

  public void setRegionName(final String regionName) {
    this.regionName = regionName;
  }

  public Long getMetroCode() {
    return metroCode;
  }

  public void setMetroCode(final Long metroCode) {
    this.metroCode = metroCode;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(final String timeZone) {
    this.timeZone = timeZone;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(final String zipCode) {
    this.zipCode = zipCode;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(final String ip) {
    this.ip = ip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(final Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(final Double longitude) {
    this.longitude = longitude;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Ip ip1 = (Ip) o;

    if (countryName != null ? !countryName.equals(ip1.countryName) : ip1.countryName != null) {
      return false;
    }
    if (countryCode != null ? !countryCode.equals(ip1.countryCode) : ip1.countryCode != null) {
      return false;
    }
    if (regionCode != null ? !regionCode.equals(ip1.regionCode) : ip1.regionCode != null) {
      return false;
    }
    if (regionName != null ? !regionName.equals(ip1.regionName) : ip1.regionName != null) {
      return false;
    }
    if (metroCode != null ? !metroCode.equals(ip1.metroCode) : ip1.metroCode != null) {
      return false;
    }
    if (timeZone != null ? !timeZone.equals(ip1.timeZone) : ip1.timeZone != null) {
      return false;
    }
    if (zipCode != null ? !zipCode.equals(ip1.zipCode) : ip1.zipCode != null) {
      return false;
    }
    if (ip != null ? !ip.equals(ip1.ip) : ip1.ip != null) {
      return false;
    }
    if (city != null ? !city.equals(ip1.city) : ip1.city != null) {
      return false;
    }
    if (latitude != null ? !latitude.equals(ip1.latitude) : ip1.latitude != null) {
      return false;
    }
    return longitude != null ? longitude.equals(ip1.longitude) : ip1.longitude == null;
  }

  @Override
  public int hashCode() {
    int result = countryName != null ? countryName.hashCode() : 0;
    result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
    result = 31 * result + (regionCode != null ? regionCode.hashCode() : 0);
    result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
    result = 31 * result + (metroCode != null ? metroCode.hashCode() : 0);
    result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
    result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
    result = 31 * result + (ip != null ? ip.hashCode() : 0);
    result = 31 * result + (city != null ? city.hashCode() : 0);
    result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
    result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Ip{" +
        "countryName='" + countryName + '\'' +
        ", countryCode='" + countryCode + '\'' +
        ", regionCode='" + regionCode + '\'' +
        ", regionName='" + regionName + '\'' +
        ", metroCode=" + metroCode +
        ", timeZone='" + timeZone + '\'' +
        ", zipCode='" + zipCode + '\'' +
        ", ip='" + ip + '\'' +
        ", city='" + city + '\'' +
        ", latitude=" + latitude +
        ", longitude=" + longitude +
        '}';
  }
}
