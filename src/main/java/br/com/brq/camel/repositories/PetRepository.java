package br.com.brq.camel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.camel.domain.PetEntity;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Integer> {

}
