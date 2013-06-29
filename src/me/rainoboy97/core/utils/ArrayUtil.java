package me.rainoboy97.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

/** Class/methods taken and modified from MCore - MassiveCraft **/

public class ArrayUtil {

	static Random random = new Random();

	@SafeVarargs
	public static <T> List<T> list(T... items) {
		return new ArrayList<T>(Arrays.asList(items));
	}

	@SafeVarargs
	public static <T> Set<T> set(T... items) {
		return new LinkedHashSet<T>(Arrays.asList(items));
	}

	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> map(K key1, V value1, Object... objects) {
		Map<K, V> ret = new LinkedHashMap<K, V>();

		ret.put(key1, value1);

		Iterator<Object> iter = Arrays.asList(objects).iterator();
		while (iter.hasNext()) {
			K key = (K) iter.next();
			V value = (V) iter.next();
			ret.put(key, value);
		}

		return ret;
	}

	public static <K, V> Map<V, K> flippedMap(Map<K, V> map) {
		Map<V, K> ret = new LinkedHashMap<V, K>();

		for (Entry<K, V> entry : map.entrySet()) {
			V value = entry.getValue();
			K key = entry.getKey();

			if (value == null)
				continue;
			ret.put(value, key);
		}

		return ret;
	}

	// -------------------------------------------- //
	// LE NICE RANDOM
	// -------------------------------------------- //

	public static <T> T random(Collection<T> coll) {
		if (coll.size() == 0)
			return null;
		if (coll.size() == 1)
			return coll.iterator().next();
		int index = random.nextInt(coll.size());
		return new ArrayList<T>(coll).get(index);
	}

}
