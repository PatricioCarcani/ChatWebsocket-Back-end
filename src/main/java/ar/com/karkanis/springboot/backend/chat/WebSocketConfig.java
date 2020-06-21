package ar.com.karkanis.springboot.backend.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ch"
				+ "at-websocket")
		.setAllowedOrigins("https://karkanis.com.ar/github/chat-app/chat", "*") // heroku 
		//.setAllowedOrigins("http://localhost:4200") // CORS, para habilitar Angular
		.withSockJS(); // STOMP usara SocksJs y protocolo HTTP en lugar del protocolo WS, para hacer mas compatible y evitar firewalls
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/chat/"); // nombre del evento
		registry.setApplicationDestinationPrefixes("/app"); //destino del payload
	}
	
}
