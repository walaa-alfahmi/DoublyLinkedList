#include <iostream>
using namespace std;

/**
 *
 * @author Walaa Alfahmi
 */
struct Node
{
  int data;
  Node *next;
  Node *prev;
  Node(int val = 0) : data(val), next(nullptr), prev(nullptr) {}
  Node(int val, Node *tempNext, Node *tempPrev) : data(val), next(tempNext), prev(tempPrev) {}
};

class DoublyLinkedList
{

public:
  Node *header;
  Node *trailer;

  int size;
  DoublyLinkedList() : header(new Node()), trailer(new Node()), size(0)
  {
    header->next = trailer;
  }
  void insertBetween(Node *pre, Node *sec, int e)
  {
    Node *newest = new Node(e);
    newest->prev = pre;
    newest->next = sec;
    sec->prev = newest;
    pre->next = newest;
    size++;
  }

  void addFirst(int e)
  {
    insertBetween(header, header->next, e);
  }

  void addLast(int e)
  {
    insertBetween(trailer->prev, trailer, e);
  }

  void remove(Node *n)
  {
    Node *pre = n->prev;
    Node *sec = n->next;
    pre->next = sec;
    sec->prev = pre;
    n->next = nullptr;
    n->prev = nullptr;
    size--;
  }

  void removeFirst()
  {
    remove(header->next);
  }

  void removeLast()
  {
    remove(trailer->prev);
  }

  void display()
  {
    cout << " header = " << header->next->data << ", trailer = " << trailer->prev->data << "\n";
    Node *c = header->next;
    while (c != trailer)
    {
      cout << c->data << "\t";
      c = c->next;
    }
    cout << endl;
  }
};

int main()
{
  DoublyLinkedList dll;
  dll.addFirst(5);
  dll.addFirst(50);
  dll.addLast(100);
  dll.display();
  dll.remove(dll.header->next);
  dll.display();
  return 0;
}