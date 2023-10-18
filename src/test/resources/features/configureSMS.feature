Feature: Configurar el SMS en la  aplicacion SMS-Bulder

  Scenario: Configurar el SMS en la aplicacion

    Given Estoy en la página SMS-Builder
    And  Ingreso mi nombre de usuario  y mi contraseña para ingresar al SMS
    And Me encuentro en la pagina del SMS y selecciono una de las opciones del sms
    When Tengo un nombre al sms y una descripcion diligenciada
    Then visualizo que me encuentro en la pagina de objetivo despues de configurar el sms
