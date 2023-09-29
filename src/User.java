public class User {
    private String name, email;
    private Integer userId;

    public User(String name, String email, Integer user_ID) {
        this.name = name;
        this.email = email;
        this.userId = user_ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
