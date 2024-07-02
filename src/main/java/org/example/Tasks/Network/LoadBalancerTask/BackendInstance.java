package org.example.Tasks.Network.LoadBalancerTask;

import java.net.MalformedURLException;
import java.net.URL;

public class BackendInstance {

  private String address;

  public BackendInstance() {
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    if (validateUrlAddress(address)) {
      this.address = address;
    }
  }

  public boolean validateUrlAddress(String address) {
    try {
      new URL(address);
      return true;
    } catch (MalformedURLException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
}
