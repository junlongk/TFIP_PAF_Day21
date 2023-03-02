package sg.edu.nus.iss.workshop21.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.edu.nus.iss.workshop21.models.Order;
import sg.edu.nus.iss.workshop21.repositories.OrderRepo;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Optional<List<Order>> getAllOrdersByCustomerId(int customerId) {
        return orderRepo.getAllOrdersByCustomerId(customerId);
    }
}
