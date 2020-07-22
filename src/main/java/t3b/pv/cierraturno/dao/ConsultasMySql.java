/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 8/10/2018
 *
 */
package t3b.pv.cierraturno.dao;

import dnn.nominae.modulobdconexion.db.Consulta;
import dnn.nominae.modulobdconexion.db.utils.Conexion;
import dnn.nominae.modulobdconexion.dto.CampoDTO;
import dnn.nominae.modulobdconexion.dto.ColumnaDTO;
import dnn.nominae.modulobdconexion.dto.QryRespDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import t3b.pv.cierraturno.dto.CierraTurnoDto;
import t3b.pv.cierraturno.dto.CierraTurnoKardex;
import t3b.pv.cierraturno.dto.TiendaDto;
import t3b.pv.cierraturno.utils.Config;
import t3b.pv.cierraturno.dao.db.IQryTurnoKardex;
import t3b.pv.cierraturno.dto.ArqueoCierraTurnoDto;
import t3b.pv.cierraturno.dto.CancelacionesDto;
import t3b.pv.cierraturno.dto.CancelacionesEncDto;
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
import t3b.pv.cierraturno.dto.TpvTicketError;
import t3b.pv.cierraturno.dto.TrnTxDetDto;
import t3b.pv.cierraturno.dto.TurnoDto;
import t3b.pv.cierraturno.dto.VentasArticulosDto;

public class ConsultasMySql {

    private final static Logger log = Logger.getLogger(ConsultasMySql.class);
    
    
    
