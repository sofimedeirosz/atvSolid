import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class Pedido {
    private final int numero;
    private final List<Produto> produtos;
    private String status = "recebido";

    public Pedido(int numero, List<Produto> produtos) {
        if (numero <= 0 || produtos == null || produtos.isEmpty()) {
            throw new IllegalArgumentException("Pedido inválido.");
        }
        this.numero = numero;
        this.produtos = List.copyOf(produtos);
    }

    public int getNumero() {
        return numero;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public int getTotalCentavos() {
        int total = 0;
        for (Produto produto : produtos) {
            total += produto.getPrecoCentavos();
        }
        return total;
    }

    public String getStatus() {
        return status;
    }

    public void marcarComoEntregue() {
        status = "entregue";
    }
}

// SRP: esta classe é responsável pela criação dos pedidos.
class CriadorPedido implements GestorPedidos {
    @Override
    public Pedido criar(int numero, List<Produto> produtos) {
        return new Pedido(numero, produtos);
    }
}

// SRP: esta classe é responsável pelo armazenamento em arquivo.
class RepositorioPedido {
    public void salvar(Pedido pedido) throws IOException {
        List<String> linhas = new ArrayList<>();
        linhas.add("Pedido: " + pedido.getNumero());
        linhas.add("Status: " + pedido.getStatus());
        for (Produto produto : pedido.getProdutos()) {
            linhas.add(produto.getNome() + ": "
                + produto.getPrecoCentavos() + " centavos");
        }
        linhas.add("Total: " + pedido.getTotalCentavos() + " centavos");
        Path arquivo = Path.of("pedido_" + pedido.getNumero() + ".txt");
        Files.write(arquivo, linhas, StandardCharsets.UTF_8);
    }
}

// SRP: esta classe é responsável pela exibição no console.
class ExibidorPedido {
    public void exibir(Pedido pedido) {
        System.out.println("Pedido " + pedido.getNumero());
        for (Produto produto : pedido.getProdutos()) {
            System.out.printf("%s: R$ %.2f%n", produto.getNome(),
                produto.getPrecoCentavos() / 100.0);
        }
        System.out.printf("Total: R$ %.2f%n",
            pedido.getTotalCentavos() / 100.0);
    }
}
