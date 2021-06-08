package at.htl.recap.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("vehicle")
public class VehicleResource {

    @Path("path/{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name){
        return String.format("hello %s", name);
    }
}
