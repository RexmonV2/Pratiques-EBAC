import Cadastro.entity.Pessoa;

import java.util.HashSet;
import java.util.Set;

public class MainCadastro {

    public static void main(String[] args){

        Set<Pessoa> cadastroDePessoas = new HashSet<>();

        cadastroDePessoas.add(new Pessoa("Jose", 54));
        cadastroDePessoas.add(new Pessoa("Mario", 48));
        cadastroDePessoas.add(new Pessoa("Jose", 54));
        cadastroDePessoas.add(new Pessoa("Julia", 25));
        cadastroDePessoas.add(new Pessoa("Julia", 25));

        for (Pessoa i : cadastroDePessoas){
            System.out.println(i);
        }

        System.out.println("\nTamanho do HashSet: " + cadastroDePessoas.size());

        System.out.println("\n========Explicação=========");
        System.out.println("O tamanho do HashSet vai ter apenas 3 pessoas mesmo tendo adicionado 5 \n" +
                "porque o HashSet utiliza os metodos hashcode() e o equal(), ao tentar adicionar\n" +
                "as outras pessoas o sistema detectou que elas possuiam o mesmo nome e idade\n" +
                "das pessoas anteriormente adicionadas assim como resultado a duplicata\n" +
                "foi barrada, garantindo a integridade do cadastro.");

    }
}
