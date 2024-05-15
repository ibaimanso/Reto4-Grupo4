package logica;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import modelo.Audio;

/**
 * Clase usada para cambiar, pausar y reproducir el audio sacado de la base de datos;
 * @author Kaiet Zarzosa
 */

public class ControladorDeSonido {
	private Audio audio;
	private Clip clip;

	/**
	 * Constructor de la clase ControladorDeSonido.
	 * @param audio El objeto Audio a controlar.
	 */
	public ControladorDeSonido(Audio audio) {
		this.audio = audio;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Método para reproducir el audio.
	 */
	public void reproducir() {
		try {
			clip.open(AudioSystem.getAudioInputStream(audio.getAudio()));
			clip.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para pausar y reiniciar la reproducción del audio.
	 */
	public void pausar() {
		clip.stop();
		clip.close();
	}
	
	/**
	 * Método para cambiar la canción a reproducir.
	 * @param audio El nuevo objeto Audio a reproducir.
	 */
	public void cambiarCancion(Audio audio) {
		pausar();
		this.audio = audio;
	}
	
	/**
	 * Método para verificar si la ejecución del audio está activa.
	 * @return True si la ejecución está activa, False si no.
	 */
	public boolean verificarEjecucion() {
		return clip.isActive();
	}
	

}
