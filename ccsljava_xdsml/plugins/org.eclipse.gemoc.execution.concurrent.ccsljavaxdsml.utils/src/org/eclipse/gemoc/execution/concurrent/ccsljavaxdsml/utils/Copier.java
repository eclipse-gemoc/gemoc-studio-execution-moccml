package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Copier {
	
	
	public static Object clone(Object o) {
		if (o instanceof Cloneable) {
			try {
				Method m = o.getClass().getMethod("clone");
				m.setAccessible(true);
				return  m.invoke(o);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		} 
		if (o instanceof Number) {
			return ((Number)o);
		}
		if (o instanceof String) {
			return ((String) o);
		}
		if (o instanceof Boolean) {
			return ((Boolean) o);
		}
		if (o instanceof Collection) {
				Collection l = (Collection) o;
				Collection r = allocateCloneContainer(l, l.size());
				for (Object oo : l) {
					r.add(Copier.clone(oo));
				}
				return r;
		}
		if (o instanceof Map) {
				Map l = (Map) o;
				Map r = allocateCloneContainer(l, l.size());
				Set<Entry> entrySet = l.entrySet();
				for (Entry e : entrySet) {
					r.put(Copier.clone(e.getKey()), Copier.clone(e.getValue()));
				}
				return r;
		}
//		if (o instanceof Serializable) {
//			JavaSerializer js = new JavaSerializer();
//			return (E) js.getDefaultSerializer().clone(o);
//		} 
			throw new IllegalArgumentException("unable to clone instances of " + o.getClass());
		
	}
	
	
	
	private static <E> E allocateCloneContainer(E o, int size) {
		try {
			E r = (E) o.getClass().getConstructor(int.class).newInstance(size);
			return (E) r;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

}
