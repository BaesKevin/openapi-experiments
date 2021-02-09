package be.kevinbaes.hello_openapi;

import be.kevinbaes.hello_world_client.generated.ApiClient;
import be.kevinbaes.hello_world_client.generated.api.DefaultApi;
import be.kevinbaes.hello_world_client.generated.model.HelloTemplate;

public class HelloServices {

    public String sayHello(String name) {
        DefaultApi api = helloClient();

        return api.getHelloMessage(name);
    }

    public HelloTemplate helloClient(HelloTemplate helloTemplate) {
        return helloClient().createHelloTemplate(helloTemplate);
    }

    private DefaultApi helloClient() {
        ApiClient client = new ApiClient();
        client.setDebugging(true);
        client.setBasePath("http://localhost:8080");

        return new DefaultApi(client);
    }

}
