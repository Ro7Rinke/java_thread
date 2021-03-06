/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadripper;

import java.util.ArrayList;

/**
 *
 * @author Ro7Rinke
 */
public class T2 implements Runnable {

    /*
    essa thread vai criar uma nova thread para cada elemento de C
    ja possui uma os valores de linha e coluna provenientes das theads T3
    */
    
    ThreadsList tl;
    int[][] A;
    int[][] B;
    int i;
    int j;

    public T2(ThreadsList tl, int[][] A, int[][] B, int i, int j) {
        this.tl = tl;
        this.A = A;
        this.B = B;
        this.i = i;
        this.j = j;
    }

    
    @Override
    public void run() {
        for (int k = 0; k < C.N; k++) {
            if(App.performanceMode){//diminiu de threads
                C.setSingle((C.getSingle(i, j) + (A[i][k] * B[k][j])), i, j);//atribui sincronizado o valor na posicao da matriz C
            }else{
                Thread localt1 = new Thread(new T1(tl, A, B, i, j, k));
                localt1.start();
                tl.add(localt1);
//                App.maxThreads++;
//                System.out.println(App.maxThreads);
            }
            
        } // for-k
    }
}
