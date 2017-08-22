
public class Cliente{
	
	public String nombre;
	public String telefono;
	public String direccion;
	public String correo;
	public String metros;
	public String precio_inmueble;
	public String precio_venta;

	public Cliente(String nombre,String telefono,String direccion,String correo,String metros,String precio_inmueble,String precio_venta){
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.metros = metros;
		this.precio_inmueble = precio_inmueble;
		this.precio_venta = precio_venta;

	}

	public String getNombre(){
		return nombre;
	}

	public String getTelefono(){
		return telefono;
	}

	public String getDireccion(){
		return direccion;
	}

	public String getCorreo(){
		return correo;
	}

	public String getMetros(){
		return metros;
	}

	public String getPrecio_Inmueble(){
		return precio_inmueble;
	}

	public void setPrecio_Inmueble(String precio){
		precio_inmueble = precio;
	}

	public String getPrecio_Venta(){
		return precio_venta;
	}

	public void setPrecio_Venta(String precio){
		precio_venta = precio;
	}
}
