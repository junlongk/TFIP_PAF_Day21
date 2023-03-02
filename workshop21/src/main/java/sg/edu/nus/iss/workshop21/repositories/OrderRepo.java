package sg.edu.nus.iss.workshop21.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import sg.edu.nus.iss.workshop21.models.Order;
import sg.edu.nus.iss.workshop21.utils.Converter;

import java.util.List;
import java.util.Optional;

import static sg.edu.nus.iss.workshop21.repositories.Queries.*;

@Repository
public class OrderRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<List<Order>> getAllOrdersByCustomerId(int customerId) {
        // Check if customer exists via customers database
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_CUSTOMER_BY_ID, customerId);

        if (!rs.next())
            return Optional.empty();

        List<Order> orderList;
        orderList = jdbcTemplate.query(SQL_GET_ORDERS_BY_CUSTOMER_ID,
                BeanPropertyRowMapper.newInstance(Order.class), customerId);

        return Optional.of(orderList);
    }
}
