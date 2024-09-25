import java.io.*;

public class Main {

    // Método para guardar un objeto de tipo Persona en un fichero
	public static void guardarObjeto(Persona persona, String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(persona);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	 
	// Método para recuperar un objeto de tipo Persona de un fichero
	public static Persona recuperarObjeto(String filename) {
        Persona persona = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))){
            persona = (Persona)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return persona;
	}	
    
	public static void main(String[] args) {
		
		//1.a. Crea una función para guardar un objeto Persona en un fichero con el nombre persona1 
        // Creamos el objeto Persona
        Persona persona1 = new Persona(1, "Jose", 20, "Lehendakari Aguirre 10 Deusto (Bilbao)");
        //Guardamos el objeto Persona en un fichero 
        guardarObjeto(persona1, "persona1");

        // 1.b. Crea una función para recuperar un objeto Persona del fichero persona1
        //  Recuperamos el objeto Persona del fichero
        Persona personaRecuperada = recuperarObjeto("persona1");
        System.out.println(personaRecuperada);

        // 1.c. Modifica sus propiedades y vuelve a guardarlo en el fichero persona1
        if (personaRecuperada != null) {
            // Modificamos una propiedad p.e: edad
            personaRecuperada.setEdad(22);
            personaRecuperada.setNombre("Pedro");
            // Guardamos nuevamente el objeto modificado en el fichero
            guardarObjeto(personaRecuperada, "persona1");
        }
        //  Recuperamos de nuevo el objeto Persona del fichero para ver los cambios
        personaRecuperada = recuperarObjeto("persona1");
        System.out.println(personaRecuperada);

        // 2.a. Crear un fichero de texto utilizando FileWriter
        String contenido = "Esto es un texto de prueba, Estamos creando nuestro primer fichero de texto https://codigonline.com";
        try (FileWriter fileWriter = new FileWriter("fichero.txt")) {
            fileWriter.write(contenido);
            System.out.println("Fichero de texto creado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3.a Lee un fichero de tipo imagen (binario) y muestra su contenido por pantalla 	
        try (FileInputStream fileInputStream = new FileInputStream("crondose.jpg")) {
            System.out.println("Contenido del fichero imagen:");
            int content;
            while ((content = fileInputStream.read()) != -1) {
               // System.out.print(content + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }		
	}
}

