package Sistema_matriculacion;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Bases_datos {

	public static List<matriculacion_persona> Listamatriculacion_persona;
	
	public static void guardarListamatriculacion_persona() {
		String  nombreArchivo="C:\\BaseDatosISTLC\\Archmatriculacion_persona";
		try(ObjectOutputStream salida = new ObjectOutputStream( new FileOutputStream(nombreArchivo))){
		salida.writeObject(Bases_datos.Listamatriculacion_persona);
		System.out.println("Producto Grabado con Éxito!");
			
		} catch (IOException e) {
			System.out.println("Ocurrió un error al grabar el producto! ");
		}
	
	}
	
	public static void leerListamatriculaciopersona() {
		String  nombreArchivo="C:\\BaseDatosISTLC\\ArchEstudiantes";
		try  (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
			Bases_datos.Listamatriculacion_persona= (ArrayList<matriculacion_persona>) entrada.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Ocurrió un error al leer el producto! ... Comuníquese con TI.");
		}
		
		
		
	}
	
	


}
