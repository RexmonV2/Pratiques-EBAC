import java.util.List;

public class Pessoa {

    private List<Object> names;

    public Pessoa() {}

    public List<Object> getNames() {
        return names;
    }

    public void adicionarNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            System.out.println("Nome não pode ser adicionado por ser vazio/nulo!");
            return;
        }
        names.add(nome);
    }
}
