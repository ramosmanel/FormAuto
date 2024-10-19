# language: pt
Funcionalidade: Informar a data de nascimento de um paciente
  Como um usuario
  Eu quero cadastrar a data de nascimento de um paciente
  Para cadastra-lo

  @campo_obrigatorio
  Esquema do Cenario: Validar se o campo data e obrigatorio
    Dado que nao preencha o campo data
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de campo obrigatorio