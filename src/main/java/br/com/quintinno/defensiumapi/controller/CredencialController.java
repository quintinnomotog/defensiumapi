package br.com.quintinno.defensiumapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class CredencialController {

    private final CredencialService credencialService;

    public CredencialController(CredencialService credencialService) {
        this.credencialService = credencialService;
    }

    @PostMapping
    public ResponseEntity<CredencialResponseTransfer> create(
            @RequestBody @Valid CredencialRequestTransfer credencialRequestTransfer) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.credencialService.create(credencialRequestTransfer));
    }

    @GetMapping
    public ResponseEntity<RestResponseTransfer<CredencialResponseTransfer>> findAll() {
        List<CredencialResponseTransfer> credencialResponseTransferList = this.credencialService.findAll();
        RestResponseTransfer<CredencialResponseTransfer> restResponseTransfer = getFindAllRestResponseTransfer(
                credencialResponseTransferList);
        return ResponseEntity.status(HttpStatus.OK).body(restResponseTransfer);
    }

    @PutMapping("/{codePublic}")
    public ResponseEntity<CredencialResponseTransfer> update(
            @PathVariable("codePublic") String codePublic,
            @RequestBody @Valid CredencialRequestTransfer credencialRequestTransfer) {
        credencialRequestTransfer.setCodePublicCredencial(codePublic);
        return ResponseEntity.ok().body(this.credencialService.update(credencialRequestTransfer));
    }

    private RestResponseTransfer<CredencialResponseTransfer> getFindAllRestResponseTransfer(
            List<CredencialResponseTransfer> credencialResponseTransferList) {
        RestResponseTransfer<CredencialResponseTransfer> restResponseTransfer = new RestResponseTransfer<>();
        restResponseTransfer.setMensagem("Dados Recuperados com Sucesso!");
        restResponseTransfer.setDataHora(DateUtility.getDataHoraFormatada());
        restResponseTransfer.setObjectList(credencialResponseTransferList);
        restResponseTransfer.setTipoOperacaoEnumeration(TipoOperacaoEnumeration.FINDALL);
        return restResponseTransfer;
    }

}
