package br.com.quintinno.defensiumapi.tranfer;

import br.com.quintinno.defensiumapi.entity.CategoriaCredencialEntity;
import br.com.quintinno.defensiumapi.entity.PessoaEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CredencialRequestTransfer {

    @Valid
    @NotNull(message = "Necessário informar campo obrigatório!")
    private CategoriaCredencialEntity categoriaCredencialEntity;

    @Valid
    @NotNull(message = "Necessário informar campo obrigatório!")
    private PessoaEntity pessoaEntity;

//    @NotBlank(message = "Necessário informar campo obrigatório!")
    private String identificador;

    @NotBlank(message = "Necessário informar campo obrigatório!")
    private String senha;

    private String descricao;

    private String link;

    private String observacao;

    private String codePublicCredencial;
    
    private String databaseHostname;
    
    private String databasePorta;
    
    private String databaseNome;
    
    private String databaseUsuario;
    
    private String cartaoBancarioNomeTitular;
    
    private String cartaoBancarioNumeroCartao;
    
    private String cartaoBancarioMesVencimento;
    
    private String cartaoBancarioAnoVencimento;
    
    private String cartaoBancarioCvv;
    
    public CategoriaCredencialEntity getCategoriaCredencialEntity() {
        return categoriaCredencialEntity;
    }

    public void setCategoriaCredencialEntity(CategoriaCredencialEntity categoriaCredencialEntity) {
        this.categoriaCredencialEntity = categoriaCredencialEntity;
    }

    public PessoaEntity getPessoaEntity() {
        return pessoaEntity;
    }

    public void setPessoaEntity(PessoaEntity pessoaEntity) {
        this.pessoaEntity = pessoaEntity;
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

    public String getCodePublicCredencial() {
        return codePublicCredencial;
    }

    public void setCodePublicCredencial(String codePublicCredencial) {
        this.codePublicCredencial = codePublicCredencial;
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
