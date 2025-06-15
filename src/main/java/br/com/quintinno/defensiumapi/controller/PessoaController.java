package br.com.quintinno.defensiumapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.defensiumapi.entity.PessoaEntity;
import br.com.quintinno.defensiumapi.service.PessoaService;
import br.com.quintinno.defensiumapi.tranfer.PessoaRequestTranfer;
import br.com.quintinno.defensiumapi.tranfer.PessoaResponseTransfer;
import br.com.quintinno.defensiumapi.tranfer.RestResponseTransfer;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/defensium/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaEntity create(@RequestBody @Valid PessoaRequestTranfer pessoaRequestTranfer) {
        return this.pessoaService.create(pessoaRequestTranfer);
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseTransfer>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(this.pessoaService.findAll());
    }

    @PutMapping("/{codePublic}")
    public ResponseEntity<PessoaResponseTransfer> update(@PathVariable("codePublic") String codePublic,
            @RequestBody @Valid PessoaRequestTranfer pessoaRequestTranfer) {
        pessoaRequestTranfer.setCodePublic(codePublic);
        return ResponseEntity.ok().body(this.pessoaService.update(pessoaRequestTranfer));
    }

    @DeleteMapping("/{codePublic}")
    public ResponseEntity<RestResponseTransfer> inativarPessoa(@PathVariable("codePublic") String codePublic) {
        return ResponseEntity.ok().body(this.pessoaService.inativarPessoa(codePublic));
    }

}
