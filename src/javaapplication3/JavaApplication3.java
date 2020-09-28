/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ro7Rinke
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sysin = new Scanner(System.in);//ler o tamanho da matrix
        int N = sysin.nextInt();
        
        int[][] A = new int[N][N];
        int[][] B = new int[N][N]; //aloca memoria para 3 matrizes com o tamnho lido anteriormente
        int[][] C = new int[N][N];
        
        ThreadsList tl = new ThreadsList(); //instancia do objeto q controla o sincronismo na lista de threads
        //mais explicacoes no classe
        
        for(int i = 0; i < N; i++){//para cada linha cria uma thread responsavel por criar threads para cada posicao, mais explicacoes na classe T5
            Thread localt5 = new Thread(new T5(tl, A, B, C, i, N)); //inicia uma thread com uma classe runnable
            localt5.start();//inicia a thread
            tl.add(localt5);//add a thread em uma lista para posteriormente verificar qnts threads ainda estao vivas
        }
        
        while(tl.verifyAlive()){//metodo q retorna se na lista de trheads possui alguma viva
            //prcurando uma idea mlr de como esperar a conclusao de todas as threads
        }
        
        tl.setThreads(new ArrayList());//limpa a lista de threads
        
        for (int i = 0 ; i < N ; i++) {//para cada linha cria uma thread responsavel por criar threads para cada coluna, mais explicacoes na classe T3
            Thread localt3 = new Thread(new T3(tl, A, B, C, i, N));//inicia uma thread com uma classe runnable
            localt3.start();//inicia a thread
            tl.add(localt3);//add a thread em uma lista para posteriormente verificar qnts threads ainda estao vivas
        } // for-i
        
        while(tl.verifyAlive()){//metodo q retorna se na lista de trheads possui alguma viva
            //prcurando uma idea mlr de como esperar a conclusao de todas as threads
        }
        
        for(int i = 0; i < N; i++){//percoree as linhas da matriz C
            for (int j = 0; j < N; j++){//percorre as colunas da matriz C
                System.out.print(C[i][j]);//imprime o valor na matriz C correspondente á sua posicao
                System.out.print(" - ");//melhorar a visualizacao no console
            }
            System.out.print("\n");//melhorar a visualizacao no console
        }
    }
    
    
}
