
package UserDao;

import User.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> getAllUser() throws SQLException{
        List<User> users = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql= "SELECT * FROM nguoidung";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                User user = new User();
                
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("hoten"));
                user.setUsername(rs.getString("taikhoan"));
                user.setPassword(rs.getString("matkhau"));
                user.setRole(rs.getString("quyen"));
                user.setCMND(rs.getString("socmnd"));
                user.setMoney(rs.getLong("sodu"));
                
                users.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }
    public User getUserByUserName(String userName) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql= "SELECT * FROM nguoidung where taikhoan= ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                User user = new User();
                
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("hoten"));
                user.setUsername(rs.getString("taikhoan"));
                user.setPassword(rs.getString("matkhau"));
                user.setRole(rs.getString("quyen"));
                user.setCMND(rs.getString("socmnd"));
                user.setMoney(rs.getLong("sodu"));
                
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public User getUserById(int Id) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql= "SELECT * FROM nguoidung where id= ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                User user = new User();
                
               user.setId(rs.getInt("ID"));
                user.setName(rs.getString("hoten"));
                user.setUsername(rs.getString("taikhoan"));
                user.setPassword(rs.getString("matkhau"));
                user.setRole(rs.getString("quyen"));
                user.setCMND(rs.getString("socmnd"));
                user.setMoney(rs.getLong("sodu"));
                
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void addUser(User user){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql="INSERT INTO nguoidung(hoten,taikhoan,matkhau,quyen,socmnd,sodu) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getRole());
            preparedStatement.setString(5,user.getCMND());
            preparedStatement.setLong(6,user.getMoney());
            
            
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }        
    public void updateUser(User user){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql="UPDATE nguoidung SET hoten = ?,taikhoan = ?,matkhau= ?,quyen = ?,socmnd =?, sodu = ? WHERE ID= ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getRole());
            preparedStatement.setString(5,user.getCMND());
            preparedStatement.setLong(6,user.getMoney());
            
            preparedStatement.setInt(7,user.getId());
            
            
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteUser(int id){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql="delete from nguoidung where id= ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1,id);
               int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}