package TestForm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutoForm {
    String url = "https://automacaocombatista.herokuapp.com/treinamento/home";
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://WebDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @After
    public void end() throws Exception{

    }

    @Test
    public void TestAutoForm(){
        driver.get(url);
        driver.findElement(By.xpath("//a[@class='collapsible-header ']")).click();
        driver.findElement(By.xpath("(//a[@data-method=\"get\"])[1]")).click();
        driver.findElement(By.name("user[name]")).sendKeys("Larissa");
        driver.findElement(By.name("user[lastname]")).sendKeys("Fakeson");
        driver.findElement(By.name("user[email]")).sendKeys("larissa@fakeson.com");
        driver.findElement(By.name("user[address]")).sendKeys("manaus");
        driver.findElement(By.name("user[university]")).sendKeys("UniNorte");
        driver.findElement(By.name("user[profile]")).sendKeys("fotografa");
        driver.findElement(By.name("user[gender]")).sendKeys("feminino");
        driver.findElement(By.name("user[age]")).sendKeys("20");

        String nameReturn = driver.findElement(By.name("user[name]")).getAttribute("value");
        String lastNameReturn = driver.findElement(By.name("user[lastname]")).getAttribute("value");
        String emailReturn = driver.findElement(By.name("user[email]")).getAttribute("value");
        String addressReturn = driver.findElement(By.name("user[address]")).getAttribute("value");
        String universityReturn = driver.findElement(By.name("user[university]")).getAttribute("value");
        String profileReturn = driver.findElement(By.name("user[profile]")).getAttribute("value");
        String genderReturn = driver.findElement(By.name("user[gender]")).getAttribute("value");
        String ageReturn = driver.findElement(By.name("user[age]")).getAttribute("value");

        Assert.assertEquals("Larissa",nameReturn);
        Assert.assertEquals("Fakeson",lastNameReturn);
        Assert.assertEquals("larissa@fakeson.com",emailReturn);
        Assert.assertEquals("manaus",addressReturn);
        Assert.assertEquals("UniNorte",universityReturn);
        Assert.assertEquals("fotografa",profileReturn);
        Assert.assertEquals("feminino",genderReturn);
        Assert.assertEquals("20",ageReturn);

        driver.findElement(By.xpath("//div[@class='actions btn waves-effect green']")).click();

        String msgSuccess = driver.findElement(By.id("notice")).getText();
        Assert.assertEquals("Usuário Criado com sucesso", msgSuccess);

        String infoName = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[1]")).getText();
        String infoLastName = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[2]")).getText();
        String infoEmail = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[3]")).getText();
        String infoAddress = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[4]")).getText();
        String infoUniversity = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[5]")).getText();
        String infoProfile = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[6]")).getText();
        String infoGender = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[7]")).getText();
        String infoAge = driver.findElement(By.xpath("(//div[@class='col s12 center']/p)[8]")).getText();

        Assert.assertEquals("Nome: Larissa",infoName);
        Assert.assertEquals("Ultimo Nome: Fakeson", infoLastName);
        Assert.assertEquals("Email: larissa@fakeson.com", infoEmail);
        Assert.assertEquals("Univercidade: UniNorte", infoAddress);
        Assert.assertEquals("Gênero: feminino", infoUniversity);
        Assert.assertEquals("Profissão: fotografa", infoProfile);
        Assert.assertEquals("Idade: 20", infoGender);
        Assert.assertEquals("Address: manaus", infoAge);


    }
}
