package br.com.quintinno.defensiumapi.tranfer;

import java.time.LocalDateTime;
import java.util.List;

import br.com.quintinno.defensiumapi.enumeration.TipoOperacaoEnumeration;
import br.com.quintinno.defensiumapi.utility.DateUtility;

public class RestResponseTransfer<T> {

    private String mensagem;

    private String dataHora;

    private TipoOperacaoEnumeration tipoOperacaoEnumeration;

    private T object;

    private List<T> objectList = List.of();

    public RestResponseTransfer() {
        this.dataHora = DateUtility.getDataHoraFormatada(LocalDateTime.now(), DateUtility.DATA_FORMATO_DDMMAAAAHHMMSS);
    }

    public RestResponseTransfer(T object) {
        this.object = object;
    }

    public RestResponseTransfer(List<T> objectList) {
        this.objectList = objectList;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
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

    public TipoOperacaoEnumeration getTipoOperacaoEnumeration() {
        return tipoOperacaoEnumeration;
    }

    public void setTipoOperacaoEnumeration(TipoOperacaoEnumeration tipoOperacaoEnumeration) {
        this.tipoOperacaoEnumeration = tipoOperacaoEnumeration;
    }

}
