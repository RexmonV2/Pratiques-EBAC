import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Operacao operacao = new Operacao();
        List<Cliente> clientes = new ArrayList<>();
        clientes = operacao.lerERetornar();

        System.out.println(clientes);

        GeradorXML geradorXML = new GeradorXML();
        geradorXML.gerarXML(clientes);

    }
}
