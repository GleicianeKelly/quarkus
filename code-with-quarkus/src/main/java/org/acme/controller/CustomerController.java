package org.acme.controller;

import org.acme.entity.Customer;
import org.acme.service.CustomerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/api/customer")
public class CustomerController {

    @Inject
    CustomerService customerService;

    @GET
    public List<Customer> retrieveCustomers(){
        return customerService.findAllCustomer();
    }

    @POST
    public void addCustomer(Customer customer){
        customerService.addCustomer(customer);
    }

    @GET
    @Path("/{id}")
    public Customer getCustomerById(@PathParam("id") Long id){
        return customerService.findCustomerById(id);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCustomer(@PathParam("id") Long id){
        customerService.deleteCustomer(id);
    }

    @PUT
    @Path("/{id}")
    public void updateCustomer(@PathParam("id") Long id, Customer customer){
        customerService.updateCustomer(id, customer);
    }
}
