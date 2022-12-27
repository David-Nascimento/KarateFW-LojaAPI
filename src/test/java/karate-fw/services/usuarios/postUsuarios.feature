Feature: Criar novo usuario

  Background:
    * url serverest
    * def hder = read("classpath:karate-fw/services/support/data/headers.yaml")
    * def fakerObj = new faker()
    * def fName = fakerObj.name().firstName()
    * def lName = fakerObj.name().lastName()
    * def mailId = fName+'.'+lName+'@test.com'

      @novoUser
    Scenario: Cria um novo usuario simples
      Given path "/usuarios"
      And headers hder.header
      * def user =
      """
      {
        "nome": "#(fName)",
        "email": "#(mailId)",
        "password": "teste",
        "administrador": "true"
      }
      """
      And request user
      When method POST
      Then status 201
      * print response
      * match response.message == "Cadastro realizado com sucesso"
      * match response._id == "#string"


        @userExistente
  Scenario: Usuario com email já cadastrado
    Given path "/usuarios"
    * def user =
      """
      {
        "nome": "Pernalonga Alfredo",
        "email": "perninha@qa.com.br",
        "password": "lola",
        "administrador": "false"
      }
      """
    And request user
    When method POST
    Then status 400
    * print response
    * match response.message == "Este email já está sendo usado"