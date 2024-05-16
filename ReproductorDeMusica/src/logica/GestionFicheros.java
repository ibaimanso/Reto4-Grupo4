package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Cancion;


/**
 * Clase utilizada para leer y escribir contenido en ficheros de texto
 * @author Kaiet Zarzosa
 */

public class GestionFicheros {
	public GestionFicheros() {
	}
	
	/**
	 * Método para escribir en un fichero.
	 * @param cancion La lista de canciones a escribir.
	 * @param archivo El nombre del archivo a escribir.
	 */
	public void escribirFichero(ArrayList<Cancion> cancion, String archivo) {
		try {
			BufferedWriter escribirFichero = new BufferedWriter(new FileWriter("./" + archivo + ".txt", false));
			for (int i = 0; i < cancion.size(); i++) {
				escribirFichero.write(cancion.get(i).toString());
				escribirFichero.newLine();
				escribirFichero.write("=================================");
				escribirFichero.newLine();
			}
			escribirFichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Método para leer un fichero.
	 * @param archivo El archivo a leer.
	 * @return Una lista de canciones leídas del fichero.
	 */
	public ArrayList<Cancion> leerFichero(File archivo){
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		File fichero = archivo;
		BufferedReader lectorFichero;
		try {
			lectorFichero = new BufferedReader(new FileReader(fichero));
			String linea;
			String idCancion = "";
			String idAlbum = "";
			while ((linea = lectorFichero.readLine()) != null) {
				if (linea.startsWith("idCancion=")) {
					String cancion[] = linea.split(",");
					idCancion = cancion[0].split("=")[1];
					idAlbum = cancion[1].split("=")[1];
				} else if (linea.startsWith("=")) {
					canciones.add(new Cancion(idCancion, idAlbum));
				}
			}
			lectorFichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return canciones;
	}
}
