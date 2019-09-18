import java.util.LinkedList;

public class Queue<T>{
    LinkedList<T> list;

    public Queue(){
        list = new LinkedList<T>();
    }

    public void add( T value ){
        list.addLast( value );
    }

    public T remove(){
        return list.removeFirst();
    }
    

    public static void main( String[] args ){
        Queue<Integer> q = new Queue<Integer>();

        q.add(10);
        System.out.println(q.remove());
        q.add(1);
        q.add(2);
        System.out.println(q.remove()); // remove -> 1 2
        System.out.println(q.remove()); // remove -> 2
        q.add(1);
        q.add(2);
        System.out.println(q.remove()); // remove -> 1 2
        q.add(3);
        System.out.println(q.remove()); // remove -> 2 3
        q.add(4);
        System.out.println(q.remove()); // remove -> 3 4
        System.out.println(q.remove()); // remove -> 4
    }
}
