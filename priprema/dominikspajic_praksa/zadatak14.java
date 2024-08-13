import java.lang.Math;


interface Riemann {
    public double Area(double A, double B);
}

class Curve implements Riemann{
    double A;
    double B;
    String trigFunction;
    double T1;
    double T2;

    public Curve(double A, double B, String trigFunction){
        this.A = A;
        this.B = B;
        this.trigFunction = trigFunction;
    }

    public double Area(double T1, double T2){
        if(T2 < T1){
            System.out.println("Krive granice!");
        }

        this.T1 = T1;
        this.T2 = T2;

        double delta_x = (T2 - T1)/20;
        double r_integral = 0;

        if(trigFunction == "sin"){
            for(int i = 1; i <= 20; i++){
                double x_i = T1 + i*delta_x;
                double x_i_1 = T1 + T1 + (i-1)*delta_x;
                r_integral += (A*Math.sin((x_i_1 + x_i)/2)+B)*delta_x;
            }
        }

        else if(trigFunction == "cos"){
            for(int i = 1; i <= 20; i++){
                double x_i = T1 + i*delta_x;
                double x_i_1 = T1 + T1 + (i-1)*delta_x;
                r_integral += (A*Math.cos((x_i_1 + x_i)/2)+B)*delta_x;
            }
        }

        else if(trigFunction == "tg"){
            for(int i = 1; i <= 20; i++){
                double x_i = T1 + i*delta_x;
                double x_i_1 = T1 + T1 + (i-1)*delta_x;
                r_integral += (A*Math.tan((x_i_1 + x_i)/2)+B)*delta_x;
            }
        }

        else if(trigFunction == "ctg"){
            for(int i = 1; i <= 20; i++){
                double x_i = T1 + i*delta_x;
                double x_i_1 = T1 + T1 + (i-1)*delta_x;
                r_integral += (A*(1/(Math.tan((x_i_1 + x_i)/2)))+B)*delta_x;
            }
        }
        return r_integral;

    }

}

public class zadatak14 {
    public static void main(String[] args){
        Curve function = new Curve(5, 2, "sin");
        System.out.println(function.Area(0, 30));
    }
}
