package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ual.dss.core.*;
import ual.dss.xmlib.XMLCoder;
import ual.dss.xmlib.XMLDecoder;

public class XMLibTest {

	List<Mensaje> mensajes;
	String resultado;
	@Before
	public void setUp() throws Exception {
		Mensaje mensaje = new Mensaje("manelme@outlook.com","nuevo mensaje");
		mensajes = new ArrayList<Mensaje>();
		mensajes.add(mensaje);
		resultado = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><documentoProductorConsumidor><mensaje><email>manelme@outlook.com</email><elemento>nuevo mensaje</elemento></mensaje></documentoProductorConsumidor>";
	}

	@Test
	public void testCoder() {
		try {
			assertEquals(resultado,XMLCoder.codeXML(mensajes));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDecoder() {
		try {
			assertEquals(mensajes.get(0).toString(),XMLDecoder.decodeXML(resultado,0).get(0).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
