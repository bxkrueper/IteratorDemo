package example;

import java.util.Iterator;

public class MyLinkedList <Type> implements MyList<Type>{

	private Node head;
	private Node tail;
	private int size;
	
	public MyLinkedList() {
		head=null;
		tail=null;
		size = 0;
	}

	public void addFirst(Type e){
	    if(head==null){
	        head = new Node(e);
	        tail = head;
	    }else{
	        head = new Node(e,head);
	    }
	    size++;
	}
	
	public void add(int index, Type e){
	    if(head==null){
            head = new Node(e);
            tail = head;
        }else{
            Node currentNode = head;
            for(int i=0;i<index-1;i++){
                currentNode = currentNode.getNext();
            }
            Node newNode = new Node(e,currentNode.getNext());
            currentNode.setNext(newNode);
            if(currentNode==tail){
                tail = newNode;
            }
        }
	    size++;
	}
	
	//adds to the end
	@Override
	public void add(Type e){
	    if(tail==null){
            tail = new Node(e);
            head = tail;
        }else{
            Node newNode = new Node(e);
            tail.setNext(newNode);
            tail = newNode;
        }
	    size++;
	}
	
	@Override
	public void clear(){
	    head = null;
	    tail = null;
	    size=0;
	}
	
	@Override
	public Type get(int index){
	    Node currentNode = head;
	    for(int i=0;i<index;i++){
            currentNode = currentNode.getNext();
        }
	    return currentNode.getContent();
	}
	
	@Override
	public void remove(int index){
	    if(index==0){
	        removeHead();
	        return;
	    }
	    
	    Node currentNode = head;
        for(int i=0;i<index-1;i++){
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
        if(currentNode.getNext()==null){
            tail = currentNode;
        }
        size--;
	}
	
	public void removeHead(){
	    head = head.getNext();
	    size--;
	}
	
	@Override
	public int size(){
	    return size;
	}
	
	@Override
    public Iterator<Type> iterator() {
        return new MyLinkedListIterator();
    }
	
	
	
	
	
	private class MyLinkedListIterator implements Iterator<Type>{

	    private Node nextNode;
	    private Node currentNode;
	    public MyLinkedListIterator(){
	        nextNode = head;
	        currentNode = null;
	    }
        @Override
        public boolean hasNext() {
            return nextNode!=null;
        }

        @Override
        public Type next() {
            currentNode = nextNode;
            nextNode = nextNode.getNext();
            return currentNode.getContent();
        }
        
	    
	}
	
	
	
	
	private class Node {

		private Type content;
		private Node nextNode;
		
		public Node(Type content) {
			this(content,null);
		}
		public Node(Type content,Node nextNode) {
			this.content = content;
			this.nextNode = nextNode;
		}
		
		protected Type getContent() {
            return content;
        }
        protected void setContent(Type content) {
            this.content = content;
        }
        
		protected Node getNext(){
		    System.out.println("getting Next");
		    return nextNode;
		}
		protected void setNext(Node n){
		    nextNode = n;
		}
        

	}



    
}
