package sg.edu.nus.iss.workshop21.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.edu.nus.iss.workshop21.models.Customer;
import sg.edu.nus.iss.workshop21.repositories.CustomerRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getAll() {
        return getAll(5, 0);
    }

    public List<Customer> getAll(int limit, int offset) {
        return customerRepo.getAll(limit, offset);
    }

    public Optional<Customer> getCustomerById(int customerId) {
        return customerRepo.getCustomerById(customerId);
    }
}
