import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        float expectedTemp, realTemp, IacTemp, acTemp;
        int acFan=0;
        String e = "";
        String heater;
        String c = "";
        
        System.out.print("Enter Expected Temperature: ");
        expectedTemp = scanner.nextFloat();

        System.out.print("Enter existing Temperature: ");
        realTemp = scanner.nextFloat();

        if(realTemp <= 22 &&  realTemp >= 16){
            acFan = 1;
        }
        else if (realTemp <= 27 && realTemp > 22){
            acFan = 2;
        }
        else if (realTemp > 27){
            acFan = 3;
            e = "WARNING!!! Surrounding temperature is too hot";
        }

        IacTemp = expectedTemp - realTemp;
        acTemp = IacTemp + expectedTemp;

        if(acTemp <= 16){
            acTemp = 16;
        }

        int acTempInt = Math.round(acTemp);
        // System.out.println(acTempInt);

        if(acTempInt >= 16 && acTempInt <= 35){
            System.out.println("AC is on.");
            System.out.println("Set AC Temperature to: " + acTempInt);
            System.out.println("Fan: " + acFan);
            if(acFan == 3){
                System.out.println(e);
            }
        }
        else if (acTemp >= 35){
            System.out.println("Heater is on.");
            System.out.println("Set Heater Temperature to: " + acTempInt);
        }  
    }
}
