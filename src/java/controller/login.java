/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO_Login;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.UUID;
import model.User;

/**
 *
 * @author DELL P5530
 */
@WebServlet(name="login", urlPatterns={"/login"})
public class login extends HttpServlet {
   
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
            out.println("<title>Servlet login</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath () + "</h1>");
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
        String refer = request.getHeader("referer");
        if(refer != null && !refer.contains("/login") &&!refer.contains("/register") ){
        request.getSession().setAttribute("refer", refer);
        }
         
        request.getRequestDispatcher("/Login/login.jsp").forward(request, response);
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
        
       // lấy tham số tk mk
       String user = request.getParameter("user");
       String password = request.getParameter("password");
       // tạo dao login
       DAO_Login daoLogin = new DAO_Login();
       // tạo session
       HttpSession session = request.getSession();
       // lấy xong rồi thì kiểm tra xem nó có trong csdl chưa
       User u = daoLogin.checkLogin(user, password,1);
       if(u == null) {
           request.setAttribute("err_login","Tài khoản mật khẩu không chính xác!");
           request.getRequestDispatcher("/Login/login.jsp").forward(request, response);     
       }
           session.setAttribute("account", u);
           String refer = (String)request.getSession().getAttribute("refer");
           //nếu tài khoản đã đăng nhập xem có tích vào remember không nếu có thì tạo cookies
           this.rememberMe(request, user, response);
        if(refer != null) {
            response.sendRedirect(refer);
            return;
        }else{
            response.sendRedirect(request.getContextPath() + "/home");
       }
    }

    // tạo hàm tạm để tạo cookies, tạo token mới mỗi lần tích
    private void rememberMe(HttpServletRequest request, String user, HttpServletResponse response) {
        DAO_Login daoLogin = new DAO_Login();
        String remember = request.getParameter("remember");
        String token = UUID.randomUUID().toString();
       Cookie cUser = new Cookie("cUser",user);
       Cookie cToken = new Cookie("cToken",token);
       cUser.setHttpOnly(true);
       cToken.setHttpOnly(true);
       if(remember != null) {
           cUser.setMaxAge(60*60);
           cToken.setMaxAge(60*60);
           daoLogin.updateToken(user, token,"[User]");
       }else{
           cUser.setMaxAge(0); // nếu logout và quay lại trang login mà ấn không remember thì không có cookies
           cToken.setMaxAge(0);
       }
       response.addCookie(cUser);
       response.addCookie(cToken);
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

 