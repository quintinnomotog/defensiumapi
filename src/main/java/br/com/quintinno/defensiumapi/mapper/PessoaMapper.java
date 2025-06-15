package br.com.quintinno.defensiumapi.mapper;

import br.com.quintinno.defensiumapi.entity.PessoaEntity;
import br.com.quintinno.defensiumapi.tranfer.PessoaRequestTranfer;

public class PessoaMapper {

    public static PessoaEntity toPessoaEntity(PessoaRequestTranfer pessoaRequestTranfer) {
        return new PessoaEntity(pessoaRequestTranfer.getNome());
    }

    public static PessoaRequestTranfer toPessoaTransfer(PessoaEntity pessoaEntity) {
        return new PessoaRequestTranfer(pessoaEntity.getNome());
    }

}
