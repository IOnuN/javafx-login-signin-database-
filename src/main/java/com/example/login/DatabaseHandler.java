package com.example.login;
import java.sql.*;
public class DatabaseHandler extends Configs{
Connection dbConnection;
public Connection getDbConnection()
        throws ClassNotFoundException, SQLException{
    String connectionString="jdbc:mysql://"+dbHost+":" +dbPort+"/"+dbName;
    Class.forName("com.mysql.cj.jdbc.Driver");

    dbConnection=DriverManager.getConnection(connectionString, dbUser,dbPass);
    return dbConnection;
}
public void signupuser(String firstname,String lastname,String username, String password,String location,String gender,String age) throws SQLException, ClassNotFoundException {
String insert="INSERT INTO "+Const.USER_TABLE + "("+
        Const.USER_NUME+","+Const.USER_PRENUME+","+Const.USER_USERNAME+","+Const.USER_VIRSTA+","+
        Const.USER_PASSWORD+","+Const.USER_LOCATION+","+Const.USER_GENDER+")"+
        "VALUES(?,?,?,?,?,?,?)";

PreparedStatement prSt=getDbConnection().prepareStatement(insert);
    prSt.setString(1,firstname);
    prSt.setString(2,lastname);
    prSt.setString(3,username);
    prSt.setString(4,age);
    prSt.setString(5,password);
    prSt.setString(6,location);
    prSt.setString(7,gender);

    prSt.executeUpdate();
}
    public boolean getUser(User user) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD + "=?";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        prSt.setString(1, user.getUsername());
        prSt.setString(2, user.getPassword());
        ResultSet resultSet = prSt.executeQuery();
        return resultSet.next();
    }
}


