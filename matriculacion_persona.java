package Sistema_matriculacion;

import java.io.Serializable;

public class matriculacion_persona implements Serializable{
	public int id;
	public String nombres;
	public int edad;
	public String correo;
	public String profesion;
	
	public matriculacion_persona(int id, String nombres, int edad, String correo, String profesion) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.edad = edad;
		this.correo = correo;
		this.profesion = profesion;
	}

	public matriculacion_persona() {
		super();
	}

	public void Imprimir() {
		System.out.println("ID: "+this.id);
		System.out.println("Nombres: "+this.nombres);
		System.out.println("edad: "+this.edad);
		System.out.println("correo: "+this.correo);
		System.out.println("profesion: "+this.profesion);
		
	}
	

}
