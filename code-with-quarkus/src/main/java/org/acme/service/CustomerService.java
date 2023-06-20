package org.acme.service;

import org.acme.entity.Customer;
import org.acme.exception.NotFoundException;
import org.acme.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    public List<Customer> findAllCustomer(){
        List<Customer> customers = new ArrayList<>();
        try {
           customers = customerRepository.findAll().list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }

    @Transactional
    public void addCustomer(Customer customer){
        customerRepository.persist(customer);
    }

    public Customer findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id);
        if(customer == null){
            throw new NotFoundException("Customer not found");
        }
        return customer;
    }

    @Transactional
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id);
        if(customer == null){
            throw new NotFoundException("Customer not found");
        }
        customerRepository.delete(customer);
    }

    @Transactional
    public void updateCustomer(Long id, Customer customer) {
        Customer customerFound = customerRepository.findById(id);
        if(customer == null){
            throw new NotFoundException("Customer not found");
        }
        customerFound.setAge(customer.getAge());
        customerFound.setEmail(customer.getEmail());
        customerFound.setLastName(customer.getLastName());
        customerRepository.persist(customerFound);
    }
}
