
package ExciteWorld.main.servlet;

import ExciteWorld.main.bean.UserAccount;
import ExciteWorld.main.util.DBUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailAddr = request.getParameter("email");
        String firstName = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        
        UserAccount user = new UserAccount();
        user.setEmail(emailAddr);
        user.setFirstname(firstName);
        user.setLastname(lastname);
        user.setUsername(userName);
        user.setPassword(passWord);
        
        String url = "";
        String message = "";
        
        if (DBUtil.emailExists(user.getEmail())){
            message = "This email address already exists, please enter another one";
            url = "/newAccount.jsp";
        }
        else{
            DBUtil.insert(user);
            url = "/UserInfo.jsp";
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("username", userName);
        request.setAttribute("message", message);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
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
