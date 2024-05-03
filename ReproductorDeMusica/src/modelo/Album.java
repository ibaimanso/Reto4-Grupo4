package modelo;

import javax.swing.ImageIcon;

public class Album {
	private String idAlbum, titulo, año, genero, idMusico;
	private ImageIcon imagen;
	
	public Album() {
		// TODO Auto-generated constructor stub
	}

	public Album(String idAlbum, String titulo, String año, String genero, ImageIcon imagen, String idMusico) {
		super();
		this.idAlbum = idAlbum;
		this.titulo = titulo;
		this.año = año;
		this.genero = genero;
		this.idMusico = idMusico;
		this.imagen = imagen;
	}

	public String getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(String idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdMusico() {
		return idMusico;
	}

	public void setIdMusico(String idMusico) {
		this.idMusico = idMusico;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	
	
}
