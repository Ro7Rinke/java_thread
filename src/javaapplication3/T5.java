/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Ro7Rinke
 */
public class T5 implements Runnable {
    /*
    essa thread é criada para cada linha da matriz, e é responsavel por criar
    mais uma thread para cada item da tabela
    */
    
    ThreadsList tl;//referencia do objeto q controla o sincronismo da lista de trheads
    int[][] A;//referencia da matriz A
    int[][] B;//referencia da matriz B
    int[][] C;//referencia da matriz C
    int i;//copia do valor de i no momento da criacao da thread
    int N;//copia do valor de N no momento da criacao da thread

    public T5(ThreadsList tl, int[][] A, int[][] B, int[][] C, int i, int N) {
        this.tl = tl;
        this.A = A;
        this.B = B;
        this.C = C;
        this.i = i;
        this.N = N;
    }

    @Override
    public void run() {
        for (int j = 0; j < N; j++){//para cada coluna é criada uma nova trhead
            //esta classe ja possui o numera da linha q foi gerado pelo for no main
                Thread localt4 = new Thread(new T4(tl, A, B, C, i, j, N));
                localt4.start();
                tl.add(localt4);
            }
    }
}
