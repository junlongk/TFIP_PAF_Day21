package sg.edu.nus.iss.workshop21.controllers;

import jakarta.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.edu.nus.iss.workshop21.models.Order;
import sg.edu.nus.iss.workshop21.services.OrderService;
import sg.edu.nus.iss.workshop21.utils.Converter;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRestController {

    @Autowired
    OrderService orderSvc;

    @GetMapping(path = "/customer/{customerId}/orders")
    public ResponseEntity<String> getAllOrdersByCustomerId (@PathVariable int customerId) {
        Optional<List<Order>> opt = orderSvc.getAllOrdersByCustomerId(customerId);

        if (opt.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Json.createObjectBuilder()
                            .add("message", "Customer with customerID <%d> does not exist".formatted(customerId))
                            .build()
                            .toString());
        else
            return ResponseEntity.status(HttpStatus.OK)
                    .body(opt.get().stream()
                            .map(v -> Converter.orderToJson(v))
                            .toList()
                            .toString());
    }
}
