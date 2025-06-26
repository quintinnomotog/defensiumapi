package br.com.quintinno.defensiumapi.tranfer;

public class CategoriaCredencialResponseTransfer {

    private Long code;

    private String codePublic;

    private String descricao;

    private String nomeIcone;

    private String corIcone;

    private String corFundo;

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
    
}
