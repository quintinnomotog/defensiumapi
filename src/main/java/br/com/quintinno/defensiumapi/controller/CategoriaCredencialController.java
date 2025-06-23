package br.com.quintinno.defensiumapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.defensiumapi.enumeration.TipoOperacaoEnumeration;
import br.com.quintinno.defensiumapi.service.CategoriaCredencialService;
import br.com.quintinno.defensiumapi.tranfer.CategoriaCredencialResponseTransfer;
import br.com.quintinno.defensiumapi.tranfer.RestResponseTransfer;
import br.com.quintinno.defensiumapi.utility.DateUtility;

@RestController
@RequestMapping("/defensium/categoria-credencial")
@CrossOrigin(origins = "*")
public class CategoriaCredencialController {

    private final CategoriaCredencialService categoriaCredencialService;

    public CategoriaCredencialController(CategoriaCredencialService categoriaCredencialService) {
        this.categoriaCredencialService = categoriaCredencialService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaCredencialResponseTransfer>> getFindAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoriaCredencialService.getFindAll());
    }

    private RestResponseTransfer<CategoriaCredencialResponseTransfer> getFindAllRestResponseTransfer(
            List<CategoriaCredencialResponseTransfer> categoriaCredencialResponseTransferList) {
        RestResponseTransfer<CategoriaCredencialResponseTransfer> restResponseTransfer = new RestResponseTransfer<>();
            restResponseTransfer.setMensagem("Dados Recuperados com Sucesso!");
            restResponseTransfer.setDataHora(DateUtility.getDataHoraFormatada());
            restResponseTransfer.setObjectList(categoriaCredencialResponseTransferList);
            restResponseTransfer.setTipoOperacaoEnumeration(TipoOperacaoEnumeration.FINDALL);
        return restResponseTransfer;
    }

}
