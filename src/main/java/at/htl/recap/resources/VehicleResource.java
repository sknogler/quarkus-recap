package at.htl.recap.resources;

import org.jboss.logging.annotations.Param;

import javax.ws.rs.*;
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

    @Path("query")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(
            @QueryParam("grade") int grade,
            @QueryParam("name") String name
    ){
        return String.format("%d grade in class %s", grade, name);
    }
}
