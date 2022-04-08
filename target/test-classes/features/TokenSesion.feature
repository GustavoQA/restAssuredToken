#language:es
@AUTENTICACION
Característica: autenticacion para ingreso al portal

  @POST-TOKEN
  Escenario: generacion de token de sesion
    Dado que configuro las cabeceras del servicio
      | parametro       | valor                                              |
      | x-rapidapi-host | bravenewcoin.p.rapidapi.com                        |
      | x-rapidapi-key  | c8f042a2b0msh5ccc719e499ade9p1d3beejsne55a03735ed0 |
    Dado que configuro el bodyrequest del servicio
      | audiencia                    | id_cliente                       | grant_type         |
      | https://api.bravenewcoin.com | oCdQoZoI96ERE9HY3sQ7JmbACfBf55RY | client_credentials |
    Y valido que la respuesta es "200"
    Entonces Guardo el token de sesion
