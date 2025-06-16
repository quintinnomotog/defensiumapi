package br.com.quintinno.defensiumapi.exception;

public class NegocioException extends RuntimeException {
    
    public NegocioException(String mensagem) {
        super(mensagem);
    }

}
