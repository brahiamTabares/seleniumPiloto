#languaje:es
Feature: Iniciar sesion

  Scenario: Iniciar sesión con credenciales válidas
    Given Estoy en la página de inicio de sesión
    When Ingreso mi nombre de usuario  y mi contraseña
    And   hago click en el boton Ingresar
    Then Me muestra la pantalla principal del SMS-Builder


