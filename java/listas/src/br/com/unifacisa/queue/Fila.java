package br.com.unifacisa.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.add("Primeiro");
        fila.add("Segundo");
        fila.add("Terceiro");

        System.out.println("Fila inicial: " + fila);

        String removido = fila.poll();
        System.out.println("Elemento removido: " + removido);
        System.out.println("Fila após remoção: " + fila);

        String proximo = fila.peek();
        System.out.println("Próximo elemento: " + proximo);

        System.out.println("Tamanho da fila: " + fila.size());

        System.out.println("A fila está vazia? " + fila.isEmpty());

        while (!fila.isEmpty()) {
            System.out.println("Removendo: " + fila.poll());
        }

        System.out.println("A fila está vazia? " + fila.isEmpty());
    }
}
