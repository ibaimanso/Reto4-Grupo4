package modelo;

import java.io.File;

import javax.swing.ImageIcon;

public class Podcast extends Audio{
	String colaboradores, idPodcaster;

	public Podcast(String idAudio, String nombreAudio, int duracion, ImageIcon imagen, String idPodcaster,
			String colaboradores) {
		super(idAudio, nombreAudio, duracion, imagen);
		this.colaboradores = colaboradores;
		this.idPodcaster = idPodcaster;
	}

	public Podcast(String idAudio, String nombreAudio, int duracion, ImageIcon imagen, File audio, String idPodcaster,
			String colaboradores) {
		super(idAudio, nombreAudio, duracion, imagen, audio);
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
