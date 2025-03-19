package org.example.Tasks.Network.LoadBalancerTask;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class LoadBalancer {
  private static final int MAX_SERVERS = 10;
  private final Collection<String> servers = new HashSet<>();
  private final Random random = new Random();

  public void setServer(String server) {
    if (server == null || server.trim().isEmpty()) {
      throw new IllegalArgumentException("Server cannot be null or empty.");
    }
    try {
      new URL(server);
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException("Invalid server URL.");
    }
    synchronized (servers) {
      if (servers.size() >= MAX_SERVERS) {
        throw new IllegalStateException("Cannot add more servers. Maximum limit reached.");
      }
      servers.add(server);
    }
  }

  public String getServer() {
    synchronized (servers) {
      if (servers.isEmpty()) {
        throw new IllegalStateException("No servers available.");
      }
      int index = random.nextInt(servers.size());
      return servers.toArray(new String[0])[index];
    }
  }

  public int getCountOfRegisteredServers() {
    synchronized (servers) {
      return servers.size();
    }
  }
}
