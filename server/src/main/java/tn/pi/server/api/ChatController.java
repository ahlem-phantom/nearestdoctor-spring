package tn.pi.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.pi.server.config.ChatConfig;
import tn.pi.server.models.Chat;
import tn.pi.server.models.User;
import tn.pi.server.services.IChatService;
import tn.pi.server.services.IUserService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chat")
public class ChatController {

     @Autowired
	   IChatService chatService;
     @Autowired
     IUserService userService;

    @CrossOrigin
    @PostMapping("/send-msg")
	@ResponseBody
    public String sendMessage(@RequestBody Chat msg) throws FileNotFoundException, IOException  {
        File file = new File("src/main/resources/testbot-epks-54686313108b.json");
        String CREDENTIAL_FILE = file.getAbsolutePath();
        String PROJECT_ID = "testbot-epks";
        ChatConfig client = new ChatConfig(CREDENTIAL_FILE, PROJECT_ID);
        String sessionId = UUID.randomUUID().toString();
        User user = userService.retrieveUser(msg.getUser().getId());
        Chat chat = new Chat(msg.getMessageSent(), client.request(sessionId,msg.getMessageSent()) , user);
        chatService.addChat(chat);
        return client.request(sessionId, msg.getMessageSent());
    }

        @GetMapping("/get-chats/{id}")
        @ResponseBody
        public List<Chat> getChats(@PathVariable("id") Long id) {
            List<Chat> list = chatService.retrieveAllChats(id);
            return list;
        }

}
