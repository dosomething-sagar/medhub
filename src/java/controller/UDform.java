
package controller;

import dao.DoctorDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Doctor;
import service.ImageHandler;

public class UDform extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("<html><head><title>Request Status...</title></head>");
        Doctor D;
        String name,contact,address,city,category,imagepath,uid,url;
        
        name=request.getParameter("dname").toUpperCase();
        contact=request.getParameter("demail");
        address=request.getParameter("daddress").toUpperCase();
        city=request.getParameter("dcity").toUpperCase();
        category=request.getParameter("dcategory").toUpperCase();
        uid=UUID.randomUUID().toString();
        while(DoctorDao.checkUUID(uid))
        {
            uid=UUID.randomUUID().toString();
        }
        url=request.getParameter("dimage");
        imagepath="C:/Users/kanik/Documents/NetBeansProjects/Medhub/web/images"+"/doctor/"+uid+".jpg";
        if(name.equals("")|contact.equals("")|address.equals("")|url.equals("")){
            out.println("Incomplete Data : Please Fullfil the data");
        }
        else{
                D=new Doctor(name, contact, category, address, city, imagepath,uid);
                DoctorDao DD=new DoctorDao();
                if(DD.checkDatabase(name, contact))
                    out.println("Record Already Exist...");
                else
                {
                    if(ImageHandler.setImage(url, imagepath)){
                        DD.insertDetails(D);
                        out.println("Data inserted successfully...");
                    }
                    else
                    out.println("URL is incorrect : Image not found");
                }
        }
        
        out.println("</html>");
        
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
    {
        
        PrintWriter out;
        try 
        {
            out = response.getWriter();
            out.println("This is doGet method of Doctor Details");
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
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
             {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            PrintWriter out=null;
            try {
                out = response.getWriter();
                out.println("error.hmtl");
            } catch (IOException ex1) {
                Logger.getLogger(UBform.class.getName()).log(Level.SEVERE, null, ex1);
            } finally {
                out.close();
            }
        } 
    }


}
