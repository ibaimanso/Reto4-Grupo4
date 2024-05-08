package modelo;

import java.io.File;

import javax.swing.ImageIcon;

public class Cancion extends Audio{
	
	String idCancion, idAlbum;

	public Cancion(String idAudio, String nombreAudio, int duracion, ImageIcon imagen, String idCancion,
			String idAlbum) {
		super(idAudio, nombreAudio, duracion, imagen);
		this.idCancion = idCancion;
		this.idAlbum = idAlbum;
	} 
	
	public Cancion(String idAudio, String nombreAudio, int duracion, ImageIcon imagen,  File audio, String idCancion,
			String idAlbum) {
		super(idAudio, nombreAudio, duracion, imagen, audio);
		this.idCancion = idCancion;
		this.idAlbum = idAlbum;
	}

	public String getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(String idCancion) {
		this.idCancion = idCancion;
	}

	public String getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(String idAlbum) {
		this.idAlbum = idAlbum;
	} 
	
	
}
