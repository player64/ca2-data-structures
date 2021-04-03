package messing;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Chlew {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("Delhi");
        linkedList.add("Agra");
        linkedList.add("Mysore");
        linkedList.add("Chennai");
        linkedList.add("Pune");

        linkedList.add(4, "NEW ELEMENT");

        System.out.println("LinkedList elements After Addition:");
        Iterator it = linkedList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        ArrayList<Integer> arrList = new ArrayList<>();

        arrList.add(1);
        arrList.add(2);
        Iterator iyt = arrList.iterator();

        while(iyt.hasNext()){
            System.out.println(iyt.next());
        }
    }



}
