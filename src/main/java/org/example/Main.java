package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();// aca se le indica el navegador a trabajar
        WebDriver driver= new ChromeDriver();// se le indica al programa que inicialize y habra el navegador

        // Se ingresa la url de la pagina a probar http://189.50.209.188/

        driver.navigate().to("http://189.50.209.188/");
        //Maximisamos la ventana del navegador
        driver.manage().window().maximize();


        driver.quit();

    }
}