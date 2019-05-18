package DataBase;

import Entity.Users;
import java.sql.*;
import java.lang.Class;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.*;

public class UsersOperation{
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private String URL = "jdbc:mysql://127.0.0.1:3306/db_user";
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //Users users = new Users();

    //第一步：加载驱动
    //第二步：链接数据库
    //第三步：编写sql代码
    //第四步：建立sql语句执行器PreparedStatment执行sql语句
    //第五步：占位符替换
    //第六步：关闭链接Connection 和 sql 语句执行器 PreparedStatement
    
    /*增加用户*/
    public void insertUsers(String nickname ,String password,String email) {
    	Users users = new Users();
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO db_user(nickname,password,email)  VALUE(?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, nickname);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            try {
                connection.close();
                ps.close();
            } catch (SQLException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }

    /*通过id查询用户*/
    public Users queryUsersById(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users news = null;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + "?characterEncoding=utf8&useSSL=false",USERNAME,PASSWORD);
            String sql = "SELECT * FROM db_user WHERE id =  + id";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	Users users = new Users();
            	users.setId(rs.getInt(1));
            	users.setNickName(rs.getString("nickname"));
            	users.setPassword(rs.getString(3));
            	users.setEmail(rs.getString(4));
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return news;
    }

    /*查询所有的用户*/
    public List<Users> queryAllUsers() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Users> list = new ArrayList<Users>();
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM db_user";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	Users users = new Users();
            	users.setId(rs.getInt("id"));
            	users.setNickName(rs.getString("nickname"));
            	users.setPassword(rs.getString("password"));
            	users.setEmail(rs.getString("email"));
                list.add(users);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return list;
    }

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
}