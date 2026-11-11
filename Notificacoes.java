interface Notificador {
    void enviar(String mensagem);
}

class Email implements Notificador {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Email simulado: " + mensagem);
    }
}

class SMS implements Notificador {
    @Override
    public void enviar(String mensagem) {
        System.out.println("SMS simulado: " + mensagem);
    }
}

class WhatsApp implements Notificador {
    @Override
    public void enviar(String mensagem) {
        System.out.println("WhatsApp simulado: " + mensagem);
    }
}

// DIP: a classe principal depende da interface Notificador.
class SistemaDelivery {
    private final Notificador notificador;

    public SistemaDelivery(Notificador notificador) {
        this.notificador = notificador;
    }

    public void notificarPedido(Pedido pedido) {
        String mensagem = "Pedido " + pedido.getNumero()
            + " está com status " + pedido.getStatus() + ".";
        notificador.enviar(mensagem);
    }
}
