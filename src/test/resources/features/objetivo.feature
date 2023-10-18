Feature: Objetivos SMS

  Scenario: Creación de objetivo exitoso
    Given Estoy en la página SMS-Builder
    And   Ingreso mi nombre de usuario  y mi contraseña para ingresar al SMS
    When ingreso los datos del codigo y descripcion y creo el objetivo
    Then muestra mensaje de operación completada y objetivo en tabla