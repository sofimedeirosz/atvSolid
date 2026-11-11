import java.util.List;

// ISP: interfaces pequenas para responsabilidades diferentes.
// A interface de notificações está em Notificacoes.java.
interface GestorPedidos {
    Pedido criar(int numero, List<Produto> produtos);
}

interface GeradorRelatorio {
    String gerar(List<Pedido> pedidos);
}

interface GestorEntregas {
    void entregar(Pedido pedido);
}

class RelatorioPedidos implements GeradorRelatorio {
    @Override
    public String gerar(List<Pedido> pedidos) {
        return "Quantidade de pedidos: " + pedidos.size();
    }
}

class ControleEntregas implements GestorEntregas {
    @Override
    public void entregar(Pedido pedido) {
        pedido.marcarComoEntregue();
    }
}
