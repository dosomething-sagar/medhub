package dao;
import connect.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.Hospital;

public class HospitalDao {
    
    public static boolean checkUUID(String uid) throws SQLException
    {
        String sql;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        sql="select uid from hospital where uid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,uid);
        rs=ps.executeQuery();
        return(rs.next());
    }
    
    public boolean checkDatabase(String name,String contact,String address) throws SQLException
    {
        String sql;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        sql="select * from hospital where name=? and address=? and contact=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,address);
        ps.setString(3,contact);
        rs=ps.executeQuery();
        return(rs.next());
    }
    
    public boolean insertDetails(Hospital H) throws SQLException
    {
        String sql;
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        sql="insert into hospital values(?,?,?,?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setString(1,H.getName());
        ps.setString(2,H.getContact());
        ps.setString(3,H.getAddress());
        ps.setString(4,H.getCity());
        ps.setString(5,H.getImagepath());
        ps.setString(6,H.getUid());
        if(checkDatabase(H.getName(),H.getContact(),H.getAddress()))
                return false;
        return(ps.executeUpdate()>0);
    }
    
    public List<Hospital> searchHospitalByCity(String city) throws SQLException
    {
        String sql;
        sql="select * from hospital where city=?";
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        ps=con.prepareStatement(sql);
        List<Hospital> HC =new ArrayList<Hospital>();
        ps.setString(1,city);
        rs=ps.executeQuery();
        while(rs.next())
        {
            Hospital H = new Hospital(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            HC.add(H);
        }
        return HC;
    }
    
    public List<Hospital> searchHospital(String city, String name) throws SQLException
    {
        String sql;
        sql="select * from hospital where city=? AND name like ? ";
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        ps=con.prepareStatement(sql);
        List<Hospital> HC =new ArrayList<Hospital>();
        ps.setString(1,city);
        ps.setString(2,name+"%");
        rs=ps.executeQuery();
        while(rs.next())
        {
            Hospital H = new Hospital(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            HC.add(H);
        }
        return HC;
    }
}
