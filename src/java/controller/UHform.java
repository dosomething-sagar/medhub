
package controller;

import dao.HospitalDao;
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
import model.Hospital;
import service.ImageHandler;

public class UHform extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException 
    {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Request Status...</title></head>");
        Hospital H;
        String name,contact,address,city,imagepath,url,uid;
        
        name=request.getParameter("hname").toUpperCase();
        contact=request.getParameter("hemail");
        address=request.getParameter("haddress").toUpperCase();
        city=request.getParameter("hcity");
        url=request.getParameter("himage");
        uid=UUID.randomUUID().toString();
        while(HospitalDao.checkUUID(uid))
        {
            uid=UUID.randomUUID().toString();
        }
        imagepath="C:/Users/kanik/Documents/NetBeansProjects/Medhub/web/images"+"/hospital/"+uid+".jpg";
        if(name.equals("")|contact.equals("")|address.equals("")|url.equals("")){
            out.println("Incomplete Data : Please Fullfil the data");
        }
        else{
                H=new Hospital(name, contact, address, city, imagepath,uid);
                HospitalDao HD=new HospitalDao();
                if(HD.checkDatabase(name,contact,address))
                    out.println("Record Already Exist...");
                else
                {
                    if(ImageHandler.setImage(url, imagepath)){
                        HD.insertDetails(H);
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

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        out.println("This is do post method...");
    }


}
