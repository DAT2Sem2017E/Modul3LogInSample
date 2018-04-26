package FunctionLayer;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    public User( String email, String password, String role, String address, String name, int phone, String city ) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.city = city;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and all
    private String role;
    private String address;
    private String name;
    private int phone;
    private String city;

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getAddress()
    {
        return address;
    }

    public String getName()
    {
        return name;
    }

    public int getPhone()
    {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    

}
