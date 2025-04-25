# Implementação do AES-128 em Java

## Visão Geral

Este repositório contém uma implementação básica do Advanced Encryption Standard (AES) com chaves de 128 bits em Java. Este projeto foi criado puramente para fins educacionais e como uma exploração pessoal do fascinante algoritmo AES.

⚠️ **AVISO IMPORTANTE DE SEGURANÇA**: Este código NÃO é destinado para uso em produção ou para proteger dados sensíveis. Foi desenvolvido apenas para aprendizado e experimentação. Para necessidades criptográficas do mundo real, por favor, utilize bibliotecas e frameworks criptográficos estabelecidos.

## O que é AES?

O Advanced Encryption Standard (AES) é um algoritmo de criptografia simétrica, o que significa que usa a mesma chave tanto para o processo de criptografia quanto para o de descriptografia. Características principais incluem:

* Originalmente selecionado pelo NIST em 2001 como substituto do DES
* Opera em blocos de dados de tamanho fixo (128 bits) usando chaves de 128, 192 ou 256 bits
* Realiza um número específico de rodadas de processamento (10 rodadas para chaves de 128 bits, 12 para chaves de 192 bits e 14 para chaves de 256 bits)
* Amplamente adotado pelo seu equilíbrio entre segurança, eficiência e flexibilidade

O AES se tornou o padrão da indústria para proteger informações sensíveis em várias aplicações, incluindo transações financeiras, comunicações governamentais e proteção de dados.

## Como o AES Funciona

O AES organiza os dados em uma matriz bidimensional chamada "estado" e os processa através de várias transformações em múltiplas rodadas. Cada rodada (exceto a final) consiste em quatro operações principais:

1. **AddRoundKey**: Combina cada byte do estado com um byte correspondente de uma chave de rodada derivada da chave de criptografia principal
2. **SubBytes**: Aplica uma substituição não-linear a cada byte usando uma tabela de substituição (S-box)
3. **ShiftRows**: Desloca as linhas do estado por diferentes deslocamentos:
    * Primeira linha: sem alteração
    * Segunda linha: deslocada 1 posição à esquerda
    * Terceira linha: deslocada 2 posições à esquerda
    * Quarta linha: deslocada 3 posições à esquerda
4. **MixColumns**: Combina bytes dentro de cada coluna usando uma transformação linear

A rodada final pula a etapa MixColumns.

## Objetivos do Projeto

Esta implementação foi criada com os seguintes objetivos:

* Aprofundar o entendimento de conceitos de criptografia simétrica
* Explorar os mecanismos internos do algoritmo AES
* Implementar as transformações principais do AES do zero
* Criar uma demonstração funcional de criptografia e descriptografia

## Limitações

Esta implementação:
* Suporta apenas chaves de 128 bits
* Usa modo de operação básico
* Não possui mecanismos adequados de padding
* Não implementa as melhores práticas de segurança
* Não foi auditada ou testada contra ataques criptográficos

## Agradecimentos

Este projeto foi inspirado pelo meu interesse em algoritmos criptográficos e pelos elegantes princípios de design por trás do AES.