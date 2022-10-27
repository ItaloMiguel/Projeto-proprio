package br.com.estudo.pratica.service.exception;

public class MyObjectNotFoundException extends RuntimeException {

    public MyObjectNotFoundException(String message) {
        super(message);
    }
}
