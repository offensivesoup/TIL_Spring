package hello.core.singleton;

public class StatefulService {

//    private int price; // 상태를 유지하는 필드
//    static int price;

    public int order(String name, int price) {
        System.out.println("name + \", price = \" + price = " + name + ", price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
