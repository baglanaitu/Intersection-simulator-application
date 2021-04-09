import java.util.Random;

public class Car extends Thread {
    Random random = new Random();
    private IntersectionApp intersectionApp;
    private int ID = random.nextInt(1000);

    public Car(IntersectionApp intersectionApp) {
        this.intersectionApp = intersectionApp;
    }

    public void run(){
        try {
            System.out.println("Car #" + ID + " is approaching the intersection");
            Thread.sleep(3000);
            System.out.println("Car #" + ID + " arrived at the intersection");
            this.intersectionApp.EnterTheRoad(ID);
            System.out.println("Car #" + ID + " exited the intersection");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
