 Feature: Inicio de sesión
  Scenario: Usuario inicia sesión con exito
  Given El usuario está en la página de inicio de sesión
  When El usuario ingresa su nombre de usuario "nombredeusuario" y contraseña "contraseña"
  Then El usuario debería estar en la página de inicio
