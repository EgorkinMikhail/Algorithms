package org.example.Interviews.Revolut.LoadBalancerTask;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LoadBalancerTest {

  @Test
  public void registerBackendInstance() {
    LoadBalancer loadBalancer = new LoadBalancer();
    Assert.assertTrue(loadBalancer.registerBackendInstance(new BackendInstance("123.1.2.3")));

  }

  @Test
  public void registerDuplicateBackendInstance() {
    LoadBalancer loadBalancer = new LoadBalancer();

    Assert.assertTrue(loadBalancer.registerBackendInstance(new BackendInstance("123.1.2.3")));
    Assert.assertFalse(loadBalancer.registerBackendInstance(new BackendInstance("123.1.2.3")));


  }

  @Test
  public void registerMoreThanTenBackEndInstance() {
    LoadBalancer loadBalancer = new LoadBalancer();

    for (int i = 0; i < 10; i++) {
      Assert.assertTrue(loadBalancer.registerBackendInstance(new BackendInstance("123.1.2.".concat(String.valueOf(i)))));
    }

    Assert.assertThrows(LoadBalancerException.class, () -> loadBalancer.registerBackendInstance(new BackendInstance("123.1.2.sd")));
  }

  @Test
  public void registerNullOrEmptyBackendInstance() {
    LoadBalancer loadBalancer = new LoadBalancer();

    Assert.assertThrows(LoadBalancerException.class, () -> loadBalancer.registerBackendInstance(null));
    Assert.assertThrows(LoadBalancerException.class, () -> loadBalancer.registerBackendInstance(new BackendInstance("")));
  }

  @Test
  public void getRandomInstance() {
    LoadBalancer loadBalancer = new LoadBalancer();
    Map<String, BackendInstance> testMap = new HashMap<>();

    for (int i = 0; i < 10; i++) {
      BackendInstance backendInstance = new BackendInstance("123.1.2.".concat(String.valueOf(i)));
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
      BackendInstance backendInstance = new BackendInstance("123.1.2.".concat(String.valueOf(i)));
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
