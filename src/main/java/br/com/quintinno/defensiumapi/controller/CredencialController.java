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

import br.com.quintinno.defensiumapi.enumeration.TipoOperacaoEnumeration;
import br.com.quintinno.defensiumapi.service.CredencialService;
import br.com.quintinno.defensiumapi.tranfer.CredencialRequestTransfer;
import br.com.quintinno.defensiumapi.tranfer.CredencialResponseTransfer;
import br.com.quintinno.defensiumapi.tranfer.RestResponseTransfer;
import br.com.quintinno.defensiumapi.utility.DateUtility;
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
    public ResponseEntity<RestResponseTransfer> findAll() {
        List<CredencialResponseTransfer> credencialResponseTransferList = this.credencialService.findAll();
        RestResponseTransfer restResponseTransfer = getRestResponseTransfer(credencialResponseTransferList);
        return ResponseEntity.status(HttpStatus.FOUND).body(restResponseTransfer);
    }

    @PutMapping("/{codePublic}")
    public ResponseEntity<CredencialResponseTransfer> update(
        @PathVariable("codePublic") String codePublic,
        @RequestBody @Valid CredencialRequestTransfer credencialRequestTransfer) {
            credencialRequestTransfer.setCodePublicCredencial(codePublic);
        return ResponseEntity.ok().body(this.credencialService.update(credencialRequestTransfer));
    }

    private RestResponseTransfer<CredencialResponseTransfer> getRestResponseTransfer(List<CredencialResponseTransfer> credencialResponseTransferList) {
        RestResponseTransfer<CredencialResponseTransfer> restResponseTransfer = new RestResponseTransfer<>();
            restResponseTransfer.setMensagem("Dados Recuperados com Sucesso!");
            restResponseTransfer.setDataHora(DateUtility.getDataHoraFormatada());
            restResponseTransfer.setObjectList(credencialResponseTransferList);
            restResponseTransfer.setTipoOperacaoEnumeration(TipoOperacaoEnumeration.FINDALL);
        return restResponseTransfer;
    }

}
