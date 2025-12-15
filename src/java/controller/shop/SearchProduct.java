/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.shop;

import dal.DAO_Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Watch;

/**
 *
 * @author DELL P5530
 */
@WebServlet(name="SearchProduct", urlPatterns={"/search"})
public class SearchProduct extends HttpServlet {
   
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
            out.println("<title>Servlet SearchProduct</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchProduct at " + request.getContextPath () + "</h1>");
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
        // lấy tham số từ trang search
        // kiểm tra xem người dùng nhấn lọc hay nhấn tìm kiếm
        String filter = request.getParameter("btnfilter");
        String search = request.getParameter("btnsearch");
        try {
            DAO_Product dao = new DAO_Product();
            List<Watch> watch_list = null;
            if(filter != null && search == null) { // nhấn lọc thì lấy tham số vứt vô dao tìm 
                String strap = request.getParameter("strap");
                String movement = request.getParameter("movement");
            String priceFrom_raw = request.getParameter("pricefrom");
            String priceTo_raw = request.getParameter("priceto");
            double priceFrom = 0;
            double priceTo = 0;
                try {
                     priceFrom = Double.parseDouble(priceFrom_raw);
                     priceTo = Double.parseDouble(priceTo_raw);
                } catch (Exception e) {
                    request.setAttribute("error_price", "Vui lòng nhập giá tiền là số");
                }
                watch_list = dao.getByFilter(priceFrom, priceTo, strap, movement);
        }else if(filter == null && search != null) { // nhấn tìm kiếm thì lấy tham số thôi
            String search_text = request.getParameter("search");
            watch_list = dao.getBySearch(search_text);
        }    
            request.setAttribute("watch_list", watch_list);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            request.getRequestDispatcher("/Shop/shop.jsp").forward(request, response);
        }
        //
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
