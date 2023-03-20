package ual.dss.core;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Mensaje.
 */
public class Mensaje {

	/** The fecha. */
	private Date fecha;
	
	/** The nivelInteres. */
	private TipoNivelInteres nivelInteres;
	
	private String descripcionCorta;
	
	private String descripcionLarga;
	
	/**
	 * Instantiates a new mensaje.
	 */
	public Mensaje(){
		fecha=new Date();
		nivelInteres=TipoNivelInteres.Alta;
		descripcionCorta="";
		descripcionLarga="";
	}
	
	/**
	 * Instantiates a new mensaje.
	 *
	 * @param fecha the fecha
	 * @param nivelInteres the nivelInteres
	 */
	public Mensaje(Date fecha, TipoNivelInteres nivelInteres, String descripcionCorta, String descripcionLarga){
		this.fecha=fecha;
		this.nivelInteres=nivelInteres;
		this.descripcionCorta=descripcionCorta;
		this.descripcionLarga=descripcionLarga;
	}

	/**
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public Date getfecha() {
		return fecha;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the new fecha
	 */
	public void setfecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Gets the nivelInteres.
	 *
	 * @return the nivelInteres
	 */
	public TipoNivelInteres getnivelInteres() {
		return nivelInteres;
	}

	/**
	 * Sets the nivelInteres.
	 *
	 * @param nivelInteres the new nivelInteres
	 */
	public void setnivelInteres(TipoNivelInteres nivelInteres) {
		this.nivelInteres = nivelInteres;
	}
	
	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionLarga() {
		return descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mensaje [fecha=" + new SimpleDateFormat("dd/MM/yyyy").format(fecha) + ", nivelInteres=" + nivelInteres.toString() + ", descripcionCorta=" + descripcionCorta + ", descripcionLarga=" + descripcionLarga + "]";
	}
	
}
