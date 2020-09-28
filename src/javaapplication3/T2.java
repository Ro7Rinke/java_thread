/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

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
    int[][] C;
    int i;
    int j;
    int N;

    public T2(ThreadsList tl, int[][] A, int[][] B, int[][] C, int i, int j, int N) {
        this.tl = tl;
        this.A = A;
        this.B = B;
        this.C = C;
        this.i = i;
        this.j = j;
        this.N = N;
    }

    
    @Override
    public void run() {
        for (int k = 0; k < N; k++) {
            Thread localt1 = new Thread(new T1(tl, A, B, C, i, j, k));
            localt1.start();
            tl.add(localt1);
//          C[i][j] = C[i][j] + A[i][k] * B[k][j];
        } // for-k
    }
}
