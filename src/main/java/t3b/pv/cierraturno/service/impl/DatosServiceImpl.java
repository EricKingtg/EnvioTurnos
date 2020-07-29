/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 31/10/2018
 *
 */

package t3b.pv.cierraturno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import t3b.pv.cierraturno.dao.ConsultasMySql;
import t3b.pv.cierraturno.dao.ConsultasSybase;
import t3b.pv.cierraturno.dto.ArqueoCierraTurnoDto;
import t3b.pv.cierraturno.dto.CancelacionesDto;
import t3b.pv.cierraturno.dto.CancelacionesEncDto;
import t3b.pv.cierraturno.dto.CierraTurnoDto;
import t3b.pv.cierraturno.dto.CierraTurnoKardex;
import t3b.pv.cierraturno.dto.DevolucionesDto;
import t3b.pv.cierraturno.dto.DevolucionesEncabezado;
import t3b.pv.cierraturno.dto.DtoTurnoActivo;
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
import t3b.pv.cierraturno.dto.TiendaDto;
import t3b.pv.cierraturno.dto.TpvTicketError;
import t3b.pv.cierraturno.dto.TrnTxDetDto;
import t3b.pv.cierraturno.dto.TurnoDto;
import t3b.pv.cierraturno.dto.VentasArticulosDto;
import t3b.pv.cierraturno.service.DatosService;
import t3b.pv.cierraturno.utils.ConfiguraConexionSybase;
import t3b.pv.cierraturno.utils.Utilidades;
import t3b.pv.cierraturno.utils.Utilities;

@Service("datosServiceImpl")
public class DatosServiceImpl implements DatosService {

	private static final Log LOG = LogFactory.getLog(DatosServiceImpl.class);

	@Autowired
	@Qualifier("consultasMySql")
	private ConsultasMySql consultas;

	@Autowired
	@Qualifier("configuraConexionSybase")
	private ConfiguraConexionSybase conection;

	@Autowired
	@Qualifier("consultasSybase")
	private ConsultasSybase inserts;

	@Autowired
	@Qualifier("utilidades")
	private Utilidades utilidades;

	@Autowired
	@Qualifier("utilities")
	private Utilities utilities;

	private String clave;
	private String caja;

	public void init() {

		LOG.info("****************************************");
		LOG.info("*   Desarrollo Hecho Para Tiendas 3B   *");
		LOG.info("*     JAR Impacta Cierre Turno BOT     *");
		LOG.info("****************************************");

		List<TiendaDto> lista = new ArrayList<>();

		consultas.setConexion(conection.getCnnUnicaMysql());

		LOG.info("Comienza Proceso paso 1: Obtener Numero de tienda");
		lista = consultas.getNumTienda();

		clave = lista.get(0).getTclave();

		LOG.info("Proceso paso 2 --> Obtener la ip con base al numero de tienda : " + clave);
		String ipBO = utilidades.obtieneIp(clave);

		caja = utilities.executeCommand("caja");
		LOG.info("Obtenemos la caja: " + caja);

		inserts.setConexion(conection.getCnnUnica(ipBO, lista.get(0).getTclave()));

	}

	public List<TurnoDto> consultaTurnosNoEnviadosExt() {
		List<TurnoDto> lista = null;
		LOG.info("Proceso paso 5: Envio Automatico");
		LOG.info("Proceso paso 4: Se obtiene informacion del turno, es un envio automatico");
		lista = consultas.consultaTurnos();
		return lista;
	}

	public void proceso(int idTurno, int bandera) {

		LOG.info("Proceso paso 3: Procesar la info del turno: " + idTurno);

		switch (bandera) {
		case 0:
			LOG.info("La bandera es 0, se esta cerrando un turno");
			procesoCierraTurnoBOT(idTurno);
			break;
		case 1:
			LOG.info("La bandera es 1, se esta iniciando un turno");
			iniciaTurnoBOT();
			break;
		case 2:
			LOG.info("La bandera es 2, se esta cerrando un turno");
			procesoCierraTurnoBOT(idTurno);
			break;
		case 3:
			LOG.info("La bandera es 3, se esta borrando informacion del turno");
			borraInfoTurno(idTurno);
			break;
		case 4:
			LOG.info("La bandera es 4, consulta turnos");
			consultaTurnosNoEnviados();
			break;

		default:
			break;
		}
	}

