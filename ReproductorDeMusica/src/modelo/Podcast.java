package modelo;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class Podcast extends Audio{
	String colaboradores, idPodcaster;

	public Podcast(String idAudio, String nombreAudio, int duracion, ImageIcon imagen, String colaboradores,
			String idPodcaster) {
		super(idAudio, nombreAudio, duracion, imagen);
		this.colaboradores = colaboradores;
		this.idPodcaster = idPodcaster;
	}

	public Podcast(String idAudio, String nombreAudio, int duracion, ImageIcon imagen, Clip audio, String colaboradores,
			String idPodcaster) {
		super(idAudio, nombreAudio, duracion, imagen);
		this.colaboradores = colaboradores;
		this.idPodcaster = idPodcaster;
	}

	public String getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(String colaboradores) {
		this.colaboradores = colaboradores;
	}

	public String getIdPodcaster() {
		return idPodcaster;
	}

	public void setIdPodcaster(String idPodcaster) {
		this.idPodcaster = idPodcaster;
	}
	
	
	
	
}
