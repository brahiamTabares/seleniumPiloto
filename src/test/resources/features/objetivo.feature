Feature: Objetivos SMS

  Scenario: Creación de objetivo exitoso
    Given Ya estoy registrado en el sms
    When Ingreso mi nombre de usuario "brahiam" y mi contraseña "1234" para ingresar al SMS1
    And Me encuentro en la pagina del SMS y selecciono una de las opciones del sms3
    And ingreso los datos del codigo y descripcion y creo el objetivo
    Then muestra mensaje de operación completada y objetivo en tabla


  Scenario: Actualizar objetivo exitoso
    Given Ya estoy registrado en el sms
    When Ingreso mi nombre de usuario "brahiam" y mi contraseña "1234" para ingresar al SMS1
    And Me encuentro en la pagina del SMS y selecciono una de las opciones del sms3
    And Busco el objetivo ,ingreso los datos nuevos del objetivo
    Then muestra mensaje de operación completada y el nuevo objetivo en tabla

  Scenario: Cancelar Actualizar objetivo
    Given Ya estoy registrado en el sms
    When Ingreso mi nombre de usuario "brahiam" y mi contraseña "1234" para ingresar al SMS1
    And Me encuentro en la pagina del SMS y selecciono una de las opciones del sms3
    And Busco el objetivo ,ingreso los datos nuevos y cancelo el actualizar
    Then muestra mensaje de operación cancelada y el objetivo en tabla

  Scenario: Eliminar objetivo exitoso
    Given Ya estoy registrado en el sms
    When Ingreso mi nombre de usuario "brahiam" y mi contraseña "1234" para ingresar al SMS1
    And Me encuentro en la pagina del SMS y selecciono una de las opciones del sms3
    And Busco el objetivo y elimino el objetivo
    Then muestra mensaje de operación completada y busca el objetivo en la tabla;