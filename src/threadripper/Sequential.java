/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadripper;

import java.util.Scanner;

/**
 *
 * @author Ro7Rinke
 */
public class Sequential {

    public static void main(String[] args) {
        Scanner sysin = new Scanner(System.in);//ler o tamanho da matrix
        int N = sysin.nextInt();
        
        int[][] A = new int[N][N];
        int[][] B = new int[N][N];
        int[][] C = new int[N][N];
        
        for(int i = 0; i < N; i++){//percoree as linhas da matriz C
            for (int j = 0; j < N; j++){//percorre as colunas da matriz C
                C[i][j] = 0;
                A[i][j] = i+j;
                B[i][j] = i+j;
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                } // for-k
            } // for-j
        } // for-
        
        for(int i = 0; i < N; i++){//percoree as linhas da matriz C
            for (int j = 0; j < N; j++){//percorre as colunas da matriz C
                System.out.print(C[i][j]);//imprime o valor na matriz C correspondente á sua posicao
                System.out.print(" - ");//melhorar a visualizacao no console
            }
            System.out.print("\n");//melhorar a visualizacao no console
        }
    }
}
