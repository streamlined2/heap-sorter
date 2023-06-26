package com.streamlined.practice;

import java.util.Comparator;
import java.util.List;

public class HeapSorter<T> implements Sorter<T> {

	private final Comparator<T> comparator;
	private final List<T> data;

	public HeapSorter(Comparator<T> comparator, List<T> data) {
		this.comparator = comparator;
		this.data = data;
	}

	@Override
	public List<T> getSorted() {
		// TODO Auto-generated method stub
		return null;
	}

}
