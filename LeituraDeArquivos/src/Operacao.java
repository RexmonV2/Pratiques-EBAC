import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Operacao {

    public List<Cliente> lerERetornar() throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(Arquivo.CAMINHO_ARQUIVO))){
            String linha = reader.readLine();
            List<Cliente> clientes = new ArrayList<>();

            while (linha != null) {
                clientes.add(converterObjeto(linha));
                linha = reader.readLine();
            }
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Cliente converterObjeto(String linha) throws IllegalAccessException {
        String[] atributos = linha.split("\\|");
        Cliente clienteDaLinha = new Cliente(null,null,null,null);

        Field[] atributoFields = clienteDaLinha.getClass().getDeclaredFields();

        for (int i = 0; i < atributos.length; i++) {
            atributoFields[i].setAccessible(true);
            atributoFields[i].set(clienteDaLinha, atributos[i]);
        }
        return clienteDaLinha;
    }
}
