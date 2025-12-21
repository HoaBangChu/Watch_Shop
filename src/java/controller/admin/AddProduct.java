/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.DAO_Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Brand;
import model.MovementTypes;
import model.StrapMaterials;
import model.User;

/**
 *
 * @author DELL P5530
 */
@WebServlet(name = "AddProduct", urlPatterns = {"/addProduct"})
public class AddProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lấy ra toàn bộ 3 danh sách đưa lên requestScope để duyệt
        DAO_Product dao = new DAO_Product();
        try {
            List<Brand> brand = dao.getAllBrand();
            List<MovementTypes> movement = dao.getAllMovementTypes();
            List<StrapMaterials> strap = dao.getAllStrapMaterials();
            //
            request.setAttribute("brand_list", brand);
            request.setAttribute("movement_list", movement);
            request.setAttribute("strap_list", strap);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            request.getRequestDispatcher("/Admin_Shop/addProductAdmin.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lấy ra các thuộc tính cấu thành 1 cái watch
        String name = request.getParameter("product_name");
        String brand_raw = request.getParameter("brand");
        String price_raw = request.getParameter("price");
        String movement_raw = request.getParameter("movement");
        String strap_raw = request.getParameter("strap");
        String images = request.getParameter("images");
        String description = request.getParameter("description");
        String quantity_raw = request.getParameter("quantity");
        String new_product = request.getParameter("new_product");
        String gender = request.getParameter("gender");
        // truyền qua dao insert
        DAO_Product dao = new DAO_Product();
        // lấy user name trên session
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("account");
        String username = null;
        if(user != null) {
             username = user.getUsername();
        }
        String refer = request.getHeader("referer");
        try {
            double price = Double.parseDouble(price_raw);
            int brand = Integer.parseInt(brand_raw);
            int movement = Integer.parseInt(movement_raw);
            int strap = Integer.parseInt(strap_raw);
            int quantity = Integer.parseInt(quantity_raw);
            //
            dao.insertAProductByAdmin(name, brand, price, movement, strap, images, description, quantity, new_product, gender, username);
            session.setAttribute("add_sucess", "Thêm thành công sản phẩm mới!");
        } catch (Exception e) {
            session.setAttribute("add_error", "Chưa thêm thành công sản phẩm mới!");
            System.out.println(e);
        } finally {
            response.sendRedirect(refer);
        }    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
