package org.example.Tasks.Network.UrlShortener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class URLShortener {
  private Lock lock;
  private static final String keyString = "https://go.key.shortener/";
  private Map<String, String> keyMap;
  private Map<String, String> valueMap;
  private char myChars[];
  private int keyLength;

  public URLShortener() {
    lock = new ReentrantLock();
    keyMap = new HashMap<>(); // short, long
    valueMap = new HashMap<>(); // long, short
    keyLength = 8;
    myChars = new char[62];
    for (int i = 0; i < 62; i++) {
      int j = 0;
      if (i < 10) {
        j = i + 48;
      } else if (i > 9 && i <= 35) {
        j = i + 55;
      } else {
        j = i + 61;
      }
      myChars[i] = (char) j;
    }
  }

  public String getShortUrlFromLongUrl(String longUrl) {
    try {
      lock.tryLock();
      if (validateLongURL(longUrl)) {
        if (valueMap.containsKey(longUrl)) {
          return valueMap.get(longUrl);
        } else {
          String shortUrl = generateKey();
          if (!keyMap.containsKey(shortUrl)) {
            keyMap.put(shortUrl, longUrl);
            valueMap.put(longUrl, shortUrl);
            return shortUrl;
          } else {
            throw new URLShortenerException("Wrong short URL address generating");
          }
        }
      } else {
        throw new URLShortenerException("Wrong long URL address");
      }
    } finally {
      lock.unlock();
    }
  }

  public String getLongUrlFromShortUrl(String shortUrl) {
    try {
      lock.tryLock();
      if (shortUrl == null || shortUrl.isBlank()) {
        throw new URLShortenerException("Wrong short URL address");
      }
      if (!keyMap.containsKey(shortUrl)) {
        throw new URLShortenerException("No long URL address generated for short URL");
      }
      return keyMap.get(shortUrl);
    } finally {
      lock.unlock();
    }
  }

  public List<String> getAllShortUrls() {
    if (!keyMap.isEmpty()) {
      return keyMap.keySet().stream().toList();
    } else {
      throw new URLShortenerException("empty URLs map");
    }
  }

  private boolean validateLongURL(String longURL) {
    try {
      new URL(longURL);
      return true;
    } catch (MalformedURLException e) {
      return false;
    }
  }

  private String generateShortKey() {
    UUID uuid = UUID.randomUUID();
    long lo = uuid.getLeastSignificantBits();
    long hi = uuid.getMostSignificantBits();
    lo = (lo >> (64 - 31)) ^ lo;
    hi = (hi >> (64 - 31)) ^ hi;
    String s = String.format("%010d", Math.abs(hi) + Math.abs(lo));
    return keyString.concat(s.substring(s.length() - 10));
  }

  private String generateKey() {
    Random myRand = new Random();
    String key = "";
    boolean flag = true;
    while (flag) {
      key = "";
      for (int i = 0; i <= keyLength; i++) {
        key += myChars[myRand.nextInt(62)];
      }
      if (!keyMap.containsKey(key)) {
        flag = false;
      }
    }
    return keyString.concat(key);
  }
}
