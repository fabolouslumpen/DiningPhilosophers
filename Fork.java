import java.util.concurrent.Semaphore;

public class Fork extends Semaphore {
    public Fork() {
        super(1, true);
    }
}
