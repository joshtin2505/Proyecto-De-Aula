import javax.swing.JOptionPane;
// import java.io.*;
import java.util.ArrayList;

public class RegUser {

    ArrayList<User> regUserArray = new ArrayList<User>();
    User objUser = new User();

    // Constructor vacio
    public RegUser() {
    }

    // Metodo de entradas En JOptionPane
    public String Entrada(String texto) {
        return JOptionPane.showInputDialog(texto);
    }

    // Metodo para registrar usuarios
    public void registrarUsuario() {
        try {

            boolean bucle;

            // Nombre

            String nombre = Entrada("Introduce tu nombre");

            // este condicional validara si el "nombre" esta dentro de las letras del
            // alfabeto
            if (!nombre.matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null, "Error: El nombre solo debe contener letras.");
                bucle = true;
            } else {
                bucle = false;
            }
            // bucle para arreglar el error
            while (bucle) {

                nombre = Entrada("Introduce tu nombre");

                if (!nombre.matches("^[a-zA-Z]+$")) {
                    JOptionPane.showMessageDialog(null, "Error: El nombre solo debe contener letras.");
                    bucle = true;
                } else {
                    bucle = false;
                    break;
                }
            }

            // Apellido

            String apellido = Entrada("Introduce tus apellido");

            // este condicional validara si el "apellido" esta dentro de las letras del
            // alfabeto
            if (!apellido.matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null, "Error: Los apellidos solo deben contener letras.");
                bucle = true;
            } else {
                bucle = false;
            }
            // bucle para arreglar el error
            while (bucle) {

                apellido = Entrada("Introduce tus apellido");

                if (!apellido.matches("^[a-zA-Z]+$")) {
                    JOptionPane.showMessageDialog(null, "Error: Los apellidos solo deben contener letras.");
                    bucle = true;
                } else {
                    bucle = false;
                }
            }

            // Correo

            String correo = Entrada("Introduce tu correo electronico");

            // este condicional validara si el "correo" es un correo electronico
            if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                JOptionPane.showMessageDialog(null, "Error: La dirección de correo electrónico no es válida.");
                bucle = true;
            } else {
                bucle = false;
            }
            // bucle para arreglar el error
            while (bucle) {
                correo = Entrada("Introduce tu correo electronico");

                if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                    JOptionPane.showMessageDialog(null, "Error: La dirección de correo electrónico no es válida.");
                    bucle = true;
                } else {
                    bucle = false;
                    break;
                }
            }

            // Contraseña

            String contraseña = Entrada(
                    "Tu contraseña debe cumplir con los siguientes requisitos:\n1. al menos una letra mayúscula\n2. al menos una letra minúscula\n3. al menos un dígito\n4. al menos un carácter especial\n5. longitud mínima de 8 caracteres");

            // este condicional validara si el "correo" es un correo electronico
            if (!contraseña.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$")) {
                JOptionPane.showMessageDialog(null, "Error: La contraseña no cumple con los requisitos.");
                bucle = true;
            } else {
                bucle = false;

            }
            // bucle para arreglar el error
            while (bucle) {

                contraseña = Entrada(
                        "Tu contraseña debe cumplir con los siguientes requisitos:\n1. al menos una letra mayúscula\n2. al menos una letra minúscula\n3. al menos un dígito\n4. al menos un carácter especial\n5. longitud mínima de 8 caracteres");

                if (!contraseña.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$")) {
                    JOptionPane.showMessageDialog(null, "Error: La contraseña no cumple con los requisitos.");
                    bucle = true;
                } else {
                    bucle = false;
                    break;
                }
            }

            // Edad

            String edad = Entrada("Ingresa tu edad\n (debes ser mayor de 18 y menor de 50 para poder crear tu cuenta)");

            // debo concatenar edad en una segunda variable para usarla en la segunda
            // condicion
            int edad_concat = Integer.parseInt(edad);

            // este condicional validara si el "correo" es un correo electronico
            if (!edad.matches("^\\d+$")) {
                JOptionPane.showMessageDialog(null, "Error: La edad debe ser un número entero positivo.");
                bucle = true;
            } else if (edad_concat < 18 || edad_concat > 50) {
                JOptionPane.showMessageDialog(null,
                        "Error: debes ser mayor de 18 y menor de 50 para poder crear tu cuenta.");
                bucle = true;
            } else {
                bucle = false;

            }
            // bucle para arreglar el error
            while (bucle) {

                edad = Entrada("Ingresa tu edad\n (debes ser mayor de 18 y menor de 50 para poder crear tu cuenta)");

                if (!edad.matches("^\\d+$")) {
                    JOptionPane.showMessageDialog(null, "Error: La edad debe ser un número entero positivo.");
                    bucle = true;
                } else if (edad_concat < 18 || edad_concat > 50) {
                    JOptionPane.showMessageDialog(null,
                            "Error: debes ser mayor de 18 y menor de 50 para poder crear tu cuenta.");
                    bucle = true;
                } else {
                    bucle = false;
                    break;
                }
            }

            objUser.setNombre(nombre);
            objUser.setApellido(apellido);
            objUser.setCorreo(correo);
            objUser.setEdad(edad);
            objUser.setContraseña(contraseña);
            regUserArray.add(objUser);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error,no se pudo registrar el nuevo usuario: " + e.getMessage());
        } finally {
            // aqui tiene que haber algo que te envie devuelta al menu o que ejecute
            // nuevamente la parte del try
        }
    }

    // Para comprobar los usuarios registrados
    public void obtenerUsuario() {
        if (regUserArray.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lista vacia");
        } else {
            String separador = "";
            for (int i = 0; i < regUserArray.size(); i++) {
                separador += "\nPersona numero: " + (i + 1);
                separador += "\nNombre: " + regUserArray.get(i).getNombre();
                separador += "\nApellido: " + regUserArray.get(i).getApellido();
                separador += "\nCorreo: " + regUserArray.get(i).getCorreo();
                separador += "\nCorreo: " + regUserArray.get(i).getContraseña();
                separador += "\nEdad: " + regUserArray.get(i).getEdad();
            }
            JOptionPane.showMessageDialog(null, separador);
        }
    }

    // Eliminar usuarios
    public void eliminarUsuario() {
        regUserArray.clear();
        JOptionPane.showMessageDialog(null, "Usuario Eliminado");
    }
    // Viejo metodo para guardar los datos en un archivo
    // public void baseDeDatosProvicional() {

    // try {

    // String directorioDeLaBase =
    // "C:/Users/mies2/OneDrive/Escritorio/PA/RC/src/Data/";

    // File dataBase = new File("dataBase.xml");
    // FileWriter dato = new FileWriter(directorioDeLaBase + dataBase);
    // dato.write("-----------User # 1------------\n");
    // dato.write("Nombre: " + objUser.getNombre() + "\n");
    // dato.write("Apellidos: " + objUser.getApellido() + "\n");
    // dato.write("Correo: " + objUser.getCorreo() + "\n");
    // dato.write("Contraseña: " + objUser.getContraseña() + "\n");
    // dato.write("Edad: " + objUser.getEdad());
    // dato.close();

    // JOptionPane.showMessageDialog(null, "Datos guardados en el archivo
    // correctamente.");

    // } catch (IOException e) {

    // JOptionPane.showMessageDialog(null, "Error al guardar los datos en el
    // archivo: " + e.getMessage());

    // } finally {
    // // aqui tiene que haber algo que te envie devuelta al menu o que ejecute
    // // nuevamente la parte del try
    // }
    // }

}
