
package dal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import model.User;

public class DAO_Login extends DBContext{
    // ĐĂNG KÍ TÀI KHOẢN
   // Thêm tài khoản vào db
    public void insertAccount(String user, String password) {
        String sql = "INSERT INTO [User] VALUES (?,?,?,?);";
        PreparedStatement ps = null;
        try {
            int index = 1;
             ps = connection.prepareStatement(sql);
            if(user != null && user.equals("") == false && password != null && password.equals("") == false){
                ps.setString(index++, user);
                ps.setString(index++, password);
                ps.setInt(index++, 1);
                ps.setString(index++, "NULL");
            }
                            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // tự động đăng nhập khi có remember bao gồm user và randomid
    public boolean checkToken(String user,String token) {
        String sql = "SELECT * FROM [User] WHERE username=? AND remember_token=?";
        try {
            int index = 1;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(index++, user);
            ps.setString(index++, token);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    // tạo token mới
    public void updateToken(String user,String token){
        String sql = "UPDATE [User] SET remember_token = ? WHERE username = ?";
        try {
            int index = 1;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(index++, token);
            ps.setString(index++, user);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    // xóa một token 
     public void deleteToken(String user){
        String sql = "UPDATE [User] SET remember_token=? WHERE username=?";
        try {
            int index = 1;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(index++,  "NULL");
            ps.setString(index++,  user);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    // Tìm tài khoản bằng user
    public User findUser(String user) {
       String sql = "SELECT * FROM [User] WHERE username=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, user);
            
            ResultSet res = ps.executeQuery();
            if(res.next()) {
                return new User(res.getString("username"),res.getString("password"),res.getInt("role_id"),res.getString("remember_token"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    // ĐĂNG NHẬP
    public User checkLogin(String user, String password) {
        String sql = "SELECT * FROM [User] WHERE username=? AND password=?";
        try {
            int index = 1;
            PreparedStatement ps = connection.prepareStatement(sql);
            if(user != null && user.equals("") == false && password != null && password.equals("") == false){
                ps.setString(index++, user);
                ps.setString(index++, password);
            }
            ResultSet res = ps.executeQuery();
            if(res.next()) {
                User u = new User(res.getString("username"),res.getString("password"),res.getInt("role_id"),res.getString("remember_token"));
                return u;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
