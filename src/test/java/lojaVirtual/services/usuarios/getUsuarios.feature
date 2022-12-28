Feature: Deve retornar o usuario
  
  Background: 
    * url "https://serverest.dev"
    * def user = call read('postUsuarios.feature@novoUser')

    @user
  Scenario: Busca simples
    Given path "/usuarios"
    And header Accept = 'application/json'
    * def lista =
    """
      {
        "nome": "Fulano da Silva",
        "email": "patolino955@qa.com.br",
        "password": "teste",
        "administrador": "true"
      }
    """
   And params lista + user._id
   And method GET
   And status 200
   * print response
   * def userId = $.usuarios[0]._id
   * print userId