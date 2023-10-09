package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SMSpage extends BasePage {

    By exitBtnLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Salir']");
    By menuLocator = By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-bars'");
    By returnLocator = By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-arrow-circle-left'");
    By nextLocator = By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-arrow-circle-right'");
    By titleSMSLocator = By.id("tituloApp");


    String stepLocator = "//span[@class='ui-steps-title' and text()='%s']";

    public SMSpage(WebDriver driver) {super(driver);}

    public boolean isHomePageDisplayed() throws InterruptedException{
        boolean value = false;
        List<By> elements = new ArrayList<>();
        elements.add((exitBtnLocator));
        elements.add((menuLocator));
        elements.add((returnLocator));
        elements.add((nextLocator));

        for (By element: elements) {
            if(isDisplayed(element)) {
                value=true;
                break;
            }

        }
        return value;
    }

    public String getTitleSMS (){
        return getText(titleSMSLocator);
    }

    public void goStep ( String title){
        String newStep = String.format(stepLocator,title);
        System.out.println(newStep);
        click(By.xpath(newStep));
    }


}



