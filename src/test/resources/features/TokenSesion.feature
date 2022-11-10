#language:es
@API-REST-ASSURED
Característica: Ingreso al portal Web con autorizacion

  Antecedentes: Genero el token de sesion
    Dado que configuro las cabeceras del servicio
      | parametro       | valor                                              |
      | x-rapidapi-host | bravenewcoin.p.rapidapi.com                        |
      | x-rapidapi-key  | c8f042a2b0msh5ccc719e499ade9p1d3beejsne55a03735ed0 |
    Y que configuro el bodyrequest del servicio
      | audiencia                    | id_cliente                       | grant_type         |
      | https://api.bravenewcoin.com | oCdQoZoI96ERE9HY3sQ7JmbACfBf55RY | client_credentials |
    Y valido que la respuesta es "200"
    Y Guardo el token de sesion

  @Consumo-API-BS
  Escenario: mostrar el token
    Dado muestro el token de sesion


#  Escenario: Consumo del API Pokemon
#    Dado que configuro las cabeceras del servicio del api pokemon
#      | parametro       | valor                                              |
#      | Authorization   | c8f042a2b0msh5ccc719e499ade9p1d3beejsne55a03735ed0 |
#    Dado que configuro el bodyrequest del servicio
#      | audiencia                    | id_cliente                       | grant_type         |
#      | https://api.bravenewcoin.com | oCdQoZoI96ERE9HY3sQ7JmbACfBf55RY | client_credentials |
#    Y valido que la respuesta es "200"



