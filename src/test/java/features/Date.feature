# language: pt
Funcionalidade: Informar a data de nascimento de um paciente
  Como um usuario
  Eu quero cadastrar a data de nascimento de um paciente
  Para cadastra-lo

  @ct01_campo_obrigatorio
  Esquema do Cenario: Validar se o campo data e obrigatorio
    Dado que eu preencha o campo data com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      | valor |           mensagem_esperada             |
      | ""    |   " Esta pergunta é obrigatória"        |

  @ct02_data_valida
  Esquema do Cenario: Validar o campo data inserindo dados validos
    Dado que eu preencha o campo data com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |     valor    |            mensagem_esperada            |
      | "22/04/2000" |                    ""                   |

  @ct03_data_invalida_passado
  Esquema do Cenario: Validar o campo data inserindo dados passados incorretos
    Dado que eu preencha o campo data com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |     valor    |    mensagem_esperada    |
      | "01/01/1500" |     " Data inválida"    |

  @ct04_data_invalida_futuro
  Esquema do Cenario: Validar o campo data inserindo dados futuros
    Dado que eu preencha o campo data com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |     valor    |    mensagem_esperada    |
      | "01/01/2050" |     " Data inválida"    |

  @ct05_menor_de_dezoito_anos
  Esquema do Cenario: Validar o campo data inserindo dados passados incorretos
    Dado que eu preencha o campo data com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |     valor    |    mensagem_esperada    |
      | "22/05/2021" |     " Data inválida"    |