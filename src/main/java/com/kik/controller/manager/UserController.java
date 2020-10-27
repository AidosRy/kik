package com.kik.controller.manager;

import com.kik.model.entity.ConfirmationToken;
import com.kik.model.entity.User;
import com.kik.service.ConfirmationTokenService;
import com.kik.service.UserService;
import com.kik.service.interfaces.IConfirmationTokenService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    IConfirmationTokenService confirmationTokenService;

    @GetMapping("/sign-in")
    String signIn() {

        return "sign-in";
    }

    @GetMapping("/sign-up")
    String signUp() {

        return "sign-up";
    }

    @PostMapping("/sign-up")
    String signUp(User user) {

        userService.signUpUser(user);

        return "redirect:/sign-in";
    }

    @GetMapping("/confirm")
    String confirmMail(@RequestParam("token") String token) {

        Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findByToken(token);

        optionalConfirmationToken.ifPresent(userService::confirmUser);

        return "/sign-in";
    }

}
