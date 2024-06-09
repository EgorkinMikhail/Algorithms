package org.example.Tasks.Network.LoadBalancerTask;

public class BackendInstance {

  private String address;

  public BackendInstance(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
