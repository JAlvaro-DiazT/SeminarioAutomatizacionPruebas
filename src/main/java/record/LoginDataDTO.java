package record;

public class LoginDataDTO {
    private String username;
    private String password;

    public LoginDataDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
