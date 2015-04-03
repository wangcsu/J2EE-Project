
package ExciteWorld.main.servlet;

import ExciteWorld.main.bean.UserAccount;
import static ExciteWorld.main.servlet.DeleteBlog.DBpassword;
import static ExciteWorld.main.servlet.DeleteBlog.DBurl;
import static ExciteWorld.main.servlet.DeleteBlog.DBusername;
import java.io.IOException;
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

public class UpdateUserInfo extends HttpServlet {
    
    public static final String DBurl = "jdbc:mysql://localhost:3306/ExciteWorld";
    public static final String DBusername = "root";
    public static final String DBpassword = "19891016wk";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query,email = "", url=" ", password = " ";
        HttpSession session = request.getSession();
        UserAccount user = new UserAccount();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            Statement myStmt = myConn.createStatement();
            ResultSet rs = null;
            query = "SELECT email, password FROM User WHERE username = '" + session.getAttribute("username") + "'";
            rs = myStmt.executeQuery(query);
            while (rs.next()){
                email = rs.getString("email");
                password = rs.getString("password");
            }
            user.setEmail(email);
            user.setFirstname(request.getParameter("firstname"));
            user.setLastname(request.getParameter("lastname"));
            user.setUsername(request.getParameter("username"));
            user.setPassword(password);
            query = "UPDATE User SET " + 
                    "firstname = ?, " + 
                    "lastname = ?, " + 
                    "username = ? " + 
                    "WHERE email = ?";
            PreparedStatement ps = myConn.prepareStatement(query);
            ps.setString(1, request.getParameter("firstname"));
            ps.setString(2, request.getParameter("lastname"));
            ps.setString(3, request.getParameter("username"));
            ps.setString(4, email);
            ps.executeUpdate();
            session.setAttribute("user", user);
            session.setAttribute("username", request.getParameter("username"));
            url = "/UserInfo.jsp";
        }catch(Exception e){
            e.printStackTrace();
            url = "/editInfo.jsp";
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
