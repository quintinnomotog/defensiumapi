package br.com.quintinno.defensiumapi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CATEGORIA_CREDENCIAL")
public class CategoriaCredencialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE", updatable = false, nullable = false)
    private Long code;

    @Column(name = "CODE_PUBLIC", unique = true, updatable = false, nullable = false)
    private String codePublic;

    @Column(name = "DESCRICAO", unique = true, nullable = false)
    private String descricao;

    @Column(name = "NOME_ICONE", length = 20)
    private String nomeIcone;

    @Column(name = "COR_ICONE", length = 7)
    private String corIcone;

    @Column(name = "COR_FUNDO", length = 7)
    private String corFundo;

    @Column(name = "DATA_CRIACAO", updatable = false)
    private LocalDateTime dataCriacao;
    
    @Column(name = "DATA_EDICAO")
    private LocalDateTime dataEdicao;

    @Column(name = "DATA_DELECAO", updatable = false)
    private LocalDateTime dataDelecao;

    public CategoriaCredencialEntity() { }

    public CategoriaCredencialEntity(String descricao, LocalDateTime dataCriacao) {
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

}
