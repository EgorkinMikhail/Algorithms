package org.example.Tasks.Network.URLShortener;

import org.example.Tasks.Network.UrlShortener.URLShortener;
import org.example.Tasks.Network.UrlShortener.URLShortenerException;
import org.junit.Assert;
import org.junit.Test;

public class URLShortenerTest {

  private static final String longUrl = "https://www.google.com/imghp?hl=ru&ogbl";
  private static final String anotherLongUrl = "https://www.google.com/imghp?hl=ru&oasdasdfqegbl";

  @Test
  public void setWrongUrlToShortener() {
    URLShortener urlShortener = new URLShortener();
    Assert.assertThrows(URLShortenerException.class, () -> urlShortener.getShortUrlFromLongUrl("test"));
  }

  @Test
  public void setNullUrlToShortener() {
    URLShortener urlShortener = new URLShortener();
    Assert.assertThrows(URLShortenerException.class, () -> urlShortener.getShortUrlFromLongUrl(null));
  }

  @Test
  public void setEmptyUrlToShortener() {
    URLShortener urlShortener = new URLShortener();
    Assert.assertThrows(URLShortenerException.class, () -> urlShortener.getShortUrlFromLongUrl(""));
  }

  @Test
  public void setUrlToShortener() {
    URLShortener urlShortener = new URLShortener();
    String shortUrl =  urlShortener.getShortUrlFromLongUrl(longUrl);
    Assert.assertEquals(longUrl, urlShortener.getLongUrlFromShortUrl(shortUrl));
    System.out.println(longUrl);
    System.out.println(shortUrl);
  }

  @Test
  public void setSeveralUrlsToShortener() {
    URLShortener urlShortener = new URLShortener();
    String shortUrl =  urlShortener.getShortUrlFromLongUrl(longUrl);
    Assert.assertEquals(longUrl, urlShortener.getLongUrlFromShortUrl(shortUrl));

    System.out.println(shortUrl);

    String anotherShortUrl =  urlShortener.getShortUrlFromLongUrl(anotherLongUrl);
    Assert.assertEquals(anotherLongUrl, urlShortener.getLongUrlFromShortUrl(anotherShortUrl));

    System.out.println(anotherShortUrl);

    Assert.assertTrue(urlShortener.getAllShortUrls().contains(shortUrl));
    Assert.assertTrue(urlShortener.getAllShortUrls().contains(anotherShortUrl));
  }

  @Test
  public void setSeveralSameUrlsToShortener() {
    URLShortener urlShortener = new URLShortener();
    String shortUrl =  urlShortener.getShortUrlFromLongUrl(longUrl);
    Assert.assertEquals(longUrl, urlShortener.getLongUrlFromShortUrl(shortUrl));

    System.out.println(shortUrl);

    String sameShortUrl =  urlShortener.getShortUrlFromLongUrl(longUrl);
    Assert.assertEquals(longUrl, urlShortener.getLongUrlFromShortUrl(sameShortUrl));

    System.out.println(sameShortUrl);

    Assert.assertEquals(shortUrl, sameShortUrl);
  }

  @Test
  public void getNullUrlFromShortener() {
    URLShortener urlShortener = new URLShortener();
    Assert.assertThrows(URLShortenerException.class, () -> urlShortener.getLongUrlFromShortUrl(null));
  }

  @Test
  public void getEmptyUrlFromShortener() {
    URLShortener urlShortener = new URLShortener();
    Assert.assertThrows(URLShortenerException.class, () -> urlShortener.getLongUrlFromShortUrl(""));
  }

  @Test
  public void getWrongUrlFromShortener() {
    URLShortener urlShortener = new URLShortener();
    Assert.assertThrows(URLShortenerException.class, () -> urlShortener.getLongUrlFromShortUrl("test"));
  }

  @Test
  public void getUnusedUrlFromShortener() {
    URLShortener urlShortener = new URLShortener();
    String shortUrl = urlShortener.getShortUrlFromLongUrl(longUrl);
    Assert.assertEquals(longUrl, urlShortener.getLongUrlFromShortUrl(shortUrl));
    Assert.assertThrows(URLShortenerException.class, () -> urlShortener.getLongUrlFromShortUrl(anotherLongUrl));
  }

  @Test
  public void testConcurrent() {
    // TODO:
  }
}
