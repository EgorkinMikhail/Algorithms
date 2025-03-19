package org.example.Tasks.Network.LoadBalancerTask;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class LoadBalancerTest {
  private LoadBalancer loadBalancer;

  @Before
  public void setUp() {
    loadBalancer = new LoadBalancer();
  }

  @Test
  public void testSetServer_ValidServer() {
    try {
      loadBalancer.setServer("http://example.com");
    } catch (Exception e) {
      fail("Exception should not be thrown");
    }
  }

  @Test
  public void testSetServer_NullOrEmpty() {
    try {
      loadBalancer.setServer(null);
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }

    try {
      loadBalancer.setServer("");
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }

    try {
      loadBalancer.setServer(" ");
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
  }

  @Test
  public void testSetServer_InvalidURL() {
    try {
      loadBalancer.setServer("invalid-url");
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
  }

  @Test
  public void testSetServer_MaxLimit() {
    try {
      for (int i = 0; i < 10; i++) {
        loadBalancer.setServer("http://example.com/" + i);
      }
      loadBalancer.setServer("http://example.com/extra");
      fail("Expected IllegalStateException");
    } catch (IllegalStateException ignored) {
    }
  }

  @Test
  public void testGetServer_Empty() {
    try {
      loadBalancer.getServer();
      fail("Expected IllegalStateException");
    } catch (IllegalStateException ignored) {
    }
  }

  @Test
  public void testGetServer_RandomSelection() {
    Set<String> addedServers = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      String server = "http://example.com/" + i;
      loadBalancer.setServer(server);
      addedServers.add(server);
    }
    assertTrue(addedServers.contains(loadBalancer.getServer()));
  }

  @Test
  public void testConcurrent() {
    LoadBalancer loadBalancer = new LoadBalancer();
    IntStream.range(0, 25)
        .parallel()
        .forEach(i -> {
          loadBalancer.setServer("https://123.1.2.".concat(String.valueOf(i)));
          System.out.println("Registered new load balancer: " +
              "server: " + "https://123.1.2.".concat(String.valueOf(i)) +
              " in thread: " + Thread.currentThread().getName());

        });

    Assert.assertNotNull(loadBalancer);
    Assert.assertNotNull(loadBalancer.getServer());
    Assert.assertEquals(10, loadBalancer.getCountOfRegisteredServers());
  }

  @Test
  public void getInstanceFromEmptyLoadBalancer() {
    LoadBalancer loadBalancer = new LoadBalancer();
    assertThrows(IllegalStateException.class, loadBalancer::getServer);
  }

}
