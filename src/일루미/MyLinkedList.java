package 일루미;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    // LinkedListd의 맨 앞과 맨뒤의 노드 정보
    private Node<E> head;
    private Node<E> tail;

    // LinkedList 사이즈
    private int size;

    MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * index에 해당하는 Node 가져오기
     * 값을 찍기 위해선 get(index).value
     *
     * @param index
     * @return
     */
    public Node<E> get(int index) {

        indexValidate(index,size);

        Node<E> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    /**
     * tail 뒤에 Node를 추가할 경우
     *
     * @param value Node에 들어갈 값
     */
    public void add(E value) {
        if (size == 0) {
            addFirst(value);
            return;
        }
        Node<E> node = new Node<E>(value);
        tail.next = node;
        tail = node;
        size++;
    }

    /**
     * 특정 index에 Node를 추가할 경우
     *
     * @param index Node를 추가할 위치
     * @param value Node에 들어갈 값
     */
    public void add(int index, E value) {
        indexValidate(index, size);

        // index가 0이면 맨 앞에 추가
        if (index==0) {
            addFirst(value);
            return;
        }

        // index가 1이면 맨 앞에 추가
        if (index==size) {
            add(value);
            return;
        }

        Node<E> preNode = get(index-1);
        Node<E> nextNode = preNode.next;
        Node<E> newNode = new Node<E>(value);

        preNode.next = newNode;
        newNode.next = nextNode;
        size++;
    }

    /**
     * LinkedList가 비어있을 경우
     *
     * @param value Node에 들어갈 값
     */
    public void addFirst(E value) {
        Node<E> node = new Node<>(value);
        node.next = head;
        head=node;
        size++;
        if (head.next == null) {
            tail = head;
        }

        return;
    }

    /**
     * index에 해당하는 Node 제거하기
     * preNode의 next를 nextNode로 교체
     *
     * @param index
     */
    public void delete(int index) {
        // 비어있을시 에러
        if (head == null) {
            throw new NoSuchElementException();
        }
        // 맨 앞의 index 제거시
        // head.next 즉 index가 1인 node로 head 변경
        if (index == 0) {
            Node<E> nextNode = head.next;
            head.value = null;
            head.next = null;
            head = nextNode;
            size--;
            if (size == 0) {
                tail = null;
            }
            return;
        }
        
        // Tail일 경우
        if (index==size-1) {
            tail = get(size-2);
        }

        indexValidate(index, size);

        Node<E> preNode = get(index - 1);
        Node<E> targetNode = preNode.next;
        Node<E> nextNode = targetNode.next;

        preNode.next = nextNode;
        targetNode.value = null;
        targetNode.next = null;
        size--;

    }

    /**
     * 입력한 index의 값이 올바른지 검증
     *
     * @param index
     * @param size
     */
    private void indexValidate(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }

    /**
     * 중복 제거를 위한 메소드
     */
    public void deduplication() {

        // Key를 value로 하고 Value를 Node로 하는 Map 타입 변수 생성
        // 동일한 value를 가진 Node는 최초의 하나만 map에 입력이 가능
        Map<E, Node<E>> map = new HashMap<>();

        int index = 0;

        while(true) {

            // index가 size와 일치하면 종료
            if(index==size) break;

            Node<E> node = get(index);

            // map에 해당 node의 value값을 key로 하는 Node가 없을 경우
            if(map.get(node.value)==null) {
                // map에 node.value, node 쌍을 추가
                map.put(node.value, node);
                // 중복이 없다는 뜻이므로 index값을 더해서 다음으로 넘어감
                index++;
            } else {
                // 이미 존재할경우 delete메소드를 통해 (i-1).node = (i+1)을 수행
                // 중복이 있어서 제거했으므로 뒤의 노드들이 한칸씩 당겨졌으므로 해당 index에 대해 다시한번 적용
                delete(index);
            }

        }


//        // LinkedList를 순회
//        for(int i=0;i<size;i++) {
//
//            System.out.println(i + " 순회중");
//
//            // i번째 node를 가져옴
//            Node<E> node = get(i);
//
//            // map에 해당 node의 value값을 key로 하는 Node가 없을 경우
//            if(map.get(node.value)==null) {
//                // map에 node.value, node 쌍을 추가
//                map.put(node.value, node);
//                System.out.println(node.value + "추가되었음");
//            } else {
//                // 이미 존재할경우 delete메소드를 통해 (i-1).node = (i+1)을 수행
//                delete(i);
//                i--;
//            }
//
//        }

    }

}
