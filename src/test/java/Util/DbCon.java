package Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
public class DbCon {

    public static int getNoOfConnection =0;
    private Connection conn=null;
    private List<Statement> statementList = new ArrayList<Statement>();


    public DbCon() throws Exception
    {
        getConnection();
    }


    public ResultSet getRecords(String strSQL) throws Exception
    {

        try
        {
            Statement s = conn.createStatement();
           // statementList.add(s);
           // s = conn.createStatement();
            //System.out.println(strSQL);
            return s.executeQuery(strSQL);
        }
        catch (Exception e)
        {
            e.printStackTrace();

            throw e;
        }
    }
    private void getConnection()throws Exception
    {

       ResourceBundle dbDetails = ResourceBundle.getBundle("dbSource");

       /* String ConnStr= "jdbc:mysql://localhost:3306/ip";//dbDetails.getString("dbServer");
        String uname="root";//dbDetails.getString("UserName");
        String pass="root";//dbDetails.getString("Password");*/


        String ConnStr= dbDetails.getString("dbServer");
        String uname =dbDetails.getString("UserName");
        String pass =dbDetails.getString("Password");


        String connectionURL = ConnStr;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(connectionURL, uname, pass);
            getNoOfConnection++;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
    public void dropConnection()
    {


        for (int i = 0; i < statementList.size(); i++) {
            try {
                statementList.get(i).close();
            } catch (SQLException e) {
                //ignore
            }

        }

        try
        {
            if(!conn.isClosed())
            {

                getNoOfConnection--;
                //conn.
                conn.close();
                //System.out.println("Active DB Connections count is: " + getNoOfConnection);
            }
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
