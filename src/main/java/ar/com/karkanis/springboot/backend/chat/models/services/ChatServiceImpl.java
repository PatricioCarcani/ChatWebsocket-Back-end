package ar.com.karkanis.springboot.backend.chat.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.karkanis.springboot.backend.chat.models.dao.ChatRepository;
import ar.com.karkanis.springboot.backend.chat.models.documents.Mensaje;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatRepository chatDao;
	
	@Override
	public List<Mensaje> obtenerUltimos10Mensajes() {
		// TODO Auto-generated method stub
		return chatDao.findFirst10ByOrderByFechaDesc();
	}

	@Override
	public Mensaje guardar(Mensaje mensaje) {
		// TODO Auto-generated method stub
		return chatDao.save(mensaje);
	}

}
