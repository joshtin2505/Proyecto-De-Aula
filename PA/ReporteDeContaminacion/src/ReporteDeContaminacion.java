import java.util.Scanner;
import java.util.Random;

public class ReporteDeContaminacion {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
//main
    public static void main(String[] args) {
        while (true) {
            System.out.println("¿Qué deseas hacer?\n1. Registrarme\n2. Salir");
            int respuesta = scanner.nextInt();
            if (respuesta == 1) {
                if (registrarUsuario()) {
                    System.out.println("Registro exitoso!");
                    hacerReportes();
                } else {
                    System.out.println("Lo siento, no puedes registrarte.");
                }
            } else if (respuesta == 2) {
                break;
            } else {
                System.out.println("Error: Opción inválida, por favor ingresa 1 o 2.");
            }
        }
    }
//registrar usuario
    public static boolean registrarUsuario() {
        
        System.out.println("Registro:\nNombre(s): ");
        String nombre = scanner.next();
        if (!nombre.matches("^[a-zA-Z]+$")) {
            System.out.println("Error: El nombre solo debe contener letras.");
            return false;
        }
        System.out.println("Apellido(s): ");
        String apellido = scanner.next();
        if (!apellido.matches("^[a-zA-Z]+$")) {
            System.out.println("Error: El apellido solo debe contener letras.");
            return false;
        }
        System.out.println("Edad: ");
        String edad_string = scanner.next();
        if (!edad_string.matches("\\d+")) {
            System.out.println("Error: La edad solo debe contener números.");
            return false;
        }
        int edad = Integer.parseInt(edad_string);
        System.out.println("Dirección: ");
        String direccion = scanner.next();
        if (edad >= 18 && edad <= 50) {
            // Aquí deberías agregar tu código para conectarte a la base de datos y almacenar al usuario
            return true;
        } else {
            return false;
        }
    }

    public static void hacerReportes() {
        while (true) {
            System.out.println("Selecciona el tipo de contaminación:\n1. Atmosférica\n2. Visual\n3. Auditiva\n4. Salir");
            int tipoContaminacion = scanner.nextInt();
            if (tipoContaminacion == 4) {
                break;
            }
            System.out.println("Selecciona la dirección:\n1. Agregar una nueva dirección\n2. Usar mi dirección actual\n3. No incluir dirección");
            int opcionDireccion = scanner.nextInt();
            String direccion;
            if (opcionDireccion == 1) {
                System.out.println("Ingresa la nueva dirección:");
                direccion = scanner.next();
            } else if (opcionDireccion == 2) {
                // Aquí deberías agregar tu código para obtener la dirección del usuario
                direccion = "";
            } else {
                System.out.println("Tu caso ha sido rechazado. Razón: Información incompleta.");
                continue;
            }
            System.out.println("Adjuntar evidencia:\n1. Fotográfica\n2. Audiovisual\n3. No adjuntar evidencia");
            int opcionEvidencia = scanner.nextInt();
            String evidencia;
            if (opcionEvidencia == 1) {
                System.out.println("Ingresa el nombre de la imagen:");
                evidencia = scanner.next();
            } else if (opcionEvidencia == 2) {
                System.out.println("Ingresa el nombre de la grabación:");
                evidencia = scanner.next();
            } else {
                System.out.println("Tu caso ha sido rechazado. Razón: Información incompleta.");
                continue;
            }
            String mensaje = String.format("Nuevo caso de contaminación:\nTipo: %d\nDirección: %s\nEvidencia: %s", tipoContaminacion, direccion, evidencia);
            // Aquí deberías agregar tu código para enviar notificaciones a la empresa ambiental
            System.out.println("Gracias por reportar. Tu caso está en trámite.");
            if (random.nextBoolean()) {
                System.out.println("Felicidades, tu caso ha sido aceptado.");
            } else {
                System.out.println("Lo siento, tu caso ha sido rechazado. Razón: Comentarios adicionales del equipo de la empresa ambiental.");
            }
        }
    }
}