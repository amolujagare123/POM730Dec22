package DbTesting.Clients;

import Util.DoLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Menu;
import pages.clients.AddClient;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static Util.Conversion.convertCountry;
import static Util.MyDataProvider.getMyData;
import static pages.clients.AddClient.getShortCodeCountry;

public class AddClientDataProviderTest extends DoLogin {


    @Test(dataProvider = "getData")
    public void addClientTest(String name,String surname,String language,
                              String address1,String address2,String city,
                              String state,String zip,String country,
                              String gender,String birthdate,String phone,
                              String fax,String mobile,String email,String web,
                              String vat,String tax) throws ParseException, ClassNotFoundException, SQLException {

        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName(name);
        addClient.setClientSurname(surname);
        addClient.setLanguage(language);
        addClient.setClientAddress1(address1);
        addClient.setClientAddress2(address2);
        addClient.setClientcity(city);
        addClient.setClientState(state);
        addClient.setClientZip(zip);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setTxtBirthDate2(birthdate);
        addClient.setClientPhone(phone);
        addClient.setClientFax(fax);
        addClient.setClientMobile(mobile);
        addClient.setClientEmail(email);
        addClient.setClientWeb(web);
        addClient.setClientVat(vat);
        addClient.setClientTax(tax);
        addClient.clickBtnSave();

        ArrayList<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(address1);
        expected.add(address2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(getShortCodeCountry());
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);

        // 1. loading a driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. creating a connection
        String username ="root";
        String password ="root";
        String url = "jdbc:mysql://localhost:3306/ip";
        Connection con = DriverManager.getConnection(url,username,password);

        // 3. create statement
        Statement st = con.createStatement();

        // 4. execute query

        String sql = "select * from ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();


        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

         /*   String shortCountry =rs.getString("client_country");
            String fullFormCountry = convertCountry(shortCountry);

            actual.add(fullFormCountry);*/
            actual.add(rs.getString("client_country"));


            actual.add(rs.getString("client_gender"));
            actual.add(rs.getString("client_birthdate"));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("expected="+expected);
        System.out.println("Actual="+actual);


        Assert.assertEquals(actual,expected,"data does not match");


    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return  getMyData("Data/InvoicePlaneData.xlsx","Db Testing");
    }


}
