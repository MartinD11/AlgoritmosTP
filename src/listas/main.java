package listas;

public class main {
    public static void main(String[] args) {
        MySimpleLinkedList list1 = new MySimpleLinkedList();
        MySimpleLinkedList list2 = new MySimpleLinkedList();

        list1.insertFront(5);
        list1.insertFront(4);
        list1.insertFront(3);
        list1.insertFront(2);
        list2.insertFront(8);
        list2.insertFront(7);
        list2.insertFront(6);
        list2.insertFront(5);
        list2.insertFront(4);


        MySimpleLinkedList salida = new MySimpleLinkedList();

        //a
        for (Object elem1 : list1) {

            boolean existeEnList2 = list2.indexOf(elem1) != -1;

            boolean noEstaEnSalida = salida.indexOf(elem1) == -1;

            if (existeEnList2 && noEstaEnSalida) {
                salida.insertInOrder(elem1);
            }
        }

        System.out.println("Lista 1: " + list1);
        System.out.println("Lista 2: " + list2);
        System.out.println("Intersección: " + salida);

        MyIterator it1 = list1.iterator();
        MyIterator it2 = list2.iterator();


        if (!it1.hasNext() || !it2.hasNext()) {
            return;
        }

        Integer val1 = (Integer) it1.next();
        Integer val2 = (Integer) it2.next();


        boolean hayElementos = true;

        while (hayElementos) {

            if (val1 < val2) {
                if (it1.hasNext()) {
                    val1 = (Integer) it1.next();
                } else {
                    hayElementos = false;
                }

            } else if (val1 > val2) {
                if (it2.hasNext()) {
                    val2 = (Integer) it2.next();
                } else {
                    hayElementos = false;
                }

            } else {
                if (salida.indexOf(val1) == -1) {
                    salida.insertInOrder(val1);
                }

                if (it1.hasNext() && it2.hasNext()) {
                    val1 = (Integer) it1.next();
                    val2 = (Integer) it2.next();
                } else {
                    hayElementos = false;
                }
            }
        }

        //6
        //es hacer lo mismo pero consultando el indexof, si no existe lo agrego y listo mientras consulto
        //que la lista de salida no lo contenga
    }
}
