package br.com.quintinno.defensiumapi.tranfer;

import java.util.List;

public class HttpResponseTransfer<T> {

    private String mensagem;

    private String dataCriacao;

    private String operacao;

    private T object;

    private List<T> objectList;

    public HttpResponseTransfer() { }

    public HttpResponseTransfer(T object) {
        this.object = object;
    }

    public HttpResponseTransfer(List<T> objectList) {
        this.objectList = objectList;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<T> objectList) {
        this.objectList = objectList;
    }

}
