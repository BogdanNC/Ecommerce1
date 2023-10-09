public class Security {
    private Integer userId;
    private String pass;



    public Security(Integer userId, String pass) {
        this.userId = userId;
        this.pass = pass;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
