Feature: Deve retornar o usuario

  Background:
    * url "https://serverest.dev"

  Scenario Outline:  Delete simples
    * def hash = call read('postUsuarios.feature@novoUser')
    * def deleteUser = hash.response._id
    Given path "/usuarios/" + deleteUser
    And header Accept = 'application/json'
    And method DELETE
    Then status <HTTPCOde>
    * print response
    * match response.message == "<Message>"
      Examples:
        | Message                       | HTTPCOde |
        | Registro excluído com sucesso | 200      |

  Scenario Outline: Tenta Deletar User com email duplicado
    * def hash = call read('postUsuarios.feature@userExistente')
    * def deleteUser = hash.response._id
    Given path "/usuarios/" + deleteUser
    And header Accept = 'application/json'
    And method DELETE
    Then status <HTTPCOde>
    * print response
    * match response.message == "<Message>"
    Examples:
      | Message                  | HTTPCOde |
      | Nenhum registro excluído | 200      |