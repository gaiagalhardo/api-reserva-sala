package com.gaiagalhardo.reservasala.domain.exception;

public class TipoSalaNaoEcontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public TipoSalaNaoEcontradaException(String msg) {
		super(msg);
	}

	public TipoSalaNaoEcontradaException(Long tipoSalaId) {
		this(String.format("Não existe um cadastro do tipo de sala com código %d", tipoSalaId));
	}

}
