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
public class T3 implements Runnable{
    
    /*
    esta thread é responsavel por criar uma nova thread para cada coluna de B
    ja possui o valor da linha gerado pelo for no main
    */
    
    ThreadsList tl;
    int[][] A;
    int[][] B;
    int i;

    public T3(ThreadsList tl, int[][] A, int[][] B, int i) {
        this.tl = tl;
        this.A = A;
        this.B = B;
        this.i = i;
    }

    
    @Override
    public void run() {
        for (int j = 0 ; j < C.N ; j++) {
                  Thread localt2 = new Thread(new T2(tl, A, B, i, j));
                  localt2.start();
                  tl.add(localt2);
//                  App.maxThreads++;
//                  System.out.println(App.maxThreads);
            } // for-j
    }
}
