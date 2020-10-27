package com.kik.service;

import com.kik.config.SecurityConfig;
import com.kik.model.entity.ConfirmationToken;
import com.kik.model.entity.User;
import com.kik.repo.ConfirmationTokenRepo;
import com.kik.repo.UserRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Import;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Import(SecurityConfig.class)
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
public class UserService implements UserDetailsService {
    UserRepo userRepository;
    ConfirmationTokenService tokenService;
    ConfirmationTokenRepo tokenRepo;
    EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        final Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
        }
    }


    public void signUpUser(User user) {

        final String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());

        user.setPassword(encryptedPassword);

        final User createdUser = userRepository.save(user);

        final ConfirmationToken confirmationToken = new ConfirmationToken(user);

        tokenService.saveConfirmationToken(confirmationToken);

    }

    public void deleteConfirmationToken(Long id){
        tokenRepo.deleteById(id);
    }

    public void confirmUser(ConfirmationToken confirmationToken) {

        final User user = confirmationToken.getUser();

        user.setEnabled(true);

        userRepository.save(user);

        tokenService.deleteConfirmationToken(confirmationToken);

    }

    public void sendConfirmationMail(String userMail, String token) {

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Mail Confirmation Link!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText(
                "Thank you for registering. Please click on the below link to activate your account." + "http://localhost:8080/sign-up/confirm?token="
                        + token);

        emailService.sendEmail(mailMessage);
    }
}