	public void consultaTurnosNoEnviados() {

		LOG.info("Proceso paso 4: Se obtiene informacion del turno, es un envio automatico");
		List<TurnoDto> listaOP = consultas.consultaTurnos();

		if (!listaOP.isEmpty()) {
			for (TurnoDto dto : listaOP) {

				System.out.println("Turno: " + String.valueOf(dto.idturno));
			}

		}

	}

	public void iniciaTurnoBOT() {
		LOG.info("Proceso paso 4: Se obtiene informacion del turno, es una apertura de turno");
		List<TurnoDto> listaOP = consultas.getInfoTurnoOpenBot();
		if (!listaOP.isEmpty()) {
			for (TurnoDto dto : listaOP) {
				LOG.info("Proceso paso 5: ya se tiene la informacion del turno se procede a insertarlo, turno: "
						+ dto.getIdturno());
				inserts.insertaInfoTurno(dto);
			}
		}
		LOG.info("Se termina el proceso correctamente!!");
		System.out.println("1");
	}

	public void borraInfoTurno(int idTurno) {

		LOG.info("Validando si el turno esta cerrado");
		List<DtoTurnoActivo> listaActivo = consultas.validaTurnoActivo(idTurno);

		if (listaActivo.get(0).getActivo() == 0) {

			LOG.info("Proceso paso 4: Se obtiene informacion del turno, es un borrado de informacion");
			List<TurnoDto> listaOP = consultas.getInfoTurno(idTurno);

			LOG.info("Proceso paso 5: Tenemos la informacion del turno, actualizamos del lado del PV");
			consultas.actualizaInfoTurnoReenvio(idTurno);

			LOG.info("Proceso paso 6: Borramos la informacion del turno en el BOT");
			inserts.borraInfoTurno(listaOP.get(0));

			LOG.info("Proceso paso 7: Calculamos nuevamente la informacion de estadisticas");
			consultas.reestructuraTurno(idTurno, caja, clave, listaOP.get(0).getUseridcierre());

		} else {
			LOG.info("Como el proceso no se a completado solo se hace el proceso de cerrar el turno");
			LOG.info("Proceso paso 7: Calculamos nuevamente la informacion de estadisticas");
			consultas.reestructuraTurno(idTurno, caja, clave, listaActivo.get(0).getUseridabre());
		}
		// LOG.info("Proceso paso 8: Calculamos nuevamente la informacion de arqueo del
		// cierre del turno");
		// consultas.recalculoInfoTurnoArqueo(idTurno, clave, caja);
		LOG.info("Se termina el proceso correctamente!!");
		System.out.println("1");
	}

