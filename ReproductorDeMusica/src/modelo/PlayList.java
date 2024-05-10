package modelo;

public class PlayList {
	private String IDList, Titulo, FechaCreacion;

	public PlayList(String iDList, String titulo, String fechaCreacion) {
		super();
		IDList = iDList;
		Titulo = titulo;
		FechaCreacion = fechaCreacion;
	}

	public String getIDList() {
		return IDList;
	}

	public String getTitulo() {
		return Titulo;
	}

	public String getFechaCreacion() {
		return FechaCreacion;
	}

	public void setIDList(String iDList) {
		IDList = iDList;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public void setFechaCreacion(String fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}
	
}
