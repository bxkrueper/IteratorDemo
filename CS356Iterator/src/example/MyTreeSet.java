package example;

import java.util.Iterator;

public class MyTreeSet<Type extends Comparable<Type>> implements MySet<Type>{

    private TreeNode root;
    private int size;
    
    public MyTreeSet() {
        root=null;
        size=0;
    }
    
    @Override
    public void add(Type e){
        if(root==null){
            root = new TreeNode(e);
            size++;
            return;
        }
        
        TreeNode currentNode = root;
        while(true){
            int compare = e.compareTo(currentNode.getContent());
            switch(compare){
                case -1:
                    if(currentNode.getLeft()==null){
                        currentNode.setLeft(new TreeNode(e,null,null,currentNode));
                        size++;
                        return;
                    }else{
                        currentNode = currentNode.getLeft();
                    }
                break;
                case 1:
                    if(currentNode.getRight()==null){
                        currentNode.setRight(new TreeNode(e,null,null,currentNode));
                        size++;
                        return;
                    }else{
                        currentNode = currentNode.getRight();
                    }
                break;
                default:
                    return;
            }
        }
    }
    
    @Override
    public void clear() {
        root=null;
        size=0;
    }

    @Override
    public int size() {
        return size();
    }

    @Override
    public Iterator<Type> iterator() {
        return new MyTreeSetIterator();
    }
    
    public String toString(){
        return root.toString();
    }

    
    
    
    private class MyTreeSetIterator implements Iterator<Type>{

        private TreeNode nextNode;
        
        public MyTreeSetIterator(){
            nextNode=root;
            if(nextNode!=null){
                while(nextNode.getLeft()!=null)
                    nextNode = nextNode.getLeft();
            }
        }
        
        @Override
        public boolean hasNext() {
            return nextNode!=null;
        }

        @Override
        public Type next() {
            Type t = nextNode.getContent();
            
            if(nextNode.getRight()!=null){
                nextNode = nextNode.getRight();
                while(nextNode.getLeft()!=null){
                    nextNode = nextNode.getLeft();
                }
            }else{
                TreeNode prevNode;
                do{
                    prevNode=nextNode;
                    nextNode = nextNode.getParent();
                }while(nextNode!=null && nextNode.getRight()==prevNode);
            }
            return t;
        }
        
    }
    
    
    
    
    private class TreeNode implements Comparable<Type>{

        private Type content;
        private TreeNode right;
        private TreeNode left;
        private TreeNode parent;
        
        public TreeNode(Type content) {
            this(content,null,null,null);
        }
        public TreeNode(Type content,TreeNode r,TreeNode l,TreeNode p) {
            this.content = content;
            this.setRight(r);
            this.setLeft(l);
            this.setParent(p);
        }
        
        private Type getContent() {
            return content;
        }
        private void setContent(Type content) {
            this.content = content;
        }
        private TreeNode getRight() {
            return right;
        }
        private void setRight(TreeNode right) {
            this.right = right;
        }
        private TreeNode getLeft() {
            return left;
        }
        private void setLeft(TreeNode left) {
            this.left = left;
        }
        private TreeNode getParent() {
            return parent;
        }
        private void setParent(TreeNode parent) {
            this.parent = parent;
        }
        @Override
        public int compareTo(Type t) {
            return getContent().compareTo(t);
        }
        
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(content.toString());
            sb.append("(");
            if(getLeft()!=null){
                sb.append(getLeft().toString());
            }
            sb.append(",");
            if(getRight()!=null){
                sb.append(getRight().toString());
            }
            sb.append(")");
            
            return sb.toString();
        }
        

    }




    
}
