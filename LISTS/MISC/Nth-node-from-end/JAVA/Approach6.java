import java.util.*;
abstract class Approach6
{
    /**
     * LINKED LIST CLASS
     **/
    private static class LinkedList
    {
        /**
         * NODE CLASS
         * for linked list node
         **/
        private class Node
        {
            private int data;
            private Node next;

            //constructor
            public Node(int data)
            {
                this.data=data;
                next=null;
            }

            /**
             * getData()
             * @return data in the node
             **/
            public int getData()
            {
                return data;
            }

            /**
             * getNext()
             * @return the next node 
             **/
            public Node getNext()
            {
                return next;
            }
            
            /**
             * setNext()
             * @param next
             **/
            public void setNext(Node next)
            {
                this.next=next;
            }
        }
        
        private Node head;  //head of the linked list
        private int size;   //size of the linked list
        private int counter;

        //constructor for linked list
        public LinkedList()
        {
            head=null;
            size=0;
            counter=0;
        }

        /**
         * getHead()
         * @return the head node
         **/
        public Node getHead()
        {
            return head;
        }

        /**
         * insert_at_head()
         * it will insert node at the head of the linked list
         * @param data
         **/
        public void insert_at_head(int data)
        {
            Node newNode = new Node(data);
            if(head==null)
            {
                head=newNode;
            }
            else
            {
                newNode.setNext(head);
                head=newNode;
            }
            size++;
        }

        /**
         * print_list()
         * it will print the linked list
         **/
        public void printList()
        {
            if(head==null)
            {
                System.out.println("NULL");
            }
            else
            {
                Node current=head;
                while(current!=null)
                {
                    System.out.print(current.getData() +" -> ");
                    current=current.getNext();
                }
                System.out.println("NULL");
            }
        }

        /*====================================================================*/
        /**
         * APPROACH 6
         * using recursion
         * in backtracking count the nodes
         * count equal to nthnode will be printed
         **/
        public void printNthNodeFromLast(Node current,int num)
        {
            if(num>size)
            {
                System.out.println("OUT OF BOUND");
                return;
            }
            if(current==null)
            {
                return;
            }
            printNthNodeFromLast(current.getNext(),num);
            counter++;
            if(counter==num)
            {
                System.out.println(current.getData());
                return;
            }
        }
        /*====================================================================*/
    }

    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
        ll.insert_at_head(3);
        ll.insert_at_head(1);
        ll.insert_at_head(4);
        ll.insert_at_head(2);
        ll.insert_at_head(5);
        ll.printList();
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the nth node from last");
        int n = in.nextInt();

        ll.printNthNodeFromLast(ll.getHead(), n);
        in.close();
    }
}
