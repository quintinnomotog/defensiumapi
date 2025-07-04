package br.com.quintinno.defensiumapi.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.quintinno.defensiumapi.entity.CredencialEntity;
import br.com.quintinno.defensiumapi.tranfer.CredencialRequestTransfer;
import br.com.quintinno.defensiumapi.tranfer.CredencialResponseTransfer;
import br.com.quintinno.defensiumapi.utility.DateUtility;

public class CredencialMapper {

    private CredencialMapper() {
        throw new UnsupportedOperationException("Essa classe não permite instâncias!");
    }

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
            credencialResponseTransfer.setNomePessoa(credencialEntity.getPessoaEntity().getNome());
        return credencialResponseTransfer;
    }
    
	public static Page<CredencialResponseTransfer> toCredencialResponseTransferPage(Page<CredencialEntity> entityPage) {
		List<CredencialResponseTransfer> transferList = entityPage.getContent().stream()
				.map(CredencialMapper::toCredencialResponseTransfer).collect(Collectors.toList());
		return new PageImpl<>(transferList, entityPage.getPageable(), entityPage.getTotalElements());
	}

    public static List<CredencialResponseTransfer> toCredencialResponseTransfer(List<CredencialEntity> credencialEntityList) {
        return credencialEntityList
                .stream()
                .map(CredencialMapper::toCredencialResponseTransfer)
                .toList();
    }

    public static CredencialEntity toCredencialEntity(CredencialRequestTransfer credencialRequestTransfer, CredencialEntity credencialEntity) {
            credencialEntity.setCategoriaCredencialEntity(credencialRequestTransfer.getCategoriaCredencialEntity());
            credencialEntity.setDataEdicao(DateUtility.getDataHora());
            credencialEntity.setDescricao(credencialRequestTransfer.getDescricao());
            credencialEntity.setIdentificador(credencialRequestTransfer.getIdentificador());
            credencialEntity.setLink(credencialRequestTransfer.getLink());
            credencialEntity.setObservacao(credencialRequestTransfer.getObservacao());
            credencialEntity.setPessoaEntity(credencialRequestTransfer.getPessoaEntity());
            credencialEntity.setSenha(credencialRequestTransfer.getSenha());
        return credencialEntity;
    }

}
