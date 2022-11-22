package com.vmo.fresher.exception;

public class InvalidLoginCredentialException extends AbstractCustomException{
    public InvalidLoginCredentialException(ApiErrorDetail apiErrorDetail) {
        super(apiErrorDetail);
    }
}
