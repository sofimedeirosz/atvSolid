# Atividade SOLID em Java

Exemplo simples de um sistema de delivery que aplica os cinco princípios SOLID.

## O que o programa faz

O programa cria um pedido com pizza, hambúrguer e bebida, exibe o total de R$ 73,00 e salva as informações em `pedido_1.txt`. Depois, demonstra três formas de pagamento, gera um relatório simples, marca o pedido como entregue e simula notificações por Email, SMS e WhatsApp.

Os pagamentos e as notificações são apenas mensagens no console. Cada pagamento apresentado é uma alternativa para o mesmo valor. Os preços são armazenados em centavos.

## Onde cada princípio aparece

- **SRP — Responsabilidade única:** `CriadorPedido` cria, `RepositorioPedido` salva e `ExibidorPedido` exibe o pedido. Essas classes estão em `Pedidos.java`.
- **OCP — Aberto para extensão:** em `Pagamentos.java`, cartão, PIX e dinheiro implementam `Pagamento`. Uma nova forma, como boleto, pode ser adicionada sem alterar `ProcessadorPagamento` ou as formas existentes. Basta fornecer a nova implementação ao processador.
- **LSP — Substituição de Liskov:** em `Produtos.java`, `Pizza`, `Hamburguer` e `Bebida` podem ser usados como `Produto`. Todos fornecem nome e preço não negativo em centavos, mantendo o cálculo do pedido funcionando.
- **ISP — Segregação de interfaces:** `GestorPedidos`, `GeradorRelatorio`, `GestorEntregas` e `Notificador` possuem operações específicas. Cada classe implementa somente o contrato que utiliza.
- **DIP — Inversão de dependência:** em `Notificacoes.java`, `SistemaDelivery` recebe a interface `Notificador` pelo construtor. A escolha entre Email, SMS e WhatsApp fica em `Main.java`.

## Arquivos

- `Main.java`: executa a demonstração.
- `Produtos.java`: produto principal e subclasses.
- `Pedidos.java`: dados, criação, armazenamento e exibição dos pedidos.
- `Pagamentos.java`: formas e processamento de pagamento.
- `Operacoes.java`: interfaces e serviços de relatórios e entregas.
- `Notificacoes.java`: canais de notificação e sistema desacoplado.

As classes estão no mesmo pacote padrão e são compiladas juntas. Somente `Main` é pública; por isso, os arquivos podem agrupar classes relacionadas.

## Entrega

Envie os seis arquivos `.java` e este `README.md` para o repositório no GitHub. Os arquivos `.class` e `pedido_1.txt` são gerados durante a execução e não precisam ser enviados. Depois, entregue o link do repositório no Classroom.

## Referências

- Robert C. Martin. [The Single Responsibility Principle](https://blog.cleancoder.com/uncle-bob/2014/05/08/SingleReponsibilityPrinciple.html), 2014.
- Robert C. Martin. [The Open Closed Principle](https://blog.cleancoder.com/uncle-bob/2014/05/12/TheOpenClosedPrinciple.html), 2014.
- Robert C. Martin. [Solid Relevance](https://blog.cleancoder.com/uncle-bob/2020/10/18/Solid-Relevance.html), 2020.
- Barbara Liskov e Jeannette Wing. [A Behavioral Notion of Subtyping](https://www.cs.cmu.edu/~wing/publications/LiskovWing94.pdf), 1994.

Os exemplos de código foram elaborados para esta atividade com base nesses princípios.
