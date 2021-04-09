public class Main {
    public static void main(String[] args) {
        IntersectionApp intersectionApp = new IntersectionApp();
        intersectionApp.start();

        // Cars with Thread class
        Car c1 = new Car(intersectionApp);
        Car c2 = new Car(intersectionApp);
        Car c3 = new Car(intersectionApp);
        Car c4 = new Car(intersectionApp);
        Car c5 = new Car(intersectionApp);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

        // Cars with Runnable class
        CarRunnable r1 = new CarRunnable(intersectionApp);
        CarRunnable r2 = new CarRunnable(intersectionApp);
        CarRunnable r3 = new CarRunnable(intersectionApp);

        r1.run();
        r2.run();
        r3.run();

    }
}
