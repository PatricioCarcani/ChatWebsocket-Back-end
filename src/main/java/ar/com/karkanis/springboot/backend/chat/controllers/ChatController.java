package ar.com.karkanis.springboot.backend.chat.controllers;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import ar.com.karkanis.springboot.backend.chat.models.documents.Mensaje;

@Controller
public class ChatController {
	
	@MessageMapping("/mensaje") // app/mensaje (tiene el prefijo en WebSocketConfig)
	@SendTo("/chat/mensaje") // 
	public Mensaje recibeMensaje(Mensaje mensaje) {
		
		mensaje.setFecha(new Date().getTime());
		mensaje.setTexto("Recibido por el broker: " + mensaje.getTexto());
		return mensaje;
		
	}

}
