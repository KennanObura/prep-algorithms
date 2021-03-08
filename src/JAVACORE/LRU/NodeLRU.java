package JAVACORE.LRU;

public class NodeLRU<T> {
    private final T id;
    private final String title;

    NodeLRU(T id, String title){
        this.id = id;
        this.title = title;
    }



    @Override
    public String toString() {
        return "NodeLRU{" +
                "T=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public String getTitle(){
        return title;
    }

    public T getId() {
        return id;
    }
}
