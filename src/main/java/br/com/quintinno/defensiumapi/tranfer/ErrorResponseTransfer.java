package br.com.quintinno.defensiumapi.tranfer;

public class ErrorResponseTransfer {

    private String mensagem;

    private String dataHoraRequisicao;

    public ErrorResponseTransfer() { }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDataHoraRequisicao() {
        return dataHoraRequisicao;
    }

    public void setDataHoraRequisicao(String dataHoraRequisicao) {
        this.dataHoraRequisicao = dataHoraRequisicao;
    }

}
