package myh;

public class Throw {
    public static void main(String[] args) {
        Number u = new Number();
        try {
            u.seta(129);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(u);
    }
}

class Number {
    private int a;
    public Number() {
    }

    public int geta() {
        return a;
    }
    public void seta(int a) throws Exception {
        if (a < -127 || a > 128) {
            throw new Exception("数字超出范围");
        }
        this.a = a;
    }
    @Override
    public String toString() {
        return "Number [数字=" + a + "]";
    }
}

