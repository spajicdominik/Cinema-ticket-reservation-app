package Zadatak15;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    /* private static User currentUser; */
    HashMap<String, String[]> taskUsers = new HashMap<String, String[]>();
    
    public static void main(String[] args){
        login();
    }

    private static void login(){
        System.out.println("ADMINISTRACIJA");
        System.out.println("Unesite korisnicko ime: ");
        String userName = scanner.nextLine();
        System.out.println("Unesite korisnicka prava (admin/superuser/user)");
        String userRole = scanner.nextLine();

        if(userRole.equals("admin")){
            User adminLogin = new Admin(userName, userRole);
            adminLogin.UI();
        }

        else if(userRole.equals("superuser")){
            User superuserLogin = new Superuser(userName, userRole);
            superuserLogin.UI();
        }

        else if(userRole.equals("user")){
            User userLogin = new User(userName, userRole);
            userLogin.UI();
        }
    }
}
