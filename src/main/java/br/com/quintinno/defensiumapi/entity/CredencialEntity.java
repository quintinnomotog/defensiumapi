package br.com.quintinno.defensiumapi.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CREDENCIAL")
public class CredencialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE", updatable = false, nullable = false)
    private Long code;

    @Column(name = "CODE_PUBLIC", updatable = false, nullable = false)
    private String codePublic;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA_CREDENCIAL")
    private CategoriaCredencialEntity categoriaCredencialEntity;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    private PessoaEntity pessoaEntity;

    @Column(name = "IDENTIFICADOR", nullable = false)
    private String identificador;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "LINK")
    private String link;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @Column(name = "ACTIVE", nullable = false)
    private Boolean active;

    @Column(name = "DATA_CRIACAO", updatable = false)
    private LocalDateTime dataCriacao;
    
    @Column(name = "DATA_EDICAO")
    private LocalDateTime dataEdicao;

    @Column(name = "DATA_DELECAO", updatable = false)
    private LocalDateTime dataDelecao;

    public CredencialEntity() {
        this.codePublic = UUID.randomUUID().toString();
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
        this.active = true;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
