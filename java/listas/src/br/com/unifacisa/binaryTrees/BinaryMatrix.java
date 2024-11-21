package br.com.unifacisa.binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryMatrix {
    private List<Integer> tree;

    public BinaryMatrix() {
        tree = new ArrayList<>();
    }

    public void insert(int value) {
        tree.add(value);
        System.out.println("Inserido " + value + " na posição " + (tree.size() - 1));
    }

    public void remove(int value) {
        int index = tree.indexOf(value);
        if (index == -1) {
            System.out.println("Valor " + value + " não encontrado.");
            return;
        }

        System.out.println("Removendo valor " + value + " da posição " + index);
        int lastValue = tree.remove(tree.size() - 1);
        if (index < tree.size()) {
            tree.set(index, lastValue);
            System.out.println("Substituído valor na posição " + index + " por " + lastValue);
        }
    }

    public void inOrder(int index) {
        if (index >= tree.size()) return;

        inOrder(2 * index + 1);
        System.out.print(tree.get(index) + " ");
        inOrder(2 * index + 2);
    }

    public void preOrder(int index) {
        if (index >= tree.size()) return;

        System.out.print(tree.get(index) + " ");
        preOrder(2 * index + 1);
        preOrder(2 * index + 2);
    }

    public void postOrder(int index) {
        if (index >= tree.size()) return;

        postOrder(2 * index + 1);
        postOrder(2 * index + 2);
        System.out.print(tree.get(index) + " ");
    }

    public void showRoot() {
        if (tree.isEmpty()) {
            System.out.println("A Árvore está vazia!");
        } else {
            System.out.println("Raiz: " + tree.get(0));
        }
    }

}
