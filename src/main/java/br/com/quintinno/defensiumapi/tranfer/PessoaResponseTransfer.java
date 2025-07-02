package br.com.quintinno.defensiumapi.tranfer;

public class PessoaResponseTransfer {
	
	private Long code;

    private String codePublic;

    private String nome; 

    private String dataCriacao;
    
    private String active;

    public PessoaResponseTransfer() { }

    public PessoaResponseTransfer(String nome) {
        this.nome = nome;
    }

    public PessoaResponseTransfer(Long code, String codePublic, String nome, String dataCriacao, String active) {
    	this.code = code;
        this.codePublic = codePublic;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.active = active;
    }

    public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getCodePublic() {
        return codePublic;
    }

    public void setCodePublic(String codePublic) {
        this.codePublic = codePublic;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

}
