import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("Televisão", 889));
        lista.add(new Produto("Radio", 79.70));
        lista.add(new Produto("Computador", 3000.540));
        lista.add(new Produto("Celular", 1500.250));

        ListaUtil.ordenarExibir(lista);
    }
}
