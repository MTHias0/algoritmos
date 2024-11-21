package br.com.unifacisa.pedido;
import java.util.PriorityQueue;
import java.util.Comparator;

class Pedido {
    private int id;
    private String cliente;
    private boolean vip;

    public Pedido(int id, String cliente, boolean vip) {
        this.id = id;
        this.cliente = cliente;
        this.vip = vip;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public boolean isVip() {
        return vip;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", vip=" + vip +
                '}';
    }
}

class GerenciadorPedidos {
    private PriorityQueue<Pedido> fila;

    public GerenciadorPedidos() {
        this.fila = new PriorityQueue<>(Comparator.comparingInt((Pedido p) -> p.isVip() ? 0 : 1));
    }

    public void adicionarPedido(Pedido pedido) {
        fila.add(pedido);
        System.out.println("Pedido adicionado: " + pedido);
    }

    public Pedido processarPedido() {
        Pedido pedido = fila.poll();
        if (pedido != null) {
            System.out.println("Processando pedido: " + pedido);
        } else {
            System.out.println("Nenhum pedido para processar.");
        }
        return pedido;
    }

    public void visualizarPedidos() {
        System.out.println("Pedidos em espera:");
        fila.forEach(System.out::println);
    }

    public void removerPedidoCancelado(int id) {
        boolean removido = fila.removeIf(p -> p.getId() == id);
        if (removido) {
            System.out.println("Pedido com ID " + id + " removido.");
        } else {
            System.out.println("Pedido com ID " + id + " não encontrado.");
        }
    }

    public void atualizarPrioridade(int id, boolean vip) {
        for (Pedido p : fila) {
            if (p.getId() == id) {
                fila.remove(p);
                Pedido atualizado = new Pedido(id, p.getCliente(), vip);
                fila.add(atualizado);
                System.out.println("Prioridade do pedido com ID " + id + " atualizada.");
                return;
            }
        }
        System.out.println("Pedido com ID " + id + " não encontrado.");
    }
}

public class Main {
    public static void main(String[] args) {
        GerenciadorPedidos gerenciador = new GerenciadorPedidos();

        gerenciador.adicionarPedido(new Pedido(1, "Cliente A", false));
        gerenciador.adicionarPedido(new Pedido(2, "Cliente VIP", true));
        gerenciador.adicionarPedido(new Pedido(3, "Cliente B", false));

        gerenciador.visualizarPedidos();

        gerenciador.processarPedido();

        gerenciador.removerPedidoCancelado(3);

        gerenciador.atualizarPrioridade(1, true);

        gerenciador.visualizarPedidos();
    }
}
