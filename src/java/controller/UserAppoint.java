
package controller;

import dao.DoctorDao;
import dao.UserAppDao;
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
import javax.servlet.http.HttpSession;
import model.Doctor;
import model.UserAppointment;


public class UserAppoint extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        UserAppointment U=new UserAppointment();
        String duid=session.getAttribute("duid").toString();
        Doctor D= DoctorDao.getDoctorByUid(duid);
        U.setName(request.getParameter("username"));
        U.setEmail(request.getParameter("useremail"));
        U.setContact(request.getParameter("usernum"));
        U.setApdescript(request.getParameter("appointmentdescription"));
        U.setApdate(request.getParameter("userdate"));
        U.setTime(request.getParameter("usertime"));
        String apid=UUID.randomUUID().toString();
        while(UserAppDao.checkAPID(apid))
        {
            apid=UUID.randomUUID().toString();
        }
        U.setApid(apid);
        U.setDname(D.getName());
        U.setDcontact(D.getContact());
        if(U.getContact()==null|U.getContact()=="")
            out.println("Enter Contact Number.....");
        else
        {
            if(U.getTime()==null|U.getTime()=="")
                out.println("Select Time.....");
            else
            {
                UserAppDao UD=new UserAppDao();
                if(UD.acceptAppointment(U))
                {
                    
                    out.println("<!DOCTYPE html>\n" +
                                "<html lang='en'>\n" +
                                "\n" +
                                "<head>\n" +
                                "    <meta charset='UTF-8'>\n" +
                                "    <title>Appointment | MedHub</title>\n" +
                                "    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css'>\n" +
                                "    <link rel='stylesheet' href='./css/dsearch.css'>\n" +
                                "\n" +
                                "</head>\n" +
                                "<header class='site-header'>\n" +
                                "    <nav>\n" +
                                "        <a href='./index.html'><strong>MEDHUB</strong></a>\n" +
                                "        <a href='./index.html'>HOME</a>\n" +
                                "        <a href='./hbsearch.html'>HOSPITAL/BLOODBANK</a>\n" +
                                
                                "        <a href='./dsearch.jsp'>DOCTOR</a>\n" +
                                "        <a href='./about.html'>ABOUT US</a>\n" +
                                "    </nav>\n" +
                                "</header>\n" +
                                "<div class='container'>\n" +
                                "    <div class='left-half'>\n" +
                                "        <img src='./images/doctor/"+D.getUid()+".jpg' alt='docsearch'>\n" +
                                "    </div>\n" +
                                "    <div class='right-half'>\n" +
                                "        <form action='search-doctor' method='get' enctype='multipart/form-data'>\n" +
                                "            <fieldset>\n" +
                                "                <legend>YOUR APPOINTMENT</legend>\n" +
                                "                <div class='double-input'>\n" +
                                "                    <div class='form-input-container'>\n" +
                                "                        <input type='hidden' name='apid' value='"+U.getApid()+"'>"+
                                "                        <label for='doctorcategeroy'><center><font size=+1>Name : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+U.getName()+"</font></center></label>\n" +
                                "                        <label for='doctorcategeroy'><center><font size=+1>Contact : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+U.getContact()+"</font></center></label>\n" +
                                "                        <label for='doctorcategeroy'><center><font size=+1>Date : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+U.getApdate()+"</font></center></label>\n" +
                                "                        <label for='doctorcategeroy'><center><font size=+1>Time : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+U.getTime()+"</font></center></label>\n" +
                                "                        <label for='doctorcategeroy'><center><font size=+1>Doctor Name : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+U.getDname()+"</font></center></label>\n" +
                                "                    </div>\n" +
                                "                </div>\n" +
                                "            </fieldset>\n" +
                                "            <button type='submit'>Cancel Appointment</button>\n" +
                                "        </form>\n" +
                                "    </div>\n" +
                                "</div>\n" +
                                "<footer>\n" +
                                "    <p>Copyright &#169; MedHub. All Rights Reserved.</p>\n" +
                                "</footer>\n" +
                                "\n" +
                                "</html>");
                    
                }
                
                
                else
                {
                    
                    
                    out.println("<!DOCTYPE html>\n" +
                                "<html lang='en'>\n" +
                                "\n" +
                                "<head>\n" +
                                "    <meta charset='UTF-8'>\n" +
                                "    <title>DOCTOR - Appointment Request form | MEDHUB</title>\n" +
                                "    <link rel='stylesheet' href='./css/dapp.css'>\n" +
                                "\n" +
                                "</head>\n" +
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
                                "    <div id='container'>\n" +
                                "        <div id='body_header'>\n" +
                                "            <h1>Appointment Request Form</h1>\n" +
                                "            <p><font size=+3 color='white'>SORRY AT THIS DATE AND TIME ANOTHER PATIENT HAS AN APPOINTMENT</font></p>"+
                                "        </div>\n" +
                                "        <form action='appointment-status' method='get' enctype=\"multipart/form-data\">\n" +
                                "            <br>\n" +
                                "            <fieldset>\n" +
                                "                <br>\n" +
                                "                <legend><span class='number'>1</span>Your basic details</legend>\n" +
                                "                <label for='username'>Name*:</label>\n" +
                                "                <input type='text' id='uname' name='username' placeholder='Aayug' required pattern='[a-zA-Z0-9]+'>\n" +
                                "\n" +
                                "                <label for='email'>Email*:</label>\n" +
                                "                <input type='email' id='umail' name='useremail' placeholder='abc@xyz.com' required>\n" +
                                "\n" +
                                "                <label for='tel'>Contact Number*:</label>\n" +
                                "                <input type='tel' id='utel' placeholder='+91-Enter Your Number' name='usernum'>\n" +
                                "\n" +
                                "            </fieldset>\n" +
                                "\n" +
                                "            <fieldset>\n" +
                                "                <div>\n" +
                                "                    <legend><span class='number'>2</span>Appointment Details</legend>\n" +
                                "                    <br>\n" +
                                "                    <label for='appointment_description'>Appointment Description:</label>\n" +
                                "                    <input type='text' id='uappointment_description' name='appointmentdescription' placeholder='What the problem'></input>\n" +
                                "                    <label for='date'>Date*:</label>\n" +
                                "                    <input type='date' name='userdate' value='' required></input>\n" +
                                "                    <br>\n" +
                                "                    <label for='time'>Time*:</label>\n" +
                                "                    AM : <input type='radio' id='time' name='usertime' value='09:00 AM'/>09:00 <input type='radio' id='time' name='usertime' value='09:30 AM'/> 09:30    <input type='radio' id='time' name='usertime' value='10:00 AM'/>10:00  <input type='radio' id='time' name='usetime' value='10:30 AM'/>10:30  <input type='radio' id='time' name='usertime' value='11:00 AM'/>11:00   <input type='radio' id='time' name='usertime' value='11:30 AM'/>11:30<br/><br>   \n" +
                                "                    PM : <input type='radio' id='time' name='usertime' value='12:00 PM'/>12:00 <input type='radio' id='time' name='usertime' value='12:30 PM'/> 12:30    <input type='radio' id='time' name='usertime' value='01:00 PM'/>01:00  <input type='radio' id='time' name='usertime' value='01:30 PM'/>01:30  <input type='radio' id='time' name='usertime' value='02:00 PM'/>02:00   <input type='radio' id='time' name='usertime' value='02:30 PM'/>02:30  <input type='radio' id='time' name='usertime' value='03:00 PM'/>03:00 <br> <br> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='radio' id='time' name='usertime' value='03:30 '/>03:30<br>      \n" +
                                "                </div>\n" +
                                "            </fieldset>\n" +
                                "            <button type='submit'>Request For Appointment</button>\n" +
                                "        </form>\n" +
                                "    </div>\n" +
                                "\n" +
                                "    <footer>\n" +
                                "        <p>Copyright &#169; MedHub. All Rights Reserved.</p>\n" +
                                "        <div class='socicons'>\n" +
                                "            <a href='https://www.instagram.com/'><img src='./images/instagram.png' alt='insta'></a>\n" +
                                "            <a href='https://www.facebook.com/'><img src='./images/facebook.png' alt='facebook'></a>\n" +
                                "            <a href='https://twitter.com/login'><img src='./images/twitter.png' alt='twitter'></a>\n" +
                                "        </div>\n" +
                                "    </footer>\n" +
                                "</body>\n" +
                                "\n" +
                                "</html>");
                    
                }
                
            }
        }
        
        session.invalidate();
                
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
