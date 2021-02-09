package be.kevinbaes.hello_openapi;

import be.kevinbaes.goodbye_client.generated.ApiClient;
import be.kevinbaes.goodbye_client.generated.api.DefaultApi;
import be.kevinbaes.goodbye_client.generated.model.GoodByeTemplate;
import be.kevinbaes.hello_world_client.generated.model.HelloTemplate;

public class GoodbyeService {

    public String sayHello(String name) {
        DefaultApi api = helloClient();

        return api.getGoodbyeMessage(name);
    }

    public GoodByeTemplate helloClient(GoodByeTemplate goodbyeTemplate) {
        return helloClient().createGoodbyeTemplate(goodbyeTemplate);
    }

    private DefaultApi helloClient() {
        ApiClient client = new ApiClient();
        client.setDebugging(true);
        client.setBasePath("http://localhost:8080");

        return new DefaultApi(client);
    }
}
