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

    public int sumarConRestriccion(int limiteInferior, int limiteSuperior) {
        return sumarConRestriccion(limiteInferior, limiteSuperior, this.root);
    }

    private int sumarConRestriccion(int inf, int sup, TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sumaTotal = 0;

        if (node.getValue() >= inf && node.getValue() <= sup) {
            sumaTotal += node.getValue();
        }

        if (node.getValue() > inf) {
            sumaTotal += sumarConRestriccion(inf, sup, node.getLeft());
        }

        if (node.getValue() < sup) {
            sumaTotal += sumarConRestriccion(inf, sup, node.getRight());
        }

        return sumaTotal;
    }

    /*1 - Dado un arbol binario y un valor k, escribir un algoritmo que determine si el arbol es equilibrado respecto
     al valor k. Un arbol esta equilibrado respecto a un valor k,
     cuando todos sus nodos internos (sin considerar las hojas) cumplen que la diferencia absoluta
     entre su valor y el valor de sus hijos (izquierdo y derecho) es menor o igual a k.*/

    public boolean equilibrado(int k) {
        return equilibrado(this.root, k);
    }

    private boolean equilibrado(TreeNode actual, int k) {
        if (actual == null) {
            return true;
        }

        if (actual.getLeft() == null && actual.getRight() == null) {
            return true;
        }

        if (actual.getLeft() != null) {
            int difIzquierda = Math.abs(actual.getValue() - actual.getLeft().getValue());
            if (difIzquierda > k) {
                return false;
            }
        }

        if (actual.getRight() != null) {
            int difDerecha = Math.abs(actual.getValue() - actual.getRight().getValue());
            if (difDerecha > k) {
                return false;
            }
        }

        return equilibrado(actual.getLeft(), k) && equilibrado(actual.getRight(), k);
    }

    // --- 1. PRE-ORDEN (Padre -> Izquierda -> Derecha) ---
    public void imprimirPreOrden() {
        System.out.print("Pre-Orden: ");
        imprimirPreOrden(this.root);
        System.out.println(); // Salto de línea al final
    }

    private void imprimirPreOrden(TreeNode node) {
        if (node == null) return;

        System.out.print(node.getValue() + " "); // TRABAJO (Yo primero)
        imprimirPreOrden(node.getLeft());        // DELEGO (Izquierda)
        imprimirPreOrden(node.getRight());       // DELEGO (Derecha)
    }

    // --- 2. IN-ORDEN (Izquierda -> Padre -> Derecha) ---
    public void imprimirInOrden() {
        System.out.print("In-Orden:  ");
        imprimirInOrden(this.root);
        System.out.println();
    }

    private void imprimirInOrden(TreeNode node) {
        if (node == null) return;

        imprimirInOrden(node.getLeft());         // DELEGO (Izquierda)
        System.out.print(node.getValue() + " "); // TRABAJO (En el medio)
        imprimirInOrden(node.getRight());        // DELEGO (Derecha)
    }

    // --- 3. POST-ORDEN (Izquierda -> Derecha -> Padre) ---
    public void imprimirPostOrden() {
        System.out.print("Post-Orden: ");
        imprimirPostOrden(this.root);
        System.out.println();
    }

    private void imprimirPostOrden(TreeNode node) {
        if (node == null) return;

        imprimirPostOrden(node.getLeft());       // DELEGO (Izquierda)
        imprimirPostOrden(node.getRight());      // DELEGO (Derecha)
        System.out.print(node.getValue() + " "); // TRABAJO (Yo al final)
    }

    /*1. El Sumador Restringido (Nodos Solitarios)
        Enunciado: Escribir un método int sumarSolitarios() que recorra un árbol binario y
        devuelva la suma de los valores de todos los nodos
        que tengan exactamente un hijo (es decir, tienen hijo izquierdo pero el derecho es null, o viceversa).
         Si un nodo tiene dos hijos o no tiene ninguno (es hoja), no se suma.*/
    public int sumaHojaSola(TreeNode node) {
        if (node == null) return 0;

        int sumaTotal = 0;

        boolean soloTieneIzq = (node.getLeft() != null && node.getRight() == null);
        boolean soloTieneDer = (node.getLeft() == null && node.getRight() != null);

        if(soloTieneIzq || soloTieneDer){
            sumaTotal += node.getValue();
        }

        sumaTotal += sumaHojaSola(node.getLeft());
        sumaTotal += sumaHojaSola(node.getRight());

        return sumaTotal;
    }

    /*
    * 2. El Recolector Eficiente (ABB)
    Enunciado: Dado un Árbol Binario de Búsqueda (ABB) y un valor X, escribir un método List<Integer> obtenerParesMayores(int x)
     que devuelva una lista con todos los números PARES que sean estrictamente mayores a X.
    Requisito de examen: La lista resultante debe quedar ordenada de menor a mayor automáticamente y
    * el algoritmo debe ser eficiente (si un subárbol entero tiene números menores a X, no deberías ni visitarlo).
    * */

    public ArrayList<Integer> listaOrdenNodes(TreeNode node, int x,ArrayList<Integer> lista){
        if(node == null) return lista;


        if(node.getLeft().getValue()> x){
            listaOrdenNodes(node.getLeft(),x,lista);
        }

        if(node.getValue() > x && node.getValue() % 2 == 0){
            lista.add(node.getValue());
        }

        listaOrdenNodes(node.getRight(),x,lista);


        return lista;
    }


}