# Conversor de Moeda

Um simples conversor de moedas que utiliza uma API externa para realizar as conversões e armazena logs das últimas operações realizadas.

## 🧾 Descrição do Projeto

Este projeto tem como objetivo facilitar a conversão entre diferentes moedas de forma rápida e eficiente. Além de converter, ele mantém um log com o histórico das últimas conversões realizadas.


## ✨ Funcionalidades

- Conversão entre diferentes moedas com base em uma API externa.
- Criação e armazenamento de logs com o histórico das últimas conversões.

## 🔧 Acesso ao Projeto

1. Clone o repositório:

```
https://github.com/lsguilherme/challenge-conversor-de-moeda.git
```
2. Navegue até o arquivo:
```
src/main/java/config/HttpService.java
```
3. Substitua a linha:

```
var key = System.getenv("key");
```

por:

```
var key = "sua key";
```

4. Vá até a classe
```
src/main/java/Main.java
```
e rode o método main.