import java.util.HashMap;
import java.util.Iterator;

public class Set<E> {
    private HashMap<E,E> hashMap;

    public Set() {
        hashMap = new HashMap<E,E>();
    }

    public Boolean isEmpty(){
        return hashMap.isEmpty();
    }

    public Boolean contains(Object o){
        return hashMap.containsKey(o);
    }

    public Boolean add(E e) {
        if(!contains(e)) {
            hashMap.put(e, e);
            return true;
        }
        return false;
    }

    public Boolean remove(Object o) {
        if(contains(o)) {
            hashMap.remove(o);
            return true;
        }
        return false;
    }

    public Iterator<E> iterator() { //credit 650610758
        return hashMap.keySet().iterator();

    }

    public boolean containsAll(Set<? extends E> s){
        return hashMap.keySet().containsAll(s.hashMap.keySet());
    }

    public Boolean addAll(Set<? extends E> s) {
        boolean addSucess = false;
        if(!containsAll(s)) {
            hashMap.putAll(s.hashMap);
            addSucess = true;
        }
        return addSucess;
    }

    public Boolean removeAll(Set<? extends E> s) {
        boolean haveThis;
        boolean removeSuccess = false;
        for (E element : s.hashMap.keySet()) {
            haveThis = hashMap.containsKey(element);
            if (haveThis) {
                hashMap.remove(element);
                removeSuccess = true;
            }
        }
        return removeSuccess;
    }

    public Boolean retainAll(Set<? extends E> s) { // Credit chat GPT
        boolean retainSuccess = false;

        Iterator<E> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (!s.hashMap.containsKey(element)) {
                iterator.remove();
                retainSuccess = true;
            }
        }
        return retainSuccess;
    }

    public void clear() {
        hashMap.clear();
    }

    public int size() {
        return hashMap.size();
    }

    public void printSet() {
        System.out.println(hashMap.values());
    }

    public String toString() { // Credit chat GPT
        StringBuilder result = new StringBuilder("[");
        for (E element : hashMap.values()) {
            result.append(element).append(", ");
        }
        if (!hashMap.isEmpty()) {
            result.setLength(result.length() - 2);
        }
        result.append("]");
        return result.toString();
    }

}
class Lab07{
    public static void main(String[] args) {
        Set<String> fruitSet = new Set<>();
        System.out.println(fruitSet.isEmpty());
        fruitSet.add("apple");
        fruitSet.add("watermelon");
        System.out.println(fruitSet.isEmpty());
        fruitSet.remove("watermelon");
        fruitSet.remove("mango");
        fruitSet.contains("watermelon");
        Set<String> otherSet = new Set<>();
        otherSet.add("melon");
        otherSet.add("banana");
        fruitSet.addAll(otherSet);
        System.out.println(fruitSet.toString());
        fruitSet.retainAll(otherSet);
        System.out.println(fruitSet.toString());
        fruitSet.printSet();
        fruitSet.iterator();
        fruitSet.containsAll(otherSet);
        fruitSet.clear();
        System.out.println(fruitSet.size());

    }
}
