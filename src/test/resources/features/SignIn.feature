#languaje:es
Feature: Iniciar sesion

  Scenario: Iniciar sesión correctamente
    Given Estoy en la página SMS-Builder  para sesión
    When Ingreso mi nombre de usuario  y mi contraseña para ingresar al SMS
    Then Me muestra la pantalla principal del SMS-Builder y valido que se observe el sms


