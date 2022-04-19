#language:es
@API-REST-USUARIO
Característica: funcionabilidad para validar usuarios dentro del API REQRES

  @Test01 @regre01
  Escenario: validar cantidad de registros
    Dado que configuro las cabecera
    Cuando mostrar el listado de usuarios
    Y validar codigo de respuesta "200"
    Entonces validar numero de registros

  @Test02 @regre01

  Escenario: Mostrar informacion del usuario
    Dado listar con usuario con id "5"
    Cuando mostrar la informacion del usuario
    Y validar codigo de respuesta "200"
    Entonces validar informacion de la consulta
      | codigo | email                    | nombre  | apellido |
      | 5      | charles.morris@reqres.in | Charles | Morris   |

  @Test03 @regre02
  Escenario: Mostrar usuario no registrado
    Dado listar con usuario con id "50"
    Y validar codigo de respuesta "404"

  @Test04 @regre02
  Escenario: Crear usuario
    Dado que no existe usuario registrado
    Cuando registro datos del usuario
      | nombre   | cargo      | codigo |
      | gustavo  | QA         | 201    |
      | Cuevita  | futbolista | 201    |
      | carrillo | futbolista | 201    |
    Y validar codigo de respuesta "201"
    Entonces muestro los usuario registro

  @Test05 @regre02
  Escenario: Actualizar usuario
    Dado que el usuario este registrado
    Cuando actualizar datos del usuario
      | id  | nombre  | puesto | codigo |
      | 580 | gustavo | Master | 200    |
    Y validar codigo de respuesta "200"
    Entonces muestro los usuario registro





