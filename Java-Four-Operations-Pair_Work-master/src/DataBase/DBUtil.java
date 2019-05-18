package DataBase;

import java.io.IOException;
import java.sql.*;

public class DBUtil {
	/*
	*获取连接conn
	*/
    public static Connection getConn() {
        String URL = "jdbc:mysql://localhost:3306/db_user";
        String newNAME = "root";
        String PASSWORD = "root";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,newNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /*
     * 获取statement语句
     * */
    public static Statement createStmt(Connection conn){
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }
    /*
     * 获取preparedStatement
     * */
    public static PreparedStatement preparedStatement(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pstmt;
    }
	/*
	*获取查询
	*/
    public static ResultSet executeQuery(Connection conn, String sql) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = createStmt(conn);
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /*
     * 分别关闭三次
     * */
    public static void close(Connection conn) {
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void close(Statement stmt) {
        if(stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
    }

    public static void close(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
    }
}
