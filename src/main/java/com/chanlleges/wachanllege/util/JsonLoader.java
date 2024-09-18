package com.chanlleges.wachanllege.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;

import com.chanlleges.wachanllege.model.Hierarchy;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonLoader {
	public Hierarchy loadHierarchy(String pathFile) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(Paths.get(pathFile).toFile(), Hierarchy.class);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Arquivo: "+pathFile +" não encontrado");
		}
		catch (IOException e){
			throw new RuntimeException("Erro ao carregar hierarquia de :" + pathFile, e);
		}
	}
}
