package com.example.benjamin.bootstrap;

import com.example.benjamin.dao.CustomerRepository;
import com.example.benjamin.dao.DivisionRepository;
import com.example.benjamin.entities.Customer;
import com.example.benjamin.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(customerRepository.count() == 1) {
            // save sample customers
            // customer1
            Division div1 = new Division();
            div1.setId(2L);
            div1.setCountry_id(1L);
            Customer customer1 = new Customer();
            customer1.setFirstName("Scott");
            customer1.setLastName("Smith");
            customer1.setAddress("123 Fisk St");
            customer1.setPostal_code("90210");
            customer1.setPhone("509-420-1337");
            customer1.setDivision(div1);
            customerRepository.save(customer1);

            // customer2
            Division div2 = new Division();
            div2.setId(101L);
            div2.setCountry_id(2L);
            Customer customer2 = new Customer();
            customer2.setFirstName("James");
            customer2.setLastName("Jameson");
            customer2.setAddress("123 James St");
            customer2.setPostal_code("91111");
            customer2.setPhone("123-456-7890");
            customer2.setDivision(div2);
            customerRepository.save(customer2);

            // customer3
            Division div3 = new Division();
            div3.setId(69L);
            div3.setCountry_id(3L);
            Customer customer3 = new Customer();
            customer3.setFirstName("Lynn");
            customer3.setLastName("Ellison");
            customer3.setAddress("890 Marion St");
            customer3.setPostal_code("98999");
            customer3.setPhone("206-592-6769");
            customer3.setDivision(div3);
            customerRepository.save(customer3);

            // customer4
            Division div4 = new Division();
            div4.setId(3L);
            div4.setCountry_id(1L);
            Customer customer4 = new Customer();
            customer4.setFirstName("Tamara");
            customer4.setLastName("Tamison");
            customer4.setAddress("369 C St");
            customer4.setPostal_code("98008");
            customer4.setPhone("789-789-7897");
            customer4.setDivision(div4);
            customerRepository.save(customer4);

            // customer5
            Division div5 = new Division();
            div5.setId(4L);
            div5.setCountry_id(1L);
            Customer customer5 = new Customer();
            customer5.setFirstName("Jonathan");
            customer5.setLastName("Jonowski");
            customer5.setAddress("100 A St");
            customer5.setPostal_code("10001");
            customer5.setPhone("321-867-5309");
            customer5.setDivision(div5);
            customerRepository.save(customer5);

            // confirm in console that customers were added
            System.out.println("Sample customers added.");
        }
        else {
            System.out.println("Sample customers already exist.");
        }

        // show number of customers
        System.out.println("Started in BootStrap.");
        System.out.println("Number of Customers: " + customerRepository.count());
        System.out.println(customerRepository.findAll());
    }
}
