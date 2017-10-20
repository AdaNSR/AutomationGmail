import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by Nathalie on 1/26/2017.
 */
public class WebMailTest {

    WebDriver driver;//Aqui estamos declarando la variable, luego en cada metodo se inicializa

    @Test // Esta es una anotación de jave creada por Junit para identificar este metodo como un test, y poder ejecutado por maven test

    public void createMailTest() {
        logIn();

//        WebElement codigotel = driver.findElement(By.id("idvPreregisteredPhonePin"));
//        codigotel.sendKeys(JOptionPane.showInputDialog(null, "Ingress the code here: "));
//        WebElement donetel = driver.findElement(By.id("submit"));
//        donetel.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);// Este es mejor que el thread.sleep que ademas una un try/catch

        WebElement compose = driver.findElement(By.xpath("//div[text()='COMPOSE']"));//Aca no le doy new, porque no voy a crear un objeto totalmente nuevo que tiene el metodo findElement
        compose.click();
        WebElement tofield = driver.findElement(By.name("to"));
        tofield.sendKeys("whquestiontutorial@gmail.com");


         WebElement subject = driver.findElement(By.name("subjectbox"));
        subject.sendKeys("webmail test");



        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.Am,.Al,.editable,.LW-avf').innerHTML = 'Clase en cinnabon'");
        WebElement send = driver.findElement(By.xpath("//div[text()='Send']"));//Aca no le doy new, porque no voy a crear un objeto totalmente nuevo que tiene el metodo findElement
        send.click();

    }

    @Test
    public void saveDraftTest(){

        logIn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// Este es mejor que el thread.sleep que ademas una un try/catch

        WebElement composedraft = driver.findElement(By.xpath("//div[text()='COMPOSE']"));//Aca no le doy new, porque no voy a crear un objeto totalmente nuevo que tiene el metodo findElement
        composedraft.click();

        WebElement tofielddraft = driver.findElement(By.name("to"));
        tofielddraft.sendKeys("adanathalie@gmail.com");

        WebElement subjectdraft = driver.findElement(By.name("subjectbox"));
        subjectdraft.sendKeys("webmail test - draft");

        JavascriptExecutor jsdraft = (JavascriptExecutor) driver;
        jsdraft.executeScript("document.querySelector('.Am,.Al,.editable,.LW-avf').innerHTML = 'Este es solo un borrador'");

        WebElement close  = driver.findElement(By.xpath("//img[@alt='Close']"));//Aca no le doy new, porque no voy a crear un objeto totalmente nuevo que tiene el metodo findElemen
        close.click();



    }

    @Test
    public void deleteEmail(){

        logIn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// Este es mejor que el thread.sleep que ademas una un try/catch



        WebElement emailtobedeleted = driver.findElement(By.xpath("//*[span='me']/parent::*"));//la etiqueta es span y el texto de la etiqueta es me
        emailtobedeleted.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// Este es mejor que el thread.sleep que ademas una un try/catch


        WebElement deleteButton  = driver.findElement(By.xpath("//*[@class='aeH']/div[2]/div[1]/div/div[2]/div[3]"));//Aca no le doy new, porque no voy a crear un objeto totalmente nuevo que tiene el metodo findElemen
        System.out.println("Boton es:" + deleteButton.getTagName()+ " " + deleteButton.getAttribute("id") + " " + deleteButton.getAttribute("role")+ " " + deleteButton.getAttribute("aria-label"));
        deleteButton.click();

      /*  JavascriptExecutor jsdelete = (JavascriptExecutor) driver;
        jsdelete.executeScript("document.querySelector('[aria-label=Delete]').click()"); */

        /*List<WebElement> listCurrentElements = driver.findElements(By.xpath("//div[@role='button']"));
        System.out.println("Lista de elementos :" + listCurrentElements);


        for (WebElement element :listCurrentElements  ) {
            System.out.println("elememt:" + element.getTagName()+ " " + element.getAttribute("aria-label"));

        }*/





       /* WebElement tofielddraft = driver.findElement(By.name("to"));
        tofielddraft.sendKeys("adanathalie@gmail.com");

        WebElement subjectdraft = driver.findElement(By.name("subjectbox"));
        subjectdraft.sendKeys("webmail test - draft");

        JavascriptExecutor jsdraft = (JavascriptExecutor) driver;
        jsdraft.executeScript("document.querySelector('.Am,.Al,.editable,.LW-avf').innerHTML = 'Este es solo un borrador'");

        WebElement close  = driver.findElement(By.xpath("//img[@alt='Close']"));//Aca no le doy new, porque no voy a crear un objeto totalmente nuevo que tiene el metodo findElemen
        close.click();*/
    }
    private void logIn() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.google.com");
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("whquestiontutorial@gmail.com");
        WebElement next = driver.findElement(By.id("next"));
        next.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }

        List<WebElement> listCurrentElements = driver.findElements(By.tagName("input"));
        System.out.println("Lista de elementos :" + listCurrentElements);

        WebElement password = driver.findElement(By.id("Passwd"));
        password.sendKeys("Unad2016");
        WebElement nextPw = driver.findElement(By.id("signIn"));
        nextPw.click();// ibamos aca, hasta aca anda
    }


}











