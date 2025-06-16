package br.com.quintinno.defensiumapi.mapper;

import br.com.quintinno.defensiumapi.entity.CredencialEntity;
import br.com.quintinno.defensiumapi.tranfer.CredencialRequestTransfer;
import br.com.quintinno.defensiumapi.tranfer.CredencialResponseTransfer;
import br.com.quintinno.defensiumapi.utility.DateUtility;

public class CredencialMapper {

    public static CredencialEntity toCredencialEntity(CredencialRequestTransfer credencialRequestTransfer) {
        CredencialEntity credencialEntity = new CredencialEntity();
            credencialEntity.setActive(true);
            credencialEntity.setCategoriaCredencialEntity(credencialRequestTransfer.getCategoriaCredencialEntity());
            credencialEntity.setDataCriacao(DateUtility.getDataHora());
            credencialEntity.setDataEdicao(DateUtility.getDataHora());
            credencialEntity.setDescricao(credencialRequestTransfer.getDescricao());
            credencialEntity.setIdentificador(credencialRequestTransfer.getIdentificador());
            credencialEntity.setLink(credencialRequestTransfer.getLink());
            credencialEntity.setObservacao(credencialRequestTransfer.getObservacao());
            credencialEntity.setPessoaEntity(credencialRequestTransfer.getPessoaEntity());
            credencialEntity.setSenha(credencialRequestTransfer.getSenha());
        return credencialEntity;
    }

    public static CredencialResponseTransfer toCredencialResponseTransfer(CredencialEntity credencialEntity) {
        CredencialResponseTransfer credencialResponseTransfer = new CredencialResponseTransfer();
            credencialResponseTransfer.setActive(credencialEntity.getActive().toString());
            credencialResponseTransfer.setCodePublic(credencialEntity.getCodePublic());
            credencialResponseTransfer.setIdentificador(credencialEntity.getIdentificador());
            credencialResponseTransfer.setSenha("**************");
            credencialResponseTransfer.setLink(credencialEntity.getLink());
            credencialResponseTransfer.setDescricao(credencialEntity.getDescricao());
            credencialResponseTransfer.setObservacao(credencialEntity.getObservacao());
            credencialResponseTransfer.setDataOperacao(DateUtility.getDataHoraFormatada(credencialEntity.getDataCriacao(), DateUtility.DATA_FORMATO_DDMMAAAAHHMMSS));
        return credencialResponseTransfer;
    }

}
