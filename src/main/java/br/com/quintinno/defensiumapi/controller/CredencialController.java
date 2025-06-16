package br.com.quintinno.defensiumapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public ResponseEntity<List<CredencialResponseTransfer>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(this.credencialService.findAll());
    }

    @PutMapping("/{codePublic}")
    public ResponseEntity<CredencialResponseTransfer> update(
        @PathVariable("codePublic") String codePublic,
        @RequestBody @Valid CredencialRequestTransfer credencialRequestTransfer) {
            credencialRequestTransfer.setCodePublicCredencial(codePublic);
        return ResponseEntity.ok().body(this.credencialService.update(credencialRequestTransfer));
    }

}
