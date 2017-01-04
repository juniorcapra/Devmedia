package br.edu.devmedia.testes;

import gnu.trove.function.TObjectFunction;

public class TroveObjFunction implements TObjectFunction<String, String> {

	@Override
	public String execute(String valor) {
		return "Meu nome é: " + valor;
	}

}
