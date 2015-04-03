
package ExciteWorld.main.servlet;

import ExciteWorld.main.bean.UserAccount;
import static ExciteWorld.main.util.DBUtil.password;
import static ExciteWorld.main.util.DBUtil.url;
import static ExciteWorld.main.util.DBUtil.username;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayUser extends HttpServlet {
    
    public static final String url = "jdbc:mysql://localhost:3306/ExciteWorld";
    public static final String username = "root";
    public static final String password = "19891016wk";
    private static List<UserAccount> users = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ResultSet rs = null;
        users = new ArrayList<UserAccount>();
        UserAccount ua = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(url, username, password);
            Statement myStmt = myConn.createStatement();
            String query = "SELECT * FROM User";
            rs =  myStmt.executeQuery(query);
            while (rs.next()){
                ua = new UserAccount();
                ua.setEmail(rs.getString("email"));
                ua.setFirstname(rs.getString("firstname"));
                ua.setLastname(rs.getString("lastname"));
                ua.setUsername(rs.getString("username"));
                users.add(ua);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            request.setAttribute("UsersData", users);
            RequestDispatcher rd = request.getRequestDispatcher("/displayUsers.jsp");
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
