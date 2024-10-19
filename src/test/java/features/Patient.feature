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