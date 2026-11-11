import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // LSP: os três tipos podem ser usados como Produto.
        List<Produto> produtos = List.of(
            new Pizza(), new Hamburguer(), new Bebida()
        );

        // SRP: criar, salvar e exibir são responsabilidades separadas.
        GestorPedidos criador = new CriadorPedido();
        Pedido pedido = criador.criar(1, produtos);
        RepositorioPedido repositorio = new RepositorioPedido();
        repositorio.salvar(pedido);
        new ExibidorPedido().exibir(pedido);

        // OCP: simula três alternativas de pagamento para o mesmo valor.
        System.out.println("\nSimulações de pagamento:");
        ProcessadorPagamento processador = new ProcessadorPagamento();
        List<Pagamento> formas = List.of(
            new Cartao(), new Pix(), new Dinheiro()
        );
        for (Pagamento forma : formas) {
            processador.processar(forma, pedido.getTotalCentavos());
        }

        // ISP: cada serviço utiliza uma interface específica.
        GeradorRelatorio relatorio = new RelatorioPedidos();
        System.out.println("\n" + relatorio.gerar(List.of(pedido)));
        GestorEntregas entregas = new ControleEntregas();
        entregas.entregar(pedido);
        repositorio.salvar(pedido);
        System.out.println("Status: " + pedido.getStatus());

        // DIP: o sistema recebe a interface, sem criar um canal concreto.
        System.out.println("\nSimulações de notificação:");
        List<Notificador> canais = List.of(
            new Email(), new SMS(), new WhatsApp()
        );
        for (Notificador canal : canais) {
            SistemaDelivery sistema = new SistemaDelivery(canal);
            sistema.notificarPedido(pedido);
        }
    }
}
