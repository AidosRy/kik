package com.kik.service.interfaces;

import com.kik.model.entity.ConfirmationToken;

import java.util.Optional;

public interface IConfirmationTokenService {
    void saveConfirmationToken(ConfirmationToken confirmationToken);
    void deleteConfirmationToken(ConfirmationToken token);
    Optional<ConfirmationToken> findByToken(String token);
}
