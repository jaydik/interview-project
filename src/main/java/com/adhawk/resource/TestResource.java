package com.adhawk.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    public TestResource() { }

    @GET
    public Response test() {
        return Response.ok("Temp Service Is UP!!").build();
    }
}
