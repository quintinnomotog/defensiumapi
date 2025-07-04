package br.com.quintinno.defensiumapi.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinno.defensiumapi.entity.CategoriaCredencialEntity;
import br.com.quintinno.defensiumapi.entity.CredencialEntity;
import br.com.quintinno.defensiumapi.entity.PessoaEntity;

@Repository
public interface CredencialRepository extends JpaRepository<CredencialEntity, Long> {

	boolean existsByCategoriaCredencialEntityAndPessoaEntityAndIdentificador(
			CategoriaCredencialEntity categoriaCredencialEntity, PessoaEntity pessoaEntity, String identificador);

     Optional<CredencialEntity> findByCode(Long code);
     
     Optional<CredencialEntity> findByCodePublic(String code);
    
     Page<CredencialEntity> findAll(Pageable pageable);

}
