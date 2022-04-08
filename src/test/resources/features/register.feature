#language:es
@API-REST-REGISTER
Característica: funcionabilidad para validar registro de usuario dentro del API REQRES

  @Escenario:01
  Escenario: Registrar usuario
    Dado que registros los usuarios
      | correo             | clave  | codigo |
      | eve.holt@reqres.in | pistol | 200    |
      | eve.holt@reqres.in | pistol | 200    |
      | eve.holt@reqres.in | pistol | 200    |

    Y validar codigo de respuesta registro "200"
    Entonces muestro los usuario registrados

