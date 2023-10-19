Feature: Objetivos SMS

  Scenario: Creación de objetivo exitoso
    Given Estoy en la página SMS-Builder
    And   Ingreso mi nombre de usuario  y mi contraseña para ingresar al SMS
    When ingreso los datos del codigo y descripcion y creo el objetivo
    Then muestra mensaje de operación completada y objetivo en tabla


  Scenario: Actualizar objetivo exitoso
    Given Estoy en la página SMS-Builder
    And   Ingreso mi nombre de usuario  y mi contraseña para ingresar al SMS
    When Busco el objetivo ,ingreso los datos nuevos del objetivo
    Then muestra mensaje de operación completada y el nuevo objetivo en tabla

  Scenario: Cancelar Actualizar objetivo
    Given Estoy en la página SMS-Builder
    And   Ingreso mi nombre de usuario  y mi contraseña para ingresar al SMS
    When Busco el objetivo ,ingreso los datos nuevos y cancelo el actualizar
    Then muestra mensaje de operación cancelada y el objetivo en tabla

  Scenario: Eliminar objetivo exitoso
    Given Estoy en la página SMS-Builder
    And   Ingreso mi nombre de usuario  y mi contraseña para ingresar al SMS
    When Busco el objetivo y elimino el objetivo
    Then muestra mensaje de operación completada y busca el objetivo en la tabla;