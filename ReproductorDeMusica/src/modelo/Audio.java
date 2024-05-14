package modelo;

import java.io.File;

import javax.swing.ImageIcon;

public class Audio {

	private String idAudio, nombreAudio;
	private int duracion;
	private ImageIcon imagen;
	private File audio;

	public Audio(String idAudio, String nombreAudio, int duracion, ImageIcon imagen) {
		super();
		this.idAudio = idAudio;
		this.nombreAudio = nombreAudio;
		this.duracion = duracion;
		this.imagen = imagen;
	}

	public Audio(String idAudio, String nombreAudio, int duracion, ImageIcon imagen, File audio) {
		super();
		this.idAudio = idAudio;
		this.nombreAudio = nombreAudio;
		this.duracion = duracion;
		this.imagen = imagen;
		this.audio = audio;
	}

	public Audio() {
		// TODO Auto-generated constructor stub
	}

	public String getIdAudio() {
		return idAudio;
	}

	public void setIdAudio(String idAudio) {
		this.idAudio = idAudio;
	}

	public String getNombreAudio() {
		return nombreAudio;
	}

	public void setNombreAudio(String nombreAudio) {
		this.nombreAudio = nombreAudio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public File getAudio() {
		return audio;
	}

	public void setAudio(File audio) {
		this.audio = audio;
	}

}
