package com.irdeto.rrm.microservices.geoip.model;


public class Response {

  private boolean isAllowed;
  private String ip;
  private String countrName;
  private String countryCode;

  public Response() {}

  public Response(final boolean isAllowed, final String ip, final String countrName, final String countryCode) {
    this.isAllowed = isAllowed;
    this.ip = ip;
    this.countrName = countrName;
    this.countryCode = countryCode;
  }

  public boolean isAllowed() {
    return isAllowed;
  }

  public void setAllowed(final boolean allowed) {
    isAllowed = allowed;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(final String ip) {
    this.ip = ip;
  }

  public String getCountrName() {
    return countrName;
  }

  public void setCountrName(final String countrName) {
    this.countrName = countrName;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(final String countryCode) {
    this.countryCode = countryCode;
  }

  @Override
  public String toString() {
    return "Response{" +
        "isAllowed=" + isAllowed +
        ", ip='" + ip + '\'' +
        ", countrName='" + countrName + '\'' +
        ", countryCode='" + countryCode + '\'' +
        '}';
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Response response = (Response) o;

    if (isAllowed != response.isAllowed) {
      return false;
    }
    if (ip != null ? !ip.equals(response.ip) : response.ip != null) {
      return false;
    }
    if (countrName != null ? !countrName.equals(response.countrName) : response.countrName != null) {
      return false;
    }
    return countryCode != null ? countryCode.equals(response.countryCode) : response.countryCode == null;
  }

  @Override
  public int hashCode() {
    int result = (isAllowed ? 1 : 0);
    result = 31 * result + (ip != null ? ip.hashCode() : 0);
    result = 31 * result + (countrName != null ? countrName.hashCode() : 0);
    result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
    return result;
  }
}
