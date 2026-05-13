package Arboles;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root,value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(),value);
            }
        }
    }

    public Integer getRoot(){
        return this.root.getValue();
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public boolean hasElem(Integer value){
        return hasElem(this.root,value);
    }

    private boolean hasElem(TreeNode node,Integer value){
        if(node == null){
            return false;
        }

        if(node.getValue().equals(value)){
            return true;
        }else if(node.getValue()<value){
            return hasElem(node.getRight(),value);
        }else{
            return hasElem(node.getLeft(),value);
        }
    }

    public int getHeight(){
        return getHeight(this.root);
    }

    private int getHeight(TreeNode node){
        if (node == null) {
            return -1;
        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        if(leftHeight >rightHeight){
            return 1 + leftHeight;
        }else{
            return 1 + rightHeight;
        }
    }

    public Integer getMaxElem(){
        return getMaxElem(this.root);
    }

    private Integer getMaxElem(TreeNode node){
        if(node == null){
            return null;
        }

        if(node.getRight()!=null){
            return getMaxElem(node.getRight());
        }else{
            return node.getValue();
        }
    }

    public List<Integer> getFronteras(){
        ArrayList<Integer> fronteras = new ArrayList<>();
        getFrontera(this.root,fronteras);
        return fronteras;
    }

    private void getFrontera(TreeNode node,ArrayList<Integer> fronteras){
        if(node == null){
            return;
        }

        if(node.getLeft()==null && node.getRight()==null){
            fronteras.add(node.getValue());
        }

        getFrontera(node.getLeft(),fronteras);
        getFrontera(node.getRight(),fronteras);
    }

    public List<Integer> getLongestBranch(){
        ArrayList<Integer> longestBranch = new ArrayList<>();
        getLongestBranch(this.root,longestBranch);
        return longestBranch;
    }

    private void getLongestBranch(TreeNode node,ArrayList<Integer> longestBranch){
        if(node == null){
            return;
        }

        longestBranch.add(node.getValue());

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        if(leftHeight > rightHeight){
            getLongestBranch(node.getLeft(),longestBranch);
        }else{
            getLongestBranch(node.getRight(),longestBranch);
        }
    }

    //longestbranch alternativa
    public List<Integer> getLongestBranchDos() {
        return getLongestBranch(this.root);
    }

    private List<Integer> getLongestBranch(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<Integer> leftBranch = getLongestBranch(node.getLeft());
        List<Integer> rightBranch = getLongestBranch(node.getRight());

        if (leftBranch.size() > rightBranch.size()) {
            leftBranch.add(0, node.getValue());
            return leftBranch;
        } else {
            rightBranch.add(0, node.getValue());
            return rightBranch;
        }
    }

    public List<Integer> getElemAtLevel(int level) {
        List<Integer> lista = new ArrayList<>();
        getElemAtLevel(this.root, level, lista);
        return lista;
    }

    private void getElemAtLevel(TreeNode node, int level, List<Integer> lista) {
        if (node == null) {
            return;
        }

        if (level == 0) {
            lista.add(node.getValue());
            return;
        }

        getElemAtLevel(node.getLeft(), level - 1, lista);
        getElemAtLevel(node.getRight(), level - 1, lista);
    }

    //delete

    public boolean delete(Integer value) {
        return delete(this.root, null,value);
    }

    private boolean delete(TreeNode node, TreeNode parent, Integer value) {
        if(node==null){
            return false;
        }

        if(node.getValue().equals(value)){
            if(node.getLeft()==null && node.getRight()==null){
                if(parent!=null){
                    if(parent.getLeft()==node){
                        parent.setLeft(null);
                    }else {
                        parent.setRight(null);
                    }
                }else{
                    this.root = null;
                }
            }
            else if(node.getLeft()==null || node.getRight()==null){
                TreeNode child = (node.getLeft()!=null) ? node.getLeft(): node.getRight();
                if(parent!=null){
                    if(parent.getLeft()==node){
                        parent.setLeft(child);
                    }else{
                        parent.setRight(child);
                    }
                }else {
                    this.root = child;
                }
            }else{
                Integer sucesor =  this.getMaxElem(node.getLeft());
                node.setValue(sucesor);
                delete(node.getLeft(), node, sucesor);
            }
            return true;
        }else if(value<node.getValue()){
            return delete(node.getLeft(),node,value);
        }else{
            return delete(node.getRight(),node,value);
        }

    }

    public Integer sumaNodesInternos(){
        return sumaNodesInternos(this.root);
    }


    private Integer sumaNodesInternos(TreeNode node){
        if(node == null){
            return 0;
        }

        if(node.getLeft()!=null || node.getRight()!=null){
           int sumarIzq = sumaNodesInternos(node.getLeft());
           int sumarDer = sumaNodesInternos(node.getRight());
           return node.getValue() + sumarIzq + sumarDer;
        }

        return 0;
    }

    public List<Integer> getHigherValues(Integer k){
        List<Integer> lista = new ArrayList<>();
        getHigherValues(this.root,lista,k);
        return lista;
    }

    private void getHigherValues(TreeNode node,List<Integer> lista,Integer k){
        if(node == null){
            return;
        }

        if(node.getLeft()==null && node.getRight()==null && node.getValue()>k){
            lista.add(node.getValue());
        }

        if(node.getValue()>k){
            getHigherValues(node.getLeft(),lista,k);
            getHigherValues(node.getRight(),lista,k);
        }else{
            getHigherValues(node.getRight(),lista,k);
        }

    }

}