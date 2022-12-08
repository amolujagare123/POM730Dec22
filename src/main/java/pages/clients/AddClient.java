package pages.clients;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


    @FindBy (xpath = "//input[@name='client_birthdate']")
    WebElement txtBirthDate;

    public void setTxtBirthDate2(String setDateStr)
    {
       // txtBirthDate.sendKeys(setDateStr);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+setDateStr+"')",txtBirthDate);
    }

    public void setTxtBirthDate(String setDateStr) throws ParseException {
        txtBirthDate.click();

        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);

        String currDateStr =
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).getText();

        Date currDate =  new SimpleDateFormat("MMMM yyyy").parse(currDateStr);

        System.out.println("setDate="+setDate);
        System.out.println("currDate="+currDate);

        int monthDiff = Months.monthsBetween(
                new DateTime(currDate).withDayOfMonth(1),

                new DateTime(setDate).withDayOfMonth(1)

        ).getMonths();

        System.out.println("monthDiff="+monthDiff);

        boolean isFuture;

        if (monthDiff>0)
            isFuture = true;
        else {
            isFuture = false;
            monthDiff = monthDiff * (-1);
        }

        for (int i=0;i<monthDiff;i++)
        {
            if (isFuture)
                // click next
             driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
                else
            // click prev
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev']")).click();
        }

        String setDay = new SimpleDateFormat("dd").format(setDate);
        int setDayInt = Integer.parseInt(setDay);

        driver.findElement(By.xpath("//td[normalize-space()='"+setDayInt+"' and @class='day']")).click();
    }

    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver; // parameterized constructor with this operator
    }



}
