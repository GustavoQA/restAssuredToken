#language:es
@API-REST-RECURSO
Característica: esto es una funcionabilidad para listar recursos
@Get_listar_Recursos
  Escenario: validar lista de recursos
    Dado que listo los recursos
    Cuando muestro el listado de recursos
    Y valido con codigo de respuesta "200"
    Entonces valido el numero de recursos
@Get_Mostrar_Recursos
  Escenario: Mostrar recurso
    Dado listar con recurso con id "2"
    Cuando mostrar la informacion del recurso
    Y valido con codigo de respuesta "200"
    Entonces validar informacion de la consulta del recurso
      | nombre       | año  | color   |
      | fuchsia rose | 2001 | #C74375 |
  @Get_Recurso_fallido
  Escenario: recurso no registrado
    Dado listar con recurso con id "50"
    Y valido con codigo de respuesta "404"

