package t3b.pv.cierraturno.service;

import java.util.List;

import t3b.pv.cierraturno.dto.TurnoDto;

public interface DatosService {

	public abstract void init();

	public abstract void proceso(int idTurno, int bandera);

	public abstract List<TurnoDto> consultaTurnosNoEnviadosExt();

	public abstract void consultaTurnosNoEnviados();

	public abstract void iniciaTurnoBOT();

	public abstract void borraInfoTurno(int idTurno);

	public abstract void procesoCierraTurnoBOT(int idTurno);

	public String getClave();

	public void setClave(String clave);

	public String getCaja();

	public void setCaja(String caja);

}
