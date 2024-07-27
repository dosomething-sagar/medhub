package model;


public class Bloodbank {
    private String name,address,city,contact,imagepath,uid;

    public Bloodbank(String name, String contact, String address, String city, String imagepath,String uid) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.contact = contact;
        this.imagepath = imagepath;
        this.uid=uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public Bloodbank(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
    
}
