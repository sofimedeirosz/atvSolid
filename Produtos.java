// LSP: as subclasses preservam o contrato de Produto.
class Produto {
    private final String nome;
    private final int precoCentavos;

    public Produto(String nome, int precoCentavos) {
        if (nome == null || nome.isBlank() || precoCentavos < 0) {
            throw new IllegalArgumentException("Produto inválido.");
        }
        this.nome = nome;
        this.precoCentavos = precoCentavos;
    }

    public String getNome() {
        return nome;
    }

    public int getPrecoCentavos() {
        return precoCentavos;
    }
}

class Pizza extends Produto {
    public Pizza() {
        super("Pizza", 4000);
    }
}

class Hamburguer extends Produto {
    public Hamburguer() {
        super("Hambúrguer", 2500);
    }
}

class Bebida extends Produto {
    public Bebida() {
        super("Bebida", 800);
    }
}
