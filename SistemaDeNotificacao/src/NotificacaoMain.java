import Sistema.Entities.EmailNotificador;
import Sistema.Entities.SmsNotificador;
import Sistema.Entities.UsuarioService;
import Sistema.Entities.WhatsappNotificador;

public class NotificacaoMain {

    public static void main(String[] args){

        System.out.println("=== Testando diferentes notificadores ===\n");

        new UsuarioService(new EmailNotificador()).registrar("João");
        System.out.println("----");
        new UsuarioService(new WhatsappNotificador()).registrar("Maria");
        System.out.println("----");
        new UsuarioService(new SmsNotificador()).registrar("Mario");

    }
}
