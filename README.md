<div align="center">
  <h1>🧩 Sudoku Game</h1>
  <p>Um jogo clássico de Sudoku desenvolvido em Java com opções de interface gráfica e via terminal.</p>

  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge" alt="Swing"/>

</div>

---

## 📖 Sobre o Projeto

Este projeto é uma implementação completa do clássico jogo **Sudoku** em Java. O diferencial desta aplicação é que ela fornece duas maneiras distintas de jogar:
1. **Via Terminal (CLI):** Utilizando a classe `Main.java`, onde as interações são feitas através do console com menus interativos.
2. **Interface Gráfica (GUI):** Utilizando a classe `UIMain.java`, que constrói uma interface utilizando a biblioteca `javax.swing` para uma melhor experiência do usuário.

## ✨ Funcionalidades

- **Início rápido:** O jogo pode ser iniciado passando o estado inicial do tabuleiro através de argumentos.
- **Entrada de dados segura:** Validação e controle dos números preenchidos para seguir as regras do Sudoku clássico.
- **Verificação de Status:** O jogo suporta verificar a qualquer momento se o tabuleiro contém erros ou se já foi finalizado.
- **Espaços Fixos:** Diferenciação visual ou em código de números que já vieram preenchidos na configuração inicial e não podem ser apagados ou alterados.
- **Múltiplas Interfaces:** O projeto suporta tanto entrada por linha de comando (`Main.java`) quanto uma interface visual baseada em Java Swing (`UIMain.java`).

## 📁 Estrutura do Projeto

O código está estruturado para ter uma separação clara de responsabilidades:

```text
src/
├── model/        # Classes de entidade (Board, Space, etc.)
├── service/      # Regras de negócio e lógicas do jogo
├── ui/           # Componentes visuais para o modo GUI (Java Swing)
├── util/         # Classes utilitárias e construtores de templates
├── Main.java     # Ponto de entrada do jogo pelo Console
└── UIMain.java   # Ponto de entrada do jogo pela Interface Gráfica
```

## 🚀 Como Executar

### Pré-requisitos

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) (Versão 17 ou superior recomendada)
- Sua IDE de preferência (IntelliJ IDEA, Eclipse, VSCode, etc.)

### Passos para rodar

1. **Clone ou abra o projeto na sua IDE**:
   Abra a pasta do projeto `sudokuGame` com a IDE para que ela reconheça a pasta `src` e as classes.

2. **Para jogar pelo Terminal:**
   - Acesse o arquivo `src/Main.java`.
   - Configure os argumentos de programa, mapeando a posição o seu tabuleiro inicial no formato esperado (`col,row; expected,fixed`) ou inicie com a matriz tratada.
   - Execute o método `main()`. Irá aparecer um menu no console com as opções: Iniciar Novo Jogo, Colocar Número, Visualizar, etc.

3. **Para jogar via Interface Gráfica (Swing):**
   - Acesse o arquivo `src/UIMain.java`.
   - Se necessário passe os argumentos do tabuleiro que define o seu jogo.

   Argumentos: 0,0;4,false 1,0;7,false 2,0;9,true 3,0;5,false 4,0;8,true 5,0;6,true 6,0;2,true 7,0;3,false 8,0;1,false 0,1;1,false 1,1;3,true 2,1;5,false 3,1;4,false 4,1;7,true 5,1;2,false 6,1;8,false 7,1;9,true 8,1;6,true 0,2;2,false 1,2;6,true 2,2;8,false 3,2;9,false 4,2;1,true 5,2;3,false 6,2;7,false 7,2;4,false 8,2;5,true 0,3;5,true 1,3;1,false 2,3;3,true 3,3;7,false 4,3;6,false 5,3;4,false 6,3;9,false 7,3;8,true 8,3;2,false 0,4;8,false 1,4;9,true 2,4;7,false 3,4;1,true 4,4;2,true 5,4;5,true 6,4;3,false 7,4;6,true 8,4;4,false 0,5;6,false 1,5;4,true 2,5;2,false 3,5;3,false 4,5;9,false 5,5;8,false 6,5;1,true 7,5;5,false 8,5;7,true 0,6;7,true 1,6;5,false 2,6;4,false 3,6;2,false 4,6;3,true 5,6;9,false 6,6;6,false 7,6;1,true 8,6;8,false 0,7;9,true 1,7;8,true 2,7;1,false 3,7;6,false 4,7;4,true 5,7;7,false 6,7;5,false 7,7;2,true 8,7;3,false 0,8;3,false 1,8;2,false 2,8;6,true 3,8;8,true 4,8;5,true 5,8;1,false 6,8;4,true 7,8;7,false 8,8;9,false
   
 - Execute o método `main()`. Uma janela gráfica do Java se abrirá com o tabuleiro desenhado.

---

### 🛠️ Contribuindo 
Sinta-se à vontade para enviar um Pull Request com melhorias de código, adição de novas funcionalidades como **Gerador de Tabuleiros Aleatório**, etc.

### 📝 Licença
Este projeto é de uso livre para aprendizado e entretenimento.
