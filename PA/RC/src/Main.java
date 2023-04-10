import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        RegUser registro = new RegUser();
        // registro.baseDeDatosProvicional();
        // Menu
        int opciones;

        do {
            opciones = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1. Consultar persona\n2. Agregar persona\n3. Eliminar persona\n4. Salir"));

            switch (opciones) {
                case 1:
                    registro.obtenerUsuario();
                    break;
                case 2:
                    registro.registrarUsuario();
                    break;
                case 3:
                    registro.eliminarUsuario();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "programa finalizado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No existe la opción");
            }
        } while (opciones != 4);
    }
}
