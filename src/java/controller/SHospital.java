
package controller;

import dao.HospitalDao;
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
import model.Hospital;


public class SHospital extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HospitalDao HD=new HospitalDao();
        List<Hospital> HC;
        String name,city;
        name=request.getParameter("hospitalname");
        city=request.getParameter("hospitalcity");
        if(name==null|name=="")
            HC=HD.searchHospitalByCity(city);
        else
            HC=HD.searchHospital(city, name);
        Iterator<Hospital> i=HC.iterator();
        if(i.hasNext())
        {
            out.println("<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <title>HOSPITAL SEARCHED | MEDHUB</title>\n" +
                        "    <link rel='stylesheet' href='./css/sdhb.css'>\n" +
                        "</head>\n" +
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
                        "    <p><font size='+3'>HOSPITALS IN "+city.toUpperCase()+"</font></p>"+
                        "    <div class='content-box'>\n" +
                        "        <h1>\n" +
                        "            HOSPITAL SEARCHED\n" +
                        "        </h1>\n" +
                        "    </div>\n");
            
            int a=1;
            for(Hospital H:HC)
            {
                //To print card in a container only 3 card in a container
                if(a==1)
                {
                    out.println("<div class='container'>");
                }
                
                
                //To print cards
                out.println("<div class='card'>\n" +
                            "            <div class='img'>\n" +
                            "                <img src='./images/hospital/"+H.getUid()+".jpg'>\n" +
                            "            </div>\n" +
                            "            <div class='top-text'>\n" +
                            "                <div class='name'>\n" +
                            "                    "+H.getName()+"</div>\n" +
                            "                <p>\n" +
                            "                    "+H.getAddress()+"</p>\n" +
                            "            </div>\n" +
                            "            <div class='bottom-text'>\n" +
                            "                <div class='btn1'>\n" +
                            "                    <a href='mailto:"+H.getContact()+"'>CONTACT</a>\n" +
                            "                </div>\n" +
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
                        "    <title>HOSPITAL SEARCHED | MEDHUB</title>\n" +
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
                        "                <div class='btn1'>\n" +
                        "                    <a >CONTACT</a>\n" +
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
                        "                <div class='btn1'>\n" +
                        "                    <a >CONTACT</a>\n" +
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
                        "                <div class='btn1'>\n" +
                        "                    <a >CONTACT</a>\n" +
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
