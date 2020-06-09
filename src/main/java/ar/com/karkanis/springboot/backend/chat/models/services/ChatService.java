package ar.com.karkanis.springboot.backend.chat.models.services;

import java.util.List;

import ar.com.karkanis.springboot.backend.chat.models.documents.Mensaje;

public interface ChatService {
	
	public List<Mensaje> obtenerUltimos10Mensajes();
	public Mensaje guardar(Mensaje mensaje);

}
