package br.com.quintinno.defensiumapi.tranfer;

import jakarta.validation.constraints.NotBlank;

public class PessoaRequestTranfer {

    @NotBlank(message = "O campo nome deve ser informado!")
    private String nome;

    public PessoaRequestTranfer(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    } 
    
}
