import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class GestorImpresiones {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Cola de documentos pendientes
        Deque<String> pendientes = new ArrayDeque<>();

        // Pila de documentos impresos
        Deque<String> historial = new ArrayDeque<>();

        int opcion;

        do {

            System.out.println("\n===== GESTOR DE IMPRESIONES =====");
            System.out.println("1. Registrar documento");
            System.out.println("2. Imprimir siguiente");
            System.out.println("3. Recuperar ultima impresion");
            System.out.println("4. Mostrar estado");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del documento: ");
                    String nombre = teclado.nextLine();

                    // Registrar documento
                    pendientes.offerLast(nombre);

                    System.out.println("Documento registrado.");
                    break;

                case 2:

                    // Validar que existan documentos pendientes
                    if (pendientes.isEmpty()) {

                        System.out.println("No hay documentos pendientes.");

                    } else {

                        // Imprimir siguiente
                        String documento = pendientes.pollFirst();

                        System.out.println("Imprimiendo: " + documento);

                        // Guardar impresión
                        historial.push(documento);
                    }

                    break;

                case 3:

                    // Validar que exista historial
                    if (historial.isEmpty()) {

                        System.out.println("No hay impresiones para recuperar.");

                    } else {

                        // Recuperar última impresión
                        String recuperado = historial.pop();

                        // Vuelve al frente de pendientes
                        pendientes.addFirst(recuperado);

                        System.out.println(
                            "Documento recuperado: " + recuperado
                        );
                    }

                    break;

                case 4:

                    System.out.println("\n--- ESTADO ACTUAL ---");

                    System.out.println(
                        "Pendientes: " + pendientes
                    );

                    System.out.println(
                        "Historial: " + historial
                    );

                    break;

                case 5:

                    System.out.println("Programa finalizado.");
                    break;

                default:

                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        teclado.close();
    }
}
