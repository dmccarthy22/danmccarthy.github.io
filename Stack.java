import java.util.LinkedList;

public class Stack<T>{
    LinkedList<T> list;

    public Stack(){
        list = new LinkedList<T>();
    }

    public void push( T value ){
        list.addLast( value );
    }

    public T pop(){
        return list.removeLast();
    }

    public static void main( String[] args){
        Stack<Integer> st = new Stack<Integer>();

        st.push(10);
        System.out.println(st.pop()); // 10
        st.push(1);
        st.push(2);
        System.out.println(st.pop()); // 1 2 <- pop
        System.out.println(st.pop()); // 1 <- pop
    }
}
