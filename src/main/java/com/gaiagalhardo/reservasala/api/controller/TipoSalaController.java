package com.gaiagalhardo.reservasala.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaiagalhardo.reservasala.domain.model.TipoSala;
import com.gaiagalhardo.reservasala.domain.repository.TipoSalasRepository;

@RestController
@RequestMapping("/tipos-sala")
public class TipoSalaController {

	@Autowired
	private TipoSalasRepository tipoSalas;

	@GetMapping
	public List<TipoSala> listar() {
		return tipoSalas.findAll();
	}

}
