package com.chanlleges.wachanllege.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Hierarchy {

	private String name;
	private List<Hierarchy> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Hierarchy> getChildren() {
		return children;
	}

	public void setChildren(List<Hierarchy> children) {
		this.children = children;
	}

	public Optional<List<String>> analize(String phrase, int depth) {
		List<String> listPhrase = List.of(phrase.replaceAll("[,.!?]", "").trim().split(" "));
		Map<Optional<Hierarchy>, Integer> countElements = new HashMap<>();
		List<Optional<Hierarchy>> roots = new ArrayList<>();
		List<String> repeatedRoots = new ArrayList<>();

		for (String p : listPhrase) {
			Optional<Hierarchy> result = findFather(p, depth);
			if (result != null) {
				roots.add(result);
			}
		}

		if (!roots.isEmpty()) {
			for (Optional<Hierarchy> h : roots) {
				countElements.put(h, countElements.getOrDefault(h, 0) + 1);
			}

			for (Map.Entry<Optional<Hierarchy>, Integer> entry : countElements.entrySet()) {
				if (entry.getValue() >= 1) {
					repeatedRoots.add(entry.getKey().get().getName() + ": " + entry.getValue());
				}
			}
			return Optional.of(repeatedRoots);
		}
		return Optional.empty();
	}

	public Optional<Hierarchy> findFather(String name, int depth) {
		Optional<List<Hierarchy>> path = findPath(name, new ArrayList<>());
		if (path.isPresent()) {
			if (depth == path.get().size() - 1) {
				return Optional.of(path.get().get(path.get().size() - 2));
			}
		}
		return null;
	}

	public Optional<List<Hierarchy>> findPath(String name, List<Hierarchy> path) {
		path.add(this);
		if (this.name.equalsIgnoreCase(name)) {
			return Optional.of(path);
		}
		if (children != null) {
			for (Hierarchy child : children) {
				Optional<List<Hierarchy>> result = child.findPath(name, new ArrayList<>(path));
				if (result.isPresent()) {
					return result;
				}
			}
		}
		return Optional.empty();
	}
}
