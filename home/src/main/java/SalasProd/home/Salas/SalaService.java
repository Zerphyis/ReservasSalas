package SalasProd.home.Salas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SalaService {
@Autowired
    private JavaMailSender mailSender;

  public  void enviarEmail(String emailDestinatario, String tipoReserva) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDestinatario);
        message.setSubject("Reserva Expirada");
        message.setText("Sua reserva de sala " + tipoReserva + " expirou.");
        mailSender.send(message);
    }
}