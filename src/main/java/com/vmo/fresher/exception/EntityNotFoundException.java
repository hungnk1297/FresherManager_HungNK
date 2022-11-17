package com.vmo.fresher.exception;

public class EntityNotFoundException extends AbstractCustomException{

    public EntityNotFoundException(ApiErrorDetail apiErrorDetail) {
        super(apiErrorDetail);
    }
}
