package br.com.quintinno.defensiumapi.tranfer;

public class PessoaRequestTranfer {

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
