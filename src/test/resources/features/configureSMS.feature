Feature: Configurar el SMS en la  aplicacion SMS-Bulder

  Scenario: Configurar el SMS en la aplicacion

    Given Ya estoy registrado en el sms
    When Ingreso mi nombre de usuario "brahiam" y mi contraseña "1234" para ingresar al SMS1
    And Me encuentro en la pagina del SMS y selecciono una de las opciones del sms
    And Tengo un nombre al sms y una descripcion diligenciada
    Then visualizo que me encuentro en la pagina de objetivo despues de configurar el sms
