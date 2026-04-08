package PortalRH.Entities;

public class Gerente extends Funcionario {

    public Gerente (Integer id, String nome){
        super(id, nome);
    }

    @Override
    public boolean batePonto() {
        return false;
    }

    @Override
    public int limiteHorasExtras() {
        return 0;
    }
}
