package br.com.quintinno.defensiumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.defensiumapi.entity.PessoaEntity;
import br.com.quintinno.defensiumapi.service.PessoaService;
import br.com.quintinno.defensiumapi.tranfer.PessoaRequestTranfer;

@RestController
@RequestMapping("/defensium/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaEntity create(@RequestBody PessoaRequestTranfer pessoaRequestTranfer) {
        return this.pessoaService.create(pessoaRequestTranfer);
    }

}
