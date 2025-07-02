package br.com.quintinno.defensiumapi.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE", updatable = false, nullable = false)
    private Long code;

    @Column(name = "CODE_PUBLIC", updatable = false, nullable = false)
    private String codePublic = UUID.randomUUID().toString();

    @Column(name = "NOME", unique = true, nullable = false)
    private String nome; 

    @Column(name = "DATA_CRIACAO", updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();
    
    @Column(name = "DATA_EDICAO")
    private LocalDateTime dataEdicao = LocalDateTime.now();

    @Column(name = "DATA_DELECAO", updatable = false)
    private LocalDateTime dataDelecao;

    @Column(name = "ACTIVE", nullable = false)
    private Boolean active = true;

    public PessoaEntity() { }

    public PessoaEntity(Long code) {
		this.code = code;
	}

	public PessoaEntity(String nome) {
        this.nome = nome;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(LocalDateTime dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public LocalDateTime getDataDelecao() {
        return dataDelecao;
    }

    public void setDataDelecao(LocalDateTime dataDelecao) {
        this.dataDelecao = dataDelecao;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
