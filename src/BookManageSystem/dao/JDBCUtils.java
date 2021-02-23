package BookManageSystem.dao;

import java.sql.*;

/**
 * 连接JDBC类
 * @author lck100
 */
public class JDBCUtils {
    //加载驱动，并建立数据库连接

    /**
     * 加载驱动建立数据库链接
     *
     * @return 返回数据库Connection连接对象
     * @throws SQLException           抛出SQLException
     * @throws ClassNotFoundException 抛出ClassNotFoundException
     */
    static Connection getConnection() throws SQLException, ClassNotFoundException {
        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 连接数据库
        String url = "jdbc:mysql://localhost:3306/db_bookSystem";
        // 数据库登录用户名
        String username = "root";
        // 数据库登录密码
        String password = "admin";
        // 获取数据库连接对象并返回Connection对象
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 关闭数据库连接，释放资源
     *
     * @param stmt Statement对象
     * @param conn Connection对象
     */
    static void release(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    /**
     * 关闭数据库连接，释放资源
     *
     * @param rs   ResultSet对象
     * @param stmt Statement对象
     * @param conn Connection对象
     */
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        release(stmt, conn);
    }

}
