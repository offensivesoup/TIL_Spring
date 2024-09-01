package hello.core.singleton;

public class SingletonService {

    // static 영역에 하나의 인스턴스만 생성
    private static final SingletonService instance = new SingletonService();

    // public으로 열어서 객체 인스턴스가 필요하면 이걸로 조회
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private으로 선언해서 외부에서 사용 못하게
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체로직을 호출했다.");
    }
}
