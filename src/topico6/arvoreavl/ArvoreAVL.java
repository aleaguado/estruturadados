/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topico6.arvoreavl;

/**
 *
 * @author aleaguado
 */
public class ArvoreAVL {

    private static class ARVORE {

        public int num, altd, alte;

        public ARVORE dir, esq;
    }

    public static ARVORE inserir(ARVORE aux, int num) {

        // o objeto novo é um objeto auxiliar
        ARVORE novo;

        if (aux == null) {
            novo = new ARVORE();
            novo.num = num;
            novo.altd = 0;
            novo.alte = 0;
            novo.esq = null;
            novo.dir = null;
            aux = novo;
        } else if (num < aux.num) {
            aux.esq = inserir(aux.esq, num);
            if (aux.esq.altd > aux.esq.alte) {
                aux.alte = aux.esq.altd + 1;
            } else {
                aux.alte = aux.esq.alte + 1;
            }
            aux = balanceamento(aux);
        } else {
            aux.dir = inserir(aux.dir, num);
            if (aux.dir.altd > aux.dir.alte) {
                aux.altd = aux.dir.altd + 1;
            } else {
                aux.altd = aux.dir.alte + 1;
            }
            aux = balanceamento(aux);
        }
        return aux;
    }

 

    public static ARVORE balanceamento(ARVORE aux) {
        int d, df;
        d = aux.altd - aux.alte;
        if (d == 2) {
            df = aux.dir.altd - aux.dir.alte;
            if (df >= 0) {
                aux = rotacao_esquerda(aux);
            } else {
                aux.dir = rotacao_direita(aux.dir);
                aux = rotacao_esquerda(aux);
            }
        } else if (d == -2) {
            df = aux.esq.altd - aux.esq.alte;
            if (df <= 0) {
                aux = rotacao_direita(aux);
            } else {
                aux.esq = rotacao_esquerda(aux.esq);
                aux = rotacao_direita(aux);
            }
        }
        return aux;
    }

    public static ARVORE rotacao_esquerda(ARVORE aux) {

        ARVORE aux1, aux2;
        aux1 = aux.dir;
        aux2 = aux1.esq;
        aux.dir = aux2;
        aux1.esq = aux;
        if (aux.dir == null) {
            aux.altd = 0;
        } else if (aux.dir.alte > aux.dir.altd) {
            aux.altd = aux.dir.alte + 1;
        } else {
            aux.altd = aux.dir.altd + 1;
        }

        if (aux1.esq.alte > aux1.esq.altd) {
            aux1.alte = aux1.esq.alte + 1;
        } else {
            aux1.alte = aux1.esq.altd + 1;
        }
        return aux1;
    }

    public static ARVORE rotacao_direita(ARVORE aux) {
        ARVORE aux1, aux2;
        aux1 = aux.esq;
        aux2 = aux1.dir;
        aux.esq = aux2;
        aux1.dir = aux;
        if (aux.esq == null) {
            aux.alte = 0;
        } else if (aux.esq.alte > aux.esq.altd) {
            aux.alte = aux.esq.alte + 1;
        } else {
            aux.alte = aux.esq.altd + 1;
        }

        if (aux1.dir.alte > aux1.dir.altd) {
            aux1.altd = aux1.dir.alte + 1;
        } else {
            aux1.altd = aux1.dir.altd + 1;
        }
        return aux1;
    }

    public static void exibiremordem(ARVORE aux) {
        if (aux != null) {
            System.out.print(aux.num + "  ");
            exibiremordem(aux.esq);
            exibiremordem(aux.dir);
        }
    }

    public static void exibirpreordem(ARVORE aux) {
        if (aux != null) {
            System.out.print(aux.num + ", ");
            exibirpreordem(aux.esq);
            exibirpreordem(aux.dir);
        }
    }

    public static void exibirposordem(ARVORE aux) {
        if (aux != null) {
            exibirposordem(aux.esq);
            exibirposordem(aux.dir);
            System.out.print(aux.num + ", ");
        }
    }

    public static void main(String[] args) {

        ARVORE a = null;

        a = inserir(a, 10 );
        a = inserir(a, 4);
        a = inserir(a, 7);
        a = inserir(a, 8);
        a = inserir(a, 2);
        a = inserir(a, 3);
        a = inserir(a, 9);

        System.out.print("EM : ");
        exibiremordem(a);
        System.out.println();
        System.out.print("PRE : ");
        exibirpreordem(a);
        System.out.println();
        System.out.print("POS : ");
        exibirposordem(a);
        System.out.println();
    }
}