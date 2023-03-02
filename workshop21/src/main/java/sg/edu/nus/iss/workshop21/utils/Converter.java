package sg.edu.nus.iss.workshop21.utils;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import sg.edu.nus.iss.workshop21.models.Customer;
import sg.edu.nus.iss.workshop21.models.Order;

public class Converter {

    /*
    private int customerId;
    private String firstName;
    private String lastName;
    private String company;
    private String jobTitle;
     */
    public static JsonObject customerToJson(Customer customer) {
        return Json.createObjectBuilder()
                .add("customerId", customer.getCustomerId())
                .add("firstName", customer.getFirstName())
                .add("lastName", customer.getLastName())
                .add("company", customer.getCompany())
                .add("jobTitle", customer.getJobTitle())
                .build();
    }

    public static Customer rowSetToCustomer(SqlRowSet rs) {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getInt("id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setCompany(rs.getString("company"));
        customer.setJobTitle(rs.getString("job_title"));
        return customer;
    }

    /*
    private int customerId;
    private int orderId;
    private String shipName;
    private String shipAddress;
    private Date paidDate;
    private Date orderDate;
    private Date shippedDate;
     */
    public static JsonObject orderToJson(Order order) {
        return Json.createObjectBuilder()
                .add("customerId", order.getCustomerId())
                .add("orderId", order.getOrderId())
                .add("shipName", order.getShipName())
                .add("shipAddress", order.getShipAddress())
                .add("paidDate", String.valueOf(order.getPaidDate()))
                .add("orderDate", String.valueOf(order.getOrderDate()))
                .add("shippedDate", String.valueOf(order.getShippedDate()))
                .build();
    }
}
