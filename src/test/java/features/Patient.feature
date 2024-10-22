# language: pt

Funcionalidade: Registrar um Paciente
  Como um usuario
  Eu quero inserir um paciente no formulario
  Para cadastra-lo

  @ct01_campo_obrigatorio
  Esquema do Cenario: Validar se o campo paciente e obrigatorio
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      | valor | mensagem_esperada                       |
      | ""    | " Esta pergunta é obrigatória"          |

  @ct02_valor_valido
  Esquema do Cenario: Validar com paciente valido
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |         valor            | mensagem_esperada                       |
      | "Juliano Albuquerque"    | ""                                      |

  @ct03_repeticao_de_caracteres
  Esquema do Cenario:  Cadastrar paciente com sequencia de caracteres iguais
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |          valor           | mensagem_esperada                                              |
      | "AAAAAAAAAAAA"           | " O nome do paciente informado não atende o padrão esperado."  |

  @ct04_valor_invalido
  Esquema do Cenario: Cadastrar paciente com valores invalidos
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |         valor            | mensagem_esperada                                              |
      | "123 Ronaldin"           | " O nome do paciente informado não atende o padrão esperado."  |

  @ct05_maximo_de_caracteres
  Esquema do Cenario: Cadastrar um paciente com o limite de caracteres permitidos
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |                                     valor                                                         | mensagem_esperada  |
      | "pneumoultramicroscopicossilicovulcanoconióticoanticonstitucionalissimamenteextraordinariamente"  |       ""           |

  @ct06_maximo_de_caracteres_excedidos
  Esquema do Cenario: Cadastrar um paciente com uma quantidade de caracteres acima do limite
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |                                         valor                                                        |                      mensagem_esperada                             |
      | "pneumoultramicroscopicossilicovulcanoconióticoanticonstitucionalissimamenteextraordinariamente123"  | " O nome do paciente informado não atende o padrão esperado."      |

  @ct07_nome_sem_sobrenome
  Esquema do Cenario: Cadastrar um paciente informando apenas o nome
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |   valor    |                      mensagem_esperada                             |
      |   "Jorge"  | " O nome do paciente informado não atende o padrão esperado."      |

  @ct08_nome_iniciando_com_espacos
  Esquema do Cenario: Cadastrar um paciente iniciando seu nome com um espaço
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |     valor    |                      mensagem_esperada                             |
      |   " Jorgue"  | " O nome do paciente informado não atende o padrão esperado."      |

  @ct09_nome_composto_apenas_com_espacos
  Esquema do Cenario: Cadastrar um paciente com o nome composto apenas por espacos
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      |     valor    |                      mensagem_esperada                             |
      |   "       "  | " O nome do paciente informado não atende o padrão esperado."      |
