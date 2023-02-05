package tn.pi.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.pi.server.config.ChatConfig;
import tn.pi.server.models.Chat;
import tn.pi.server.services.IChatService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/chat")
public class ChatController {

  @Autowired
	IChatService chatService;

  @PostMapping("/test")
	@ResponseBody
    public String processRequest(@RequestBody String msg) throws FileNotFoundException, IOException  {
        String CREDENTIAL_FILE = "C:/Users/Ahlem/Desktop/hello world/nearestdoctors/server/src/main/resources/testbot-epks-54686313108b.json";
        String PROJECT_ID = "testbot-epks";
        ChatConfig client = new ChatConfig(CREDENTIAL_FILE, PROJECT_ID);
        String sessionId = UUID.randomUUID().toString();
          
        //to refine
      //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //  System.out.println("Talk to the bot, press Ctrl-D to exit\n");
     //   System.out.print("Me: ");
       // String userInput = br.readLine();
       // while (userInput != null) {
         //   System.out.print("Bot: ");
          //  System.out.print("Me: ");
          //  userInput = br.readLine();
        //}
        Chat chat = new Chat(msg, client.request(sessionId, msg));
        chatService.addChat(chat);
        return client.request(sessionId, msg);
}
}
