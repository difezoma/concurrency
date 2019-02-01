import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FirstWorker implements Runnable{

    BlockingQueue<Person> blockingQueue;

    public FirstWorker(BlockingQueue<Person> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    public void run(){
        try {
            System.out.println("add");
            blockingQueue.put(new Person(26, "Diego"));  
            blockingQueue.put(new Person(12, "Salome")); 
            blockingQueue.put(new Person(15, "Jose")); 
            Thread.sleep(1000);
            blockingQueue.put(new Person(70, "Manuel")); 
            Thread.sleep(1000);
            blockingQueue.put(new Person(56, "Myriam"));   
        } catch (InterruptedException e) {
            //TODO: handle exception
        }
    }

}

class SecondWorker implements Runnable{

    BlockingQueue<Person> blockingQueue;

    public SecondWorker(BlockingQueue<Person> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    public void run(){
        try {
            System.out.println("remove");
            System.out.println(blockingQueue.take());  
            Thread.sleep(1000);   
            System.out.println(blockingQueue.take());  
            System.out.println(blockingQueue.take());  
            Thread.sleep(3000);
            System.out.println(blockingQueue.take());  
            System.out.println(blockingQueue.take());   
        } catch (InterruptedException e) {
            //TODO: handle exception
        }
    }

}

class Person implements Comparable<Person> {

    private int age;
    private String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int compareTo(Person otherPerson){
        return name.compareTo(otherPerson.getName());
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String toString(){
        return this.name+" "+this.age;
    }

}


public class PriorityQueue{

    public static void main(String[] args) {

        BlockingQueue<Person> blockingQueue = new PriorityBlockingQueue<>();

        new Thread(new FirstWorker(blockingQueue)).start();
        new Thread(new SecondWorker(blockingQueue)).start();
    }

}