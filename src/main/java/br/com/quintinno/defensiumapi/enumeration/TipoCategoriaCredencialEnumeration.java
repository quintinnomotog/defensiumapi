package br.com.quintinno.defensiumapi.enumeration;

public enum TipoCategoriaCredencialEnumeration {

    APLICATIVO(1, "Aplicativo"),
    WEBMAIL(2, "Webmail"),
    EMAIL(3, "E-mail"),
    WIFI(4, "Wi-Fi"),
    BANCO_DADOS(5, "Banco de Dados"),
    CARTAO_BANCARIO(6, "Cartão Bancário"),
    OUTROS(7, "Outros");

    private Integer code;

    private String descricao;

    private TipoCategoriaCredencialEnumeration(Integer code, String descricao) {
        this.code = code;
        this.descricao = descricao;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
