package br.com.quintinno.defensiumapi.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PessoaInterfaceRepository {

    @PersistenceContext
    private EntityManager entityManager;

}
