package Client;

public class Client {
    private final String name;
    private final String email;
    private final String phoneNumber;

    public Client(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name +
                ", email: " + email +
                ", phoneNumber: " + phoneNumber;
    }
}
