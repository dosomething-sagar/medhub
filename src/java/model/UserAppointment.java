package model;


public class UserAppointment {
    private String name,email,contact,apdescript,apdate,time,apid,dname,dcontact;

    public String getDcontact() {
        return dcontact;
    }

    public void setDcontact(String dcontact) {
        this.dcontact = dcontact;
    }

    public String getName() {
        return name;
    }

    public UserAppointment(String name, String email, String contact, String apdescript, String apdate, String time, String apid, String dname, String dcontact) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.apdescript = apdescript;
        this.apdate = apdate;
        this.time = time;
        this.apid = apid;
        this.dname = dname;
        this.dcontact = dcontact;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
    
    public UserAppointment(){
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getApdescript() {
        return apdescript;
    }

    public void setApdescript(String apdescript) {
        this.apdescript = apdescript;
    }

    public String getApdate() {
        return apdate;
    }

    public void setApdate(String apdate) {
        this.apdate = apdate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getApid() {
        return apid;
    }

    public void setApid(String apid) {
        this.apid = apid;
    }
    
}
