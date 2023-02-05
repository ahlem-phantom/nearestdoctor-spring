package tn.pi.server.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.pi.server.config.ChatConfig;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
public class ChatController {
    
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
            System.out.println(client.request(sessionId, msg));
          //  System.out.print("Me: ");
          //  userInput = br.readLine();
        //}
        return client.request(sessionId, msg);
}
}
