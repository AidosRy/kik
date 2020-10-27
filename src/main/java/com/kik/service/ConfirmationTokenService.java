package com.kik.service;

import com.kik.model.entity.ConfirmationToken;
import com.kik.repo.ConfirmationTokenRepo;
import com.kik.service.interfaces.IConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService implements IConfirmationTokenService {

    private final ConfirmationTokenRepo tokenRepo;

    @Override
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        tokenRepo.save(confirmationToken);
    }

    @Override
    public void deleteConfirmationToken(ConfirmationToken token) {
        tokenRepo.delete(token);
    }

    @Override
    public Optional<ConfirmationToken> findByToken(String token) {
        return tokenRepo.findByToken(token);
    }
}
