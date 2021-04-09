import java.util.Random;

public class IntersectionApp extends Thread {
    private Boolean Color;
    private Object Check = new Object();
    private int ID;


    IntersectionApp(){
        Color = new Boolean(true);
                if(Color){
                    System.out.println("The traffic light color is GREEN!");
                    System.out.println("---------");
                }
                else{
                    System.out.println("The traffic light color is RED!");
                    System.out.println("---------");
                }
    }

    // The traffic lights switching app
    public void run(){
        while(true){
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Color = !Color;
            if (Color){
                System.out.println();
                System.out.println("The traffic light color is GREEN!");
                System.out.println("---------");
            }
            else{
                System.out.println();
                System.out.println("The traffic light color is RED!");
                System.out.println("---------");
            }

            new Thread(new Runnable() {
                public void run() {
                    synchronized (Check){
                        if(Color){
                            Check.notifyAll();
                        }
                    }
                }
            }).start();
        }
    }


    public void EnterTheRoad(int ID){
        synchronized (Check){
            while(!Color){
                try{
                    System.out.println("Car #" + ID + " has stopped");
                    Check.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Car #" + ID + " started to enter the intersection");

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Car #" + ID + " is leaving the intersection");
                Check.notifyAll();
            }
        }
    }
}
