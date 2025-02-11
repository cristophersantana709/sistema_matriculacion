package Sistema_matriculacion;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		InicializarBases_Datos();
		MenuPrincipal();
	}
	
	public static void InicializarBases_Datos() {
		Bases_datos.Listamatriculacion_persona = new ArrayList<matriculacion_persona>();
		Bases_datos.leerListamatriculaciopersona();
	}

	public static void MenuPrincipal() {
		Scanner sc = new Scanner(System.in);
		int opcion=0;	
		do {
			
			System.out.println("*********************************************");
			System.out.println("**********SISTEMA DE MATRICULACION***********");
			System.out.println("*********************************************");
			System.out.println();
			System.out.println("************************");
			System.out.println("MENÚ DE OPCIONES");
			System.out.println("1.- Crear persona");
			System.out.println("2.- Consultar persona");
			System.out.println("3.- Actualizar persona");
			System.out.println("4.- Salir");
			System.out.println();
			System.out.print("Seleccione una opción:");
			opcion=sc.nextInt();
			
			switch(opcion)
			{
			case 1:
				Crearmatriculacion_persona();
				break;
			case 2:
				Consultarmatriculacion_persona();
				break;
			case 3:
				Actualizarmatriculacion_persona();
				break;
			case 4:
				System.out.println("Gracias por visitarnos, adios!");
				break;
			
			}
			
			System.out.println("************************");
			
		}while(opcion!=4);
			
	}
			
	public static void Crearmatriculacion_persona() {
		Scanner sc = new Scanner(System.in);
		int id =0;
		String nombre="";
		int edad = 0;
		String correo ="";
		String profesion = "";
		
		System.out.println("*********CREACIÓN DE PERSONA********");
		System.out.print("Ingrese El Id: ");
		id = sc.nextInt(); 
		sc.nextLine();
		System.out.println();
		
		System.out.print("Ingrese El Nombre: ");
		nombre = sc.nextLine();
		System.out.println();
		
		System.out.print("Ingrese La Edad: ");
		edad = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		System.out.print("Ingrese el Correo: ");
		correo = sc.nextLine();
		System.out.println();
		
		System.out.print("Ingrese La Profesion: ");
		profesion = sc.nextLine();
		System.out.println();
		
		if(!ExisteIdpersona(id)) {
			if(!ExisteNombrepersona(nombre)) {
				matriculacion_persona objEstudiante= new matriculacion_persona(id, nombre, edad, correo, profesion);
				Bases_datos.Listamatriculacion_persona.add(objEstudiante);
				System.out.println("Producto Ingresado con Éxito!");
				Bases_datos.guardarListamatriculacion_persona();
				objEstudiante.Imprimir();
			}
			else {
				System.out.println("El Nombre ya se encuentra Ingresado en el Sistema.");
			}
		}
		else {
			System.out.println("El Id ya se encuentra Ingresado en el Sistema.");
		}	
	}

	private static boolean ExisteNombrepersona(String nombre) {
		for (matriculacion_persona elemento : Bases_datos.Listamatriculacion_persona) {
			if (elemento.nombres.equals(nombre)) {
				return true;
			}
		}
		return false;
	}

	private static boolean ExisteIdpersona(int id) {
		for (matriculacion_persona elemento : Bases_datos.Listamatriculacion_persona) {
			if (elemento.id == id) {
				return true;
			}
		}
		return false;
	}
	
	public static void Consultarmatriculacion_persona() {
		
		for (matriculacion_persona elemento : Bases_datos.Listamatriculacion_persona) {
			elemento.Imprimir();
		}
	}
	
	public static void Actualizarmatriculacion_persona() {
	    Scanner sc = new Scanner(System.in);
	    int id;
	    String nombre = "";
	    int edad = 0;
	    String correo = "";
	    String profesion = "";

	    System.out.println("********* MODIFICACIÓN DE LA PERSONA ********");
	    System.out.print("Ingrese el ID de la persona a modificar: ");
	    id = sc.nextInt();
	    sc.nextLine();
	    System.out.println();

	    if (ExisteIdpersona(id)) {
	        for (int i = 0; i < Bases_datos.Listamatriculacion_persona.size(); i++) {
	            if (id == Bases_datos.Listamatriculacion_persona.get(i).id) {
	                Bases_datos.Listamatriculacion_persona.get(i).Imprimir();

	                System.out.print("Ingrese el nuevo nombre: ");
	                nombre = sc.nextLine();
	                System.out.println();

	                System.out.print("Ingrese la nueva edad: ");
	                edad = sc.nextInt();
	                sc.nextLine();
	                System.out.println();

	                System.out.print("Ingrese el nuevo correo: ");
	                correo = sc.nextLine();
	                sc.nextLine();
	                System.out.println();

	                System.out.print("Ingrese la nueva profesion : ");
	                profesion = sc.nextLine();
	                sc.nextLine();
	                System.out.println();

	                Bases_datos.Listamatriculacion_persona.get(i).nombres = nombre;
	                Bases_datos.Listamatriculacion_persona.get(i).edad = edad;
	                Bases_datos.Listamatriculacion_persona.get(i).correo = correo;
	                Bases_datos.Listamatriculacion_persona.get(i).profesion = profesion ;

	                Bases_datos.guardarListamatriculacion_persona();
	                System.out.println("persona actualizado correctamente.");
	                return;
	            }
	        }
	    } else {
	        System.out.println("El ID ingresado no coincide con los registros.");
	    }
	}


	}

