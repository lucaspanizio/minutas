/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panizio.ireport;

/**
 *
 * @author Lucas Panizio
 */

import java.io.File;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import panizio.conexao.ConexaoBanco;
 
public class Relatorios {
    
    private static final String FOLDER_RELATORIOS = "C:/SofPan";    
   
 
    public void visualizarMinuta(HashMap parametrosRelatorio, String nomeRelatorioJasper) throws Exception {
 
        String caminhoRelatorio = FOLDER_RELATORIOS;//this.getClass().getResource(FOLDER_RELATORIOS).getPath();
 
//        /* caminho completo até o relatório compilado indicado */
//        String caminhoArquivosJasper = caminhoRelatorio + File.separator
//                + nomeRelatorioJasper + ".jasper";

          String relatorio = caminhoRelatorio + File.separator + nomeRelatorioJasper + ".jasper";
          
//        /* Faz o carregamento do relatório */
//        JasperReport relatorioJasper = (JasperReport) JRLoader
//                .loadObjectFromFile(caminhoArquivosJasper);
        
 
        /* Carrega o arquivo */
        JasperPrint impressoraJasper = JasperFillManager.fillReport(
                relatorio, parametrosRelatorio, new ConexaoBanco().getConnection());
        
        JasperViewer.viewReport(impressoraJasper,false);
    }
 
}
