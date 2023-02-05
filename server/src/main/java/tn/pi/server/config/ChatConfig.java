package tn.pi.server.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.SessionsSettings;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.TextInput;

public class ChatConfig {
    private SessionsClient client;

    private String project;

    public ChatConfig (String credentialFile, String project) throws FileNotFoundException, IOException {
        this.project = project;
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(credentialFile));
        SessionsSettings settings = SessionsSettings.newBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build();
        client = SessionsClient.create(settings);
    }
    
    public String request(String sessionId, String message) {
        QueryInput queryInput;
        queryInput = QueryInput.newBuilder()
                .setText(
                        TextInput.newBuilder()
                        .setText(message)
                        .setLanguageCode("EN")
                        .build())
                .build();

        // Perform query
        SessionName session = SessionName.of(project, sessionId);
        DetectIntentResponse actualResponse = client.detectIntent(session, queryInput);
        return actualResponse.getQueryResult().getFulfillmentText();
    }

}
