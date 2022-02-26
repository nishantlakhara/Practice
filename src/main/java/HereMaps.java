import java.util.*;

public class HereMaps {
    public static void main(String[] args) {
        BinaryOperation add = (a,b) -> a+b;

        Map<String, String> map = new HashMap<>();

        Comparator<Map.Entry<String, String>> comparator = new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        //Serialization

        //default implementation
        //


    }

    public List<Node> getParentsAndChildren(Node node) {
        List<Node> res = new ArrayList<>();

        List<Node> p = new ArrayList<>();
        List<Node> c = new ArrayList<>();
        Set<Integer> visitedP = new HashSet<>();
        Set<Integer> visitedC = new HashSet<>();
        getParents(node, p, visitedP);
        getChildren(node, c, visitedC);

        res.addAll(p);
        res.addAll(c);
        return res;    }

    private void getChildren(Node node, List<Node> children, Set<Integer> visitedC) {
        children.add(node);
        if(node.getChildren() == null || node.getChildren().isEmpty()) {
            return;
        }

        List<Node> par = node.getParents();
        for(int i=0; i<par.size(); i++) {
            getParents(par.get(i), children, visitedC);
        }
    }

    private void getParents(Node node, List<Node> parents, Set<Integer> visitedP) {
        visitedP.add(node.getValue());
        parents.add(node);
        if(node.getParents() == null || node.getParents().isEmpty()) {
            return;
        }

        List<Node> par = node.getParents();
        for(int i=0; i<par.size(); i++) {
            if(!visitedP.contains(par.get(i).getValue()))
                getParents(par.get(i), parents, visitedP);
        }
    }
}

interface BinaryOperation {
    public int operation(int a, int b);
}

class Node {
    List<Node> parents;
    Integer value;
    List<Node> children;

    public List<Node> getParents() {
        return parents;
    }

    public void setParents(List<Node> parents) {
        this.parents = parents;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    //equals and hashcode
}




