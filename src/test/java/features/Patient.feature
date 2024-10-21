# language: pt

Funcionalidade: Registrar um Paciente
  Como um usuario
  Eu quero inserir um paciente no formulario
  Para cadastra-lo

  @campo_obrigatorio
  Esquema do Cenario: Validar se o campo paciente e obrigatorio
    Dado que nao preencha o campo paciente
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de campo obrigatorio

  @valor_valido
  Esquema do Cenario: Validar com paciente valido
    Dado que eu preencha o campo paciente
    E passe para o campo seguinte
    Entao o sistema não deve retornar nenhuma mensagem de erro