package com.spx.general.client;

import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.client.proxy.WebResourceFactory;

@Slf4j
public class GeneralClientBuilder {

  private URI url;

  public static <T>T createClient(Class<T> type,String uri){

    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(uri);
    return WebResourceFactory.newResource(type, target);
  }

  public GeneralClientBuilder uri(URI uri){
    this.url = uri;
    return this;
  }

  public GeneralClientBuilder uri(String uri){
    try {
      return  this.uri(new URI(uri));
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  public <T>T build(Class<T> type){
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(url);
    return WebResourceFactory.newResource(type, target);
  }
}