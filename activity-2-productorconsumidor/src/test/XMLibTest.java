package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		Mensaje mensaje = new Mensaje(new Date(), TipoNivelInteres.Alta, "Corta", "Larga");
		mensajes = new ArrayList<Mensaje>();
		mensajes.add(mensaje);

		resultado = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><documentoProductorConsumidor><mensaje><fecha>"
				+ new SimpleDateFormat("dd/MM/yyyy").format(new Date())
				+ "</fecha><nivelInteres>Alta</nivelInteres><descripcionCorta>Corta</descripcionCorta><descripcionLarga>Larga</descripcionLarga></mensaje></documentoProductorConsumidor>";
	}

	@Test
	public void testCoder() {
		try {
			assertEquals(resultado, XMLCoder.codeXML(mensajes));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDecoder() {
		try {
			assertEquals(mensajes.get(0).toString(), XMLDecoder.decodeXML(resultado, 0).get(0).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
