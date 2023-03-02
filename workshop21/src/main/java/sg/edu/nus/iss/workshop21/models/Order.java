package sg.edu.nus.iss.workshop21.models;

import java.sql.Date;

public class Order {
    private int customerId;
    private int orderId;
    private String shipName;
    private String shipAddress;
    private Date paidDate;
    private Date orderDate;
    private Date shippedDate;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Override
    public String toString() {
        return "Order{customerId=%d, orderId=%d, shipName='%s', shipAddress='%s', paidDate=%s, orderDate=%s, shippedDate=%s}"
                .formatted(customerId, orderId, shipName, shipAddress, paidDate, orderDate, shippedDate);
    }
}
