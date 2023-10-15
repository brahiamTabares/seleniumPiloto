Feature: Registrar un usuario en la aplicacion

    Scenario: Registrar un usuario en la aplicacon
       Given Estoy en la página de inicio de sesión
       And  hago click en el  boton Registrarse
       When Ingreso mi nombre completo, el nombre de usurio,una clave y la confirmo
       And  Hago Click en el boton Aceptar
       Then Me muestra un mensaje de Operación Completada




