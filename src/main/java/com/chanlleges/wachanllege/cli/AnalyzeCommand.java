package com.chanlleges.wachanllege.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chanlleges.wachanllege.service.HierarchyService;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "analyze", description = "analisar uma frase e exibir o nó mais próximo de um elemento presente na frase,"
		+ " de acordo com a profundidade especificada")
public class AnalyzeCommand implements Runnable {

	@Option(names = "--verbose", description = "exibir métricas", required = false)
	private boolean verbose;

	@Option(names = "--depth", description = "nível profundidade", required = true)
	private int depth;

	@Parameters(paramLabel = "<phrase>", description = "frase a ser analisada", arity = "1")
	private String phrase;

	@Autowired
	HierarchyService service;

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		service.analizePhrase(depth, phrase, verbose);
		long endTime = System.currentTimeMillis();
		long loadingParamsTime = endTime - startTime;

		if (verbose) {
			System.out.printf("%-40s%20s\n", "Tempo de carregamento dos parametros", loadingParamsTime + " ms");
			System.out.println("--------------------------------------------------------------------");
		}

		System.exit(0);
	}
}
