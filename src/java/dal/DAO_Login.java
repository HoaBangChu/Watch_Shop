
package dal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import model.User;

public class DAO_Login extends DBContext{
    // ĐĂNG KÍ TÀI KHOẢN
   // Thêm tài khoản vào db
    public void insertAccount(String user, String password,int id) {
        String sql = "INSERT INTO [User] VALUES (?,?,?,?,?,?,?);";
        PreparedStatement ps = null;
        try {
            int index = 1;
             ps = connection.prepareStatement(sql);
            if(user != null && user.equals("") == false && password != null && password.equals("") == false){
                ps.setString(index++, user);
                ps.setString(index++, password);
                ps.setInt(index++, id);
                ps.setString(index++, "NULL");
                ps.setString(index++, "NULL");
                ps.setString(index++, "NULL");
                ps.setString(index++, "NULL");
            }
              ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // tự động đăng nhập khi có remember bao gồm user và randomid
    public boolean checkToken(String user,String token, String table) {
        String sql = "SELECT * FROM "+table+" WHERE username=? AND remember_token=?";
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
    public void updateToken(String user,String token,String table){
        String sql = "UPDATE "+table+" SET remember_token = ? WHERE username = ?";
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
     public void deleteToken(String user,String table){
        String sql = "UPDATE "+table+" SET remember_token=? WHERE username=?";
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
    public User findUser(String user,int id) {
       String sql = "SELECT * FROM [User] WHERE username=? AND role_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, user);
                ps.setInt(2, id);
            ResultSet res = ps.executeQuery();
            if(res.next()) {
                return new User(res.getString("username"),res.getString("password"),
                        res.getInt("role_id"),res.getString("remember_token"),res.getString("avatar")
                        ,res.getString("email"),res.getString("phone"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    // ĐĂNG NHẬP
    public User checkLogin(String user, String password) {
        String sql = "SELECT * FROM [User] WHERE username=? AND password=? ";
        try {
            int index = 1;
            PreparedStatement ps = connection.prepareStatement(sql);
            if(user != null && user.equals("") == false && password != null && password.equals("") == false){
                ps.setString(index++, user);
                ps.setString(index++, password);
                //ps.setInt(index++, id);
            }
            ResultSet res = ps.executeQuery();
            if(res.next()) {
                 return new User(res.getString("username"),res.getString("password"),
                        res.getInt("role_id"),res.getString("remember_token"),res.getString("avatar")
                        ,res.getString("email"),res.getString("phone"));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    // update quyền admin
    public void updateAdminRole(String user) {
        String sql = "UPDATE [User] SET role_id=? WHERE username=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 2);
            ps.setString(2, user);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // cập nhật email và sđt cho admin
    public void updateInfoAdmin(String email,String phone,String user) {
        String sql = "UPDATE [User] SET email=?,phone=? WHERE username=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setString(3, user);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // kiểm tra phone và email đã tồn tại rồi thì bắt add khác đi
    public boolean checkPhoneMail(String email,String phone) {
        String sql = "SELECT * FROM [User] WHERE email=? OR phone=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, phone);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
