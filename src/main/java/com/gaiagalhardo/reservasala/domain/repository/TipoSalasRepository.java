package com.gaiagalhardo.reservasala.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaiagalhardo.reservasala.domain.model.TipoSala;

@Repository
public interface TipoSalasRepository extends JpaRepository<TipoSala, Long>{

}
