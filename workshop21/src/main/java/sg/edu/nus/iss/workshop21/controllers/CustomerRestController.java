package sg.edu.nus.iss.workshop21.controllers;

import jakarta.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.edu.nus.iss.workshop21.models.Customer;
import sg.edu.nus.iss.workshop21.services.CustomerService;
import sg.edu.nus.iss.workshop21.utils.Converter;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestController {

    @Autowired
    CustomerService customerSvc;

    // Get list of customers
    @GetMapping(path = "/customers")
    public ResponseEntity<String> getAllCustomers(@RequestParam(defaultValue = "5") int limit,
                                                  @RequestParam(defaultValue = "0") int offset) {
        List<Customer> customers = customerSvc.getAll(limit, offset);

        if (customers.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No results");
        else
            return ResponseEntity.status(HttpStatus.OK)
                    .body(customers.stream()
                            .map(v -> Converter.customerToJson(v))
                            .toList()
                            .toString());
    }

    @GetMapping(path = "/customer/{customerId}")
    public ResponseEntity<String> getCustomerById(@PathVariable int customerId) {
        Optional<Customer> opt = customerSvc.getCustomerById(customerId);

        if (opt.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Json.createObjectBuilder()
                            .add("message", "No customer with customerID <%d> found".formatted(customerId))
                            .build()
                            .toString());
        else
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Converter.customerToJson(opt.get())
                            .toString());
    }
}
