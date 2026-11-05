1. O que é entrada em um sistema computacional? Dê dois exemplos.

Entradas são dados ou instruções inseridas pelo usuário para o computador. Teclado, mouse.

2. Qual é a diferença entre processamento e saída?

O processamento é a fase em que os dados inseridos são computados e manipulados pelo computador. 
Saída é o resultado já exibido para o usuário por meio da interfacfe, que pode ser exibida em 
monitores.

3. Por que o valor digitado em um TextField é inicialmente tratado como texto?

    Um TextField mantém o padrão ASCII/Unicode, assim ele aceita a entrada de uma cadeia de 
caracteres, que são códigos interpretados pelo computador, e não como valores simples. Exemplo: o 5 
não é lido como cinco, mas como o código decimal 53 pelo padrão ASCII.

4. Qual é a finalidade de remember e mutableStateOf?

Esses componentes são componentes reativos. Remember guarda o valor em cache para acessar o dado em
memória de execução. MutableStateOf guarda o estado do valor, alterando de forma reativa assim que 
seu estado muda.

5. O que é um evento? Cite os eventos utilizados nesta aplicação.

Eventos capturam ações em tempo de execução, como cliques, mudanças, estados. onClick, onValueChange. 

6. O que significa recomposição no Jetpack Compose?

A recomposição no Jetpack Compose é o processo em que o compose reconstroi um componente apenas quando
seu estado foi alterado, ignorando os demais elementos que não sofreram alteração.

7. Qual é a responsabilidade da MainActivity neste projeto?

Iniciar a aplicação e exibir CalculadoraDescontroScreen.

8. Qual é a responsabilidade de CalculadoraDescontoScreen?

Construir os componentes dá tela, chamar os acionadores de estado para os campos e chamar as funções.

9. Por que calcularPrecoComDesconto foi colocada em outro arquivo?

Garantir que a lógica esteja separada permite um código desacoplado, mais simples e limpo. Também
faz com que a lógica não seja reativa a mudanças nos componentes, apenas executando quando chamada.

10. Qual é a vantagem de uma função de regra de negócio não depender do Compose?

Isso permite com que a estrutura lógica não esteja completamente relacionada as funções, permitindo 
o reuso do código, testes mais simples e implementações de código mais claras.