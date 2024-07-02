package org.example.Tasks.Network.LoadBalancerTask;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LoadBalancerTest {

  @Test
  public void registerBackendInstance() {
    LoadBalancer loadBalancer = new LoadBalancer();
    BackendInstance backendInstance = new BackendInstance();
    backendInstance.setAddress("https://123.1.2.3");
    Assert.assertTrue(loadBalancer.registerBackendInstance(backendInstance));

  }

  @Test
  public void registerDuplicateBackendInstance() {
    LoadBalancer loadBalancer = new LoadBalancer();
    BackendInstance backendInstance1 = new BackendInstance();
    backendInstance1.setAddress("https://123.1.2.3");
    BackendInstance backendInstance2 = new BackendInstance();
    backendInstance2.setAddress("https://123.1.2.3");

    Assert.assertTrue(loadBalancer.registerBackendInstance(backendInstance1));
    Assert.assertFalse(loadBalancer.registerBackendInstance(backendInstance2));


  }

  @Test
  public void registerMoreThanTenBackEndInstance() {
    LoadBalancer loadBalancer = new LoadBalancer();

    for (int i = 0; i < 10; i++) {
      BackendInstance backendInstance = new BackendInstance();
      backendInstance.setAddress("https://123.1.2.".concat(String.valueOf(i)));
      Assert.assertTrue(loadBalancer.registerBackendInstance(backendInstance));
    }
    BackendInstance backendInstance = new BackendInstance();
    backendInstance.setAddress("https://123.1.2.11");
    Assert.assertThrows(LoadBalancerException.class, () -> loadBalancer.registerBackendInstance(backendInstance));
  }

  @Test
  public void registerNullOrEmptyBackendInstance() {
    LoadBalancer loadBalancer = new LoadBalancer();

    Assert.assertThrows(LoadBalancerException.class, () -> loadBalancer.registerBackendInstance(null));
    Assert.assertThrows(LoadBalancerException.class, () -> loadBalancer.registerBackendInstance(new BackendInstance()));
  }

  @Test
  public void getRandomInstance() {
    LoadBalancer loadBalancer = new LoadBalancer();
    Map<String, BackendInstance> testMap = new HashMap<>();

    for (int i = 0; i < 10; i++) {
      BackendInstance backendInstance = new BackendInstance();
      backendInstance.setAddress("https://123.1.2.".concat(String.valueOf(i)));
      Assert.assertTrue(loadBalancer.registerBackendInstance(backendInstance));
      testMap.put(backendInstance.getAddress(), backendInstance);
    }

    BackendInstance backendInstance = loadBalancer.getInstance();
    System.out.println(backendInstance.getAddress());

    Assert.assertTrue(testMap.containsKey(backendInstance.getAddress()));


  }

  @Test
  public void getRandomInstanceWithRandomFunctionChecking() {
    LoadBalancer loadBalancer = new LoadBalancer();
    Map<String, BackendInstance> testMap = new HashMap<>();

    for (int i = 0; i < 10; i++) {
      BackendInstance backendInstance = new BackendInstance();
      backendInstance.setAddress("https://123.1.2.".concat(String.valueOf(i)));
      Assert.assertTrue(loadBalancer.registerBackendInstance(backendInstance));
      testMap.put(backendInstance.getAddress(), backendInstance);
    }

    BackendInstance backendInstance = loadBalancer.getInstance();
    System.out.println(backendInstance.getAddress());

    Assert.assertTrue(testMap.containsKey(backendInstance.getAddress()));


  }

  @Test
  public void getInstanceFromEmptyLoadBalancer() {
    LoadBalancer loadBalancer = new LoadBalancer();

    Assert.assertThrows(LoadBalancerException.class, loadBalancer::getInstance);

  }

}
