import java.io.*;

public class Main {
    
	public static void main(String[] args) {
		
		//1.a. Crea una función para guardar un objeto Persona en un fichero con el nombre persona1 
        Persona persona1 = new Persona(1, "nombrePrueba", 20, "99999999H");
        guardarObjeto(persona1, "persona1");

        // 1.b. Crea una función para recuperar un objeto Persona del fichero persona1
        Persona personaRecuperada = recuperarObjeto("persona1");
        System.out.println("Persona recuperada: " + personaRecuperada);

        // 1.c. Modifica sus propiedades y vuelve a guardarlo en el fichero persona1
        if (personaRecuperada != null) {
            personaRecuperada.setEdad(22);
            guardarObjeto(personaRecuperada, "persona1");
        }
        personaRecuperada = recuperarObjeto("persona1");
        System.out.println("Persona recuperada: " + personaRecuperada);

        // 2.a. Crear un fichero de texto utilizando FileWriter
        String contenido = "Esto es un texto de prueba, Estamos creando nuestro primer fichero de texto https://codigonline.com";
        try (FileWriter fileWriter = new FileWriter("ficheroTexto.txt")) {
            fileWriter.write(contenido);
            System.out.println("Fichero de texto creado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3.a Lee un fichero de tipo imagen (binario) y muestra su contenido por pantalla 	
        try (FileInputStream fis = new FileInputStream("UD1EjerciciosBLOQUE2/crondose.jpg")) {
            System.out.println("Contenido del fichero imagen:");
            int bytesContent;
            while ((bytesContent = fis.read()) != -1) {
                System.out.print(bytesContent + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }		
	}
	
	// Método para guardar un objeto de tipo Persona en un fichero
	public static void guardarObjeto(Persona persona, String nombreArchivo) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            objectOutputStream.writeObject(persona);
            System.out.println("Persona guardada correctamente en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	 
	// Método para recuperar un objeto de tipo Persona de un fichero
	public static Persona recuperarObjeto(String nombreArchivo) {
        Persona persona = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(nombreArchivo))){
            persona = (Persona)objectInputStream.readObject();
            System.out.println("Persona recuperada correctamente de " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return persona;
	}	
}

