	package modelo;

import javax.swing.ImageIcon;

public class Musico {
	private String id, nombre,  clase, descripcion;
	private ImageIcon imagen;
	public Musico() {
		
	}

	public Musico(String id, String nombre,ImageIcon imagen, String clase, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.clase = clase;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	
}
