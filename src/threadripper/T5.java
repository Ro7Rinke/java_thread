/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadripper;

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
    int i;//copia do valor de i no momento da criacao da thread

    public T5(ThreadsList tl, int[][] A, int[][] B, int i) {
        this.tl = tl;
        this.A = A;
        this.B = B;
        this.i = i;
    }

    @Override
    public void run() {
        for (int j = 0; j < C.N; j++){//para cada coluna é criada uma nova trhead
            //esta classe ja possui o numera da linha q foi gerado pelo for no main
                Thread localt4 = new Thread(new T4(tl, A, B, i, j));
                localt4.start();
                tl.add(localt4);
            }
    }
}
