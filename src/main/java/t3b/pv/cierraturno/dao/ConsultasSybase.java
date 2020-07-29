package t3b.pv.cierraturno.dao;

import java.sql.Connection;

import t3b.pv.cierraturno.dto.ArqueoCierraTurnoDto;
import t3b.pv.cierraturno.dto.CancelacionesDto;
import t3b.pv.cierraturno.dto.CancelacionesEncDto;
import t3b.pv.cierraturno.dto.CierraTurnoDto;
import t3b.pv.cierraturno.dto.CierraTurnoKardex;
import t3b.pv.cierraturno.dto.DevolucionesDto;
import t3b.pv.cierraturno.dto.DevolucionesEncabezado;
import t3b.pv.cierraturno.dto.EValeLogDto;
import t3b.pv.cierraturno.dto.EstadisticasDto;
import t3b.pv.cierraturno.dto.HoraTipoDto;
import t3b.pv.cierraturno.dto.InetErrorSummary;
import t3b.pv.cierraturno.dto.IngresoVentasDto;
import t3b.pv.cierraturno.dto.InternetErrorDto;
import t3b.pv.cierraturno.dto.Log10TransDto;
import t3b.pv.cierraturno.dto.LogPtTransDto;
import t3b.pv.cierraturno.dto.LogTregaloDTo;
import t3b.pv.cierraturno.dto.MovDetDto;
import t3b.pv.cierraturno.dto.MovEncDto;
import t3b.pv.cierraturno.dto.MovTregaloDto;
import t3b.pv.cierraturno.dto.MovimientosEvaleDto;
import t3b.pv.cierraturno.dto.MovimientosRetirosDto;
import t3b.pv.cierraturno.dto.MvtosElectroDto;
import t3b.pv.cierraturno.dto.PagosVentasDto;
import t3b.pv.cierraturno.dto.PvLogTarjetaDto;
import t3b.pv.cierraturno.dto.TpvTicketError;
import t3b.pv.cierraturno.dto.TrnTxDetDto;
import t3b.pv.cierraturno.dto.TurnoDto;
import t3b.pv.cierraturno.dto.VentasArticulosDto;

public interface ConsultasSybase {

	public void setConexion(Connection sybase);

	public boolean borraInfoTurno(TurnoDto in);

	public boolean actualizaInfoTurnoCierra(TurnoDto in);

	public boolean insertaInfoDevolucion(DevolucionesDto in);

	public boolean insertaInfoDevolEnc(DevolucionesEncabezado in);

	public boolean insertaInfoTrnTxDet(TrnTxDetDto in);

	public boolean insertaInfoHoraTipo(HoraTipoDto in);

	public boolean insertaInfoIngresoVtas(IngresoVentasDto in);

	public boolean insertaInfoEvaleLog(EValeLogDto in);

	public boolean insertaInfoInetErrorSummary(InetErrorSummary in);

	public boolean insertaInfoInetError(InternetErrorDto in);

	public boolean insertaInfoPagosVenta(PagosVentasDto in);

	public boolean insertaInfoMovsEvale(MovimientosEvaleDto in);

	public boolean insertaInfoMovsRetiro(MovimientosRetirosDto in);

	public boolean insertaInfoTcksError(TpvTicketError in);

	public boolean insertaInfoMtosElectro(MvtosElectroDto in);

	public boolean insertaInfoVtasArti(VentasArticulosDto in);

	public boolean insertaInfoMovEnc(MovEncDto in);

	public boolean insertaInfoMovDet(MovDetDto in);

	public boolean insertaInfoLog10Trans(Log10TransDto in);

	public boolean insertaInfoLogRega(LogTregaloDTo in);

	public boolean insertaInfoMovRegalo(MovTregaloDto in);

	public boolean insertaInfoLogTrans(LogPtTransDto in);

	public boolean insertaInfoCierraTurno(CierraTurnoDto in);

	public boolean insertaInfoKardex(CierraTurnoKardex in);

	public boolean insertaInfoCancelaciones(CancelacionesDto in);

	public boolean insertaInfoCancelacionesEnc(CancelacionesEncDto in);

	public boolean insertaInfoTurno(TurnoDto in);

	public boolean insertaInfoEstadisticas(EstadisticasDto in);

	public boolean insertaInfoArqueoCierraTurno(ArqueoCierraTurnoDto in);
	
	public boolean insertaInfoPagoTarjeta(PvLogTarjetaDto in);

}
