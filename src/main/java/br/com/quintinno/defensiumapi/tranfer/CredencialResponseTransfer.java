package br.com.quintinno.defensiumapi.tranfer;

public class CredencialResponseTransfer {

    private String codePublic;

    private String identificador;

    private String senha;

    private String descricao;

    private String link;

    private String observacao;

    private String active;

    private String dataOperacao;
    
    private String nomePessoa;
    
    private String databaseHostname;
    
    private String databasePorta;
    
    private String databaseNome;
    
    private String databaseUsuario;
    
    private String cartaoBancarioNomeTitular;
    
    private String cartaoBancarioNumeroCartao;
    
    private String cartaoBancarioMesVencimento;
    
    private String cartaoBancarioAnoVencimento;
    
    private String cartaoBancarioCvv;

    public CredencialResponseTransfer() { }

    public CredencialResponseTransfer(String senha) {
		this.senha = senha;
	}

	public String getCodePublic() {
        return codePublic;
    }

    public void setCodePublic(String codePublic) {
        this.codePublic = codePublic;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(String dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getDatabaseHostname() {
		return databaseHostname;
	}

	public void setDatabaseHostname(String databaseHostname) {
		this.databaseHostname = databaseHostname;
	}

	public String getDatabasePorta() {
		return databasePorta;
	}

	public void setDatabasePorta(String databasePorta) {
		this.databasePorta = databasePorta;
	}

	public String getDatabaseNome() {
		return databaseNome;
	}

	public void setDatabaseNome(String databaseNome) {
		this.databaseNome = databaseNome;
	}

	public String getDatabaseUsuario() {
		return databaseUsuario;
	}

	public void setDatabaseUsuario(String databaseUsuario) {
		this.databaseUsuario = databaseUsuario;
	}

	public String getCartaoBancarioNomeTitular() {
		return cartaoBancarioNomeTitular;
	}

	public void setCartaoBancarioNomeTitular(String cartaoBancarioNomeTitular) {
		this.cartaoBancarioNomeTitular = cartaoBancarioNomeTitular;
	}

	public String getCartaoBancarioNumeroCartao() {
		return cartaoBancarioNumeroCartao;
	}

	public void setCartaoBancarioNumeroCartao(String cartaoBancarioNumeroCartao) {
		this.cartaoBancarioNumeroCartao = cartaoBancarioNumeroCartao;
	}

	public String getCartaoBancarioMesVencimento() {
		return cartaoBancarioMesVencimento;
	}

	public void setCartaoBancarioMesVencimento(String cartaoBancarioMesVencimento) {
		this.cartaoBancarioMesVencimento = cartaoBancarioMesVencimento;
	}

	public String getCartaoBancarioAnoVencimento() {
		return cartaoBancarioAnoVencimento;
	}

	public void setCartaoBancarioAnoVencimento(String cartaoBancarioAnoVencimento) {
		this.cartaoBancarioAnoVencimento = cartaoBancarioAnoVencimento;
	}

	public String getCartaoBancarioCvv() {
		return cartaoBancarioCvv;
	}

	public void setCartaoBancarioCvv(String cartaoBancarioCvv) {
		this.cartaoBancarioCvv = cartaoBancarioCvv;
	}

}
