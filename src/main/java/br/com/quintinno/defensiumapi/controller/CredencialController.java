package br.com.quintinno.defensiumapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Autowired
    private CredencialService credencialService;

    @PostMapping
    public ResponseEntity<CredencialResponseTransfer> create(@RequestBody @Valid CredencialRequestTransfer credencialRequestTransfer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.credencialService.create(credencialRequestTransfer));
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Page<CredencialResponseTransfer>> findAll(Pageable pageable) {
        Page<CredencialResponseTransfer> credencialResponseTransferPageList = this.credencialService.findAll(pageable);
        return ResponseEntity.ok(credencialResponseTransferPageList);
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
    
    @PostMapping("/descriptografar")
    public ResponseEntity<CredencialResponseTransfer> descriptografarSenha(@RequestBody String codePublicCredencial) {
    	CredencialRequestTransfer credencialRequestTransfer = new CredencialRequestTransfer();
    		credencialRequestTransfer.setCodePublicCredencial(codePublicCredencial);
        return ResponseEntity.status(HttpStatus.OK).body(new CredencialResponseTransfer(this.credencialService.recuperarSenhaDescriptografada(credencialRequestTransfer)));
    }

}
