package br.com.quintinno.defensiumapi.tranfer;

import jakarta.validation.constraints.NotBlank;

public class PessoaRequestTranfer {

    @NotBlank(message = "Necessário informar campo obrigatório!")
    private String nome;

    private String codePublic;

    public PessoaRequestTranfer(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodePublic() {
        return codePublic;
    }

    public void setCodePublic(String codePublic) {
        this.codePublic = codePublic;
    } 
    
}
