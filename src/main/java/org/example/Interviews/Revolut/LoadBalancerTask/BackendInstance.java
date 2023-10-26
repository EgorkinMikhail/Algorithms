package org.example.Interviews.Revolut.LoadBalancerTask;

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
