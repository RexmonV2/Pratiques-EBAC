public class Cliente {
    private String id;
    private String nome;
    private String idade;
    private String empresa;

    public Cliente(String id, String nome, String idade, String empresa) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.empresa = empresa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return this.getId().concat("|")
                .concat(this.getNome()).concat("|")
                .concat(this.getIdade()).concat("|")
                .concat(this.getEmpresa());
    }
}
