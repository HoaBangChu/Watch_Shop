
package model;

public class User {
    private String username;
    private String password;
    private int role_id;
    private String remember_token;
    private String avatar;
    private String email;
    private String phone;

    public User(String username, String password, int role_id, String remember_token, String avatar, String email, String phone) {
        this.username = username;
        this.password = password;
        this.role_id = role_id;
        this.remember_token = remember_token;
        this.avatar = avatar;
        this.email = email;
        this.phone = phone;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
