<%-- 
    Document   : UserAppointment
    Created on : May 25, 2023, 10:35:29 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='en'>

<head>
    <meta charset='UTF-8'>
    <title>DOCTOR - Appointment Request form | MEDHUB</title>
    <link rel='stylesheet' href='./css/dapp.css'>

</head>
<%
    String uid= request.getParameter("duid");
    session.setAttribute("duid",uid);
%>
<body>
    <header class='site-header'>
        <nav>
            <a href='./index.html'><strong>MEDHUB</strong></a>
            <a href='./index.html'>HOME</a>
            <a href='./hbsearch.html'>HOSPITAL/BLOODBANK</a>
            
            <a href='./dsearch.jsp'>DOCTOR</a>
            <a href='./about.html'>ABOUT US</a>
        </nav>
    </header>
    <div id='container'>
        <div id='body_header'>
            <h1>Appointment Request Form</h1>
        </div>
        <form action='appointment-status?uid=<%=uid%>' method='get' enctype="multipart/form-data">
            <br>
            <fieldset>
                <br>
                <legend><span class='number'>1</span>Your basic details</legend>
                <label for='username'>Name*:</label>
                <input type='text' id='uname' name='username' placeholder='Aayug' required pattern='[a-zA-Z0-9]+'>

                <label for='email'>Email*:</label>
                <input type='email' id='umail' name='useremail' placeholder='abc@xyz.com' required>

                <label for='tel'>Contact Number*:</label>
                <input type='tel' id='utel' placeholder='+91-Enter Your Number' name='usernum'>

            </fieldset>

            <fieldset>
                <div>
                    <legend><span class='number'>2</span>Appointment Details</legend>
                    <br>
                    <label for='appointment_description'>Appointment Description:</label>
                    <input type='text' id='uappointment_description' name='appointmentdescription' placeholder='What the problem'></input>
                    <label for='date'>Date*:</label>
                    <input type='date' name='userdate' value='' required></input>
                    <br>
                    <label for='time'>Time*:</label>
                    AM : <input type='radio' id='time' name='usertime' value='09:00 AM'/>09:00 <input type='radio' id='time' name='usertime' value='09:30 AM'/> 09:30    <input type='radio' id='time' name='usertime' value='10:00 AM'/>10:00  <input type='radio' id='time' name='usertime' value='10:30 AM'/>10:30  <input type='radio' id='time' name='usertime' value='11:00 AM'/>11:00   <input type='radio' id='time' name='usertime' value='11:30 AM'/>11:30<br/>
                    PM : <input type='radio' id='time' name='usertime' value='12:00 PM'/>12:00 <input type='radio' id='time' name='usertime' value='12:30 PM'/> 12:30    <input type='radio' id='time' name='usertime' value='01:00 PM'/>01:00  <input type='radio' id='time' name='usertime' value='01:30 PM'/>01:30  <input type='radio' id='time' name='usertime' value='02:00 PM'/>02:00   <input type='radio' id='time' name='usertime' value='02:30 PM'/>02:30  <input type='radio' id='time' name='usertime' value='03:00 PM'/>03:00 <input type='radio' id='time' name='usertime' value='03:30 '/>03:30<br>      
                </div>
            </fieldset>
            <button type='submit'>Request For Appointment</button>
        </form>
    </div>

    <footer>
        <p>Copyright &#169; MedHub. All Rights Reserved.</p>
        <div class='socicons'>
            <a href='https://www.instagram.com/'><img src='./images/instagram.png' alt='insta'></a>
            <a href='https://www.facebook.com/'><img src='./images/facebook.png' alt='facebook'></a>
            <a href='https://twitter.com/login'><img src='./images/twitter.png' alt='twitter'></a>
        </div>
    </footer>
</body>

</html>