
package model;

public class User {
    private String username;
    private String password;
    private int role_id;
    private String remember_token;

    public User(String username, String password, int role_id, String remember_token) {
        this.username = username;
        this.password = password;
        this.role_id = role_id;
        this.remember_token = remember_token;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }
    
}