	public void procesoCierraTurnoBOT(int idTurno) {

		List<CierraTurnoDto> listaInfoTurno = new ArrayList<>();
		List<CierraTurnoKardex> listaInfoKardex = new ArrayList<>();
		List<CancelacionesDto> listaCancelaciones = new ArrayList<>();
		List<CancelacionesEncDto> listCanEnc = new ArrayList<>();
		List<TurnoDto> listaTurno = new ArrayList<>();
		List<EstadisticasDto> listaEstadisticas = new ArrayList<>();
		List<Log10TransDto> lista10trans = new ArrayList<>();
		List<LogTregaloDTo> listaLogRega = new ArrayList<>();
		List<LogPtTransDto> listaLogTran = new ArrayList<>();
		List<MovTregaloDto> listaMovRega = new ArrayList<>();
		List<IngresoVentasDto> listaVentas = new ArrayList<>();
		List<EValeLogDto> listaEvaleLog = new ArrayList<>();
		List<InetErrorSummary> listErrSumm = new ArrayList<>();
		List<InternetErrorDto> listInitErr = new ArrayList<>();
		List<PagosVentasDto> listPagoVenta = new ArrayList<>();
		List<MovimientosEvaleDto> listMovEvale = new ArrayList<>();
		List<MovimientosRetirosDto> listMovRetiro = new ArrayList<>();
		List<TpvTicketError> listTckError = new ArrayList<>();
		List<MovEncDto> listMovEnc = new ArrayList<>();
		List<MvtosElectroDto> listMovElectro = new ArrayList<>();
		List<VentasArticulosDto> listVtasArti = new ArrayList<>();
		List<MovDetDto> listMovDet = new ArrayList<>();
		List<HoraTipoDto> listaHoraTipo = new ArrayList<>();
		List<DevolucionesEncabezado> listDevEnc = new ArrayList<>();
		List<DevolucionesDto> listDev = new ArrayList<>();
		List<TrnTxDetDto> listaTrnTxDet = new ArrayList<>();
		List<ArqueoCierraTurnoDto> listaArqueoTurno = new ArrayList<>();
		List<PvLogTarjetaDto> listaPagoTarjeta = new ArrayList<>();

		// consultas.setConexion(conection.getCnnUnicaMysql());

		LOG.info("vERSION 27 JULIO");
		LOG.info("Proceso paso 4: Obtenemos la informacion principal del turno: " + idTurno);

		listaTurno = consultas.getInfoTurno(idTurno);

		String fecha = listaTurno.get(0).getFecha();

		LOG.info("Proceso paso 5: Obtener la informacion de las tablas principales");
		listaInfoTurno = consultas.getInfoCierraTurno(idTurno);
		listaInfoKardex = consultas.getInfoCierraTurnoKardex(idTurno);
		listaCancelaciones = consultas.getInfoCancelaciones(idTurno);
		listCanEnc = consultas.getInfoCancelacionesEnc(idTurno);
		listaEstadisticas = consultas.getInfoEstadisticas(idTurno);
		listDevEnc = consultas.getInfoDevolucionesEnc(idTurno);
		listDev = consultas.getInfoDevoluciones(idTurno);
		listaVentas = consultas.getInfoIngresoVtas(clave, caja, fecha, idTurno);

		LOG.info("Proceso paso 6: Obtenemos la informacion de las tablas de log");
		lista10trans = consultas.getInfoLog10Trans(clave, caja, fecha, idTurno);
		listaLogRega = consultas.getInfoLogTregalo(clave, caja, fecha, idTurno);
		listaLogTran = consultas.getInfoLogTrans(clave, caja, fecha, idTurno);
		listaEvaleLog = consultas.getInfoEvaleLog(clave, caja, fecha, idTurno);

		LOG.info("Proceso paso 7: Obtenemos la informacion de las tablas de Error y de tarjetas");
		listErrSumm = consultas.getInfoInetErrorSummary(clave, caja, fecha, idTurno);
		listInitErr = consultas.getInfoInetError(clave, caja, fecha, idTurno);
		listMovEvale = consultas.getInfoMovsEvale(clave, caja, fecha, idTurno);
		listaMovRega = consultas.getInfoMovTRegalo(clave, caja, fecha, idTurno);

		LOG.info("Proceso paso 8: Obtenemos la informacion de las tablas de calculo de datos");
		listPagoVenta = consultas.getInfoPagosVenta(clave, caja, fecha, idTurno);
		listMovRetiro = consultas.getInfoMovsRetiro(clave, caja, fecha, idTurno);
		listTckError = consultas.getInfoTcksError(clave, caja, fecha, idTurno);// no
		listMovEnc = consultas.getInfoMovEnc(clave, caja, fecha, idTurno);
		listMovDet = consultas.getInfoMovDet(clave, caja, fecha, idTurno);
		listVtasArti = consultas.getInfoVtasArti(clave, caja, fecha, idTurno);
		listaArqueoTurno = consultas.getInfoArqueoCierraTurno(idTurno);

		LOG.info("Proceso paso 9: Obtenemos la informacion de las tablas de Movimientos electronicos y la suma total");
		listMovElectro = consultas.getInfoMtosElctro(clave, caja, fecha, idTurno);
		listaHoraTipo = consultas.getInfoHoraTipo(clave, idTurno, fecha);
		listaTrnTxDet = consultas.getInfoTrnTxDet(clave, caja, fecha, idTurno);
		listaPagoTarjeta = consultas.getInfoPagoTarjeta(idTurno);

		// trn_tx_det
		if (!listaTrnTxDet.isEmpty()) {
			LOG.info("Insertando en SYBASE la informacion de TRNTXDET.");
			for (TrnTxDetDto sal : listaTrnTxDet) {
				inserts.insertaInfoTrnTxDet(sal);
			}
		}

		// trn_thora_tipo
		if (!listaHoraTipo.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Movimiento Hora Tipo.");
			for (HoraTipoDto dto : listaHoraTipo) {
				inserts.insertaInfoHoraTipo(dto);
			}
		}

		// trn_telectro
		if (!listMovElectro.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Movimiento Electronico.");
			for (MvtosElectroDto dto : listMovElectro) {
				inserts.insertaInfoMtosElectro(dto);
			}
		}

		// trn_TVtasArti
		if (!listVtasArti.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Ventas Articulo.");
			for (VentasArticulosDto dto : listVtasArti) {
				inserts.insertaInfoVtasArti(dto);
			}
		}

		// pv_infoarqueoturno
		if (!listaArqueoTurno.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Ventas Articulo.");
			for (ArqueoCierraTurnoDto dto : listaArqueoTurno) {
				inserts.insertaInfoArqueoCierraTurno(dto);
			}
		}

		// trn_THoras
		if (!listMovDet.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Movimiento Detalle.");
			for (MovDetDto dto : listMovDet) {
				inserts.insertaInfoMovDet(dto);
			}
		}

		// trn_TVtasVend
		if (!listMovEnc.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Movimiento Encabezado.");
			for (MovEncDto dto : listMovEnc) {
				inserts.insertaInfoMovEnc(dto);
			}
		}

		// trn_tpv_tickets_error
		if (!listTckError.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Error de Tickets.");
			for (TpvTicketError dto : listTckError) {
				inserts.insertaInfoTcksError(dto);
			}
		}

		// trn_tpv_movimientos_retiros
		if (!listMovRetiro.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Movimientos retiros.");
			for (MovimientosRetirosDto dto : listMovRetiro) {
				inserts.insertaInfoMovsRetiro(dto);
			}
		}

		// trn_tpv_fpagos_ventas
		if (!listPagoVenta.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Pago venta.");
			for (PagosVentasDto dto : listPagoVenta) {
				inserts.insertaInfoPagosVenta(dto);
			}
		}

		// trn_tpv_movimientos_tregalo
		if (!listaMovRega.isEmpty()) {
			LOG.info("Insertando la informacion del Log10Trans");
			for (MovTregaloDto dto : listaMovRega) {
				inserts.insertaInfoMovRegalo(dto);
			}
		}

		// trn_tpv_movimientos_evale
		if (!listMovEvale.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Movimientos de Vales.");
			for (MovimientosEvaleDto dto : listMovEvale) {
				inserts.insertaInfoMovsEvale(dto);
			}
		}

		// trn_tpv_inet_error
		if (!listInitErr.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Logs Internet.");
			for (InternetErrorDto dto : listInitErr) {
				inserts.insertaInfoInetError(dto);
			}
		}

		// trn_tpv_inet_error_summary
		if (!listErrSumm.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Log Internet Summary.");
			for (InetErrorSummary dto : listErrSumm) {
				inserts.insertaInfoInetErrorSummary(dto);
			}
		}

		// trn_tevale_log
		if (!listaEvaleLog.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de Logs de Vales.");
			for (EValeLogDto dto : listaEvaleLog) {
				inserts.insertaInfoEvaleLog(dto);
			}
		}

		// trn_tpv_log_pt_trans
		if (!listaLogTran.isEmpty()) {
			LOG.info("Insertando en Sybase la informacion del LogTrans");
			for (LogPtTransDto dto : listaLogTran) {
				inserts.insertaInfoLogTrans(dto);
			}
		}

		// trn_ttregalo_log
		if (!listaLogRega.isEmpty()) {
			LOG.info("Insertando en Sybase la informacion del LogRegalo");
			for (LogTregaloDTo dto : listaLogRega) {
				inserts.insertaInfoLogRega(dto);
			}
		}

		// trn_tpv_log_10s_trans
		if (!lista10trans.isEmpty()) {
			LOG.info("Insertando en Sybase la informacion del Log10Trans");
			for (Log10TransDto dto : lista10trans) {
				inserts.insertaInfoLog10Trans(dto);
			}
		}

		// trn_tbot_ctrlingreso_ventas
		if (!listaVentas.isEmpty()) {
			LOG.info("Insertamos en Sybase la info de las ventas.");
			for (IngresoVentasDto dto : listaVentas) {
				inserts.insertaInfoIngresoVtas(dto);
			}
		}

		// pv_dc
		if (!listDev.isEmpty()) {
			LOG.info("Insertando en Sybase la info de las Devoluciones");
			for (DevolucionesDto dev : listDev) {
				if (inserts.insertaInfoDevolucion(dev)) {
					consultas.actualizaInfoDevoluciones(idTurno, dev.getIddevolucion());
				}
			}
		}

		// pv_dcc
		if (!listDevEnc.isEmpty()) {
			LOG.info("Insertando en Sybase la info de devoluciones Encabezado");
			for (DevolucionesEncabezado dev : listDevEnc) {
				if (inserts.insertaInfoDevolEnc(dev)) {
					consultas.actualizaInfoDevEnc(idTurno, dev.getFolio());
				}
			}
		}

		// pv_estadisticas
		if (!listaEstadisticas.isEmpty()) {
			LOG.info("Insertando en Sybase la info de las Estadisticas.");
			for (EstadisticasDto dto : listaEstadisticas) {
				if (inserts.insertaInfoEstadisticas(dto)) {
					LOG.info("Paso 11: Si se inserta en Sybase se actualiza en MySql");
					consultas.actualizaEstadisticas(idTurno);
				}
			}
		}

		// pv_cancelaciones
		if (!listCanEnc.isEmpty()) {
			LOG.info("Insertando en Sybase la info de cancelaciones Encabezado");
			for (CancelacionesEncDto dto : listCanEnc) {
				if (inserts.insertaInfoCancelacionesEnc(dto)) {
					LOG.info("ya insertamos las cancelaciones ENC");
					consultas.actualizaCancelacionesEnc(idTurno);
				}
			}
		}

		// pv_cancelaciones_summary
		if (!listaCancelaciones.isEmpty()) {
			LOG.info("Insertando en Sybase la info de las cancelaciones.");
			for (CancelacionesDto dto : listaCancelaciones) {
				if (inserts.insertaInfoCancelaciones(dto)) {
					LOG.info("Paso 9: Si se inserta en Sybase se actualiza en MySql");
					consultas.actualizaCancelaciones(idTurno);
				}
			}
		}

		// pv_turno_kardex
		if (!listaInfoKardex.isEmpty()) {
			LOG.info("Insertando en Sybase la info del Kardex.");
			for (CierraTurnoKardex dto : listaInfoKardex) {
				if (inserts.insertaInfoKardex(dto)) {
					LOG.info("Paso 7: Si se inserta en Sybase Se actualiza en MySql");
					consultas.actualizaKardex(dto.getIdturno());
				}
			}
		}

		// pv_turno_fp
		if (!listaInfoTurno.isEmpty()) {
			LOG.info("Insertando en Sybase la info de las formas de pago.");
			for (CierraTurnoDto dto : listaInfoTurno) {
				if (inserts.insertaInfoCierraTurno(dto)) {
					LOG.info("Paso 5: Si se inserta en Sybase Se actualiza en MySql");
					consultas.actualizaTurno(dto.getIdturno());
				}
			}
		}
		// pv_log_pago_tarjeta
		if (!listaPagoTarjeta.isEmpty()) {
			LOG.info("Insertando en Sybase la info del cobro con tarjeta.");
			for (PvLogTarjetaDto dto : listaPagoTarjeta) {
				inserts.insertaInfoPagoTarjeta(dto);

			}
		}

		// pv_turnos
		if (!listaTurno.isEmpty()) {
			LOG.info("Insertando en Sybase la info de los turnos.");
			for (TurnoDto dto : listaTurno) {
				if (inserts.insertaInfoTurno(dto)) {
					LOG.info("Paso 13: Se inserto la informacion del turno " + idTurno);
					consultas.actualizaStatusTurno(idTurno);
				}
			}
		}

		LOG.info("Se termina el proceso correctamente!!");
		System.out.println("1");
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCaja() {
		return caja;
	}

	public void setCaja(String caja) {
		this.caja = caja;
	}

}
