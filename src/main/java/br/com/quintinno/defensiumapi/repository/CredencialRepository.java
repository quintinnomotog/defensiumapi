package br.com.quintinno.defensiumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinno.defensiumapi.entity.CredencialEntity;

@Repository
public interface CredencialRepository extends JpaRepository<CredencialEntity, Long> { }
