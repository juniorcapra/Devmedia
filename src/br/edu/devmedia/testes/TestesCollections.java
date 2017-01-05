package br.edu.devmedia.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;

import gnu.trove.list.linked.TLinkedList;
import gnu.trove.map.TMap;
import gnu.trove.map.hash.THashMap;
import gnu.trove.map.hash.TIntIntHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;
import gnu.trove.set.hash.THashSet;

public class TestesCollections {
	
	public static void main(String[] args) {
		testaPerformanceJDK();
		testaPerformanceTrove();
		testaPerformanceGuava();
	}
	
	public static void testaPerformanceGuava() {
		Builder<String, Integer> mapaGuava = ImmutableMap.<String, Integer>builder();
		com.google.common.collect.ImmutableSet.Builder<Pessoa> hashSet = ImmutableSet.<Pessoa>builder();
		com.google.common.collect.ImmutableList.Builder<Pessoa> lista = ImmutableList.<Pessoa>builder();
		long tempo = Calendar.getInstance().getTimeInMillis();
		
		for (int i = 0; i < 100000 * 10; i++) {
			Endereco endereco = new Endereco();
			endereco.setEndereco("R Teste da Silva" + i);
			
			Pessoa pessoa = new Pessoa(i, "Diogo Castro" + i, 56.59 + i, endereco);
			
			mapaGuava.put("Diogo" + i, i);
//			hashSet.add(pessoa);
			lista.add(pessoa);
		}
		System.out.println(Calendar.getInstance().getTimeInMillis() - tempo);
	}

	public static void testaPerformanceTrove() {
		TMap<String, Pessoa> mapaTrove = new THashMap<String, Pessoa>();
		THashSet<Pessoa> hasSet = new THashSet<Pessoa>();
		
		TIntIntHashMap mapInt = new TIntIntHashMap();
		
		long tempo = Calendar.getInstance().getTimeInMillis();

		for (int i = 0; i < 100000 * 10; i++) {
			Endereco endereco = new Endereco();
			endereco.setEndereco("R Teste da Silva" + i);
			
			Pessoa pessoa = new Pessoa(i, "Diogo Castro" + i, 56.59 + i, endereco);
			
//			mapaTrove.put("Diogo" + i, pessoa);
			mapInt.put(i, i);
		}
		System.out.println(Calendar.getInstance().getTimeInMillis() - tempo);
	}
	
	public static void testaPerformanceJDK() {
		Map<String, Integer> mapaJDK = new HashMap<String, Integer>();
		HashSet<Pessoa> hashSet = new HashSet<Pessoa>();
		List<Pessoa> lista = new ArrayList<Pessoa>();
		long tempo = Calendar.getInstance().getTimeInMillis();
		
		for (int i = 0; i < 100000 * 10; i++) {
			Endereco endereco = new Endereco();
			endereco.setEndereco("R Teste da Silva" + i);
			
			Pessoa pessoa = new Pessoa(i, "Diogo Castro" + i, 56.59 + i, endereco);
			
			mapaJDK.put("Diogo" + i, i);
//			hashSet.add(pessoa);
//			lista.add(pessoa);
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
