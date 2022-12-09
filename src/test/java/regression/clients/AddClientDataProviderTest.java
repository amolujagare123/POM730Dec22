package regression.clients;

import Util.DoLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Menu;
import pages.clients.AddClient;

import java.io.IOException;
import java.text.ParseException;

import static Util.MyDataProvider.getMyData;

public class AddClientDataProviderTest extends DoLogin {


    @Test(dataProvider = "getData")
    public void addClientTest(String name,String surname,String language,
                              String address1,String address2,String city,
                              String state,String zip,String country,
                              String gender,String birthdate,String phone,
                              String fax,String mobile,String email,String web,
                              String vat,String tax,String expected,String xpathActual) throws ParseException
    {
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

        String actual="";

        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }

        Assert.assertEquals(actual,expected,"Wrong message or message absent");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return  getMyData("Data/InvoicePlaneData.xlsx","Sheet1");
    }


}
