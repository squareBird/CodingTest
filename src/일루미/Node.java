package 일루미;

public class Node<E> {

    E value;
    Node<E> next;

    Node(E value) {

        this.value = value;
        this.next = null;
    }

}
