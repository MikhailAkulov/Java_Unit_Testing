package main.java.ru.gb.examples.Example_4.Seminar.webService;

public class WebService {
    MyHttpClient myHttpClient;
    public WebService(MyHttpClient myHttpClient) {
        this.myHttpClient = myHttpClient;
    }

    public String sendRequest(String url) {
        return myHttpClient.get(url);
    }
}
