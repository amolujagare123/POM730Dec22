package regression.clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClient;

import java.io.IOException;

import static utility.ConfigReader.*;

public class AddClientTest {
    WebDriver driver;
    @BeforeClass
    public void doLogin() throws IOException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickBtnLogin();
    }

    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setLanguage("Turkish");
        addClient.setCountry("Malaysia");
        addClient.setGender("Male");

        /*addClient.setClientName("Sagar");
        addClient.setClientSurname("Motling");
        addClient.setClientAddress1("xyz");
        addClient.setClientAddress2("abc");
        addClient.setClientcity("Mumbai");
        addClient.setClientState("MH");
        addClient.setClientZip("55454545");
        addClient.setClientPhone("5454545");
        addClient.setClientFax("8787878");
        addClient.setClientMobile("995454554");
        addClient.setClientEmail("sagar@gmail.com");
        addClient.setClientWeb("www.sagar.com");
        addClient.setClientVat("76767");
        addClient.setClientTax("6532323");
        addClient.clickBtnSave();*/

    }


}
