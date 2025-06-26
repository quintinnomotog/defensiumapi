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

    @NotBlank(message = "Necessário informar campo obrigatório!")
    private String identificador;

    @NotBlank(message = "Necessário informar campo obrigatório!")
    private String senha;

    @NotBlank(message = "Necessário informar campo obrigatório!")
    private String descricao;

    private String link;

    private String observacao;

    private String codePublicCredencial;
    
    private String nomeIcone;

    private String corIcone;

    private String corFundo;

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

	public String getNomeIcone() {
		return nomeIcone;
	}

	public void setNomeIcone(String nomeIcone) {
		this.nomeIcone = nomeIcone;
	}

	public String getCorIcone() {
		return corIcone;
	}

	public void setCorIcone(String corIcone) {
		this.corIcone = corIcone;
	}

	public String getCorFundo() {
		return corFundo;
	}

	public void setCorFundo(String corFundo) {
		this.corFundo = corFundo;
	}

}
