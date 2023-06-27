package com.streamlined.practice;

import java.util.Comparator;

class Heap<T> {

	private final Comparator<T> comparator;
	private final T[] data;
	private int size;

	Heap(Comparator<T> comparator, @SuppressWarnings("unchecked") T... data) {
		this.comparator = comparator;
		this.data = data;
		size = data.length;
	}

	boolean isEmpty() {
		return size <= 0;
	}

	void heapify() {
		for (int start = getParentIndex(data.length - 1); start >= 0; start--) {
			siftDown(start, data.length);
		}
	}

	void extractMaxAndSwapWithLastValue() {
		swap(0, size - 1);
		size--;
		siftDown(0, size);
	}

	private void siftDown(int startIndex, int size) {
		int rootIndex = startIndex;
		int leftChildIndex;
		int rightChildIndex;
		
		while ((leftChildIndex = getLeftChildIndex(rootIndex)) < size) {
			int maxValueIndex = rootIndex;
			if (comparator.compare(data[maxValueIndex], data[leftChildIndex]) < 0) {
				maxValueIndex = leftChildIndex;
			}
			rightChildIndex = getRightChildIndex(rootIndex);
			if (rightChildIndex < size && comparator.compare(data[maxValueIndex], data[rightChildIndex]) < 0) {
				maxValueIndex = rightChildIndex;
			}
			if (maxValueIndex == rootIndex) {
				break;
			}
			swap(rootIndex, maxValueIndex);
			rootIndex = maxValueIndex;
		}
	}

	private void swap(int i, int j) {
		T value = data[i];
		data[i] = data[j];
		data[j] = value;
	}

	private int getParentIndex(int nodeIndex) {
		return (nodeIndex - 1) / 2;
	}

	private int getLeftChildIndex(int nodeIndex) {
		return 2 * nodeIndex + 1;
	}

	private int getRightChildIndex(int nodeIndex) {
		return 2 * nodeIndex + 2;
	}

}
