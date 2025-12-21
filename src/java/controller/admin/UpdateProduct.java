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

/**
 *
 * @author DELL P5530
 */
@WebServlet(name="UpdateProduct", urlPatterns={"/updateproduct"})
public class UpdateProduct extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet UpdateProduct</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProduct at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       // get all param ffrom admin_product
       String id_raw = request.getParameter("watch_id");
       String p_name = request.getParameter("product_name");
       String price_raw = request.getParameter("price");
//       String brand  = request.getParameter("brand");
       String images = request.getParameter("image_url");
       String quantity_raw = request.getParameter("quantity");
       String new_pro = request.getParameter("new_product");
       String new_product = new_pro == null || new_pro.equals("") ? null : new_pro;
       String gender = request.getParameter("gender");
       String old_price_raw = request.getParameter("old_price");
       // try giá trị ra
       DAO_Product dao = new DAO_Product();
        try {
            int id = Integer.parseInt(id_raw);
            double oldPrice = Double.parseDouble(old_price_raw);
            double price = price_raw != null ? Double.parseDouble(price_raw) : oldPrice;
            int quantity = quantity_raw != null ? Integer.parseInt(quantity_raw) : 0;
            // gọi dao xử lí
            dao.updateProductByAdmin(id,p_name,price,images,quantity,new_product,gender);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            String url = request.getHeader("referer");
           response.sendRedirect(url);
       }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
