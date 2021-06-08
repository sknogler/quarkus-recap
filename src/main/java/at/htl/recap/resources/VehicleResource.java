package at.htl.recap.resources;

import at.htl.recap.entity.Vehicle;
import at.htl.recap.repository.VehicleRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("vehicle")
public class VehicleResource {

    @Inject
    VehicleRepository vehicleRepository;

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


    @Path("response")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDummyVehicle(){
        Vehicle opel = new Vehicle("Opel", "Kadett", 1979);

        return Response.ok(opel).build();
    }

    @Path("db")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVehiclefromDb(){
        Vehicle opel = new Vehicle("Opel", "Kadett", 1979);
        Vehicle savedOpel = vehicleRepository.save(opel);

        return Response.ok(savedOpel).build();
    }
}
