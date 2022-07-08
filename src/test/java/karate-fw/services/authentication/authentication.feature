Feature: Deve logar e gerar o Token de Acesso

  Background:
    * url "https://serverest.dev"
    * def hd = read("classpath:support/config/headers.yaml")
    * def auth = read("classpath:features/authentication/payload/user.json")

    @Token
    Scenario: Login
      Given path "/login"
      And headers hd.header_auth
      And request auth
      When method POST
      Then status 200
      And print response.authorization
