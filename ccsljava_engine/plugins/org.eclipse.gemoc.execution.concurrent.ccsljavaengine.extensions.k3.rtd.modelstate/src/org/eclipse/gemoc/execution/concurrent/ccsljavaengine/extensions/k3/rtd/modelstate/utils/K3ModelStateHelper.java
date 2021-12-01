package org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.rtd.modelstate.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class K3ModelStateHelper {

	public static String getSerializedString(Object o) throws IOException {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
	    ObjectOutputStream so = new ObjectOutputStream(bo);
	    so.writeObject(o);
	    so.flush();
	    String serializedObject = new String(Base64.getEncoder().encode(bo.toByteArray()));
	    return serializedObject;       	
	}
	
	public static Object getDeserializedObject(String serializedObject) throws IOException, ClassNotFoundException {
		byte b[] = Base64.getDecoder().decode(serializedObject.getBytes()); 
	    ByteArrayInputStream bi = new ByteArrayInputStream(b);
	    ObjectInputStream si = new ObjectInputStream(bi);      
	    return si.readObject();
	}
}
