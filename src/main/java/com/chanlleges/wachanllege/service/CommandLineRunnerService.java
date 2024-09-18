package com.chanlleges.wachanllege.service;

import org.springframework.stereotype.Service;

import com.chanlleges.wachanllege.cli.AnalyzeCommand;

import picocli.CommandLine;

@Service
public class CommandLineRunnerService {

	private final AnalyzeCommand analyzeCommand;
	
	public CommandLineRunnerService(AnalyzeCommand analyzeCommand) {
		this.analyzeCommand = analyzeCommand;
	}
	
	public void run(String[] args) {
		CommandLine cmd = new CommandLine(analyzeCommand);
		cmd.execute(args);
	}
}
