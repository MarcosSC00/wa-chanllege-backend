package com.chanlleges.wachanllege.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.chanlleges.wachanllege.model.Hierarchy;
import com.chanlleges.wachanllege.util.JsonLoader;

class HierarchyServiceTest {

	@Mock
	JsonLoader jsonLoader;
	
	private Hierarchy hierarchy;
	private HierarchyService service;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		hierarchy = mock(Hierarchy.class);
		
		when(jsonLoader.loadHierarchy(anyString())).thenReturn(hierarchy);
		service = new HierarchyService(jsonLoader);
	}

	@Test
	void testAnalizePhrase() {
		String phrase = "child1 child2";
		int depth = 1;
		boolean verbose = false;

		List<String> analysisResult = List.of("Root: 2");
		when(hierarchy.analize(anyString(), eq(depth))).thenReturn(Optional.of(analysisResult));

		service.analizePhrase(depth, phrase, verbose);
		verify(hierarchy).analize(phrase, depth);
	}

	@Test
	public void testAnalyzePhraseEmptyResult() {
		String phrase = "NonExistent";
		int depth = 1;
		boolean verbose = true;

		when(hierarchy.analize(anyString(), eq(depth))).thenReturn(Optional.empty());
		service.analizePhrase(depth, phrase, verbose);

		verify(hierarchy).analize(phrase, depth);
	}
}
