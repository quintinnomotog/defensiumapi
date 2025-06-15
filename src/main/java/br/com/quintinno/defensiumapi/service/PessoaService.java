package br.com.quintinno.defensiumapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinno.defensiumapi.entity.PessoaEntity;
import br.com.quintinno.defensiumapi.mapper.PessoaMapper;
import br.com.quintinno.defensiumapi.repository.PessoaRepository;
import br.com.quintinno.defensiumapi.tranfer.PessoaRequestTranfer;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaEntity create(PessoaRequestTranfer pessoaRequestTranfer) {
        return this.pessoaRepository.save(PessoaMapper.fromPessoaEntity(pessoaRequestTranfer));
    }

}
