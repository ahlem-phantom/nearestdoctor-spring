package tn.pi.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tn.pi.server.models.Chat;
import tn.pi.server.models.User;
import tn.pi.server.repositories.ChatRepository;
import tn.pi.server.repositories.UserRepository;

@Service
public class ChatService implements IChatService{

    @Autowired
	ChatRepository chatRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Chat> retrieveAllChats(Long id) {
        List<Chat> chats = (List<Chat>) chatRepository.getChatByUser(id);
        for (Chat chat : chats) {
            System.out.println(" chat : " + chat);
        }
        return chats;
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
