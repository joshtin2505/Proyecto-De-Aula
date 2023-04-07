import javax.swing.JOptionPane;
import java.io.*;

public class RegUser {
    
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private String edad;

        //Metodo para registrar usuarios
        public void registrarUsuario(){

            boolean bucle;

            //Nombre

                this.nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre");

                //este condicional validara si el "nombre" esta dentro de las letras del alfabeto
                    if (!nombre.matches("^[a-zA-Z]+$")) {
                        JOptionPane.showMessageDialog(null, "Error: El nombre solo debe contener letras.");
                        bucle = true;
                    }
                    else{
                        bucle = false;
                    }
                //bucle para arreglar el error
                    while (bucle){

                        this.nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre");

                        if (!nombre.matches("^[a-zA-Z]+$")) {
                            JOptionPane.showMessageDialog(null, "Error: El nombre solo debe contener letras.");
                            bucle = true;
                        }
                        else{
                            bucle = false;
                            break;
                        }
                }

            //Apellido

            this.apellido = JOptionPane.showInputDialog(null, "Introduce tus apellido");

            //este condicional validara si el "apellido" esta dentro de las letras del alfabeto
                if (!apellido.matches("^[a-zA-Z]+$")) {
                    JOptionPane.showMessageDialog(null, "Error: Los apellidos solo deben contener letras.");
                    bucle = true;
                }
                else{
                    bucle = false;
                }
            //bucle para arreglar el error
                while (bucle){

                    this.apellido = JOptionPane.showInputDialog(null, "Introduce tus apellido");

                    if (!apellido.matches("^[a-zA-Z]+$")) {
                        JOptionPane.showMessageDialog(null, "Error: Los apellidos solo deben contener letras.");
                        bucle = true;
                    }
                    else{
                        bucle = false;
                    }
                }

            //Correo

                this.correo = JOptionPane.showInputDialog(null, "Introduce tu correo electronico");

                //este condicional validara si el "correo" es un correo electronico
                if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                    JOptionPane.showMessageDialog(null, "Error: La dirección de correo electrónico no es válida.");
                    bucle = true;
                } else {
                    bucle = false;
                }
                //bucle para arreglar el error
                    while (bucle){
                        this.correo = JOptionPane.showInputDialog(null, "Introduce tu correo electronico");

                        if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                            JOptionPane.showMessageDialog(null, "Error: La dirección de correo electrónico no es válida.");
                            bucle = true;
                        }
                        else {
                            bucle = false;
                            break;
                        }
                    }

            //Contraseña

                this.contraseña = JOptionPane.showInputDialog(null, "Tu contraseña debe cumplir con los siguientes requisitos:\n1. al menos una letra mayúscula\n2. al menos una letra minúscula\n3. al menos un dígito\n4. al menos un carácter especial\n5. longitud mínima de 8 caracteres");

                //este condicional validara si el "correo" es un correo electronico
                if (!contraseña.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$")) {
                    JOptionPane.showMessageDialog(null, "Error: La contraseña no cumple con los requisitos.");
                    bucle = true;
                }
                else {
                    bucle = false;
                    
                }
                //bucle para arreglar el error
                    while (bucle){

                        this.contraseña = JOptionPane.showInputDialog(null, "Tu contraseña debe cumplir con los siguientes requisitos:\n1. al menos una letra mayúscula\n2. al menos una letra minúscula\n3. al menos un dígito\n4. al menos un carácter especial\n5. longitud mínima de 8 caracteres");

                        if (!contraseña.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$")) {
                            JOptionPane.showMessageDialog(null, "Error: La contraseña no cumple con los requisitos.");
                            bucle = true;
                        } else {
                            bucle = false;
                            break;
                        }
                    }

            //Edad

                this.edad = JOptionPane.showInputDialog(null, "Ingresa tu edad\n (debes ser mayor de 18 y menor de 50 para poder crear tu cuenta)");

                //debo concatenar edad en una segunda variable para usarla en  la segunda condicion
                int edad_concat = Integer.parseInt(edad);

                //este condicional validara si el "correo" es un correo electronico
                if (!edad.matches("^\\d+$")) {
                    JOptionPane.showMessageDialog(null, "Error: La edad debe ser un número entero positivo.");
                    bucle = true;
                } 
                else if(edad_concat < 18 || edad_concat > 50){
                    JOptionPane.showMessageDialog(null, "Error: debes ser mayor de 18 y menor de 50 para poder crear tu cuenta.");
                    bucle = true;
                }
                else {
                    bucle = false;
                    
                }
                //bucle para arreglar el error
                    while (bucle){

                        this.edad = JOptionPane.showInputDialog(null, "Ingresa tu edad\n (debes ser mayor de 18 y menor de 50 para poder crear tu cuenta)");

                        if (!edad.matches("^\\d+$")) {
                            JOptionPane.showMessageDialog(null, "Error: La edad debe ser un número entero positivo.");
                            bucle = true;
                        } 
                        else if(edad_concat < 18 || edad_concat > 50){
                            JOptionPane.showMessageDialog(null, "Error: debes ser mayor de 18 y menor de 50 para poder crear tu cuenta.");
                            bucle = true;
                        }
                        else {
                            bucle = false;
                            break;
                        }  
                    }
        }

        public void baseDeDatosProvicional (){
            try{

                String directorioDeLaBase = "C:/Users/mies2/OneDrive/Escritorio/PA/RC/src/Data/";

                File dataBase = new File("dataBase.txt");
                FileWriter dato = new FileWriter(directorioDeLaBase + dataBase);
                dato.write("-----------User # 1------------\n");
                dato.write("Nombre: " + nombre + "\n");
                dato.write("Apellidos: " +apellido+ "\n");
                dato.write("Correo: " +correo+ "\n");
                dato.write("Contraseña: " +contraseña+ "\n");
                dato.write("Edad: " +edad+ "\n");

                dato.close();

                JOptionPane.showMessageDialog(null, "Datos guardados en el archivo correctamente.");

            }
            catch(IOException e){

                JOptionPane.showMessageDialog(null, "Error al guardar los datos en el archivo: " + e.getMessage());

            }
        }
}
    
    

