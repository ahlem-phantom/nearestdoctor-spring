package tn.pi.server.services;

import java.util.List;

import tn.pi.server.models.Chat;

public interface IChatService {

	List<Chat> retrieveAllChats(Long id);

	Chat addChat(Chat c);

	void deleteChat(Long id);

	Chat updateChat(Chat c);

	Chat retrieveChat(Long id);

}
