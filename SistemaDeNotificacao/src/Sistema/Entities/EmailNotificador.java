package Sistema.Entities;

public class EmailNotificador implements Notificador {


    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando mensagem via E-mail: " + mensagem);
    }
}
