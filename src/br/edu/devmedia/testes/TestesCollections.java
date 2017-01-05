package br.edu.devmedia.testes;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

import gnu.trove.map.TMap;
import gnu.trove.map.hash.THashMap;
import gnu.trove.set.hash.THashSet;

public class TestesCollections {
	
	public static void main(String[] args) {
		testaPerformanceJDK();
		testaPerformanceTrove();
		testaPerformanceGuava();
	}
	
	public static void testaPerformanceGuava() {
		Builder<String, Pessoa> mapaGuava = ImmutableMap.<String, Pessoa>builder();
//		THashSet<Pessoa> hasSet = new THashSet<Pessoa>();
		long tempo = Calendar.getInstance().getTimeInMillis();
		
		for (int i = 0; i < 100000 * 10; i++) {
			Endereco endereco = new Endereco();
			endereco.setEndereco("R Teste da Silva" + i);
			
			Pessoa pessoa = new Pessoa(i, "Diogo Castro" + i, 56.59 + i, endereco);
			
			mapaGuava.put("Diogo" + i, pessoa);
//			hasSet.add(pessoa);
		}
		System.out.println(Calendar.getInstance().getTimeInMillis() - tempo);
	}

	public static void testaPerformanceTrove() {
		TMap<String, Pessoa> mapaTrove = new THashMap<String, Pessoa>();
		THashSet<Pessoa> hasSet = new THashSet<Pessoa>();
		long tempo = Calendar.getInstance().getTimeInMillis();

		for (int i = 0; i < 100000 * 10; i++) {
			Endereco endereco = new Endereco();
			endereco.setEndereco("R Teste da Silva" + i);
			
			Pessoa pessoa = new Pessoa(i, "Diogo Castro" + i, 56.59 + i, endereco);
			
			mapaTrove.put("Diogo" + i, pessoa);
//			hasSet.add(pessoa);
		}
		System.out.println(Calendar.getInstance().getTimeInMillis() - tempo);
	}
	
	public static void testaPerformanceJDK() {
		Map<String, Pessoa> mapaJDK = new HashMap<String, Pessoa>();
		HashSet<Pessoa> hashSet = new HashSet<Pessoa>();
		long tempo = Calendar.getInstance().getTimeInMillis();
		
		for (int i = 0; i < 100000 * 10; i++) {
			Endereco endereco = new Endereco();
			endereco.setEndereco("R Teste da Silva" + i);
			
			Pessoa pessoa = new Pessoa(i, "Diogo Castro" + i, 56.59 + i, endereco);
			
			mapaJDK.put("Diogo" + i, pessoa);
//			hashSet.add(pessoa);
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
