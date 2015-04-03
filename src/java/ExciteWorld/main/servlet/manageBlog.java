
package ExciteWorld.main.servlet;

import ExciteWorld.main.bean.BlogInfo;
import ExciteWorld.main.bean.UserAccount;
import static ExciteWorld.main.servlet.DisplayUser.password;
import static ExciteWorld.main.servlet.DisplayUser.url;
import static ExciteWorld.main.servlet.DisplayUser.username;
import java.io.IOException;
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
import javax.servlet.http.HttpSession;

public class manageBlog extends HttpServlet {
    
    public static final String url = "jdbc:mysql://localhost:3306/ExciteWorld";
    public static final String username = "root";
    public static final String password = "19891016wk";
    private static List<BlogInfo> blogs = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query, email = "";
        HttpSession session = request.getSession();
        ResultSet rs = null;
        blogs = new ArrayList<BlogInfo>();
        BlogInfo bi = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(url, username, password);
            Statement myStmt = myConn.createStatement();
            query = "SELECT email FROM User WHERE username = '" + session.getAttribute("username") + "'";
            rs = myStmt.executeQuery(query);
            while (rs.next()){
                email = rs.getString("email");
            }
            query = "SELECT * FROM Blog WHERE user_email = '" + email + "'";
            rs =  myStmt.executeQuery(query);
            while (rs.next()){
                bi = new BlogInfo();
                bi.setAuthor_email(rs.getString("user_email"));
                bi.setBlog_content(rs.getString("blog_content"));
                bi.setBlog_id(rs.getInt("blog_id"));
                bi.setBlog_title(rs.getString("blog_title"));
                blogs.add(bi);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.setAttribute("BlogInfo", blogs);
            RequestDispatcher rd = request.getRequestDispatcher("/manageBlog.jsp");
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
