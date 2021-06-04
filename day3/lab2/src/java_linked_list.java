import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class java_linked_list {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
            a.add("A");
            a.add("B");
            a.add("C");
        ListIterator<String> aIter = a.listIterator();

        List<String> b = new LinkedList<>();
            b.add("D");
            b.add("E");
            b.add("F");
            b.add("G");
        Iterator<String> bIter = b.iterator();
        // merge the words from b into a
        while(bIter.hasNext()){
            if(aIter.hasNext())
            {
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(a);

        // remove every second word from b
        bIter = b.iterator();
        while (bIter.hasNext())
        {
            bIter.next();
            if(bIter.hasNext())
            {
                bIter.next(); // skip next element
                bIter.remove(); // remove that element
            }

        }
        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);
    }
}
