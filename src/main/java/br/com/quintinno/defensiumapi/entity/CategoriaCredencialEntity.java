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

    @Column(name = "DATA_CRIACAO", updatable = false)
    private LocalDateTime dataCriacao;
    
    @Column(name = "DATA_EDICAO")
    private LocalDateTime dataEdicao;

    @Column(name = "DATA_DELECAO", updatable = false)
    private LocalDateTime dataDelecao;

    public CategoriaCredencialEntity() { }

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
