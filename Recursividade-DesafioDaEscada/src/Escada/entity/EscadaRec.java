package Escada.entity;

import java.util.HashMap;
import java.util.Map;

public class EscadaRec {

    private Map<Integer, Integer> memoria = new HashMap<>();

    public EscadaRec(int n){

        int result = escadaRecursividade(n);
        System.out.println("A quantidade de " + n + " degraus tem " + result + " maneiras de subir");

    }
    private int escadaRecursividade(int n){

        if (n <= 2){
            return n;
        }

        if(memoria.containsKey(n)){
            return memoria.get(n);
        }

        int resultado = escadaRecursividade(n-1) + escadaRecursividade(n-2);
        memoria.put(n, resultado);

        return resultado;
    }
}
