interface classInterface {
    public double calculateArea();
    public double calculatePerimeter();
}

class Rectangle implements classInterface {
    double a;
    double b;

    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }

    public double calculateArea(){
        return a*b;
    }

    public double calculatePerimeter(){
        return 2*a + 2*b;
    }
}

public class zadatak13 {
    public static void main(String[] args){
        Rectangle myRectangle = new Rectangle(5, 3);
        System.out.println(myRectangle.calculateArea());
        System.out.println(myRectangle.calculatePerimeter());
    }
}
