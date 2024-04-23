package modelo;

public class Cliente {
    
	private String nombre, idCliente, apellido, idioma, usuario, contraseña, fecha_de_nacimiento, contratacion;
 



  

    public Cliente() {
    	
    }

	public Cliente(String nombre, String idCliente, String apellido, String idioma, String usuario, String contraseña,
			String fecha_de_nacimiento, String contratacion) {
		super();
		this.nombre = nombre;
		this.idCliente = idCliente;
		this.apellido = apellido;
		this.idioma = idioma;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.fecha_de_nacimiento = fecha_de_nacimiento;
		this.contratacion = contratacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getFecha_de_nacimiento() {
		return fecha_de_nacimiento;
	}

	public void setFecha_de_nacimiento(String fecha_de_nacimiento) {
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}

	public String getContratacion() {
		return contratacion;
	}

	public void setContratacion(String contratacion) {
		this.contratacion = contratacion;
	}

}
