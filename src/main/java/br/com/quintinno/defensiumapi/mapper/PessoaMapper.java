package br.com.quintinno.defensiumapi.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.quintinno.defensiumapi.entity.PessoaEntity;
import br.com.quintinno.defensiumapi.tranfer.PessoaRequestTranfer;
import br.com.quintinno.defensiumapi.tranfer.PessoaResponseTransfer;
import br.com.quintinno.defensiumapi.utility.DateUtility;

public class PessoaMapper {

    public static PessoaEntity toPessoaEntity(PessoaRequestTranfer pessoaRequestTranfer) {
        return new PessoaEntity(pessoaRequestTranfer.getNome());
    }

    public static PessoaEntity toPessoaEntity(PessoaEntity pessoaEntity) {
        return new PessoaEntity(pessoaEntity.getNome());
    }

    public static PessoaRequestTranfer toPessoaTransfer(PessoaEntity pessoaEntity) {
        return new PessoaRequestTranfer(pessoaEntity.getNome());
    }

    public static List<PessoaResponseTransfer> toPessoaResponseTransfer(List<PessoaEntity> pessoaEntityList) {
        return pessoaEntityList
                .stream()
                .map(PessoaMapper::fromPessoaResponseTransfer)
                .collect(Collectors.toList());
    }

    public static PessoaResponseTransfer fromPessoaResponseTransfer(PessoaEntity pessoaEntity) {
        PessoaResponseTransfer pessoaResponseTransfer = new PessoaResponseTransfer(
        		pessoaEntity.getCode(),
                pessoaEntity.getCodePublic(),
                pessoaEntity.getNome(),
                DateUtility.getDataHoraFormatada(pessoaEntity.getDataCriacao(), DateUtility.DATA_FORMATO_DDMMAAAA),
                pessoaEntity.getActive().toString());
        return pessoaResponseTransfer;
    }

}
