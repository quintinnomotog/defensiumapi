package br.com.quintinno.defensiumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinno.defensiumapi.entity.CategoriaCredencialEntity;
import br.com.quintinno.defensiumapi.entity.CredencialEntity;
import br.com.quintinno.defensiumapi.entity.PessoaEntity;

@Repository
public interface CredencialRepository extends JpaRepository<CredencialEntity, Long> {

    public boolean existsByCategoriaCredencialEntityAndPessoaEntityAndIdentificador(
        CategoriaCredencialEntity categoriaCredencialEntity,
        PessoaEntity pessoaEntity,
        String identificador
    );

}
