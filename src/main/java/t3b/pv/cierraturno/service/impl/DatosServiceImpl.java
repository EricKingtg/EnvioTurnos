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
import org.apache.log4j.Logger;
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

	private final static Logger log = Logger.getLogger(DatosServiceImpl.class);
	private List<TiendaDto> lista = null;

	@Autowired
	@Qualifier("consultasMySql")
	private ConsultasMySql consultas;

	@Autowired
	@Qualifier("configuraConexionSybase")
	private ConfiguraConexionSybase conection;

	@Autowired
	@Qualifier("consultasMySql")
	private ConsultasSybase inserts;

	@Autowired
	@Qualifier("utilidades")
	private Utilidades utilidades;

	@Autowired
	@Qualifier("utilities")
	private Utilities utilities;

	private String clave;
	private String caja;

	public DatosServiceImpl() {

		log.info("****************************************");
		log.info("*   Desarrollo Hecho Para Tiendas 3B   *");
		log.info("*     JAR Impacta Cierre Turno BOT     *");
		log.info("****************************************");

		lista = new ArrayList<TiendaDto>();
		
		consultas.setConexion(conection.getCnnUnicaMysql());

		log.info("Comienza Proceso paso 1: Obtener Numero de tienda");
		lista = consultas.getNumTienda();

		clave = lista.get(0).getTclave();

		log.info("Proceso paso 2 --> Obtener la ip con base al numero de tienda : " + clave);
		String ipBO = utilidades.obtieneIp(clave);

		caja = utilities.executeCommand("caja");
		log.info("Obtenemos la caja: " + caja);

		inserts.setConexion(conection.getCnnUnica(ipBO, lista.get(0).getTclave()));
	}

	public List<TurnoDto> consultaTurnosNoEnviadosExt() {
		List<TurnoDto> lista = null;
		log.info("Proceso paso 5: Envio Automatico");
		log.info("Proceso paso 4: Se obtiene informacion del turno, es un envio automatico");
		lista = consultas.consultaTurnos();
		return lista;
	}

	public void proceso(int idTurno, int bandera) {

		log.info("Proceso paso 3: Procesar la info del turno: " + idTurno);

		DatosServiceImpl process = new DatosServiceImpl();
		switch (bandera) {
		case 0:
			log.info("La bandera es 0, se esta cerrando un turno");
			process.procesoCierraTurnoBOT(idTurno);
			break;
		case 1:
			log.info("La bandera es 1, se esta iniciando un turno");
			process.iniciaTurnoBOT();
			break;
		case 2:
			log.info("La bandera es 2, se esta cerrando un turno");
			process.procesoCierraTurnoBOT(idTurno);
			break;
		case 3:
			log.info("La bandera es 3, se esta borrando informacion del turno");
			process.borraInfoTurno(idTurno);
			break;
		case 4:
			log.info("La bandera es 4, consulta turnos");
			process.consultaTurnosNoEnviados();
			break;

		default:
			break;
		}
	}

	public void consultaTurnosNoEnviados() {

		log.info("Proceso paso 4: Se obtiene informacion del turno, es un envio automatico");
		List<TurnoDto> listaOP = consultas.consultaTurnos();

		if (!listaOP.isEmpty()) {
			for (TurnoDto dto : listaOP) {

				System.out.println("Turno: " + String.valueOf(dto.idturno));
			}

		}

	}

	public void iniciaTurnoBOT() {
		log.info("Proceso paso 4: Se obtiene informacion del turno, es una apertura de turno");
		List<TurnoDto> listaOP = consultas.getInfoTurnoOpenBot();
		if (!listaOP.isEmpty()) {
			for (TurnoDto dto : listaOP) {
				log.info("Proceso paso 5: ya se tiene la informacion del turno se procede a insertarlo, turno: "
						+ dto.getIdturno());
				inserts.insertaInfoTurno(dto);
			}
		}
		log.info("Se termina el proceso correctamente!!");
		System.out.println("1");
	}

	public void borraInfoTurno(int idTurno) {

		log.info("Validando si el turno esta cerrado");
		List<DtoTurnoActivo> listaActivo = consultas.validaTurnoActivo(idTurno);

		if (listaActivo.get(0).getActivo() == 0) {

			log.info("Proceso paso 4: Se obtiene informacion del turno, es un borrado de informacion");
			List<TurnoDto> listaOP = consultas.getInfoTurno(idTurno);

			log.info("Proceso paso 5: Tenemos la informacion del turno, actualizamos del lado del PV");
			consultas.actualizaInfoTurnoReenvio(idTurno);

			log.info("Proceso paso 6: Borramos la informacion del turno en el BOT");
			inserts.borraInfoTurno(listaOP.get(0));

			log.info("Proceso paso 7: Calculamos nuevamente la informacion de estadisticas");
			consultas.reestructuraTurno(idTurno, caja, clave, listaOP.get(0).getUseridcierre());

		} else {
			log.info("Como el proceso no se a completado solo se hace el proceso de cerrar el turno");
			log.info("Proceso paso 7: Calculamos nuevamente la informacion de estadisticas");
			consultas.reestructuraTurno(idTurno, caja, clave, listaActivo.get(0).getUseridabre());
		}
		// log.info("Proceso paso 8: Calculamos nuevamente la informacion de arqueo del
		// cierre del turno");
		// consultas.recalculoInfoTurnoArqueo(idTurno, clave, caja);
		log.info("Se termina el proceso correctamente!!");
		System.out.println("1");
	}

	public void procesoCierraTurnoBOT(int idTurno) {

		List<CierraTurnoDto> listaInfoTurno = new ArrayList<CierraTurnoDto>();
		List<CierraTurnoKardex> listaInfoKardex = new ArrayList<CierraTurnoKardex>();
		List<CancelacionesDto> listaCancelaciones = new ArrayList<CancelacionesDto>();
		List<CancelacionesEncDto> listCanEnc = new ArrayList<CancelacionesEncDto>();
		List<TurnoDto> listaTurno = new ArrayList<TurnoDto>();
		List<EstadisticasDto> listaEstadisticas = new ArrayList<EstadisticasDto>();
		List<Log10TransDto> lista10trans = new ArrayList<Log10TransDto>();
		List<LogTregaloDTo> listaLogRega = new ArrayList<LogTregaloDTo>();
		List<LogPtTransDto> listaLogTran = new ArrayList<LogPtTransDto>();
		List<MovTregaloDto> listaMovRega = new ArrayList<MovTregaloDto>();
		List<IngresoVentasDto> listaVentas = new ArrayList<IngresoVentasDto>();
		List<EValeLogDto> listaEvaleLog = new ArrayList<EValeLogDto>();
		List<InetErrorSummary> listErrSumm = new ArrayList<InetErrorSummary>();
		List<InternetErrorDto> listInitErr = new ArrayList<InternetErrorDto>();
		List<PagosVentasDto> listPagoVenta = new ArrayList<PagosVentasDto>();
		List<MovimientosEvaleDto> listMovEvale = new ArrayList<MovimientosEvaleDto>();
		List<MovimientosRetirosDto> listMovRetiro = new ArrayList<MovimientosRetirosDto>();
		List<TpvTicketError> listTckError = new ArrayList<TpvTicketError>();
		List<MovEncDto> listMovEnc = new ArrayList<MovEncDto>();
		List<MvtosElectroDto> listMovElectro = new ArrayList<MvtosElectroDto>();
		List<VentasArticulosDto> listVtasArti = new ArrayList<VentasArticulosDto>();
		List<MovDetDto> listMovDet = new ArrayList<MovDetDto>();
		List<HoraTipoDto> listaHoraTipo = new ArrayList<HoraTipoDto>();
		List<DevolucionesEncabezado> listDevEnc = new ArrayList<DevolucionesEncabezado>();
		List<DevolucionesDto> listDev = new ArrayList<DevolucionesDto>();
		List<TrnTxDetDto> listaTrnTxDet = new ArrayList<TrnTxDetDto>();
		List<ArqueoCierraTurnoDto> listaArqueoTurno = new ArrayList<ArqueoCierraTurnoDto>();

		log.info("Proceso paso 4: Obtenemos la informacion principal del turno");
		listaTurno = consultas.getInfoTurno(idTurno);

		String fecha = listaTurno.get(0).getFecha();

		log.info("Proceso paso 5: Obtener la informacion de las tablas principales");
		listaInfoTurno = consultas.getInfoCierraTurno(idTurno);
		listaInfoKardex = consultas.getInfoCierraTurnoKardex(idTurno);
		listaCancelaciones = consultas.getInfoCancelaciones(idTurno);
		listCanEnc = consultas.getInfoCancelacionesEnc(idTurno);
		listaEstadisticas = consultas.getInfoEstadisticas(idTurno);
		listDevEnc = consultas.getInfoDevolucionesEnc(idTurno);
		listDev = consultas.getInfoDevoluciones(idTurno);
		listaVentas = consultas.getInfoIngresoVtas(clave, caja, fecha, idTurno);

		log.info("Proceso paso 6: Obtenemos la informacion de las tablas de log");
		lista10trans = consultas.getInfoLog10Trans(clave, caja, fecha, idTurno);
		listaLogRega = consultas.getInfoLogTregalo(clave, caja, fecha, idTurno);
		listaLogTran = consultas.getInfoLogTrans(clave, caja, fecha, idTurno);
		listaEvaleLog = consultas.getInfoEvaleLog(clave, caja, fecha, idTurno);

		log.info("Proceso paso 7: Obtenemos la informacion de las tablas de Error y de tarjetas");
		listErrSumm = consultas.getInfoInetErrorSummary(clave, caja, fecha, idTurno);
		listInitErr = consultas.getInfoInetError(clave, caja, fecha, idTurno);
		listMovEvale = consultas.getInfoMovsEvale(clave, caja, fecha, idTurno);
		listaMovRega = consultas.getInfoMovTRegalo(clave, caja, fecha, idTurno);

		log.info("Proceso paso 8: Obtenemos la informacion de las tablas de calculo de datos");
		listPagoVenta = consultas.getInfoPagosVenta(clave, caja, fecha, idTurno);
		listMovRetiro = consultas.getInfoMovsRetiro(clave, caja, fecha, idTurno);
		listTckError = consultas.getInfoTcksError(clave, caja, fecha, idTurno);// no
		listMovEnc = consultas.getInfoMovEnc(clave, caja, fecha, idTurno);
		listMovDet = consultas.getInfoMovDet(clave, caja, fecha, idTurno);
		listVtasArti = consultas.getInfoVtasArti(clave, caja, fecha, idTurno);
		listaArqueoTurno = consultas.getInfoArqueoCierraTurno(idTurno);

		log.info("Proceso paso 9: Obtenemos la informacion de las tablas de Movimientos electronicos y la suma total");
		listMovElectro = consultas.getInfoMtosElctro(clave, caja, fecha, idTurno);
		listaHoraTipo = consultas.getInfoHoraTipo(clave, idTurno, fecha);
		listaTrnTxDet = consultas.getInfoTrnTxDet(clave, caja, fecha, idTurno);

		// trn_tx_det
		if (!listaTrnTxDet.isEmpty()) {
			log.info("Insertando en SYBASE la informacion de TRNTXDET.");
			for (TrnTxDetDto sal : listaTrnTxDet) {
				inserts.insertaInfoTrnTxDet(sal);
			}
		}

		// trn_thora_tipo
		if (!listaHoraTipo.isEmpty()) {
			log.info("Insertamos en Sybase la info de Movimiento Hora Tipo.");
			for (HoraTipoDto dto : listaHoraTipo) {
				inserts.insertaInfoHoraTipo(dto);
			}
		}

		// trn_telectro
		if (!listMovElectro.isEmpty()) {
			log.info("Insertamos en Sybase la info de Movimiento Electronico.");
			for (MvtosElectroDto dto : listMovElectro) {
				inserts.insertaInfoMtosElectro(dto);
			}
		}

		// trn_TVtasArti
		if (!listVtasArti.isEmpty()) {
			log.info("Insertamos en Sybase la info de Ventas Articulo.");
			for (VentasArticulosDto dto : listVtasArti) {
				inserts.insertaInfoVtasArti(dto);
			}
		}

		// pv_infoarqueoturno
		if (!listaArqueoTurno.isEmpty()) {
			log.info("Insertamos en Sybase la info de Ventas Articulo.");
			for (ArqueoCierraTurnoDto dto : listaArqueoTurno) {
				inserts.insertaInfoArqueoCierraTurno(dto);
			}
		}

		// trn_THoras
		if (!listMovDet.isEmpty()) {
			log.info("Insertamos en Sybase la info de Movimiento Detalle.");
			for (MovDetDto dto : listMovDet) {
				inserts.insertaInfoMovDet(dto);
			}
		}

		// trn_TVtasVend
		if (!listMovEnc.isEmpty()) {
			log.info("Insertamos en Sybase la info de Movimiento Encabezado.");
			for (MovEncDto dto : listMovEnc) {
				inserts.insertaInfoMovEnc(dto);
			}
		}

		// trn_tpv_tickets_error
		if (!listTckError.isEmpty()) {
			log.info("Insertamos en Sybase la info de Error de Tickets.");
			for (TpvTicketError dto : listTckError) {
				inserts.insertaInfoTcksError(dto);
			}
		}

		// trn_tpv_movimientos_retiros
		if (!listMovRetiro.isEmpty()) {
			log.info("Insertamos en Sybase la info de Movimientos retiros.");
			for (MovimientosRetirosDto dto : listMovRetiro) {
				inserts.insertaInfoMovsRetiro(dto);
			}
		}

		// trn_tpv_fpagos_ventas
		if (!listPagoVenta.isEmpty()) {
			log.info("Insertamos en Sybase la info de Pago venta.");
			for (PagosVentasDto dto : listPagoVenta) {
				inserts.insertaInfoPagosVenta(dto);
			}
		}

		// trn_tpv_movimientos_tregalo
		if (!listaMovRega.isEmpty()) {
			log.info("Insertando la informacion del Log10Trans");
			for (MovTregaloDto dto : listaMovRega) {
				inserts.insertaInfoMovRegalo(dto);
			}
		}

		// trn_tpv_movimientos_evale
		if (!listMovEvale.isEmpty()) {
			log.info("Insertamos en Sybase la info de Movimientos de Vales.");
			for (MovimientosEvaleDto dto : listMovEvale) {
				inserts.insertaInfoMovsEvale(dto);
			}
		}

		// trn_tpv_inet_error
		if (!listInitErr.isEmpty()) {
			log.info("Insertamos en Sybase la info de Logs Internet.");
			for (InternetErrorDto dto : listInitErr) {
				inserts.insertaInfoInetError(dto);
			}
		}

		// trn_tpv_inet_error_summary
		if (!listErrSumm.isEmpty()) {
			log.info("Insertamos en Sybase la info de Log Internet Summary.");
			for (InetErrorSummary dto : listErrSumm) {
				inserts.insertaInfoInetErrorSummary(dto);
			}
		}

		// trn_tevale_log
		if (!listaEvaleLog.isEmpty()) {
			log.info("Insertamos en Sybase la info de Logs de Vales.");
			for (EValeLogDto dto : listaEvaleLog) {
				inserts.insertaInfoEvaleLog(dto);
			}
		}

		// trn_tpv_log_pt_trans
		if (!listaLogTran.isEmpty()) {
			log.info("Insertando en Sybase la informacion del LogTrans");
			for (LogPtTransDto dto : listaLogTran) {
				inserts.insertaInfoLogTrans(dto);
			}
		}

		// trn_ttregalo_log
		if (!listaLogRega.isEmpty()) {
			log.info("Insertando en Sybase la informacion del LogRegalo");
			for (LogTregaloDTo dto : listaLogRega) {
				inserts.insertaInfoLogRega(dto);
			}
		}

		// trn_tpv_log_10s_trans
		if (!lista10trans.isEmpty()) {
			log.info("Insertando en Sybase la informacion del Log10Trans");
			for (Log10TransDto dto : lista10trans) {
				inserts.insertaInfoLog10Trans(dto);
			}
		}

		// trn_tbot_ctrlingreso_ventas
		if (!listaVentas.isEmpty()) {
			log.info("Insertamos en Sybase la info de las ventas.");
			for (IngresoVentasDto dto : listaVentas) {
				inserts.insertaInfoIngresoVtas(dto);
			}
		}

		// pv_dc
		if (!listDev.isEmpty()) {
			log.info("Insertando en Sybase la info de las Devoluciones");
			for (DevolucionesDto dev : listDev) {
				if (inserts.insertaInfoDevolucion(dev)) {
					consultas.actualizaInfoDevoluciones(idTurno, dev.getIddevolucion());
				}
			}
		}

		// pv_dcc
		if (!listDevEnc.isEmpty()) {
			log.info("Insertando en Sybase la info de devoluciones Encabezado");
			for (DevolucionesEncabezado dev : listDevEnc) {
				if (inserts.insertaInfoDevolEnc(dev)) {
					consultas.actualizaInfoDevEnc(idTurno, dev.getFolio());
				}
			}
		}

		// pv_estadisticas
		if (!listaEstadisticas.isEmpty()) {
			log.info("Insertando en Sybase la info de las Estadisticas.");
			for (EstadisticasDto dto : listaEstadisticas) {
				if (inserts.insertaInfoEstadisticas(dto)) {
					log.info("Paso 11: Si se inserta en Sybase se actualiza en MySql");
					consultas.actualizaEstadisticas(idTurno);
				}
			}
		}

		// pv_cancelaciones
		if (!listCanEnc.isEmpty()) {
			log.info("Insertando en Sybase la info de cancelaciones Encabezado");
			for (CancelacionesEncDto dto : listCanEnc) {
				if (inserts.insertaInfoCancelacionesEnc(dto)) {
					log.info("ya insertamos las cancelaciones ENC");
					consultas.actualizaCancelacionesEnc(idTurno);
				}
			}
		}

		// pv_cancelaciones_summary
		if (!listaCancelaciones.isEmpty()) {
			log.info("Insertando en Sybase la info de las cancelaciones.");
			for (CancelacionesDto dto : listaCancelaciones) {
				if (inserts.insertaInfoCancelaciones(dto)) {
					log.info("Paso 9: Si se inserta en Sybase se actualiza en MySql");
					consultas.actualizaCancelaciones(idTurno);
				}
			}
		}

		// pv_turno_kardex
		if (!listaInfoKardex.isEmpty()) {
			log.info("Insertando en Sybase la info del Kardex.");
			for (CierraTurnoKardex dto : listaInfoKardex) {
				if (inserts.insertaInfoKardex(dto)) {
					log.info("Paso 7: Si se inserta en Sybase Se actualiza en MySql");
					consultas.actualizaKardex(dto.getIdturno());
				}
			}
		}

		// pv_turno_fp
		if (!listaInfoTurno.isEmpty()) {
			log.info("Insertando en Sybase la info de las formas de pago.");
			for (CierraTurnoDto dto : listaInfoTurno) {
				if (inserts.insertaInfoCierraTurno(dto)) {
					log.info("Paso 5: Si se inserta en Sybase Se actualiza en MySql");
					consultas.actualizaTurno(dto.getIdturno());
				}
			}
		}

		// pv_turnos
		if (!listaTurno.isEmpty()) {
			log.info("Insertando en Sybase la info de los turnos.");
			for (TurnoDto dto : listaTurno) {
				if (inserts.insertaInfoTurno(dto)) {
					log.info("Paso 13: Se inserto la informacion del turno " + idTurno);
					consultas.actualizaStatusTurno(idTurno);
				}
			}
		}

		log.info("Se termina el proceso correctamente!!");
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
