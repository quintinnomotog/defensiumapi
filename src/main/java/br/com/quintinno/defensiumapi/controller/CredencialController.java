package br.com.quintinno.defensiumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.defensiumapi.service.CredencialService;
import br.com.quintinno.defensiumapi.tranfer.CredencialRequestTransfer;
import br.com.quintinno.defensiumapi.tranfer.CredencialResponseTransfer;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/defensium/credencial")
public class CredencialController {

    @Autowired
    private CredencialService credencialService;

    @PostMapping
    public ResponseEntity<CredencialResponseTransfer> create(@RequestBody @Valid CredencialRequestTransfer credencialRequestTransfer) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.credencialService.create(credencialRequestTransfer));
    }

}
