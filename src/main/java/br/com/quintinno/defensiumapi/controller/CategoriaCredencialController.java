package br.com.quintinno.defensiumapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.defensiumapi.entity.CategoriaCredencialEntity;
import br.com.quintinno.defensiumapi.service.CategoriaCredencialService;

@RestController
@RequestMapping("/defensium/categoria-credencial")
@CrossOrigin(origins = "*")
public class CategoriaCredencialController {

    private final CategoriaCredencialService categoriaCredencialService;

    public CategoriaCredencialController(CategoriaCredencialService categoriaCredencialService) {
        this.categoriaCredencialService = categoriaCredencialService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaCredencialEntity>> getFindAll() {
        return ResponseEntity.ok().body(this.categoriaCredencialService.getFindAll());
    }

}
