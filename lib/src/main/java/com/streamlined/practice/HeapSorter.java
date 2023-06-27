package com.streamlined.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HeapSorter<T> implements Sorter<T> {

	private final Heap<T> heap;
	private final T[] data;

	public HeapSorter(Comparator<T> comparator, @SuppressWarnings("unchecked") T... data) {
		this.data = data;
		heap = new Heap<>(comparator, data);
	}

	@Override
	public List<T> getSorted() {
		heap.heapify();
		while (!heap.isEmpty()) {
			heap.extractMaxAndSwapWithLastValue();
		}
		return Arrays.asList(data);
	}

}
