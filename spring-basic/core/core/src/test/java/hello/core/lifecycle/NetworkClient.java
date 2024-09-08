package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url= " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 시작시 호출
    public void connect() {
        System.out.println("NetworkClient.connect");
    }

    public void call() {
        System.out.println("NetworkClient.call" + url + "call");
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("NetworkClient.disconnect" + url);
    }

    @PostConstruct
    public void init() {
        connect();
        call();
    }

    @PreDestroy
    public void close() {
        disconnect();
    }
}
