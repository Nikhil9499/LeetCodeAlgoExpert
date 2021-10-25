package LLD_Codes;

import java.util.*;

public class LRUCache {

	private final int CACHE_SIZE;

	private final Deque<Integer> doublyQueue;

	private final HashSet<Integer> hashSet;

	Set<Integer> cache;

	LRUCache(int capacity) {
		doublyQueue = new LinkedList<>();
		hashSet = new HashSet<>();
		CACHE_SIZE = capacity;
		this.cache = new LinkedHashSet<Integer>(capacity);
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.lruCache(1);
		cache.lruCache(2);
		cache.lruCache(3);
		cache.lruCache(1);
		cache.lruCache(4);
		cache.lruCache(5);
		cache.lruCache(2);
		cache.lruCache(2);
		cache.lruCache(1);
		cache.display();
		System.out.println();

		LRUCache ca = new LRUCache(4);
		ca.refer(1);
		ca.refer(2);
		ca.refer(3);
		ca.refer(1);
		ca.refer(4);
		ca.refer(5);
		ca.refer(2);
		ca.refer(2);
		ca.refer(1);
		ca.display2();
	}

	public void lruCache(int page) {
		if (!hashSet.contains(page)) {
			if (doublyQueue.size() == CACHE_SIZE) {
				int last = doublyQueue.removeLast();
				hashSet.remove(last);
			}
		} else {
			doublyQueue.remove(page);
		}
		doublyQueue.push(page);
		hashSet.add(page);
	}

	public void display() {
		Iterator<Integer> itr = doublyQueue.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	// This function returns false if key is not
	// present in cache. Else it moves the key to
	// front by first removing it and then adding
	// it, and returns true.
	public boolean get(int key) {
		if (!cache.contains(key))
			return false;
		cache.remove(key);
		cache.add(key);
		return true;
	}

	/* Refers key x with in the LRU cache */
	public void refer(int key) {
		if (!get(key))
			put(key);
	}

	public void put(int key) {

		if (cache.size() == CACHE_SIZE) {
			int firstKey = cache.iterator().next();
			cache.remove(firstKey);
		}

		cache.add(key);
	}

	public void display2() {
		LinkedList<Integer> list = new LinkedList<>(cache);

		// The descendingIterator() method of java.util.LinkedList
		// class is used to return an iterator over the elements
		// in this LinkedList in reverse sequential order
		Iterator<Integer> itr = list.descendingIterator();

		while (itr.hasNext())
			System.out.print(itr.next() + " ");
	}
}


