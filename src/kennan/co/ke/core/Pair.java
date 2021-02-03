package kennan.co.ke.core;

public class Pair<K, V> {
    private final K first;
    private final V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    //static factory method for creating immutable instance of pair
    public static <K, V> Pair<K, V> of(K a, V b) {
        return new Pair<>(a, b);
    }

    public K getFirst(){
        return first;
    }

    public V getSecond(){
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static void main(String[] args) {
        Pair<Integer, Integer> pair = new Pair<>(2, 6);
        System.out.println(pair.getFirst());
    }
}
