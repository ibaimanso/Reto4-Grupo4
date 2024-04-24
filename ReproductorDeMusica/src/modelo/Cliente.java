package modelo;

public class Cliente {
	private String nombre, idCliente, apellido, usuario, contraseña, fecha_de_nacimiento, contratacion;
    private String idioma;
    private String premium;


 
    public Cliente() {

    }

    public Cliente(String nombre, String idCliente, String apellido, String usuario, String contraseña,
            String fecha_de_nacimiento, String contratacion, String idioma, String premium) {
        super();
        this.nombre = nombre;
        this.idCliente = idCliente;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.contratacion = contratacion;
        this.idioma = idioma;
        this.premium = premium;
        
    }


	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
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

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}
