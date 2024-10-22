# language: pt

Funcionalidade: Registrar um Paciente
  Como um usuario
  Eu quero inserir um paciente no formulario
  Para cadastra-lo

  @campo_obrigatorio
  Esquema do Cenario: Validar se o campo paciente e obrigatorio
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      | valor | mensagem_esperada                       |
      | ""    | " Esta pergunta é obrigatória"          |

  @valor_valido
  Esquema do Cenario: Validar com paciente valido
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      | valor                    | mensagem_esperada                       |
      | "Juliano Albuquerque"    | ""                                      |

  @repeticao_de_caracteres
  Esquema do Cenario:  Cadastrar paciente com sequencia de caracteres iguais
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      | valor                    | mensagem_esperada                                              |
      | "AAAAAAAAAAAA"           | " O nome do paciente informado não atende o padrão esperado."  |

  @valor_invalido
  Esquema do Cenario: Cadastrar paciente com valores invalidos
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      | valor                    | mensagem_esperada                                              |
      | "123 Ronaldin"           | " O nome do paciente informado não atende o padrão esperado."  |

  @maximo_de_caracteres
  Esquema do Cenario: Cadastrar um paciente com o limite de caracteres permitidos
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      | valor                                                                                             | mensagem_esperada  |
      | "pneumoultramicroscopicossilicovulcanoconióticoanticonstitucionalissimamenteextraordinariamente"  |       ""           |

  @maximo_de_caracteres_excedidos
  Esquema do Cenario: Cadastrar um paciente com uma quantidade de caracteres acima do limite
    Dado que eu preencha o campo paciente com <valor>
    E passe para o campo seguinte
    Entao o sistema deve retornar uma mensagem de <mensagem_esperada>

    Exemplos:
      | valor                                                                                                |                      mensagem_esperada                             |
      | "pneumoultramicroscopicossilicovulcanoconióticoanticonstitucionalissimamenteextraordinariamente123"  | " O nome do paciente informado não atende o padrão esperado."      |
