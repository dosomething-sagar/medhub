<%-- 
    Document   : dsearch
    Created on : May 25, 2023, 10:35:29 AM
    Author     : HP
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='en'>

<head>
    <meta charset='UTF-8'>
    <title>Search Doctor | MedHub</title>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css'>
    <link rel='stylesheet' href='./css/dsearch.css'>

</head>
<header class='site-header'>
    <nav>
        <a href='./index.html'><strong>MEDHUB</strong></a>
        <a href='./index.html'>HOME</a>
        <a href='./hbsearch.html'>HOSPITAL/BLOODBANK</a>
       
        <a href='./dsearch.jsp'>DOCTOR</a>
        <a href='./about.html'>ABOUT US</a>
    </nav>
</header>
<div class='container'>
    <div class='left-half'>
        <%
            if(request.getParameterNames().hasMoreElements())
            {
                String res=request.getParameter("response");
                if(res.equals("y"))
                    out.println("<center><font size='+2' color='lightgreen'>Your Appointment Has Been Canceled</font></center>");
                else
                    if(res.equals("n"))
                        out.println("<center><font size='+2' color='red'>We Are Unable To Cancel Your Appointment</font></center>");
            }
             
        %>
        <img src='./images/dsearch.jpg' alt='docsearch'>
    </div>
    <div class='right-half'>
        <form action='doctor-searched' method='get' enctype='multipart/form-data'>
            <fieldset>
                <legend>DOCTOR<img src='./images/doctoricon.png'></legend>
                <div class='double-input'>
                    <div class='form-input-container'>
                        <label for='doctorcategeroy'>Category</label>
                        <select id='doctorcategory' name='doctorcategory'>
                               <option value='Cardiologist'>Cardiologist </option>
                               <option value='Pediatrician'>Pediatrician</option>
                               <option value='Gynecologist'> Gynecologist </option>
                               <option value='General Medicine'>General Medicine</option>
                        </select>
                        <label for='doctorcity'>City</label>
                        <select id='doctorcity' name='doctorcity'>
                            <option value='Indore'>Indore</option>
                            <option value='Ahmedabad'>Ahmedabad</option>
                            <option value='Hyderabad'>Hyderabad</option>
                        </select>
                    </div>
                </div>
            </fieldset>
            <button type='submit'>SEARCH</button>
        </form>
    </div>
</div>
<footer>
    <p>Copyright &#169; MedHub. All Rights Reserved.</p>
</footer>

</html>