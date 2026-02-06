package Sistema.Entities;

public class SmsNotificador implements Notificador {


    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando mensagem via Sms: " + mensagem);
    }
}
