package dal;

import java.util.List;
import model.Brand;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Watch;

public class DAO_Product extends DBContext {

    // làm việc với các brand trong db
    // BRAND
    public List<Brand> getAllBrand() throws SQLException {
        String sql = "SELECT * FROM Brands";
        PreparedStatement ps = null;
        List<Brand> list = new ArrayList();
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand b = new Brand(rs.getInt("brand_id"), rs.getString("brand_name"), rs.getString("images"));
                list.add(b);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }

    // lấy thương hiệu bằng id
    private Brand getBrandById(int id) throws SQLException {
        String sql = "SELECT * FROM Brands WHERE brand_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand b = new Brand(rs.getInt("brand_id"), rs.getString("brand_name"), rs.getString("images"));
                return b;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

    //BEST SELLER
    // lấy ra tất cả sản phẩm bestseller
    public List<Watch> getAllBestSeller() throws SQLException {
        String sql = "SELECT * FROM Watches WHERE quantity>=?";
        PreparedStatement ps = null;
        List<Watch> list = new ArrayList();
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, 40);
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand b = this.getBrandById(rs.getInt("brand_id"));
                Watch watch = new Watch(rs.getInt("watch_id"), rs.getString("product_name"),
                        rs.getDouble("price"), b, rs.getInt("movement_id"),
                        rs.getInt("strap_id"), rs.getString("image_url"), rs.getString("description"),
                        rs.getInt("quantity"), rs.getString("new_product"), rs.getString("gender"),
                        rs.getString("username"));
                list.add(watch);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }

    //NEW PRODUCT
    // lấy ra tất cả sản phẩm mới nhất
    public List<Watch> getAllNewWatch() throws SQLException {
        String sql = "SELECT * FROM Watches WHERE new_product IS NOT NULL AND 1=1";
        PreparedStatement ps = null;
        List<Watch> list = new ArrayList();
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand b = this.getBrandById(rs.getInt("brand_id"));
               Watch watch = new Watch(rs.getInt("watch_id"), rs.getString("product_name"),
                        rs.getDouble("price"), b, rs.getInt("movement_id"),
                        rs.getInt("strap_id"), rs.getString("image_url"), rs.getString("description"),
                        rs.getInt("quantity"), rs.getString("new_product"), rs.getString("gender"),
                        rs.getString("username"));
                list.add(watch);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }

    // lấy tất cả sản phẩm
    public List<Watch> getAllWatch() throws SQLException {
        String sql = "SELECT * FROM Watches";
        PreparedStatement ps = null;
        List<Watch> list = new ArrayList();
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand b = this.getBrandById(rs.getInt("brand_id"));
               Watch watch = new Watch(rs.getInt("watch_id"), rs.getString("product_name"),
                        rs.getDouble("price"), b, rs.getInt("movement_id"),
                        rs.getInt("strap_id"), rs.getString("image_url"), rs.getString("description"),
                        rs.getInt("quantity"), rs.getString("new_product"), rs.getString("gender"),
                        rs.getString("username"));
                list.add(watch);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }

    // Tìm kiếm theo search
    public List<Watch> getBySearch(String search,boolean isAdmin, String user) throws SQLException {
        String sql = "SELECT * FROM Watches WHERE 1=1";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Watch> list = new ArrayList();
        try {
            int index = 1;
            if (search.equals("") == false && search != null) {
                sql += " AND (product_name LIKE ? OR description LIKE ?)";
            }
             if(isAdmin) sql += " AND username=?";
            ps = connection.prepareStatement(sql);
            if (search.equals("") == false && search != null) {
                ps.setString(index++, "%" + search + "%");
                ps.setString(index++, "%" + search + "%");
            }
            if(isAdmin) ps.setString(index++, user);    
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand b = this.getBrandById(rs.getInt("brand_id"));
               Watch watch = new Watch(rs.getInt("watch_id"), rs.getString("product_name"),
                        rs.getDouble("price"), b, rs.getInt("movement_id"),
                        rs.getInt("strap_id"), rs.getString("image_url"), rs.getString("description"),
                        rs.getInt("quantity"), rs.getString("new_product"), rs.getString("gender"),
                        rs.getString("username"));
                list.add(watch);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }

    // Tìm kiếm theo giá, dây, máy
    public List<Watch> getByFilter(double priceFrom, double priceTo, String strap, String movement,boolean isAdmin,String user) throws SQLException {
        String sql = "select * from Watches w \n" +
"	JOIN StrapMaterials s ON s.strap_id = w.strap_id\n" +
"	JOIN MovementTypes m ON m.movement_id = w.movement_id\n" +
"	WHERE 1=1 ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Watch> list = new ArrayList();
        try {
            // ô nhập ko trả về null nhưng lần vô đầu load web có thể null
            if (strap != null && !strap.isEmpty()) {
                sql += " AND strap_name LIKE ? ";
            }
            if (movement != null && !movement.isEmpty()) {
                sql += " AND movement_name LIKE ? "; // Sửa tên cột cho đúng
            }
            if (priceFrom < priceTo) {
                sql += " AND (price >= ? AND price <= ?)";
            }
            if(isAdmin) sql += " AND username =?";

            // tạo ps
            ps = connection.prepareStatement(sql);
            int index = 1;
            if (strap != null && !strap.isEmpty()) {
                ps.setString(index++, "%" + strap + "%");
            }
            if (movement != null && !movement.isEmpty()) {
                ps.setString(index++, "%" + movement + "%");
            }
            if (priceFrom < priceTo) {
                ps.setDouble(index++, priceFrom);
                ps.setDouble(index++, priceTo);
            }
            if(isAdmin) ps.setString(index++, user);
            // thực thi
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand b = this.getBrandById(rs.getInt("brand_id"));
               Watch watch = new Watch(rs.getInt("watch_id"), rs.getString("product_name"),
                        rs.getDouble("price"), b, rs.getInt("movement_id"),
                        rs.getInt("strap_id"), rs.getString("image_url"), rs.getString("description"),
                        rs.getInt("quantity"), rs.getString("new_product"), rs.getString("gender"),
                        rs.getString("username"));
                list.add(watch);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }
    
    // lấy tất cả sản phẩm bằng user name
    public List<Watch> getProductAdmin(String user) throws SQLException {
        String sql = "SELECT * FROM Watches WHERE username = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Watch> list = new ArrayList();
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while(rs.next()) {
                 Brand b = this.getBrandById(rs.getInt("brand_id"));
               Watch watch = new Watch(rs.getInt("watch_id"), rs.getString("product_name"),
                        rs.getDouble("price"), b, rs.getInt("movement_id"),
                        rs.getInt("strap_id"), rs.getString("image_url"), rs.getString("description"),
                        rs.getInt("quantity"), rs.getString("new_product"), rs.getString("gender"),
                        rs.getString("username"));
                list.add(watch);
            }
        } catch (Exception e) {
        } finally {
            if(ps != null) ps.close();
            if(rs != null) rs.close();
        }
        return list;
    }
    
    // XÓA SẢN PHẨM
    public void deleteProductByAdmin(String product_name, String username) throws SQLException {
        String sql = "DELETE FROM Watches WHERE product_name=? AND username=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            int index = 1;
            ps = connection.prepareStatement(sql);
            if(username != null && product_name != null) {
                ps.setString(index++, product_name);
                ps.setString(index++, username);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if(ps!= null) ps.close();
            if(rs!=null) rs.close();
        }
    }
}