        public List<TurnoDto> consultaTurnos(){
            
            log.info("ConsultasMysql.consultaTurnos");
            if (!Config.estaCargadaMysql) {
                Config.cargaConfigMysql();
            }

            Conexion con = new Conexion();
            con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
            Connection conn = con.getConexion();
            QryRespDTO resp = null;
            List<TurnoDto> listaTurno = new ArrayList<TurnoDto>();
            try {
                if (conn != null) {
                    ArrayList<Object> paramsIn = new ArrayList<Object>();
                    //paramsIn.add(idTurno);
                    resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.CONSULTA_TURNOS, paramsIn);
                    
                    
                    if (resp.getRes() == 1) {
                        ArrayList<ColumnaDTO> cols = resp.getColumnas();
                        for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                            TurnoDto dato = new TurnoDto();
                            for (ColumnaDTO col : cols) {
                                //log.info("Col: " + col.toString());
                                switch (col.getIdTipo()) {
                                    case java.sql.Types.INTEGER:
                                        dato.getClass().getField(col.getEtiqueta()).set(dato,
                                                fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                        break;

                                    case java.sql.Types.DOUBLE:
                                        dato.getClass().getField(col.getEtiqueta()).set(dato,
                                                fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                        break;

                                    case java.sql.Types.FLOAT:
                                        dato.getClass().getField(col.getEtiqueta()).set(dato,
                                                fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                        break;

                                    case java.sql.Types.DECIMAL:
                                        dato.getClass().getField(col.getEtiqueta()).set(dato,
                                                fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                        break;

                                    case java.sql.Types.NUMERIC:
                                        dato.getClass().getField(col.getEtiqueta()).set(dato,
                                                fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                        break;

                                    case java.sql.Types.VARCHAR:
                                        dato.getClass().getField(col.getEtiqueta()).set(dato,
                                                fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                        break;

                                    case java.sql.Types.TINYINT:
                                        dato.getClass().getField(col.getEtiqueta()).set(dato,
                                                fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                        break;

                                    case java.sql.Types.DATE:
                                        dato.getClass().getField(col.getEtiqueta()).set(dato,
                                                fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                        break;

                                    default:
                                        dato.getClass().getField(col.getEtiqueta()).set(dato,
                                                fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                        break;
                                }
                            }
                            //log.info(dato.toString());
                            listaTurno.add(dato);
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                log.info("Error durante la consulta a BD 1: " + e.getMessage());
                e.printStackTrace();
            } catch (SecurityException e) {
                log.info("Error durante la consulta a BD 2: " + e.getMessage());
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                log.info("Error durante la consulta a BD 3: " + e.getMessage());
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                log.info("Error durante la consulta a BD 4: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                log.info("Error durante la consulta a BD 5: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    log.info("Error al cerrar conexion: " + ex.toString());
                }
            }
            return listaTurno;
            
        }
    
    
        public List<DtoTurnoActivo> validaTurnoActivo(int idTurno) {
        log.info("ConsultasMysql.validaTurnoActivo");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;
        List<DtoTurnoActivo> listaTurno = new ArrayList<DtoTurnoActivo>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(idTurno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.VALIDA_TURNO_ACTIVO, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        DtoTurnoActivo dato = new DtoTurnoActivo();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DATE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        //log.info(dato.toString());
                        listaTurno.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listaTurno;
    }

    public void actualizaInfoTurnoReenvio(int idTurno) {

        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<Object>();
                paramsIn.add(idTurno);
                ArrayList<Integer> paramsOut = new ArrayList<Integer>();
                paramsOut.add(java.sql.Types.INTEGER);
                paramsOut.add(java.sql.Types.VARCHAR);
                QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.UPDATE_INFO_REENVIATURNO, paramsIn, paramsOut);
                if (resp.getRes() == 1) {
                    int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                    String msg = resp.getParamOut().get(1).getValor().toString();
                    log.info("La salida: " + res + " -- " + msg);
                } else {
                    int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                    String msg = resp.getParamOut().get(1).getValor().toString();
                    log.info("La salida: " + res + " -- " + msg);
                }
            }
        } catch (NumberFormatException ex) {
            log.info("Error al actualizar bd: " + ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
    }

    public List<TurnoDto> getInfoTurnoOpenBot() {

        log.info("ConsultasMysql.getInfoTurnoOpenBot");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<TurnoDto> listDev = new ArrayList<TurnoDto>();

        try {
            if (conn != null) {

                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_TURNOOPEN, null);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        TurnoDto dato = new TurnoDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listDev.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listDev;
    }

    public void actualizaInfoDevoluciones(int idTurno, int iddevolucion) {

        log.info("ConsultasMysql.actualizaInfoDevoluciones");

        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<Object>();
                paramsIn.add(idTurno);
                paramsIn.add(iddevolucion);
                ArrayList<Integer> paramsOut = new ArrayList<Integer>();
                paramsOut.add(java.sql.Types.INTEGER);
                paramsOut.add(java.sql.Types.VARCHAR);
                QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.UPDATE_DEVOLUCIONES, paramsIn, paramsOut);
                if (resp.getRes() == 1) {
                    int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                    String msg = resp.getParamOut().get(1).getValor().toString();
                    log.info("La salida: " + res + " -- " + msg);
                } else {
                    int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                    String msg = resp.getParamOut().get(1).getValor().toString();
                    log.info("La salida: " + res + " -- " + msg);
                }
            }
        } catch (NumberFormatException ex) {
            log.info("Error al actualizar bd: " + ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
    }

    public void actualizaInfoDevEnc(int idTurno, int idfolio) {

        log.info("ConsultasMysql.actualizaInfoDevEnc");

        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<Object>();
                paramsIn.add(idTurno);
                paramsIn.add(idfolio);
                ArrayList<Integer> paramsOut = new ArrayList<Integer>();
                paramsOut.add(java.sql.Types.INTEGER);
                paramsOut.add(java.sql.Types.VARCHAR);
                QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.UPDATE_INFO_DEVOENC, paramsIn, paramsOut);
                if (resp.getRes() == 1) {
                    int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                    String msg = resp.getParamOut().get(1).getValor().toString();
                    log.info("La salida: " + res + " -- " + msg);
                } else {
                    int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                    String msg = resp.getParamOut().get(1).getValor().toString();
                    log.info("La salida: " + res + " -- " + msg);
                }
            }
        } catch (NumberFormatException ex) {
            log.info("Error al actualizar bd: " + ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
    }

    public List<DevolucionesDto> getInfoDevoluciones(int idturno) {
        log.info("ConsultasMysql.getInfoDevolucionesEnc");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<DevolucionesDto> listDev = new ArrayList<DevolucionesDto>();

        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<Object>();
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_DEVOLUC, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        DevolucionesDto dato = new DevolucionesDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        //log.info(dato.toString());
                        listDev.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listDev;
    }

    public List<DevolucionesEncabezado> getInfoDevolucionesEnc(int idturno) {
        log.info("ConsultasMysql.getInfoDevolucionesEnc");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<DevolucionesEncabezado> listDevEnc = new ArrayList<DevolucionesEncabezado>();

        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_DEV_ENC, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        DevolucionesEncabezado dato = new DevolucionesEncabezado();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        //log.info(dato.toString());
                        listDevEnc.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return listDevEnc;
    }

    //Obtenido
    public List<TrnTxDetDto> getInfoTrnTxDet(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoTrnTxDet");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        log.info(clave + " -- " + caja + " -- " + fecha);
        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<TrnTxDetDto> listtrxDet = new ArrayList<TrnTxDetDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(idturno);
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_TRN_TXDET, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        TrnTxDetDto dato = new TrnTxDetDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listtrxDet.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return listtrxDet;
    }

    //Obtenido
    public List<HoraTipoDto> getInfoHoraTipo(String clave, int idturno, String fecha) {
        log.info("ConsultasMysql.getInfoHoraTipo");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<HoraTipoDto> listHorTip = new ArrayList<HoraTipoDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(idturno);
                paramsIn.add(fecha);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_HORA_TIPO, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        HoraTipoDto dato = new HoraTipoDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listHorTip.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return listHorTip;
    }

    //Obtenido
    public List<IngresoVentasDto> getInfoIngresoVtas(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoIngresoVtas");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<IngresoVentasDto> ingresoVtas = new ArrayList<IngresoVentasDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_INGERSO_VTAS, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        IngresoVentasDto dato = new IngresoVentasDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        ingresoVtas.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return ingresoVtas;
    }

    //Obtenido
    public List<EValeLogDto> getInfoEvaleLog(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoEvaleLog");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<EValeLogDto> infoEvaleLog = new ArrayList<EValeLogDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_EVALE_LOG, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        EValeLogDto dato = new EValeLogDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        infoEvaleLog.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return infoEvaleLog;
    }

    //Obtenido
    public List<InetErrorSummary> getInfoInetErrorSummary(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoInetErrorSummary");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<InetErrorSummary> ErrorInternetSum = new ArrayList<InetErrorSummary>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_INETERR_SUMM, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        InetErrorSummary dato = new InetErrorSummary();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        ErrorInternetSum.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return ErrorInternetSum;
    }

    //Obtenido
    public List<InternetErrorDto> getInfoInetError(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoInetError");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<InternetErrorDto> ErrorInternet = new ArrayList<InternetErrorDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_INET_ERROR, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        InternetErrorDto dato = new InternetErrorDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        ErrorInternet.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return ErrorInternet;
    }

    //Obtenido
    public List<PagosVentasDto> getInfoPagosVenta(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoPagosVenta");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<PagosVentasDto> pagosVenta = new ArrayList<PagosVentasDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_PAGOS_VENTA, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        PagosVentasDto dato = new PagosVentasDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        pagosVenta.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return pagosVenta;
    }

    //Obtenido
    public List<MovimientosEvaleDto> getInfoMovsEvale(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoMovsEvale");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<MovimientosEvaleDto> movimientoVales = new ArrayList<MovimientosEvaleDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_MOVS_EVALE, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        MovimientosEvaleDto dato = new MovimientosEvaleDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        movimientoVales.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return movimientoVales;
    }

    //Obtenido
    public List<MovimientosRetirosDto> getInfoMovsRetiro(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoMovsRetiro");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<MovimientosRetirosDto> movimientoRetiro = new ArrayList<MovimientosRetirosDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_MOVS_RETIRO, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        MovimientosRetirosDto dato = new MovimientosRetirosDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        movimientoRetiro.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return movimientoRetiro;
    }

    //Obtenido
    public List<TpvTicketError> getInfoTcksError(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoTcksError");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<TpvTicketError> tcksError = new ArrayList<TpvTicketError>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_TCKS_ERROR, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        TpvTicketError dato = new TpvTicketError();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        tcksError.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return tcksError;
    }

    //Obtenido
    public List<TiendaDto> getNumTienda() {

        log.info("ConsultasMysql.getNumTienda");

        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;
        List<TiendaDto> listaTienda = new ArrayList<TiendaDto>();
        try {
            if (conn != null) {

                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.CONSULTA_TIENDAS, null);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        TiendaDto dato = new TiendaDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listaTienda.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listaTienda;
    }

    //Obtenido
    public List<CancelacionesDto> getInfoCancelaciones(int idTurno) {
        log.info("ConsultasMysql.getInfoCancelaciones");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;
        List<CancelacionesDto> listaCancelaciones = new ArrayList<CancelacionesDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(idTurno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_CANCELACIONES, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        CancelacionesDto dato = new CancelacionesDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        //log.info(dato.toString());
                        listaCancelaciones.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listaCancelaciones;
    }

    public List<CancelacionesEncDto> getInfoCancelacionesEnc(int idTurno) {
        log.info("ConsultasMysql.getInfoCancelacionesEnc");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;
        List<CancelacionesEncDto> listaCancelaciones = new ArrayList<CancelacionesEncDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(idTurno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_CANCELACIOENC, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        CancelacionesEncDto dato = new CancelacionesEncDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        //log.info(dato.toString());
                        listaCancelaciones.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listaCancelaciones;
    }

    //Obtenido
    public List<CierraTurnoDto> getInfoCierraTurno(int idTurno) {
        log.info("ConsultasMysql.getInfoCierraTurno");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;
        List<CierraTurnoDto> listaTienda = new ArrayList<CierraTurnoDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(idTurno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_CIERRA_TURNO, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        CierraTurnoDto dato = new CierraTurnoDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        //log.info(dato.toString());
                        listaTienda.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listaTienda;
    }

    //Obtenido
    public List<MovEncDto> getInfoMovEnc(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoMovEnc");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<MovEncDto> listaMovEnc = new ArrayList<MovEncDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_MOV_ENC, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        MovEncDto dato = new MovEncDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listaMovEnc.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return listaMovEnc;
    }

    //Obtenido
    public List<Log10TransDto> getInfoLog10Trans(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoLog10Trans");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<Log10TransDto> listaLog10Trans = new ArrayList<Log10TransDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_LOG_10TRANS, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        Log10TransDto dato = new Log10TransDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listaLog10Trans.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return listaLog10Trans;
    }

    //Obtenido
    public List<LogTregaloDTo> getInfoLogTregalo(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoLogTregalo");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<LogTregaloDTo> listaLogRegalo = new ArrayList<LogTregaloDTo>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_LOG_REGA, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        LogTregaloDTo dato = new LogTregaloDTo();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listaLogRegalo.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return listaLogRegalo;
    }

    //Obtenido
    public List<MovTregaloDto> getInfoMovTRegalo(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoMovTRegalo");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<MovTregaloDto> listaMovRegalo = new ArrayList<MovTregaloDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_MOV_REGA, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        MovTregaloDto dato = new MovTregaloDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listaMovRegalo.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return listaMovRegalo;
    }

    //Obtenido
    public List<LogPtTransDto> getInfoLogTrans(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoLogTrans");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<LogPtTransDto> listaLogTrans = new ArrayList<LogPtTransDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_LOG_TRANS, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        LogPtTransDto dato = new LogPtTransDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listaLogTrans.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return listaLogTrans;
    }

    //Obtenido
    public List<MvtosElectroDto> getInfoMtosElctro(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoMtosElctro");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<MvtosElectroDto> mvtoElctro = new ArrayList<MvtosElectroDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_MVTOS_ELECTRO, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        MvtosElectroDto dato = new MvtosElectroDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        mvtoElctro.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return mvtoElctro;
    }

    //Obtenido
    public List<VentasArticulosDto> getInfoVtasArti(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoVtasArti");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<VentasArticulosDto> ventas = new ArrayList<VentasArticulosDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_VTAS_ARTI, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        VentasArticulosDto dato = new VentasArticulosDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        ventas.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return ventas;
    }

    //Uilizado
    public List<MovDetDto> getInfoMovDet(String clave, String caja, String fecha, int idturno) {
        log.info("ConsultasMysql.getInfoMovDet");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;

        List<MovDetDto> listaMovDet = new ArrayList<MovDetDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(clave);
                paramsIn.add(caja);
                paramsIn.add(fecha);
                paramsIn.add(idturno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_MOV_DET, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        MovDetDto dato = new MovDetDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.BIGINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Long.parseLong(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listaMovDet.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }

        return listaMovDet;
    }

    //Obtenido
    public List<CierraTurnoKardex> getInfoCierraTurnoKardex(int idTurno) {
        log.info("ConsultasMysql.getInfoCierraTurnoKardex");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;
        List<CierraTurnoKardex> listaTienda = new ArrayList<CierraTurnoKardex>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(idTurno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_CIERRA_KARDEX, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        CierraTurnoKardex dato = new CierraTurnoKardex();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listaTienda.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listaTienda;
    }

    //Utilizado
    public void actualizaTurno(int idTurno) {

        log.info("ConsultasMysql.actualizaTurno");

        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<Object>();
                paramsIn.add(idTurno);
                ArrayList<Integer> paramsOut = new ArrayList<Integer>();
                paramsOut.add(java.sql.Types.INTEGER);
                paramsOut.add(java.sql.Types.VARCHAR);
                QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.UPDATE_INFO_TURNO, paramsIn, paramsOut);
                if (resp.getRes() == 1) {
                    int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                    String msg = resp.getParamOut().get(1).getValor().toString();
                    log.info("La salida: " + res + " -- " + msg);
                } else {
                    int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                    String msg = resp.getParamOut().get(1).getValor().toString();
                    log.info("La salida: " + res + " -- " + msg);
                }
            }
        } catch (NumberFormatException ex) {
            log.info("Error al actualizar bd: " + ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
    }

    //Utilizado
    public void actualizaKardex(int idTurno) {

        log.info("ConsultasMysql.actualizaKardex");

        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        try {

            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<Object>();
                paramsIn.add(idTurno);
                ArrayList<Integer> paramsOut = new ArrayList<Integer>();
                paramsOut.add(java.sql.Types.INTEGER);
                paramsOut.add(java.sql.Types.VARCHAR);
                QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.UPDATE_INFO_KARDEX, paramsIn, paramsOut);
                if (resp.getRes() == 1) {
                    int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                    String msg = resp.getParamOut().get(1).getValor().toString();
                    log.info("La salida: " + res + " -- " + msg);
                } else {
                    int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                    String msg = resp.getParamOut().get(0).getValor().toString();
                    log.info("La salida: " + res + " -- " + msg);
                }
            }
        } catch (NumberFormatException ex) {
            log.info("Error al actualizar bd: " + ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
    }

    //Obtenido
    public List<TurnoDto> getInfoTurno(int idTurno) {
        log.info("ConsultasMysql.getInfoTurno");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;
        List<TurnoDto> listaTurno = new ArrayList<TurnoDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(idTurno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_TURNO, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        TurnoDto dato = new TurnoDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DATE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        //log.info(dato.toString());
                        listaTurno.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listaTurno;
    }

    //Utilizado
    public void actualizaCancelaciones(int idTurno) {

        log.info("ConsultasMysql.actualizaCancelaciones");

        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();

        if (conn != null) {
            ArrayList<Object> paramsIn = new ArrayList<Object>();
            paramsIn.add(idTurno);
            ArrayList<Integer> paramsOut = new ArrayList<Integer>();
            paramsOut.add(java.sql.Types.INTEGER);
            paramsOut.add(java.sql.Types.VARCHAR);
            QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.UPDATE_INFO_CANCELACIONES, paramsIn, paramsOut);
            if (resp.getRes() == 1) {
                int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                String msg = resp.getParamOut().get(1).getValor().toString();
                log.info("La salida: " + res + " -- " + msg);
            } else {
                int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                String msg = resp.getParamOut().get(0).getValor().toString();
                log.info("La salida: " + res + " -- " + msg);
            }
        }
    }

    public void actualizaCancelacionesEnc(int idTurno) {

        log.info("ConsultasMysql.actualizaCancelacionesEnc");

        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();

        if (conn != null) {
            ArrayList<Object> paramsIn = new ArrayList<Object>();
            paramsIn.add(idTurno);
            ArrayList<Integer> paramsOut = new ArrayList<Integer>();
            paramsOut.add(java.sql.Types.INTEGER);
            paramsOut.add(java.sql.Types.VARCHAR);
            QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.UPDATE_INFO_CANCELACIONESENC, paramsIn, paramsOut);
            if (resp.getRes() == 1) {
                int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                String msg = resp.getParamOut().get(1).getValor().toString();
                log.info("La salida: " + res + " -- " + msg);
            } else {
                int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                String msg = resp.getParamOut().get(0).getValor().toString();
                log.info("La salida: " + res + " -- " + msg);
            }
        }
    }

    //Obtenido
    public List<EstadisticasDto> getInfoEstadisticas(int idTurno) {
        log.info("ConsultasMysql.getInfoEstadisticas");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;
        List<EstadisticasDto> listaEstadisticas = new ArrayList<EstadisticasDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(idTurno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_ESTADISTICAS, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        EstadisticasDto dato = new EstadisticasDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DATE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        //log.info(dato.toString());
                        listaEstadisticas.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listaEstadisticas;
    }

    //Utilizado
    public void actualizaEstadisticas(int idTurno) {

        log.info("ConsultasMysql.actualizaEstadisticas");

        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();

        if (conn != null) {
            ArrayList<Object> paramsIn = new ArrayList<Object>();
            paramsIn.add(idTurno);
            ArrayList<Integer> paramsOut = new ArrayList<Integer>();
            paramsOut.add(java.sql.Types.INTEGER);
            paramsOut.add(java.sql.Types.VARCHAR);
            QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.UPDATE_INFO_ESTADISTICAS, paramsIn, paramsOut);
            if (resp.getRes() == 1) {
                int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                String msg = resp.getParamOut().get(1).getValor().toString();
                log.info("La salida: " + res + " -- " + msg);
            } else {
                int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                String msg = resp.getParamOut().get(0).getValor().toString();
                log.info("La salida: " + res + " -- " + msg);
            }
        }
    }

    //Utilizado
    public void actualizaStatusTurno(int idTurno) {

        log.info("ConsultasMysql.actualizaStatusTurno");

        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();

        if (conn != null) {
            ArrayList<Object> paramsIn = new ArrayList<Object>();
            paramsIn.add(idTurno);
            ArrayList<Integer> paramsOut = new ArrayList<Integer>();
            paramsOut.add(java.sql.Types.INTEGER);
            paramsOut.add(java.sql.Types.VARCHAR);
            QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.UPDATE_STATUS_TURNO, paramsIn, paramsOut);
            if (resp.getRes() == 1) {
                int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                String msg = resp.getParamOut().get(1).getValor().toString();
                log.info("La salida: " + res + " -- " + msg);
            } else {
                int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                String msg = resp.getParamOut().get(0).getValor().toString();
                log.info("La salida: " + res + " -- " + msg);
            }
        }
    }

    public List<ArqueoCierraTurnoDto> getInfoArqueoCierraTurno(int idTurno) {
        log.info("ConsultasMysql.getInfoArqueoCierraTurno");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;
        List<ArqueoCierraTurnoDto> listaArqueoTurno = new ArrayList<ArqueoCierraTurnoDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(idTurno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.OBTIENE_INFO_ARQUEOCIERRATURNO, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        ArqueoCierraTurnoDto dato = new ArqueoCierraTurnoDto();
                        for (ColumnaDTO col : cols) {
                            //log.info("Col: " + col.toString());
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        listaArqueoTurno.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listaArqueoTurno;
    }

    public boolean reestructuraTurno(int idTurno, String caja, String tclave, int userIdCierre) {
        log.info("ConsultasMysql.reestructuraTurno");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(tclave);
                paramsIn.add(caja);
                paramsIn.add(userIdCierre);
                paramsIn.add(idTurno);
                ArrayList<Integer> paramsOut = new ArrayList<Integer>();
                paramsOut.add(java.sql.Types.INTEGER);
                resp = new Consulta().ejecutaSP(conn, IQryTurnoKardex.REESTRUCTURA_TURNO, paramsIn, null);
                if (resp.getRes() == 1) {
                    log.info("La salida: " + "OK" + " -- " + "Ok");
                } else {
                    log.info("La salida: " + "Error" + " -- " + "Error");
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return true;
    }

    public List<ArqueoCierraTurnoDto> recalculoInfoTurnoArqueo(int idTurno, String tienda, String caja) {
        log.info("ConsultasMysql.recalculoInfoTurnoArqueo");
        if (!Config.estaCargadaMysql) {
            Config.cargaConfigMysql();
        }

        Conexion con = new Conexion();
        con.creaConexion(Config.host, Config.user, Config.pass, Config.port, Config.name, Config.driv, Config.surl);
        Connection conn = con.getConexion();
        QryRespDTO resp = null;
        List<ArqueoCierraTurnoDto> listaArqueo = new ArrayList<ArqueoCierraTurnoDto>();
        try {
            if (conn != null) {
                ArrayList<Object> paramsIn = new ArrayList<>();
                paramsIn.add(tienda);
                paramsIn.add(caja);
                paramsIn.add(idTurno);
                resp = new Consulta().ejecutaSelectSP(conn, IQryTurnoKardex.RECALCULAINFOARQUEOCIERRATURNO, paramsIn);
                if (resp.getRes() == 1) {
                    ArrayList<ColumnaDTO> cols = resp.getColumnas();
                    for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
                        ArqueoCierraTurnoDto dato = new ArqueoCierraTurnoDto();
                        for (ColumnaDTO col : cols) {
                            switch (col.getIdTipo()) {
                                case java.sql.Types.INTEGER:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                case java.sql.Types.DOUBLE:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Double.parseDouble(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.FLOAT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.DECIMAL:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.NUMERIC:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
                                    break;

                                case java.sql.Types.VARCHAR:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;

                                case java.sql.Types.TINYINT:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "0" : Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString().replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
                                    break;

                                default:
                                    dato.getClass().getField(col.getEtiqueta()).set(dato,
                                            fila.get(col.getEtiqueta()).getValor() == null ? "" : fila.get(col.getEtiqueta()).getValor().toString());
                                    break;
                            }
                        }
                        //log.info(dato.toString());
                        listaArqueo.add(dato);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            log.info("Error durante la consulta a BD 1: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            log.info("Error durante la consulta a BD 2: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.info("Error durante la consulta a BD 3: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.info("Error durante la consulta a BD 4: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error durante la consulta a BD 5: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                log.info("Error al cerrar conexion: " + ex.toString());
            }
        }
        return listaArqueo;
    }

}
