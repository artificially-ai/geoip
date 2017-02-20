package nl.ekholabs.microservices.geoip.model;

import java.util.List;

public class Request {

  private String ip;
  private List<String> countriesAllowed;

  public Request() {}

  public Request(final String ip, final List<String> countriesAllowed) {
    this.ip = ip;
    this.countriesAllowed = countriesAllowed;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(final String ip) {
    this.ip = ip;
  }

  public List<String> getCountriesAllowed() {
    return countriesAllowed;
  }

  public void setCountriesAllowed(final List<String> countriesAllowed) {
    this.countriesAllowed = countriesAllowed;
  }

  @Override
  public String toString() {
    return "Request{" +
        "ip='" + ip + '\'' +
        ", countriesAllowed=" + countriesAllowed +
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

    final Request request = (Request) o;

    if (ip != null ? !ip.equals(request.ip) : request.ip != null) {
      return false;
    }
    return countriesAllowed != null ? countriesAllowed.equals(request.countriesAllowed) : request.countriesAllowed == null;
  }

  @Override
  public int hashCode() {
    int result = ip != null ? ip.hashCode() : 0;
    result = 31 * result + (countriesAllowed != null ? countriesAllowed.hashCode() : 0);
    return result;
  }
}
