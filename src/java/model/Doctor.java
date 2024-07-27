package model;


public class Doctor {
    private String name,address,city,contact,category,imagepath,uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
    
    public Doctor(){
        
    }

    public Doctor(String name, String contact, String category, String address, String city, String imagepath,String uid) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.contact = contact;
        this.category = category;
        this.imagepath = imagepath;
        this.uid=uid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    
}
