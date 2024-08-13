package Zadatak15;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Task {
    String name, description, type, currStatus;
    Integer complexity, investedTime;
    LocalDateTime startTime, endTime;

    public Task(String name, String description, String type, String currStatus, 
    Integer complexity, Integer investedTime,
    LocalDateTime startTime, LocalDateTime endTime){
        this.name = name;
        this.description = description;
        this.type = type;
        this.currStatus = currStatus;
        this.complexity = complexity;
        this.investedTime = investedTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void postTaskUI(){
        System.out.println("Unesite sljedece podatke o zadatku:");

        System.out.print("Naziv: ");
        Scanner nameScanner = new Scanner(System.in);
        String scannedName = nameScanner.nextLine();

        System.out.print("Opis: ");
        Scanner descScanner = new Scanner(System.in);
        String scannedDesc = descScanner.nextLine();

        System.out.print("Tip zadatka(bug/task): ");
        Scanner typeScanner = new Scanner(System.in);
        String scannedType = typeScanner.nextLine();

        System.out.print("Trenutni status: ");
        Scanner statusScanner = new Scanner(System.in);
        String scannedStatus = statusScanner.nextLine();

        System.out.print("Kompleksnost: ");
        Scanner compScanner = new Scanner(System.in);
        Integer scannedComp = compScanner.nextInt();

        System.out.print("Potroseno vrijeme: ");
        Scanner invScanner = new Scanner(System.in);
        Integer scannedInv = invScanner.nextInt();

            
    }

    public void postTask(String name, String description, String type, String currStatus, 
    Integer complexity, Integer investedTime,
    LocalDateTime startTime, LocalDateTime endTime){

    }
}
