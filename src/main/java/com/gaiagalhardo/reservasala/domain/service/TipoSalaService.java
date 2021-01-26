package com.gaiagalhardo.reservasala.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaiagalhardo.reservasala.domain.exception.EntidadeEmUsoException;
import com.gaiagalhardo.reservasala.domain.exception.TipoSalaNaoEcontradaException;
import com.gaiagalhardo.reservasala.domain.model.TipoSala;
import com.gaiagalhardo.reservasala.domain.repository.TipoSalasRepository;

@Service
public class TipoSalaService {

	private static final String MSG_TIPO_SALA_EM_USO = "Tipo de sala de código %d, não pode ser removido, pois está em uso.";
	
	@Autowired
	private TipoSalasRepository tiposalas;
	
	@Transactional
	public TipoSala salvar(TipoSala tipoSala) {
		return tiposalas.save(tipoSala);
	}
	
	@Transactional
	public void excluir(Long id) {
		try {
			tiposalas.deleteById(id);
			tiposalas.flush();
		}catch (EmptyResultDataAccessException e) {
			throw new TipoSalaNaoEcontradaException(id);
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_TIPO_SALA_EM_USO, id));
		}
	}
	
}