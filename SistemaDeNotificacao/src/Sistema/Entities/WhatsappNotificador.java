package Sistema.Entities;

public class WhatsappNotificador implements Notificador {


    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando mensagem via WhatsApp: " + mensagem);
    }
}
