package dao;

import connect.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserAppointment;


public class UserAppDao {
    
    public static boolean checkAPID(String apid) throws SQLException
    {
        String sql;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        sql="select apid from userappointment where apid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,apid);
        rs=ps.executeQuery();
        return(rs.next());
    }
    
    private boolean checkDatabase(String date,String time,String dname,String dcontact) throws SQLException
    {
        String sql;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        sql="select * from userappointment where date=? AND time=? AND dname=? AND dcontact=?";
        ps= con.prepareStatement(sql);
        ps.setString(1,date);
        ps.setString(2,time);
        ps.setString(3,dname);
        ps.setString(4,dcontact);
        rs=ps.executeQuery();
        return(rs.next());
    }
    
    public boolean deleteAppByApid(String apid) throws SQLException
    {
        String sql;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        sql="delete from userappointment where apid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,apid);
        return(ps.executeUpdate()>0);
    }
    
    public boolean acceptAppointment(UserAppointment U) throws SQLException
    {
        String sql;
        Connection con;
        PreparedStatement ps;
        con = MyConnection.getConnection();
        sql="insert into userappointment values(?,?,?,?,?,?,?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setString(1,U.getName());
        ps.setString(2,U.getEmail());
        ps.setString(3,U.getContact());
        ps.setString(4,U.getApdescript());
        ps.setString(5,U.getApdate());
        ps.setString(6,U.getTime());
        ps.setString(7,U.getApid());
        ps.setString(8,U.getDname());
        ps.setString(9,U.getDcontact());
        if(checkDatabase(U.getApdate(),U.getTime(),U.getDname(),U.getDcontact()))
            return false;
        return(ps.executeUpdate()>0); 
    }
    
}
