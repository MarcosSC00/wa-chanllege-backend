package com.chanlleges.wachanllege.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chanlleges.wachanllege.model.Hierarchy;
import com.chanlleges.wachanllege.util.JsonLoader;

@Service
public class HierarchyService {
	private Hierarchy hierarchy;

	public HierarchyService(JsonLoader jsonLoader) {
		try {
			this.hierarchy = jsonLoader.loadHierarchy("src/main/resources/dicts/teste.json");
		} catch (RuntimeException e) {
			System.err.println( e.getMessage());
			System.exit(0);
		}
	}

	public void analizePhrase(int depth, String phrase, boolean verbose) {
		long startTime = System.currentTimeMillis();
		Optional<List<String>> count = hierarchy.analize(phrase, depth);
		long endTime = System.currentTimeMillis();
		long loadingPhraseAnalyse = endTime - startTime;

		if (count.isPresent()) {
			for (String h : count.get()) {
				System.out.print(h.toString() + "; ");
			}
		} else
			System.out.print("0");
		if (verbose) {
			System.out.println();

			System.out.println("--------------------------------------------------------------------");
			System.out.printf("%-40s%20s\n", "Tempo de verificação da frase", loadingPhraseAnalyse + " ms");
			System.out.println("--------------------------------------------------------------------");
		}
	}
}
