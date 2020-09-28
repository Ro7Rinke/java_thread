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
public class T3 implements Runnable{
    
    /*
    esta thread é responsavel por criar uma nova thread para cada coluna de B
    ja possui o valor da linha gerado pelo for no main
    */
    
    ThreadsList tl;
    int[][] A;
    int[][] B;
    int[][] C;
    int i;
    int N;

    public T3(ThreadsList tl, int[][] A, int[][] B, int[][] C, int i, int N) {
        this.tl = tl;
        this.A = A;
        this.B = B;
        this.C = C;
        this.i = i;
        this.N = N;
    }

    
    @Override
    public void run() {
        for (int j = 0 ; j < N ; j++) {
                  Thread localt2 = new Thread(new T2(tl, A, B, C, i, j, N));
                  localt2.start();
                  tl.add(localt2);
            } // for-j
    }
}
