Conversor de Moedas em Java (com API e Arquivo JSON)
🪙 Conversor de Moedas — Projeto Java

Este projeto implementa um conversor de moedas em Java, utilizando uma API de taxas de câmbio em tempo real.
O sistema oferece um menu interativo no console, permitindo converter moedas, visualizar cotações e gerar arquivos JSON com os valores usados.

O projeto faz parte de um desafio prático de programação que envolve:

Requisições HTTP

Consumo de API

Manipulação de JSON com Gson

Tratamento de dados financeiros

Organização de tarefas com Trello

Geração de arquivo JSON

🚀 Tecnologias utilizadas

Java 17+

HttpClient (Java nativo)

Gson — para leitura e escrita de JSON

ExchangeRate API (ou similar)

Trello para organização das tarefas

📡 API utilizada

A API consultada retorna as taxas de câmbio atualizadas:

https://v6.exchangerate-api.com/v6/SUA_CHAVE_AQUI/latest/USD


Ela retorna um JSON como:

{
  "conversion_rates": {
    "USD": 1,
    "EUR": 0.92,
    "BRL": 5.12,
    "JPY": 151.22
  }
}

🧠 Funcionalidades do projeto
✔️ 1. Conversão de moedas em tempo real

O usuário escolhe um tipo de conversão no menu:

USD → BRL

BRL → USD

EUR → BRL

GBP → USD

ARS → BRL

JPY → USD

…mínimo de 6 conversões

Cada conversão usa a taxa atual da API.

✔️ 2. Listagem das cotações usadas

A aplicação lista apenas as moedas usadas nas conversões:

"USD": 1,
"BRL": 5.12,
"EUR": 0.92,
"GBP": 0.78,
"ARS": 870.50,
"JPY": 151.22

✔️ 3. Geração de arquivo cotacoes.json

O programa cria automaticamente um arquivo contendo as cotações usadas:

{
  "USD": 1,
  "BRL": 5.12,
  "EUR": 0.92,
  "GBP": 0.78,
  "ARS": 870.5,
  "JPY": 151.22
}

✔️ 4. Menu interativo via console

Exemplo:

1 - Converter USD → BRL
2 - Converter BRL → USD
...
7 - Listar cotações usadas
8 - Gerar arquivo cotacoes.json
0 - Sair

🧑‍💻 Autor

Projeto desenvolvido por Carlos Gleyson Vieira, como parte de um desafio prático de programação Java.

Este projeto é livre para estudo e modificação.
