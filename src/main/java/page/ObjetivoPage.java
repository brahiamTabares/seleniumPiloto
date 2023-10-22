package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ObjetivoPage extends SMSpage {

    By objetivoLocator = By.id("formulario:j_idt83");
    By descripObjLocator = By.id("formulario:j_idt85");
    By confirmObjLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Aceptar']");
    By confirMsgObjetivo = By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title']");
    By tableLocator = By.id("tabla:j_idt89_data");

    By actualizarObjetivoBtnLocator = By.xpath("//*[@id='tabla:j_idt89_data']//tr/td[3]/div//span[@class='ui-icon ui-icon-pencil']");
    By codigoActualizadoLocator = By.cssSelector(".ui-row-editing > td:nth-child(1) input");
    By descripCionActualizadaLocator = By.cssSelector(".ui-row-editing > td:nth-child(2) textarea");
    By btnactualizarObjetivoLocator = By.cssSelector(".ui-row-editing > td:nth-child(3) a.ui-row-editor-check");
    By confirMsgActualizar = By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title']");
    By deleteObjectivoLocator = By.xpath("//*[@id='tabla:j_idt89_data']//tr/td[3]/button//span[@class='ui-button-icon-left ui-icon ui-c pi pi-trash']");
    By alertDeleteObjLocator = By.cssSelector(".ui-confirm-dialog");
    By confirmDeleteObjLocator = By.xpath("//span[@class='ui-button-text ui-c' and text()='Si']");
    By cancelarActualizarLocator = By. cssSelector(".ui-row-editing > td:nth-child(3) a.ui-row-editor-close");


    public ObjetivoPage(WebDriver driver) {
        super(driver);
    }

    public void declararObjetivo(String codigo, String descripcionO) {
        type(codigo, objetivoLocator);
        type(descripcionO, descripObjLocator);
        click(confirmObjLocator);
    }

    public boolean buscarObjetivo(String codigoObjetivo) {
        // Espera a que la tabla esté presente en la página
        if (buscarObjetivoPos(codigoObjetivo) >= 0) {
            return true;
        } else {
            return false;
        }
    }


    public int buscarObjetivoPos(String codigoObjetivo) {

        getEwait().until(ExpectedConditions.presenceOfElementLocated(tableLocator));

        List<WebElement> filas = findElements(By.cssSelector("#tabla\\:j_idt89 tr"));

        if (filas.size() == 1 && filas.get(0).getText().contains("No se encontraron registros")) {
            System.out.println("La tabla está vacía. No se encontraron registros.");
            return 0;
        }
        // se crea un flujo de enteros para iterar atravez de la tabla y se filtra las filas que cumplen con las condiciones
        int posicionObjetivo = IntStream.range(0, filas.size())
                .filter(i -> {
                    WebElement fila = filas.get(i);
                    List<WebElement> celdas = fila.findElements(By.tagName("td"));

                    if (celdas.size() >= 2) {
                        String codigo = getText(celdas.get(0));
                        String descripcion = getText(celdas.get(1));

                        if (codigo.equalsIgnoreCase(codigoObjetivo) || descripcion.equalsIgnoreCase(codigoObjetivo)) {
                            System.out.println("Objetivo encontrado en la tabla: " + codigoObjetivo);
                            return true;
                        }
                    }
                    return false;
                })

                //recupera el primer índice de fila que cumple con las condiciones o devuelve -1 si no se encontró.
                .findFirst()
                .orElse(-1);

        if (posicionObjetivo == -1) {
            System.out.println("Objetivo no encontrado en la tabla.");
        }
        System.out.println(posicionObjetivo);
        return posicionObjetivo - 1;
    }


    public void actualizarObjetivo(String codigo, String nuevoCodigo, String nuevaDescripcion) {

        int posObjetivo = buscarObjetivoPos(codigo);
        List<WebElement> BtnsEditar = findElements(actualizarObjetivoBtnLocator);
        BtnsEditar.get(posObjetivo).click();
        type(nuevoCodigo, codigoActualizadoLocator);
        type(nuevaDescripcion, descripCionActualizadaLocator);
        click(btnactualizarObjetivoLocator);
    }
    public void cancelarActualizarObjetivo(String codigo, String nuevoCodigo, String nuevaDescripcion) {

        int posObjetivo = buscarObjetivoPos(codigo);
        List<WebElement> BtnsEditar = findElements(actualizarObjetivoBtnLocator);
        BtnsEditar.get(posObjetivo).click();
        type(nuevoCodigo, codigoActualizadoLocator);
        type(nuevaDescripcion, descripCionActualizadaLocator);
        click(cancelarActualizarLocator);
    }

    public void eliminarObjetivo(String codigo) {
        int posObjetivo = buscarObjetivoPos(codigo);
        List<WebElement> btnsEliminar = findElements(deleteObjectivoLocator);
        btnsEliminar.get(posObjetivo).click();
        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(alertDeleteObjLocator));
        click(confirmDeleteObjLocator);
    }

    public String confirMsgObjetivo() {

        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirMsgObjetivo));

        return getText(confirMsgObjetivo);
    }

    public String confirMSGAcualizarObjetivo() {

        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirMsgActualizar));

        return getText(confirMsgActualizar);
    }
    public boolean isDisplayeObjetivePage() {
        getEwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(objetivoLocator));
        return isDisplayed(objetivoLocator);
    }

    public String elementoAleatorio() {
            // Obtener la cantidad de filas en la tabla
            List<WebElement> filas = findElements(By.cssSelector("#tabla\\:j_idt89_data tr"));
            int numRows = filas.size();

            if (numRows > 1) { // Asegurarse de que haya al menos una fila con datos
                // Generar un índice aleatorio
                int randomIndex = (int) (Math.random() * (numRows - 1)) + 1;

                // Obtener el código y descripción del objetivo aleatorio
                WebElement fila = filas.get(randomIndex);
                List<WebElement> celdas = fila.findElements(By.tagName("td"));

                return getText(celdas.get(0));

            } return "";

        }






    }

