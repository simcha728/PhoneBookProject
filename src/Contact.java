public class Contact {
    private String firstName;
    private String lastName;
    private String primaryPhone;
    private String secondaryPhone;
    private String address;
    private String jobTitle;

    // בנאי לשדות חובה
    public Contact(String firstName, String lastName, String primaryPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryPhone = primaryPhone;
    }

    // בנאי מלא לשדות הרשות
    public Contact(String firstName, String lastName, String primaryPhone,
                   String secondaryPhone, String address, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
        this.address = address;
        this.jobTitle = jobTitle;
    }

    // Getters & Setters
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

    public String getPrimaryPhone() {
        return primaryPhone;
    }
    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }
    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    // toString() לנוחות ההדפסה
    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", primaryPhone='" + primaryPhone + '\'' +
                ", secondaryPhone='" + secondaryPhone + '\'' +
                ", address='" + address + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
