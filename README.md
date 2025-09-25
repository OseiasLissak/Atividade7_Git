# 🚀 Atividades Java: Fundamentos de POO e Design Patterns

[![Java 17+](https://img.shields.io/badge/Java-17%2B-blue.svg)](https://www.java.com/)
[![Licença](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

Este repositório contém uma coleção de **8 exercícios práticos em Java**, focados em demonstrar e aplicar conceitos essenciais da **Programação Orientada a Objetos (POO)** e padrões de design, como o **Strategy**.

---

## 🎯 Conceitos Chave por Exercício

| Exercício | Conceito Principal | Classes Chave |
| :---: | :--- | :--- |
| **1 & 2** | **Encapsulamento** e **Validação** | `Produto.java` (Getters/Setters com validação de preço e desconto) |
| **3** | **Herança** e **Polimorfismo** | `Funcionario`, `Gerente`, `Desenvolvedor` e `List<Funcionario>` |
| **4** | **Interface** e **Polimorfismo** | `IMeioTransporte`, `Carro`, `Bicicleta`, `Trem` |
| **5** | **Abstração** e **Polimorfismo** | `FormaPagamento (abstract)`, `CartaoCredito`, `SimuladorPagamentos` |
| **6** | **Imutabilidade** e **Objeto de Valor** | `Dinheiro (final)`, `Carrinho (retorna novo objeto)` |
| **7** | **Generics** e **Interfaces Genéricas** | `IRepository<T, ID>`, `InMemoryRepository` |
| **8** | **Padrão Strategy** e **Lambdas** | `CalculoFreteStrategy` (injetável no `Pedido`), `SimuladorFrete` |

---

## ⚙️ Como Executar os Códigos

Todos os exercícios incluem uma classe principal (geralmente nomeada **`Simulador...`**, **`Programa...`** ou **`Main`**) que demonstra o fluxo e as validações do código.

### 1. Pré-requisitos

Certifique-se de ter o **Java Development Kit (JDK) 17 ou superior** instalado.

### 2. Execução via IDE (Recomendado)

A forma mais fácil de executar o código é através de uma IDE (IntelliJ, Eclipse, VS Code, etc.):

1.  **Clone o Repositório:** Carregue o projeto na sua IDE.
2.  **Selecione o Teste:** Navegue até o arquivo principal do exercício que deseja testar (ex: `exercicio8/SimuladorFrete.java`).
3.  **Execute:** Clique com o botão direito no arquivo e escolha a opção **"Run 'NomeDaClasse.main()'"**.

### 3. Execução via Linha de Comando (Manual)

Se preferir utilizar o terminal:,

#### A. Compilação (a partir do diretório raiz)

```bash
# Compila todos os arquivos .java e gera os arquivos .class no diretório 'out'
javac -d out $(find src -name "*.java")
