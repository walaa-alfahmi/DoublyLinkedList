package javaapplication1;

/**
 *
 * @author Walaa Alfahmi
 */
public class DoublyLinkedList<E> {
    class Node<E> {

    E data;
    Node next;
    Node prev;
    
    public Node(){
        next = null;
        prev = null;
    }
    
    public Node(E e) {
        data = e;
        next = null;
        prev = null;
    }
    
}
    Node header;
    Node trailer;
    int size;
    
    public DoublyLinkedList() {
        header = new Node();
        trailer = new Node();
        header.next = trailer;
        trailer.next = header;
        size = 0;
    }
    
    public void insertBetween(Node pre, Node sec, E e){
        Node newest = new Node(e);
        newest.prev = pre;
        newest.next = sec;
        sec.prev = newest;
        pre.next = newest;
        size++;
    }
    
    public void insertFirst(E e){
        insertBetween(header, header.next, e);
    }
    
    public void insertLast(E e){
        insertBetween(trailer.prev, trailer, e);
    }
    
    public void remove(Node n){
        Node pre = n.prev;
        Node sec = n.next;
        pre.next = sec;
        sec.prev = pre;
        n.next = null;
        n.prev = null;
        size--;  
    }
    
    public void removeFirst(){
        remove(header.next);
    }
    
    public void removeLast(){
        remove(trailer.prev);
    }
    
    public void print(){
        System.out.println("header: " + header.next.data);
        System.out.println("trailer: " + trailer.prev.data);
        Node c = header.next;
        
        while(c != trailer){
            System.out.println(c.data);
            c = c.next;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(5);
        dll.insertLast(10);
        dll.insertLast(100);
        dll.insertBetween(dll.header.next, dll.header.next.next, 33);
        dll.print();
    }
    
}
