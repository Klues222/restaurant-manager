//package mysql;
//
//import java.sql.*;
//
//public class Conn {
//    private Connection conn = null;
//    public Statement statement = null;
//    public PreparedStatement pstate = null;
//    private ResultSet resultSet = null;
//    public void getConn() {
//        //forName加载驱动
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver" );
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try{
//            //getConnection建立连接
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/authorization", "root", "12345678");
//            statement = conn.createStatement();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//    }
//    //TODO：用户数据查询
//    public ResultSet select(String sql) throws SQLException {
//
//        try {
//            pstate = conn.prepareStatement("select * from user where username = ?");
//            resultSet = pstate.executeQuery();
//        }catch (SQLException e){
//            e.printStackTrace();
//            return resultSet;
//        }
//        return resultSet;
//
//    }
//}
