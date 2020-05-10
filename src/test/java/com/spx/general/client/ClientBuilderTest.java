package com.spx.general.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ClientBuilderTest {

  @Test
  @DisplayName("╯°□°）╯   Simple General client")
  public void createClient(){
    NotificationsResource client = GeneralClientBuilder.createClient(
        NotificationsResource.class,
        "https://postman-echo.com:443");

    String result = client.getFoo("TEST");
    //log.info(result);
  }

  @Test
  @DisplayName("Build General client")
  public void buildClient(){
    NotificationsResource client = new GeneralClientBuilder()
        .uri("https://postman-echo.com:443")
        .build(NotificationsResource.class);
    String result = client.getFoo("TEST 2");
    //log.info(result);
  }

}
