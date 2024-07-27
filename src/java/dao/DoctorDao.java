package dao;
import connect.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Doctor;
/**
 *
 * @author HP
 */
public class DoctorDao {
    
    /**
     *
     * @param uid
     * @return
     * @throws SQLException
     */
    public static boolean checkUUID(String uid) throws SQLException
    {
        String sql;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        sql="select uid from doctor where uid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,uid);
        rs=ps.executeQuery();
        return(rs.next());
    }
    
    public static Doctor getDoctorByUid(String uid) throws SQLException
    {
        String sql;
        Connection con;
        Doctor D=null;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        sql="select * from doctor where uid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,uid);
        rs=ps.executeQuery();
        if(rs.next())
        {
            D=new Doctor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
        }
        return D;
    }
    
    public boolean checkDatabase(String name,String contact) throws SQLException
    {
        String sql;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        sql="select name,contact from doctor where name=? AND contact=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,contact);
        rs=ps.executeQuery();
        return(rs.next());
    }
    
    public boolean insertDetails(Doctor D) throws SQLException
    {
        String sql;
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        sql="insert into doctor values(?,?,?,?,?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setString(1,D.getName());
        ps.setString(2,D.getContact());
        ps.setString(3,D.getCategory());
        ps.setString(4,D.getAddress());
        ps.setString(5,D.getCity());
        ps.setString(6,D.getImagepath());
        ps.setString(7,D.getUid());
        if(checkDatabase(D.getName(),D.getContact()))
                return false;
        return(ps.executeUpdate()>0);
    }
    
    public List<Doctor> searchDoctor(String category,String city) throws SQLException
    {
        String sql;
        sql="select * from doctor where category=? and city=?";
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        ps=con.prepareStatement(sql);
        List<Doctor> DC =new ArrayList<Doctor>();
        ps.setString(1,category);
        ps.setString(2,city);
        rs=ps.executeQuery();
        while(rs.next())
        {
            Doctor D = new Doctor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
            DC.add(D);
        }
        return DC;
    }
}
