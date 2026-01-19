package ReservaHotel.entity;

public class Reserva {

    private String nomeHospede;
    private String tipoQuarto;
    private int diasDeEstadia;
    private double valorDiaria;

    public Reserva (String nomeHospede, String tipoQuarto, int diasDeEstadia, double valorDiaria){
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.diasDeEstadia = diasDeEstadia;
        this.valorDiaria = valorDiaria;
    }

    public Reserva (String nomeHospede, String tipoQuarto){
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public int getDiasDeEstadia() {
        return diasDeEstadia;
    }

    public void setDiasDeEstadia(int diasDeEstadia) {
        if (diasDeEstadia >= 1) {
            this.diasDeEstadia = diasDeEstadia;
        } else {
            System.out.println("Erro: A estadia mínima é de 1 dia. Definindo padrão.");
            this.diasDeEstadia = 1;
        }
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double calcularValorTotal(){
        double total = 0;

        total = diasDeEstadia * valorDiaria;

        return total;
    }

    @Override
    public String toString() {
        return "Hospede: " + nomeHospede + "\nTipo do quarto: " + tipoQuarto + "\nDias de estadia: " + diasDeEstadia + "\n" +
                "Valor da diaria: R$" + String.format("%.2f", valorDiaria) + "\nValor total: R$" + String.format("%.2f", calcularValorTotal());
    }
}
