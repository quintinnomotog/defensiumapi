package br.com.quintinno.defensiumapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.defensiumapi.entity.PessoaEntity;
import br.com.quintinno.defensiumapi.enumeration.TipoOperacaoEnumeration;
import br.com.quintinno.defensiumapi.mapper.PessoaMapper;
import br.com.quintinno.defensiumapi.repository.PessoaRepository;
import br.com.quintinno.defensiumapi.tranfer.PessoaRequestTranfer;
import br.com.quintinno.defensiumapi.tranfer.PessoaResponseTransfer;
import br.com.quintinno.defensiumapi.tranfer.RestResponseTransfer;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaEntity create(PessoaRequestTranfer pessoaRequestTranfer) {
        return this.pessoaRepository.save(PessoaMapper.toPessoaEntity(pessoaRequestTranfer));
    }

    public List<PessoaResponseTransfer> findAll() {
        List<PessoaEntity> pessoaEntityList = this.pessoaRepository.findAll();
        return PessoaMapper.toPessoaResponseTransfer(pessoaEntityList);
    }

    public PessoaResponseTransfer update(PessoaRequestTranfer pessoaRequestTranfer) {
        PessoaEntity pessoaEntity = this.pessoaRepository.findByCodePublic(pessoaRequestTranfer.getCodePublic());
        if (pessoaEntity == null) {
            throw new EntityNotFoundException("Pessoa não Encontrada!");
        }
        pessoaEntity.setNome(pessoaRequestTranfer.getNome());
        return PessoaMapper.fromPessoaResponseTransfer(this.pessoaRepository.save(pessoaEntity));
    }

    public RestResponseTransfer inativarPessoa(String codePublic) {
        PessoaEntity pessoaEntity = this.pessoaRepository.findByCodePublic(codePublic);
        if (pessoaEntity == null) {
            new EntityNotFoundException("Pessoa não Encontrada!");
        }
        pessoaEntity.setActive(false);
        RestResponseTransfer restResponseTransfer = new RestResponseTransfer<PessoaResponseTransfer>();
            restResponseTransfer.setTipoOperacaoEnumeration(TipoOperacaoEnumeration.INATIVAR);
            restResponseTransfer.setMensagem("Pessoa Inativada com Sucesso!");
            restResponseTransfer.setObject(PessoaMapper.fromPessoaResponseTransfer(pessoaEntity));
        this.pessoaRepository.save(pessoaEntity);
        return restResponseTransfer;
    }

}
