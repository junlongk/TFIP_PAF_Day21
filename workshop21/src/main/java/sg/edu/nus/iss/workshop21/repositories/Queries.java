package sg.edu.nus.iss.workshop21.repositories;

public class Queries {

    public static final String SQL_GET_ALL_CUSTOMERS = """
            select id customer_id, first_name, last_name, company, job_title from customers limit ? offset ?
            """;

    public static final String SQL_GET_CUSTOMER_BY_ID = """
            select id customer_id, first_name, last_name, company, job_title from customers where id = ?
            """;

    public static final String SQL_GET_ORDERS_BY_CUSTOMER_ID = """
            select customer_id, id order_id, ship_name, ship_address, paid_date, order_date, shipped_date from orders where customer_id = ?
            """;
}
