Feature: Deve logar e gerar o Token de Acesso

  Background:
    * url "https://serverest.dev"
    * def hd = read("classpath:lojaVirtual/services/support/data/headers.yaml")
    * def auth = read("classpath:lojaVirtual/services/authentication/payload/user.json")

    @Token
    Scenario: Login
      Given path "/login"
      And headers hd.header
      And request auth
      When method POST
      Then status 200
      And print response.authorization
