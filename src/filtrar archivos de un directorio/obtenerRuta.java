package ParcialArchivosHilos;

import java.io.File;
import java.io.FilenameFilter;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class obtenerRuta implements Runnable {

    File rutaxd;
    File rutaxd2;

    JTextArea panes1;
    JTextArea panes2;

    String opc;

    public obtenerRuta(File rutaxd, File rutaxd2, JTextArea panes1, JTextArea panes2, String opc) {
        this.rutaxd = rutaxd;
        this.rutaxd2 = rutaxd2;
        this.panes1 = panes1;
        this.panes2 = panes2;
        this.opc = opc;
    }

    public static void seleccionarCarpeta(JTextField txtRuta2) {
        JFileChooser seleccionarCarpeta = new JFileChooser();
        seleccionarCarpeta.setDialogTitle("Seleccione la carpeta para guardar los archivos...");
        seleccionarCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        seleccionarCarpeta.showOpenDialog(seleccionarCarpeta);
        txtRuta2.setText(seleccionarCarpeta.getSelectedFile().getPath());
    }

    FilenameFilter textFilter = (File dir, String name) -> {
        String lowercaseName = name.toLowerCase();
        return lowercaseName.endsWith(opc);
    };

    @Override
    public void run() {

        File[] listas1 = rutaxd.listFiles(textFilter);
        File[] listas2 = rutaxd2.listFiles(textFilter);

        for (File lista1 : listas1) {
            panes1.append(lista1.getName() + "\n");
        }

        for (File lista2 : listas2) {
            panes2.append(lista2.getName() + "\n");
        }

        
    }
}
