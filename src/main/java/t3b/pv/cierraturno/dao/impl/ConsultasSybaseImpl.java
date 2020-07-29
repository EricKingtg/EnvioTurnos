/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 9/10/2018
 *
 */
package t3b.pv.cierraturno.dao.impl;

import dnn.nominae.modulobdconexion.db.Consulta;
import dnn.nominae.modulobdconexion.dto.QryRespDTO;
import java.sql.Connection;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import t3b.pv.cierraturno.dto.CierraTurnoDto;
import t3b.pv.cierraturno.dto.CierraTurnoKardex;
import t3b.pv.cierraturno.dao.ConsultasSybase;
import t3b.pv.cierraturno.dao.db.IQryTurnoKardex;
import t3b.pv.cierraturno.dto.ArqueoCierraTurnoDto;
import t3b.pv.cierraturno.dto.CancelacionesDto;
import t3b.pv.cierraturno.dto.CancelacionesEncDto;
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

@Service("consultasSybase")
public class ConsultasSybaseImpl implements ConsultasSybase {

	private static final Log log = LogFactory.getLog(ConsultasSybaseImpl.class);

	Connection conn = null;

	public void setConexion(Connection sybase) {
		conn = sybase;
	}

	public boolean borraInfoTurno(TurnoDto in) {

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getFecha());
			paramsIn.add(in.getTclave());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.DELETE_INFOTURNO, paramsIn, paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida 2: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	public boolean actualizaInfoTurnoCierra(TurnoDto in) {

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getActivo());
			paramsIn.add(in.getTicket_fin());
			paramsIn.add(in.getFecha_fin());
			paramsIn.add(in.getUseridcierre());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.UPDATE_TURNO_CIERRA, paramsIn, paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida 2: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	public boolean insertaInfoDevolucion(DevolucionesDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoDevolucion: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getIddevolucion());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getFecha());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(in.getFolio());
			paramsIn.add(in.getMov());
			paramsIn.add(in.getCve_razon());
			paramsIn.add(in.getNum_ticket());
			paramsIn.add(in.getFecha_ticket());
			paramsIn.add(in.getTipo_dc());
			paramsIn.add(in.getIclave());
			paramsIn.add(in.getIcb());
			paramsIn.add(in.getCantidad());
			paramsIn.add(in.getTotal_precio());
			paramsIn.add(in.getUserid());
			paramsIn.add(in.getUserid_aut());
			paramsIn.add(in.getUserid_bot());
			paramsIn.add(in.getUdDATE());
			paramsIn.add(0); // Estatus de la operacion a 0 en BOT
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_DEVOLUC, paramsIn, paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida 2: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	public boolean insertaInfoDevolEnc(DevolucionesEncabezado in) {

		log.info("ConsultasSybaseImpl.insertaInfoDevolEnc: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getFolio());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(0); // El estatus al pasrlo a BOT es Cero 0
			paramsIn.add(in.getIdturno());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_DEV_ENC, paramsIn, paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida 2: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	public boolean insertaInfoTrnTxDet(TrnTxDetDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoTrnTxDet: " + in.toString());
		boolean out = false;

		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getFecha());
			paramsIn.add(in.getTtrans_clave());
			paramsIn.add(in.getTtrans_desc());
			paramsIn.add(in.getTimporte());
			paramsIn.add(in.getTtrans());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_TRN_TXDET, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// utulizado
	public boolean insertaInfoHoraTipo(HoraTipoDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoHoraTipo: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getHora());
			paramsIn.add(in.getIclave());
			paramsIn.add(in.getCant_art());
			paramsIn.add(in.getImporte_art());
			paramsIn.add(in.getNum_ticket());
			paramsIn.add(in.getFech());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_HORA_TIPO, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoIngresoVtas(IngresoVentasDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoIngresoVtas: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getFech());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getUserid());
			paramsIn.add(in.getMov());
			paramsIn.add(in.getVenta());
			paramsIn.add(in.getTotal_anula());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_INGRESO_VTAS, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoEvaleLog(EValeLogDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoEvaleLog: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getLog_id());
			paramsIn.add(in.getLog_server_id());
			paramsIn.add(in.getUser_id());
			paramsIn.add(in.getTarjeta_id());
			paramsIn.add(in.getTarjeta_num());
			paramsIn.add(in.getTienda());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getNum_ticket());
			paramsIn.add(in.getFech());
			paramsIn.add(in.getMonto());
			paramsIn.add(in.getAtmdesc());
			paramsIn.add(in.getNc_envio());
			paramsIn.add(in.getNc_recibo());
			paramsIn.add(in.getIp_local());
			paramsIn.add(in.getIp_trans());
			paramsIn.add(in.getSt_sldo());
			paramsIn.add(in.getSt_nce());
			paramsIn.add(in.getSt_ncr());
			paramsIn.add(in.getSt_server());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_EVALE_LOG, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoInetErrorSummary(InetErrorSummary in) {

		log.info("ConsultasSybaseImpl.insertaInfoInetErrorSummary: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getAtmseq());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getInternet());
			paramsIn.add(in.getTotal());
			paramsIn.add(in.getFechax());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_INETERR_SUMM, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoInetError(InternetErrorDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoInetError: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getAtmseq());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getFechax());
			paramsIn.add(in.getInternet());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_INET_ERROR, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoPagosVenta(PagosVentasDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoPagosVenta: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getAtmseq());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getNum_ticket());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getFec());
			paramsIn.add(in.getFp_clave());
			paramsIn.add(in.getImporte_rec());
			paramsIn.add(in.getImporte_cambio());
			paramsIn.add(in.getEstatus());
			paramsIn.add(in.getReferencia());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_PAGOS_VENTA, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoMovsEvale(MovimientosEvaleDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoMovsEvale: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getAtmseq());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getNum_ticket());
			paramsIn.add(in.getIclave());
			paramsIn.add(in.getIcb());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getPclave());
			paramsIn.add(in.getFechax());
			paramsIn.add(in.getAtmdesc());
			paramsIn.add(in.getAtmcant());
			paramsIn.add(in.getAtmcosto());
			paramsIn.add(in.getAtmventa());
			paramsIn.add(in.getUserid());
			paramsIn.add(in.getIv_clave());
			paramsIn.add(in.getIe_clave());
			paramsIn.add(in.getGclave());
			paramsIn.add(in.getLclave());
			paramsIn.add(in.getFechay());
			paramsIn.add(in.getPorcentaje());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_MOVS_EVALE, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoMovsRetiro(MovimientosRetirosDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoMovsRetiro: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getRt_clave());
			paramsIn.add(in.getFec());
			paramsIn.add(in.getRt_importe());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getUserid());
			paramsIn.add(in.getVe_clave());
			paramsIn.add(in.getFp_clave());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_MOVS_RETIRO, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoTcksError(TpvTicketError in) {

		log.info("ConsultasSybaseImpl.insertaInfoTcksError: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getNum_ticket());
			paramsIn.add(in.getFec());
			paramsIn.add(in.getHora());
			paramsIn.add(in.getTotal_enc());
			paramsIn.add(in.getTotal_det());
			paramsIn.add(in.getTipo());
			paramsIn.add(in.getFech());
			paramsIn.add(in.getTclave_0());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_TCKS_ERROR, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoMtosElectro(MvtosElectroDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoMtosElectro: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getAtmseq());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getNum_ticket());
			paramsIn.add(in.getIclave());
			paramsIn.add(in.getIcb());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getPclave());
			paramsIn.add(in.getFecha());
			paramsIn.add(in.getAtmdesc());
			paramsIn.add(in.getAtmventa());
			paramsIn.add(in.getLclave());
			paramsIn.add(in.getNum_ref());
			paramsIn.add(in.getNum_conf());
			paramsIn.add(in.getNum_unico_pt());
			paramsIn.add(in.getReversada());
			paramsIn.add(in.getUserid());
			paramsIn.add(in.getEstatus());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_MVTOS_ELECTRO, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoVtasArti(VentasArticulosDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoVtasArti: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(in.getCODIGOBAR());
			paramsIn.add(in.getVETNTAMULT());
			paramsIn.add(in.getCANTIDAD());
			paramsIn.add(in.getCANTIDADNEG());
			paramsIn.add(in.getPclave());
			paramsIn.add(in.getTipo());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_VTAS_ARTI, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoMovEnc(MovEncDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoMovEnc: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(in.getVendedores());
			paramsIn.add(in.getTotal());
			paramsIn.add(in.getOperaciones());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_MOV_ENC, paramsIn, paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoMovDet(MovDetDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoMovDet: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(in.getHora());
			paramsIn.add(in.getTotal());
			paramsIn.add(in.getOperaciones());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_MOV_DET, paramsIn, paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoLog10Trans(Log10TransDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoLog10Trans: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getPvseq());
			paramsIn.add(in.getEnc_id());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getNum_ticket());
			paramsIn.add(in.getMonto());
			paramsIn.add(in.getReferencia());
			paramsIn.add(in.getIcb());
			paramsIn.add(in.getIclave());
			paramsIn.add(in.getPclave());
			paramsIn.add(in.getFechax());
			paramsIn.add(in.getHora_ini());
			paramsIn.add(in.getHora_fin());
			paramsIn.add(in.getDuracion());
			paramsIn.add(in.getConfirmacion());
			paramsIn.add(in.getMensaje());
			paramsIn.add(in.getFolio());
			paramsIn.add(in.getReverso());
			paramsIn.add(in.getUserid());
			paramsIn.add(in.getStAV());
			paramsIn.add(in.getStED());
			paramsIn.add(in.getStRD());
			paramsIn.add(in.getStGE());
			paramsIn.add(in.getStGD());
			paramsIn.add(in.getStUE());
			paramsIn.add(in.getStUD());
			paramsIn.add(in.getStFP());
			paramsIn.add(in.getStIT());
			paramsIn.add(in.getStCP());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_LOG_10TRANS, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoLogRega(LogTregaloDTo in) {

		log.info("ConsultasSybaseImpl.insertaInfoLogRega: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getLog_id());
			paramsIn.add(in.getLog_server_id());
			paramsIn.add(in.getUser_id());
			paramsIn.add(in.getTarjeta_id());
			paramsIn.add(in.getTarjeta_num());
			paramsIn.add(in.getTienda());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getNum_ticket());
			paramsIn.add(in.getFech());
			paramsIn.add(in.getMonto());
			paramsIn.add(in.getAtmdesc());
			paramsIn.add(in.getNc_envio());
			paramsIn.add(in.getNc_recibo());
			paramsIn.add(in.getIp_local());
			paramsIn.add(in.getIp_trans());
			paramsIn.add(in.getSt_sldo());
			paramsIn.add(in.getSt_nce());
			paramsIn.add(in.getSt_ncr());
			paramsIn.add(in.getSt_server());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_LOG_REGA, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoMovRegalo(MovTregaloDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoMovRegalo: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getAtmseq());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIclave());
			paramsIn.add(in.getIcb());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getPclave());
			paramsIn.add(in.getFechax());
			paramsIn.add(in.getAtmdesc());
			paramsIn.add(in.getAtmcant());
			paramsIn.add(in.getAtmcosto());
			paramsIn.add(in.getAtmventa());
			paramsIn.add(in.getUserid());
			paramsIn.add(in.getIv_clave());
			paramsIn.add(in.getIe_clave());
			paramsIn.add(in.getGclave());
			paramsIn.add(in.getLclave());
			paramsIn.add(in.getFechay());
			paramsIn.add(in.getPorcentaje());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_MOV_REGA, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoLogTrans(LogPtTransDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoLogTrans: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getId_log());
			paramsIn.add(in.getNum_ticket());
			paramsIn.add(in.getFechax());
			paramsIn.add(in.getAtmventa());
			paramsIn.add(in.getIclave());
			paramsIn.add(in.getIcb());
			paramsIn.add(in.getPclave());
			paramsIn.add(in.getResp_pt());
			paramsIn.add(in.getNum_ref());
			paramsIn.add(in.getNum_conf());
			paramsIn.add(in.getNum_unico_pt());
			paramsIn.add(in.getReversada());
			paramsIn.add(in.getUserid());
			paramsIn.add(in.getStAV());
			paramsIn.add(in.getStED());
			paramsIn.add(in.getStRD());
			paramsIn.add(in.getStGE());
			paramsIn.add(in.getStGD());
			paramsIn.add(in.getStUV());
			paramsIn.add(in.getStIT());
			paramsIn.add(in.getFechay());
			paramsIn.add(in.getStUD());
			paramsIn.add(in.getStFP());
			paramsIn.add(in.getStCP());
			paramsIn.add(in.getStUE());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_LOG_TRANS, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoCierraTurno(CierraTurnoDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoCierraTurno: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(in.getFp_clave());
			paramsIn.add(in.getTotal());
			paramsIn.add(0);// paramsIn.add(in.getStatus()); --> Se setea a 0 el estatus para que no cause
							// error ¬¬
			paramsIn.add(in.getIdturno());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_CIERRA_TURNO, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoKardex(CierraTurnoKardex in) {

		log.info("ConsultasSybaseImpl.insertaInfoKardex: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(in.getIclave());
			paramsIn.add(in.getIcb());
			paramsIn.add(in.getTotal());
			paramsIn.add(in.getAtmcant());
			paramsIn.add(0);// paramsIn.add(in.getStatus()); --> Se setea a 0 el estatus para que no cause
							// error ¬¬
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getAtmdesc());
			paramsIn.add(in.getIva());
			paramsIn.add(in.getIeps());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_CIERRA_KARDEX, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		}

		return out;
	}

	// Uilizado
	public boolean insertaInfoCancelaciones(CancelacionesDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoCancelaciones: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(in.getUserid());
			paramsIn.add(in.getAtmdesc());
			paramsIn.add(in.getCantidad());
			paramsIn.add(0);// paramsIn.add(in.getStatus()); --> Se setea a 0 el estatus para que no cause
							// error ¬¬
			paramsIn.add(in.getImporte());
			paramsIn.add(in.getFecha());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_CANCELACIONES, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		}
		return out;
	}

	// Uilizado
	public boolean insertaInfoCancelacionesEnc(CancelacionesEncDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoCancelacionesEnc: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getAtmseq());
			paramsIn.add(in.getTurnoid());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(in.getNum_ticket());
			paramsIn.add(in.getIclave());
			paramsIn.add(in.getIcb());
			paramsIn.add(in.getUserid());
			paramsIn.add(in.getAtmcant());
			paramsIn.add(in.getAtmventa());
			paramsIn.add(0);
			paramsIn.add(in.getFecha());
			paramsIn.add(in.getUseridcanc());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_CANCELACIOENC, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		}
		return out;
	}

	// Uilizado
	public boolean insertaInfoTurno(TurnoDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoTurno: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getActivo());
			paramsIn.add(in.getTicket_ini());
			paramsIn.add(in.getTicket_fin() == 0 ? in.getTicket_ini() : in.getTicket_fin());
			paramsIn.add(in.getUserid());
			paramsIn.add(in.getFecha_ini());
			paramsIn.add(in.getFecha_fin() == null ? in.getFecha_ini() : in.getFecha_fin());
			paramsIn.add(in.getUseridcierre() == 0 ? 0 : in.getUseridcierre());
			paramsIn.add(in.getFecha());
			paramsIn.add(in.getUseridabre());
			paramsIn.add(in.getTurno());
			paramsIn.add(in.getFondo());
			paramsIn.add(in.getTotal_ps());
			paramsIn.add(in.getCantidad_retiros());
			paramsIn.add(in.getMonto_retiros());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_DEL_TURNO, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		}
		return out;
	}

	// Uilizado
	public boolean insertaInfoEstadisticas(EstadisticasDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoEstadisticas: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getClave());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(in.getDescripcion());
			paramsIn.add(in.getValor());
			paramsIn.add(0);// paramsIn.add(in.getStatus()); --> Se setea a 0 el estatus para que no cause
							// error ¬¬
			paramsIn.add(in.getValor_numerico());
			paramsIn.add(in.getFecha());

			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_ESTADISTICAS, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		}
		return out;
	}

	public boolean insertaInfoArqueoCierraTurno(ArqueoCierraTurnoDto in) {

		log.info("ConsultasSybaseImpl.insertaInfoArqueoCierraTurno: " + in.toString());

		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTclave());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getIdturno());
			paramsIn.add(in.getFecha());
			paramsIn.add(in.getHora());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(in.getVentCajeroEfec());
			paramsIn.add(in.getVentCajeroVales());
			paramsIn.add(in.getVentCajeroValesE());
			paramsIn.add(in.getVentCajeroValesTR());
			paramsIn.add(in.getVentCajeroTC());
			paramsIn.add(in.getVentCajeroTGDF());
			paramsIn.add(in.getVentCajeroT3E());
			paramsIn.add(in.getRetCajeroEfec());
			paramsIn.add(in.getVentCajeroTotal());
			paramsIn.add(in.getRetCajeroTotal());
			paramsIn.add(in.getFondoEfectivo());
			paramsIn.add(in.getDifCajeroEfec());
			paramsIn.add(in.getTckProm());
			paramsIn.add(in.getOperTotal());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_ARQUEOCIERRATURNO, paramsIn,
					paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida 2: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

	@Override
	public boolean insertaInfoPagoTarjeta(PvLogTarjetaDto in) {
		boolean out = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(in.getTienda());
			paramsIn.add(in.getCaja());
			paramsIn.add(in.getTicket());
			paramsIn.add(in.getIdLog());
			paramsIn.add(in.getNegocio());
			paramsIn.add(in.getDescripcion());
			paramsIn.add(in.getCode());
			paramsIn.add(in.getAgente());
			paramsIn.add(in.getProducto());
			paramsIn.add(in.getAutoriza());
			paramsIn.add(in.getFolio());
			paramsIn.add(in.getBanco());
			paramsIn.add(in.getAfiliacion());
			paramsIn.add(in.getTarjeta());
			paramsIn.add(in.getReferencia());
			paramsIn.add(in.getFirma());
			paramsIn.add(in.getMarca());
			paramsIn.add(in.getMonto());
			paramsIn.add(in.getFecha());
			paramsIn.add(in.getPan());
			paramsIn.add(in.getAid());
			paramsIn.add(in.getArqc());
			paramsIn.add(in.getAtmfecha());
			paramsIn.add(in.getAutenticacion());
			paramsIn.add(in.getIdturno());
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.INSERTA_INFO_PAGOTARJETA, paramsIn, paramsOut);
			if (resp.getRes() == 1) {
				out = true;
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida 2: " + res + " -- " + msg);
			}
		} else {
			log.info("la conexion es nula");
		}

		return out;
	}

}
