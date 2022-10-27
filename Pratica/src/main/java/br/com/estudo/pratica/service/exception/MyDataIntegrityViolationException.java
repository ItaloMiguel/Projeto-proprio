package br.com.estudo.pratica.service.exception;

public class MyDataIntegrityViolationException extends RuntimeException {

    public MyDataIntegrityViolationException(String message) {
        super(message);
    }
}
