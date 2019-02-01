import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Book{

    private int id;
    private Lock lock;

    public Book(int id){
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public void read(Student student) throws InterruptedException{
        Random random = new Random();
        lock.lock();
        System.out.println(student+" reading the ... "+this);
        Thread.sleep(random.nextInt(5000));
        lock.unlock();
        System.out.println(student+" has finished the ... "+this);
    }

    public String toString(){
        return "book "+id;
    }

}