package pages.clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    @FindBy(xpath = "//input[@name='client_name']")
    WebElement clientName;

    public void setClientName(String name)
    {
        clientName.sendKeys(name);
    }


    @FindBy(xpath = "//input[@name='client_surname']")
    WebElement clientSurname;

    public void setClientSurname(String surname)
    {
        clientSurname.sendKeys(surname);
    }


    @FindBy(xpath = "//input[@name='client_address_1']")
    WebElement clientAddress1;

    public void setClientAddress1(String address1)
    {
        clientAddress1.sendKeys(address1);
    }



    @FindBy(xpath = "//input[@name='client_address_2']")
    WebElement clientAddress2;

    public void setClientAddress2(String address2)
    {
        clientAddress2.sendKeys(address2);
    }


    @FindBy(xpath = "//input[@name='client_city']")
    WebElement clientCity;

    public void setClientcity(String city)
    {
        clientCity.sendKeys(city);
    }


    @FindBy(xpath = "//input[@name='client_state']")
    WebElement clientState;


    public void setClientState(String state)
    {
        clientState.sendKeys(state);
    }


    @FindBy(xpath = "//input[@name='client_zip']")
    WebElement clientZip;

    public void setClientZip(String zip)
    {
        clientZip.sendKeys(zip);
    }

    @FindBy(xpath = "//input[@name='client_phone']")
    WebElement clientPhone;

    public void setClientPhone(String phone)
    {
        clientPhone.sendKeys(phone);
    }


    @FindBy(xpath = "//input[@name='client_fax']")
    WebElement clientFax;

    public void setClientFax(String fax)
    {
        clientFax.sendKeys(fax);
    }


    @FindBy(xpath = "//input[@name='client_mobile']")
    WebElement clientMobile;

    public void setClientMobile(String mobile)
    {
        clientMobile.sendKeys(mobile);
    }

    @FindBy(xpath = "//input[@name='client_email']")
    WebElement clientEmail;

    public void setClientEmail(String email)
    {
        clientEmail.sendKeys(email);
    }

    @FindBy(xpath = "//input[@name='client_web']")
    WebElement clientWeb;

    public void setClientWeb(String web)
    {
        clientWeb.sendKeys(web);
    }


    @FindBy(xpath = "//input[@name='client_vat_id']")
    WebElement clientVat;

    public void setClientVat(String vat)
    {
        clientVat.sendKeys(vat);
    }


    @FindBy(xpath = "//input[@name='client_tax_code']")
    WebElement clientTax;

    public void setClientTax(String tax)
    {
        clientTax.sendKeys(tax);
    }

    @FindBy(xpath = "//button[@name='btn_submit']")
    WebElement btnSave;

    public void clickBtnSave()
    {
        btnSave.click();
    }

    @FindBy (id="select2-client_language-container")
    WebElement containerLanguage;

    @FindBy (xpath = "//input[@role='searchbox']")
    WebElement searchBox;

    WebDriver driver;

    public void setLanguage(String language)
    {
        containerLanguage.click();
        searchBox.sendKeys(language);
        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();
    }


    @FindBy (id="select2-client_country-container")
    WebElement containerCountry;

    public void setCountry(String country)
    {
        containerCountry.click();
        searchBox.sendKeys(country);
        driver.findElement(By.xpath("//li[normalize-space()='"+country+"']")).click();
    }

    @FindBy (id = "select2-client_gender-container")
    WebElement containerGender;

    public  void setGender(String gender)
    {
        containerGender.click();
        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();
    }


    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver; // parameterized constructor with this operator
    }



}
