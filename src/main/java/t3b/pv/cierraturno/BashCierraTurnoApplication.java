package t3b.pv.cierraturno;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import t3b.pv.cierraturno.service.DatosService;

@SpringBootApplication
public class BashCierraTurnoApplication implements ApplicationRunner {
	
	private static final Log LOG = LogFactory.getLog(BashCierraTurnoApplication.class);

	@Autowired
	@Qualifier("datosServiceImpl")
	private DatosService datosServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(BashCierraTurnoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String[] arg = args.getSourceArgs();
		
		Integer idTurno = Integer.parseInt(arg[0]);
		Integer bandera = Integer.parseInt(arg[1]);
		
		LOG.info("Se comienza la ejecucion para turno: " + idTurno + ", con bandera: " + bandera);
		
		datosServiceImpl.init();
		datosServiceImpl.proceso(idTurno, bandera);
	}
}