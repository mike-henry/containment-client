package com.spx.general.client;

import com.sun.research.ws.wadl.Param;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/")
public interface NotificationsResource {
  @GET
  @Path("/ping")
  public String ping();

  @GET
  @Path("/get")
  @Produces(MediaType.APPLICATION_JSON)
  public String getFoo(@QueryParam("foo") String foo);


}