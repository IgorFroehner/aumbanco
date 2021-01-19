package br.com.aumbanco.util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 * Classe com mÃ©todos utilitÃ¡rios para executar e abrir relatÃ³rios.
 *
 * @author David Buzatto ===> Modificado por Joecir ===> Modificado por Igor
 */
public class ReportUtils {

    /**
     * Abre um relatÃ³rio usando uma conexÃ£o como datasource.
     *
     * @param titulo TÃ­tulo usado na janela do relatÃ³rio.
     * @param inputStream InputStream que contÃ©m o relatÃ³rio.
     * @param parametros ParÃ¢metros utilizados pelo relatÃ³rio.
     * @param conexao ConexÃ£o utilizada para a execuÃ§Ã£o da query.
     * @throws JRException Caso ocorra algum problema na execuÃ§Ã£o do relatÃ³rio
     */
    public static void openReport(
            String titulo,
            InputStream inputStream,
            Map parametros,
            Connection conexao) throws JRException {

        /*
         * Cria um JasperPrint, que Ã© a versÃ£o preenchida do relatÃ³rio,
         * usando uma conexÃ£o.
         */
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, conexao);

        // abre o JasperPrint em um JFrame
        viewReportFrame(titulo, print);

    }

    
    
    private static void viewReportFrame(String titulo, JasperPrint print) {
        /*
         * Cria um JRViewer para exibir o relatÃ³rio.
         * Um JRViewer Ã© uma JPanel.
         */
        JRViewer jrviewer = new JRViewer(print);

        try {
            JDialog viewer = new JDialog(new javax.swing.JFrame(), titulo, true);
            //maximiza o viewer
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            viewer.setBounds(0, 0, screenSize.width, screenSize.height);
            
            viewer.add(jrviewer, BorderLayout.CENTER);
            viewer.setLocationRelativeTo(null);

            viewer.setVisible(true);

        } catch (Exception e) {

        }
    }

}
