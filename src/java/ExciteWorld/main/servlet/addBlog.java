
package ExciteWorld.main.servlet;

import static ExciteWorld.main.servlet.LoginServlet.DBpassword;
import static ExciteWorld.main.servlet.LoginServlet.DBurl;
import static ExciteWorld.main.servlet.LoginServlet.DBusername;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class addBlog extends HttpServlet {
    
    public static final String DBurl = "jdbc:mysql://localhost:3306/ExciteWorld";
    public static final String DBusername = "root";
    public static final String DBpassword = "19891016wk";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query, email = " ", url=" ";
        HttpSession session = request.getSession();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            Statement myStmt = myConn.createStatement();
            ResultSet rs = null;
            query = "SELECT email FROM User WHERE username = '" + session.getAttribute("username") + "'";
            rs = myStmt.executeQuery(query);
            while (rs.next()){
                email = rs.getString("email");
            }
            /*query = "INSERT INTO Blog (user_email, blog_content, blog_title) "
                    + "VALUES ('" + email + "', "
                    + "'" + request.getParameter("blogcontent") + "',"
                    + "'" + request.getParameter("blogtitle") + "')";
            myStmt.executeUpdate(query);*/
            
            query = "INSERT INTO Blog (user_email, blog_content, blog_title) "
                    + "VALUES (?,?,?)";
            PreparedStatement ps = myConn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, request.getParameter("blogcontent"));
            ps.setString(3, request.getParameter("blogtitle"));
            
            ps.executeUpdate();
            url = "/AccountMgmt.jsp";
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
           rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
