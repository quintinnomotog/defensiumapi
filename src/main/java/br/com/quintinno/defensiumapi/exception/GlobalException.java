package br.com.quintinno.defensiumapi.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.quintinno.defensiumapi.tranfer.ErrorResponseTransfer;
import br.com.quintinno.defensiumapi.utility.DateUtility;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalException {

    private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseTransfer> dataIntegrityViolationException(
            DataIntegrityViolationException dataIntegrityViolationException) {
        ErrorResponseTransfer errorResponseTransfer = new ErrorResponseTransfer();
        errorResponseTransfer.setMensagem("Registro Duplicado.");
        errorResponseTransfer.setDataHoraRequisicao(this.getDataHora());
        return new ResponseEntity<>(errorResponseTransfer, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseTransfer> methodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException) {
        ErrorResponseTransfer errorResponseTransfer = new ErrorResponseTransfer(
                this.getMensagem(methodArgumentNotValidException),
                this.getDataHora());
        return new ResponseEntity<>(errorResponseTransfer, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseTransfer> entityNotFoundException(
            EntityNotFoundException entityNotFoundException) {
        logger.warn("Recurso não encontrado: {}", entityNotFoundException.getMessage());
        ErrorResponseTransfer errorResponseTransfer = new ErrorResponseTransfer(
                entityNotFoundException.getMessage(),
                this.getDataHora());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseTransfer);
    }

    private String getMensagem(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<String> mensagemList = methodArgumentNotValidException
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return mensagemList.isEmpty() ? "Falha na requisição!" : this.getFindAllMensagem(mensagemList);
    }

    private String getDataHora() {
        return DateUtility.getDataHoraFormatada(LocalDateTime.now(), DateUtility.DATA_FORMATO_DDMMAAAAHHMMSS);
    }

    private String getFindAllMensagem(List<String> mensagemList) {
        return String.join("; ", mensagemList);
    }

}
