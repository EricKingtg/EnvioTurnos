package t3b.pv.cierraturno.service;

import java.util.List;

import t3b.pv.cierraturno.dto.TurnoDto;

public interface DatosService {

	public abstract void proceso(int idTurno, int bandera);
	//////////////////////////
	abstract List<TurnoDto> consultaTurnosNoEnviadosExt();
	abstract void consultaTurnosNoEnviados();
	abstract void iniciaTurnoBOT();
	abstract void borraInfoTurno(int idTurno);
	abstract void procesoCierraTurnoBOT(int idTurno);
	
}
