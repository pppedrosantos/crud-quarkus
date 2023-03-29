package br.com.crud.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import br.com.crud.dto.ProductDto;
import br.com.crud.entity.Product;
import br.com.crud.service.ProductService;

@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductService service;

    @GET
    public Response listProducts(){
        List<Product> products = service.listProducts();
        return Response.ok(products).build();
    }

    @POST
    public Response saveProduct(ProductDto dto){
        Product product = service.saveProduct(dto);
        return Response.ok(product).status(201).build();
    }

    @PUT
    @Path("{id}")
    public Response updateProduct(@PathParam("id") Long id, ProductDto dto){
        service.updateProduct(id, dto);
        return Response.status(204).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeProduct(@PathParam("id") Long id){
        service.deleteProduct(id);
        return Response.status(204).build();
    }
}
