
package controller;

import dao.BloodbankDao;
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
import model.Bloodbank;
import service.ImageHandler;

public class UBform extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException 
    {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Request Status...</title></head>");
        Bloodbank B;
        String name,contact,address,city,imagepath,url,uid;
        
        name=request.getParameter("bname").toUpperCase();
        contact=request.getParameter("bemail");
        address=request.getParameter("baddress").toUpperCase();
        city=request.getParameter("bcity");
        url=request.getParameter("bimage");
        uid=UUID.randomUUID().toString();
        while(BloodbankDao.checkUUID(uid))
        {
            uid=UUID.randomUUID().toString();
        }
        imagepath="C:/Users/kanik/Documents/NetBeansProjects/Medhub/web/images"+"/bloodbank/"+uid+".jpg";
        if(name.equals("")|contact.equals("")|address.equals("")|url.equals("")){
            out.println("Incomplete Data : Please Fullfil the data");
        }
        else{
                B=new Bloodbank(name, contact, address, city, imagepath,uid);
                BloodbankDao BD=new BloodbankDao();
                if(BD.checkDatabase(name, address,contact))
                    out.println("Record Already Exist...");
                else
                {
                    if(ImageHandler.setImage(url, imagepath)){
                        BD.insertDetails(B);
                        out.println("Data inserted successfully...");
                    }
                    else
                    out.println("URL is incorrect : Image not found");
                }
        }
        
        out.println("</html>");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            try {
                PrintWriter out = response.getWriter();
                out.println("error.hmtl");
            } catch (IOException ex1) {
                Logger.getLogger(UBform.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        out.println("This is do post method...");
    }


}
