// OCP: novas formas implementam este contrato.
interface Pagamento {
    void pagar(int valorCentavos);
}

class Cartao implements Pagamento {
    @Override
    public void pagar(int valorCentavos) {
        System.out.printf("Cartão simulado: R$ %.2f%n",
            valorCentavos / 100.0);
    }
}

class Pix implements Pagamento {
    @Override
    public void pagar(int valorCentavos) {
        System.out.printf("PIX simulado: R$ %.2f%n",
            valorCentavos / 100.0);
    }
}

class Dinheiro implements Pagamento {
    @Override
    public void pagar(int valorCentavos) {
        System.out.printf("Dinheiro simulado: R$ %.2f%n",
            valorCentavos / 100.0);
    }
}

class ProcessadorPagamento {
    public void processar(Pagamento forma, int valorCentavos) {
        if (valorCentavos <= 0) {
            throw new IllegalArgumentException("Valor inválido.");
        }
        forma.pagar(valorCentavos);
    }
}
