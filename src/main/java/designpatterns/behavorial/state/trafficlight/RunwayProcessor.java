package designpatterns.behavorial.state.trafficlight;

import java.util.PriorityQueue;

public class RunwayProcessor {

    private PriorityQueue<Plane> planesPriorityQueue = new PriorityQueue<>();

    public void initialize() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while(true) {

                    if (!planesPriorityQueue.isEmpty()) {
                        Plane plane = planesPriorityQueue.poll();
                        try {
                            Thread.sleep(1000);
                            RunwayProcessor.log(plane);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }

    public static void log(Plane plane) {
        if (plane.isEmergency)
            System.out.println("Emergency Plane successfully landed " + plane);
        else
            System.out.println("Plane successfully landed " + plane);
    }

    public void push(Plane plane) {
        planesPriorityQueue.add(plane);
    }
    
    public static void main(String[] args) {
        RunwayProcessor processor = new RunwayProcessor();
        processor.initialize();
        processor.push(new Plane(0, 1, false));
        processor.push(new Plane(1, 2, false));
        processor.push(new Plane(2, 3, true));
        processor.push(new Plane(3, 4, true));
        processor.push(new Plane(4, 5, false));
        processor.push(new Plane(5, 6, false));
        processor.push(new Plane(6, 7, true));
        processor.push(new Plane(7, 8, true));
    }
}
