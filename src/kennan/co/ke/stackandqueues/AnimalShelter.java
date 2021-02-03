package kennan.co.ke.stackandqueues;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
 * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
 * that type). They cannot select which specific animal they would like. Create the data structures to
 * maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 * and dequeueCat. You may use the built-in Linked List data structure.
 */
public class AnimalShelter<T> {

    private enum TYPE {
        CAT, DOG
    }

    private static class Node<T> {
        int index;
        private final T value;
        private final TYPE type;

        Node(T value, TYPE type) {
            this.value = value;
            this.type = type;
        }
    }

    Queue<Node<T>> queueCats = new LinkedList<>();
    Queue<Node<T>> queueDogs = new LinkedList<>();

    public T enqueue(Node<T> item) {
        item.index = getIndex();
        if (item.type.equals(TYPE.CAT)) {
            return enqueueCat(item);
        } else
            return enqueueDog(item);
    }

    private T enqueueDog(Node<T> item) {
        queueDogs.add(item);
        return item.value;
    }

    private T enqueueCat(Node<T> item) {
        queueCats.add(item);
        return item.value;
    }

    private int getIndex() {
        if (queueDogs.isEmpty() && queueCats.isEmpty())
            return 0;
        return queueCats.size() + queueDogs.size() - 1;
    }

    private boolean isEmpty() {
        return queueCats.isEmpty() && queueDogs.isEmpty();
    }

    public T dequeueAny() {
        if (!isEmpty())
            return !queueDogs.isEmpty() && !queueCats.isEmpty()
                    && queueDogs.peek().index < queueCats.peek().index ? queueDogs.remove().value : queueCats.remove().value;
        else if (!queueDogs.isEmpty())
            return queueDogs.remove().value;
        else if (!queueCats.isEmpty())
            return queueCats.remove().value;
        else throw new EmptyStackException();
    }

    public T oldest() {
        if (!isEmpty()) {
            return queueDogs.peek().index > queueCats.peek().index ? queueDogs.peek().value : queueCats.peek().value;
        } else if (!queueCats.isEmpty()) return queueCats.peek().value;
        else if (!queueDogs.isEmpty()) return queueDogs.peek().value;
        else throw new EmptyStackException();
    }

    public T dequeueDog() {
        if (queueDogs.isEmpty())
            throw new EmptyStackException();
        return queueDogs.remove().value;
    }

    public T dequeueCat() {
        if (queueCats.isEmpty())
            throw new EmptyStackException();
        return queueCats.remove().value;
    }


    public static void main(String[] args) {
        AnimalShelter<String> shelter = new AnimalShelter<>();

        shelter.enqueue(new Node<>("Jypse", TYPE.CAT));
        shelter.enqueue(new Node<>("Jerry", TYPE.DOG));
        shelter.enqueue(new Node<>("Mose", TYPE.DOG));
        shelter.enqueue(new Node<>("Cute cat", TYPE.CAT));
        shelter.enqueue(new Node<>("Billy", TYPE.DOG));
        shelter.enqueue(new Node<>("Banny", TYPE.CAT));

        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueAny());
    }
}
