package logica;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import modelo.Audio;

public class ControladorDeSonido {
	private Audio audio;
	private Clip clip;

	public ControladorDeSonido(Audio audio) {
		this.audio = audio;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}

	public void reproducir() {
		try {
			clip.open(AudioSystem.getAudioInputStream(audio.getAudio()));
			clip.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pausar() {
		clip.stop();
		clip.close();
	}
	
	

}
