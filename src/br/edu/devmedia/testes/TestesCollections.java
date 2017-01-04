package br.edu.devmedia.testes;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import gnu.trove.map.TMap;
import gnu.trove.map.hash.THashMap;

public class TestesCollections {
	
	public static void main(String[] args) {
		Map<String, String> mapaJDK = new HashMap<String, String>();
		long tempo = Calendar.getInstance().getTimeInMillis();
		for (int i = 0; i < 100000; i++) {
			mapaJDK.put("Diogo", "DevMedia");
		}
		System.out.println(Calendar.getInstance().getTimeInMillis() - tempo);
		
	}

	public void testaProceduresFunctions() {
		TMap<String, String> mapa = new THashMap<String, String>();
		mapa.put("Diogo", "123");
		mapa.put("Ana", "321");
		
		System.out.println("Processando procedure");
		for (String v : mapa.values()) {
			System.out.println(v);
		}
		
		mapa.forEachValue(new TroveObjProcedure());
		
		mapa.transformValues(new TroveObjFunction());
		
		System.out.println("Processando function");
		for (String v : mapa.values()) {
			System.out.println(v);
		}
	}
	
}
