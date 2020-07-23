package t3b.pv.cierraturno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import t3b.pv.cierraturno.service.DatosService;

@SpringBootApplication
public class BashCierraTurnoApplication {
	
	@Autowired
	@Qualifier("datosServiceImpl")
	private DatosService datosServiceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(BashCierraTurnoApplication.class, args);
		
		
		
	}
}