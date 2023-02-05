package tn.pi.server.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tn.pi.server.models.Chat;
import tn.pi.server.repositories.ChatRepository;

@Service
public class ChatService implements IChatService{

    @Autowired
	ChatRepository chatRepository;

    @Override
    public List<Chat> retrieveAllChats() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Chat addChat(Chat c) {
        chatRepository.save(c);
		return c;
    }

    @Override
    public void deleteChat(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Chat updateChat(Chat c) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Chat retrieveChat(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
