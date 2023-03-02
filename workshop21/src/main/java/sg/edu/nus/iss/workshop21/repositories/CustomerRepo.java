package sg.edu.nus.iss.workshop21.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import sg.edu.nus.iss.workshop21.models.Customer;
import sg.edu.nus.iss.workshop21.utils.Converter;

import static sg.edu.nus.iss.workshop21.repositories.Queries.*;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getAll() {
        return getAll(5, 0);
    }

    public List<Customer> getAll(int limit, int offset) {
        List<Customer> result;
        result = jdbcTemplate.query(SQL_GET_ALL_CUSTOMERS,
                BeanPropertyRowMapper.newInstance(Customer.class), limit, offset);
        return result;
    }

    public Optional<Customer> getCustomerById(int customerId) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_CUSTOMER_BY_ID, customerId);

        if (!rs.next())
            return Optional.empty();

        return Optional.of(Converter.rowSetToCustomer(rs));
    }
}
