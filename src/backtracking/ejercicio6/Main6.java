package backtracking.ejercicio6;

import java.util.List;

public class Main6 {
    public static void main(String[] args) {

        // 1. DIBUJAMOS EL JARDÍN (3x3)
        boolean[][] mapa = new boolean[3][3];

        // Llenamos todo de tierra pelada (true)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mapa[i][j] = true;
            }
        }

        // Le ponemos un bloque de pasto intacto en el centro (false)
        mapa[1][1] = false;

        System.out.println("--- JARDÍN DE ATILA ---");
        System.out.println("Iniciando búsqueda de recorrido...\n");

        // 2. INSTANCIAMOS EL MOTOR
        CaballoAtila motor = new CaballoAtila(mapa);

        // 3. DEFINIMOS EL PUNTO DE PARTIDA (Esquina superior izquierda)
        Posicion origen = new Posicion(0, 0);

        // 4. ¡A CORRER!
        List<Posicion> recorridoFinal = motor.getCamino(origen);

        // 5. MOSTRAMOS LOS RESULTADOS
        if (recorridoFinal != null && !recorridoFinal.isEmpty()) {
            System.out.println("¡Recorrido encontrado con éxito!");
            System.out.println("Cantidad total de casillas de tierra pisadas: " + recorridoFinal.size());
            System.out.println("Pasos del caballo:");

            int paso = 1;
            for (Posicion p : recorridoFinal) {
                System.out.println("Paso " + paso + ": (" + p.getX() + ", " + p.getY() + ")");
                paso++;
            }
        } else {
            System.out.println("No se encontró ningún recorrido cerrado válido para este mapa.");
        }
    }
}