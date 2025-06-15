package br.com.quintinno.defensiumapi.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.quintinno.defensiumapi.tranfer.ErrorResponseTransfer;
import br.com.quintinno.defensiumapi.utility.DateUtility;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseTransfer> dataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
        ErrorResponseTransfer errorResponseTransfer = new ErrorResponseTransfer();
            errorResponseTransfer.setMensagem("Registro Duplicado.");
            errorResponseTransfer.setDataHoraRequisicao(DateUtility.getDataHoraFormatada(LocalDateTime.now(), DateUtility.DATA_FORMATO_DDMMAAAAHHMMSS));
        return new ResponseEntity<>(errorResponseTransfer, HttpStatus.CONFLICT);
    }

}
