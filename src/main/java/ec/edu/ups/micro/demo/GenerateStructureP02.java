import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import com.fitbank.common.Helper;
import com.fitbank.common.logger.FitbankLogger;
import com.fitbank.dto.management.Detail;
import com.fitbank.processor.maintenance.MaintenanceCommand;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * CLASE QUE PERMITE GENERAR REPORTE DE LA ESTRUCTURA P02
 */
public class GenerateStructureP02 extends MaintenanceCommand{

	/**SERIAL DE LA CLASE**/
	private static final long serialVersionUID = 1L;
	
	private static final String[] CAMPOS= {"SUBSTR(TP.CTIPOPERSONA,0,1) AS TIPOPERSONA","TNB.APELLIDOPATERNO","TNB.APELLIDOMATERNO","TNB.PRIMERNOMBRE","TNB.SEGUNDONOMBRE",
			"TO_CHAR(TNB.FNACIMIENTO,'DD/MM/YYYY')FNACIMIENTO","TNB.GENERO","TPD.NUMERODOCUMENTO","TO_CHAR(TPD.FEMISION,'DD/MM/YYYY')FEMISION","TPA.SIGLAS","TO_CHAR(TPD.FCADUCIDAD,'DD/MM/YYYY')FCADUCIDAD","TPCE.CESTADOMIGRATORIO","TO_CHAR(TPCE.FINGRESOPAIS,'DD/MM/YYYY')FINGRESOPAIS"} ;
	
	@SuppressWarnings("deprecation")
	public static final Logger LOGGER = FitbankLogger.getLogger();

	@Override
	public Detail executeNormal(Detail pDetail) throws Exception {
		
		String fdesde=pDetail.findFieldByName("FDESDE").getDateValue().replace("-", "/");
	    String fhasta=pDetail.findFieldByName("FHASTA").getDateValue().replace("-", "/");
	    
	    /**CONSULTA ESTRUCTURA P02**/
		String consultaP02="SELECT DISTINCT "+generarCamposConsulta()+" FROM TPERSONA TP, TNATURALINFORMACIONBASICA TNB, TCUENTA TC, TPERSONADOCUMENTOS TPD, TPAISES TPA, TPERSONACODIGOEXTRANJERO TPCE WHERE TP.CPERSONA=TC.CPERSONA_CLIENTE AND TP.FHASTA=TO_DATE('29991231','YYYYMMDD') AND TC.FHASTA=TP.FHASTA AND TNB.FHASTA=TP.FHASTA AND TNB.CPERSONA=TP.CPERSONA AND TPCE.CPERSONA=TP.CPERSONA AND TPCE.FHASTA=TP.FHASTA AND TPD.FHASTA=TP.FHASTA AND TPA.FHASTA=TP.FHASTA AND TP.CPAIS=TPA.CPAIS AND TPD.CPERSONA=TP.CPERSONA AND TC.CSUBSISTEMA='04' AND TC.CESTATUSCUENTA='002' AND TPD.CTIPODOCUMENTOPERSONA='8' AND TP.CTIPOIDENTIFICACION='PAS' AND TC.FAPERTURA BETWEEN TO_DATE(:FDESDE,'DD/MM/YYYY') AND TO_DATE(:FHASTA,'DD/MM/YYYY')";

	    List<Object[]>datos=getData(fdesde, fhasta,consultaP02);
	    int numeroRegistros=datos.size()+1;
	    String estructura=pDetail.findFieldByName("ESTRUCTURA").getStringValue();
		/*
		 * Archivo
		 */
	    SimpleDateFormat formatArchivo = new SimpleDateFormat("ddMMyyyy"); 
		String ruta=this.getParameter();	
		String codigoSib="1004";
		String extension=".txt";
		String archivo=estructura+codigoSib+formatArchivo.format(new Date())+extension;
        pDetail.findFieldByName("RUTA").setValue(ruta);
        pDetail.findFieldByName("ARCHIVO").setValue(archivo);
        

		
		/*
		 *Contenido del Archivo
		 */
        String delimitador="\t";
        String cabecera=crearCabecera(estructura, codigoSib, numeroRegistros,delimitador);
		String usuario=pDetail.getUser();
       	createFile(ruta,archivo,datos,cabecera,usuario,estructura,delimitador);
		
    	return pDetail;
	}

