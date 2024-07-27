
package dao;
import connect.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.Bloodbank;

public class BloodbankDao {
    
    public static boolean checkUUID(String uid) throws SQLException
    {
        String sql;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        sql="select uid from bloodbank where uid=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,uid);
        rs=ps.executeQuery();
        return(rs.next());
    }
    
    public boolean checkDatabase(String name,String address,String contact) throws SQLException
    {
        String sql;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        sql="select name,address,contact from bloodbank where name=? AND address=? AND contact=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,address);
        ps.setString(3,contact);
        rs=ps.executeQuery();
        return(rs.next());
    }
    
    public boolean insertDetails(Bloodbank bb) throws SQLException
    {
        String sql;
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        sql="insert into bloodbank values(?,?,?,?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setString(1,bb.getName());
        ps.setString(2,bb.getContact());
        ps.setString(3,bb.getAddress());
        ps.setString(4,bb.getCity());
        ps.setString(5,bb.getImagepath());
        ps.setString(6,bb.getUid());
        if(checkDatabase(bb.getName(),bb.getContact(),bb.getAddress()))
                return false;
        return(ps.executeUpdate()>0);
    }
    
    public List<Bloodbank> searchBloodbank(String city) throws SQLException
    {
        String sql;
        sql="select * from bloodbank where city=?";
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        con=MyConnection.getConnection();
        ps=con.prepareStatement(sql);
        List<Bloodbank> BBC =new ArrayList<Bloodbank>();
        ps.setString(1,city);
        rs=ps.executeQuery();
        while(rs.next())
        {
            Bloodbank bb = new Bloodbank(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            BBC.add(bb);
        }
        return BBC;
    }
}
