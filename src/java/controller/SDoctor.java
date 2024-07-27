
package controller;

import dao.DoctorDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Doctor;


public class SDoctor extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        DoctorDao DD=new DoctorDao();
        List<Doctor> DC;
        String category,city;
        category=request.getParameter("doctorcategory");
        city=request.getParameter("doctorcity");
        DC=DD.searchDoctor(category, city);
        Iterator<Doctor> i=DC.iterator();
        if(i.hasNext())
        {
            out.println("<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <title>DOCTOR SEARCHED | MEDHUB</title>\n" +
                        "    <link rel='stylesheet' href='./css/sdhb.css'>\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body>\n" +
                        "    <header class='site-header'>\n" +
                        "        <nav>\n" +
                        "            <a href='./index.html'><strong>MEDHUB</strong></a>\n" +
                        "            <a href='./index.html'>HOME</a>\n" +
                        "            <a href='./hbsearch.html'>HOSPITAL/BLOODBANK</a>\n" +
                                
                        "            <a href='./dsearch.jsp'>DOCTOR</a>\n" +
                        "            <a href='./about.html'>ABOUT US</a>\n" +
                        "        </nav>\n" +
                        "    </header>\n" +
                        "    <p><font size='+3'>"+request.getParameter("doctorcategory").toUpperCase()+" IN "+request.getParameter("doctorcity").toUpperCase()+"</font></p>"+
                        "    <div class='content-box'>\n" +
                        "        <h1>\n" +
                        "            DOCTOR SEARCHED\n" +
                        "        </h1>\n" +
                        "    </div>");
            int a=1;
            for(Doctor D:DC)
            {
                //To print card in a container only 3 card in a container
                if(a==1)
                {
                    out.println("<div class='container'>");
                }
                
                
                
                //To print cards
                out.println("<div class='card'>\n" +
                            "            <div class='img'>\n" +
                            "                <img src='./images/doctor/"+D.getUid()+".jpg'>\n" +
                            "            </div>\n" +
                            "            <div class='top-text'>\n" +
                            "                <div class='name'>\n" +
                            "                    "+D.getName()+"</div>\n" +
                            "                <p>\n" +
                            "                    "+D.getCategory()+"</p>\n" +
                            "            </div>\n" +
                            "            <div class='bottom-text'>\n" +
                            "                <div class='text'>\n" +
                            "                     <div class='btn'>\n" +
                            "                    "+D.getAddress()+", "+D.getCity()+" \n" +
                            "                    <center><a href='mailto:"+D.getContact()+"'>Contact</a></center><br>                 \n" +
                            "                    <a href='UserAppointment.jsp?duid="+D.getUid()+"'>Book Appointment</a>\n" +
                            "                </div>\n" +
                            "                    </div>\n" +
                            "            </div>\n" +
                            "        </div>");
                
                
                if(a==3)
                {
                    out.println("</div>\n" +
                            "    <br>\n" +
                            "    <br>\n" +
                            "    <br>");
                    a=0;
                }
                a++;
            }
        }
        
        else
        {
            out.println("<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <title>DOCTOR SEARCHED | MEDHUB</title>\n" +
                        "    <link rel='stylesheet' href='./css/sdhb.css'>\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body>\n" +
                        "    <header class='site-header'>\n" +
                        "        <nav>\n" +
                        "            <a href='./index.html'><strong>MEDHUB</strong></a>\n" +
                        "            <a href='./index.html'>HOME</a>\n" +
                        "            <a href='./hbsearch.html'>HOSPITAL</a>\n" +
                        "            <a href='./hbsearch.html'>BLOODBANK</a>\n" +
                        "            <a href='./dsearch.jsp'>DOCTOR</a>\n" +
                        "            <a href='./about.html'>ABOUT US</a>\n" +
                        "        </nav>\n" +
                        "    </header>\n" +
                        "    <div class='content-box'>\n" +
                        "        <h1>\n" +
                        "             WE ARE UPDATING CURRENTLY....\n" +
                        "        </h1>\n" +
                        "    </div>\n" +
                        "    <br>"+
                        "    <div class='container'>\n" +
                        "        <div class='card'>\n" +
                        "            <div class='img'>\n" +
                        "                <img src='./images/hospital/23.png'>\n" +
                        "            </div>\n" +
                        "            <div class='top-text'>\n" +
                        "                <div class='name'>\n" +
                        "                    Not Available</div>\n" +
                        "                <p>\n" +
                        "                    Not available</p>\n" +
                        "            </div>\n" +
                        "            <div class='bottom-text'>\n" +
                        "                <div class='btn'>\n" +
                        "                    <a >Book Appointment</a>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "        <div class='card'>\n" +
                        "            <div class='img'>\n" +
                        "                <img src='notavailable'>\n" +
                        "            </div>\n" +
                        "            <div class='top-text'>\n" +
                        "                <div class='name'>\n" +
                        "                    Not available</div>\n" +
                        "                <p>\n" +
                        "                    Not available</p>\n" +
                        "            </div>\n" +
                        "            <div class='bottom-text'>\n" +
                        "                <div class='btn'>\n" +
                        "                    <a >Book Appointment</a>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "        <div class='card'>\n" +
                        "            <div class='img'>\n" +
                        "                <img src='notavailable'>\n" +
                        "            </div>\n" +
                        "            <div class='top-text'>\n" +
                        "                <div class='name'>\n" +
                        "                    Not Available</div>\n" +
                        "                <p>\n" +
                        "                    Not Available</p>\n" +
                        "            </div>\n" +
                        "            <div class='bottom-text'>\n" +
                        "                <div class='btn'>\n" +
                        "                    <a >Book Appointment</a>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>\n" +                    
                        "    </div>\n" +
                        "</body>\n" +
                        "</html>");
        }
    }

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        
        try 
        {
            processRequest(request, response);
        } 
        catch (IOException|ServletException|SQLException ex) 
        {
            try {
                PrintWriter out=response.getWriter();
                out.println(ex);
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



