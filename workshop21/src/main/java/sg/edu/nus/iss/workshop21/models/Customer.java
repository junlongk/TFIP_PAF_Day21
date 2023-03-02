package sg.edu.nus.iss.workshop21.models;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String company;
    private String jobTitle;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Customer{customerId=%d, firstName='%s', lastName='%s', company='%s', jobTitle='%s'}"
                .formatted(customerId, firstName, lastName, company, jobTitle);
    }
}
