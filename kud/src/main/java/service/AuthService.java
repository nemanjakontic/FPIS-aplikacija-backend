package service;

import dto.RegisterRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import modeli.User;
import modeli.Verifikacija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repozitorijumi.UserRepository;
import repozitorijumi.VerifikacijaRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VerifikacijaRepository verifikacijaRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    public void signup(RegisterRequest registerRequest){
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setVerifikovan(false);
        userRepository.save(user);

        Verifikacija verifikacija = generateVerificationToken(user);

        sendEmail(verifikacija);
    }

    @Async
    void sendEmail(Verifikacija verifikacija) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(verifikacija.getUser().getEmail());

        msg.setSubject("Verifikacija naloga");
        msg.setText("Postovani korisnice \n Molimo Vas, verifikujte " +
                "vas nalog klikom na sledeci link: \n " +
                "http://localhost:8080/api/auth/verifikacija/"
                + verifikacija.getToken());// dodati ime na usera

        javaMailSender.send(msg);
    }

    private Verifikacija generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        Verifikacija verifikacija = new Verifikacija();
        verifikacija.setToken(token);
        verifikacija.setUser(user);

        verifikacijaRepository.save(verifikacija);
        return verifikacija;
    }


}
