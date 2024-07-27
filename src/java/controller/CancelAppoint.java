

package controller;

import dao.UserAppDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CancelAppoint extends HttpServlet {

    
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("<html><head><title>Cancelling Process...</title></head>");
        String apid=request.getParameter("apid");
        UserAppDao UD=new UserAppDao();
        if(UD.deleteAppByApid(apid))
        {
            response.sendRedirect("./dsearch.jsp?response=y");
        }
        else
        {
            response.sendRedirect("./dsearch.jsp?response=n");
        }
        out.println("</html>");
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        
        try 
        {
            processRequest(request, response);
        } 
        catch (IOException|ServletException|SQLException|InterruptedException ex) 
        {
            try {
                PrintWriter out=response.getWriter();
                out.println(ex);
                ex.printStackTrace();
            } catch (IOException ex1) {
                Logger.getLogger(SBloodbank.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out;
        try 
        {
            out = response.getWriter();
            out.println("This is doPost method of Doctor Details");
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }


}
