package modelo;

public class Musico {
	private String nombre, clase, descripcion;
	
	public Musico() {
		
	}

	public Musico(String nombre, String clase, String descripcion) {
		super();
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Musico [nombre=" + nombre + ", clase=" + clase + ", descripcion=" + descripcion + "]";
	}

}
