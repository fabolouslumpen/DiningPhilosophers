public class Philosopher extends Thread{
    private final int id;
    private final Fork rightFork;
    private final Fork leftFork;

    public Philosopher(int id, Fork rightFork, Fork leftFork) {
        this.id = id;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Philosopher " + id + " thinking");
                sleep(1000);

                System.out.println("Philosopher " + id + " want to eat");

                if (id % 2 == 0) {
                    rightFork.acquire();
                    System.out.println("Philosopher " + id + " took right fork");
                    leftFork.acquire();
                    System.out.println("Philosopher " + id + " took left fork");

                    System.out.println("Philosopher " + id + " eating");
                    sleep(1000);
                    System.out.println("Philosopher " + id + " ate");

                    rightFork.release();
                    System.out.println("Philosopher " + id + " put right fork");
                    leftFork.release();
                    System.out.println("Philosopher " + id + " put left fork");
                } else {
                    leftFork.acquire();
                    System.out.println("Philosopher " + id + " took left fork");
                    rightFork.acquire();
                    System.out.println("Philosopher " + id + " took right fork");

                    System.out.println("Philosopher " + id + " eating");
                    sleep(1000);
                    System.out.println("Philosopher " + id + " ate");

                    leftFork.release();
                    System.out.println("Philosopher " + id + " put left fork");
                    rightFork.release();
                    System.out.println("Philosopher " + id + " put right fork");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