	/**
	 * Método que se encarga de ejecutar la consulta del reporte.
	 * @param fdesde
	 * @param fhasta
	 * @param consultaP02
	 * @return
	 */
	public List<Object[]> getData(String fdesde, String fhasta,String consultaP02) {
		SQLQuery sql = Helper.createSQLQuery(consultaP02);
		sql.setString("FDESDE", fdesde);
		sql.setString("FHASTA", fhasta);
		LOGGER.info("**********SE REALIZA LA EJECUCION DE LA CONSULTA A LA BASE DE DATOS ENTRE LAS FECHAS: "+fdesde +" Y "+fhasta+"**********");
		@SuppressWarnings("unchecked")
		List<Object[]> datos=sql.list();
		return datos;
	}
	private static final Set<String> VALID_PATHS = new HashSet<String>(Arrays.asList("/FitBank/reportes/otros/EstructuraP02/"));
	/**
	 * Método que se encarga de crear el archivo con el contenido solicitado.
	 * @param ruta
	 * @param archivo
	 * @param datos
	 * @param cabecera
	 * @param usuario
	 * @param estructura
	 * @param delimitador
	 * @throws Exception
	 */
	private void createFile(String ruta,String archivo,List<Object[]> datos, String cabecera,String usuario,String estructura,String delimitador) throws Exception{
		LOGGER.info("**********EL USUARIO: "+usuario+" VA A GENERAR LA ESTRUCTURA: "+ estructura+"**********");
		LOGGER.info("**********EMPIEZA LA GENERACION DEL REPORTE DE LA ESTRUCTURA "+ estructura+"**********");
		String rut = ruta.toString();
		String norma_path = Paths.get(rut).normalize().toString();

		FileWriter fw = null;
	    BufferedWriter bw = null;
		  try {
		        File file = new File(ruta+archivo);
				String nameFile = FilenameUtils.getName(ruta+archivo);

			    File path =  new File(norma_path+"/");

	            LOGGER.info("**********COMIENZA LA CREACION DEL ARCHIVO Y DIRECTORIO**********");
	            if(path.exists()) {
	            	for (File f : path.listFiles()) {
						f.delete();
					}
	            }else {
	            	path.mkdirs();
	            }
	    		fw = new FileWriter(file+"",true);
	    	    bw = new BufferedWriter(fw);
	    	    
				bw.write(cabecera);
				LOGGER.info("**********SE INSERTA LA CABECERA EN EL REPORTE**********");
				for (Object[] d : datos) {
					bw.newLine();
					for (Object campo : d) {
						if(campo==null)
							campo="";
						bw.write(campo+delimitador);
					}
				}
				LOGGER.info("**********SE INSERTA LA INFORMACIÓN DEL REPORTE**********");
	        } catch (Exception e) {	            
	        	LOGGER.info("**********SE HA PRODUCIDO UN ERROR: "+e.getMessage()+"**********");
				throw new Exception("SE HA PRODUCIDO UN ERROR VERIFIQUE LOS LOGS.");	
	        } finally {
    			if(bw!=null) {
    				bw.close();
    				LOGGER.info("**********CIERRA EL BUFFER DE ESCRITURA DEL ARCHIVO**********");
    			}
    		}
	}

	@Override
	public Detail executeReverse(Detail arg0) throws Exception {
		return null;
	}
	/**
	 * Método para crear la cabecera del archivo.
	 * @param estructura
	 * @param codigoSib
	 * @param numeroRegistros
	 * @param delimitador
	 * @return
	 */
	public String crearCabecera(String estructura,String codigoSib,int numeroRegistros,String delimitador) {
		SimpleDateFormat formatoCabecera = new SimpleDateFormat("dd/MM/yyyy"); 
		String cabecera=estructura+delimitador+codigoSib+delimitador+formatoCabecera.format(new Date())+delimitador+numeroRegistros;	    
		String espacios="";
		for (int i = 0; i < CAMPOS.length-4;i++) {
			espacios=espacios+delimitador+"";
		}
		cabecera=cabecera+espacios;
		LOGGER.info("**********SE GENERA LA CABECERA DEL REPORTE**********");
		return cabecera;
	}
	
	/**
	 * Método que se encarga de generar los campos para el select de la consulta
	 * @return
	 */
	public String generarCamposConsulta() {
		String camposSelect="";
		for (String c : CAMPOS) {
			camposSelect=camposSelect+","+c;
		}
		return camposSelect.substring(1);
	}
}
