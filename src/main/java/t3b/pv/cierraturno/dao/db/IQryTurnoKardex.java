/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 9/10/2018
 *
 */
package t3b.pv.cierraturno.dao.db;

public interface IQryTurnoKardex {

    public static String CONSULTA_TIENDAS = "{ CALL sp_obtiene_info_tienda() }";
    public static String OBTIENE_INFO_CIERRA_TURNO = "{ CALL S_OBTIENE_INFO_CIERRE_TURNO(?) }";
    public static String OBTIENE_INFO_CIERRA_KARDEX = "{ CALL S_OBTIENE_INFO_CIERRE_TURNO_KARDEX(?)}";
    public static String OBTIENE_INFO_CANCELACIONES = "{ CALL SP_OBTIENE_INFO_CANCELACIONES(?) }";
    public static String OBTIENE_INFO_CANCELACIOENC = "{ CALL SP_OBTIENE_INFO_CANCELACIONESENC(?) }";
    public static String OBTIENE_INFO_ESTADISTICAS = "{ CALL SP_GET_INFO_ESTADISTICAS(?) }";
    public static String OBTIENE_INFO_TURNO = "{ CALL S_OBTIENE_INFO_TURNO(?) }";
    public static String OBTIENE_INFO_MOV_DET = "{ CALL GET_MOV_DET(?,?,?,?) }";
    public static String OBTIENE_INFO_MOV_ENC = "{ CALL GET_MOV_ENC(?,?,?,?) }";
    public static String OBTIENE_INFO_VTAS_ARTI = "{ CALL GET_VTAS_ARTI(?,?,?,?) }";
    public static String OBTIENE_INFO_MVTOS_ELECTRO = " { CALL GET_MVTOS_ELECTRO(?,?,?,?) }";
    public static String OBTIENE_INFO_LOG_TRANS = "{ CALL GET_LOG_TRANS(?,?,?,?) }";
    public static String OBTIENE_INFO_MOV_REGA = "{ CALL GET_MOV_TREGALO(?,?,?,?) }";
    public static String OBTIENE_INFO_LOG_REGA = "{ CALL GET_LOG_TREGALO(?,?,?,?) }";
    public static String OBTIENE_INFO_LOG_10TRANS = "{ CALL GET_LOG_10TRANS(?,?,?,?) }";
    public static String OBTIENE_INFO_TCKS_ERROR = "{ CALL GET_TCKS_ERROR(?,?,?,?) }";
    public static String OBTIENE_INFO_MOVS_RETIRO = "{ CALL GET_MOVS_RETIRO(?,?,?,?) }";
    public static String OBTIENE_INFO_MOVS_EVALE = "{ CALL GET_MOVS_EVALE(?,?,?,?) }";
    public static String OBTIENE_INFO_PAGOS_VENTA = "{ CALL GET_PAGOS_VENTA(?,?,?,?) }";
    public static String OBTIENE_INFO_INET_ERROR = "{ CALL GET_INET_ERROR(?,?,?,?) }";
    public static String OBTIENE_INFO_INETERR_SUMM = "{ CALL GET_INETERROR_SUMMARY(?,?,?,?) }";
    public static String OBTIENE_INFO_EVALE_LOG = "{ CALL GET_EVALE_LOG(?,?,?,?) }";
    public static String OBTIENE_INFO_INGERSO_VTAS = "{ CALL GET_INGRESO_VTAS(?,?,?,?) }";
    public static String OBTIENE_INFO_HORA_TIPO = "{ CALL GET_HORA_TIPO(?,?,?) }";
    public static String OBTIENE_INFO_TRN_TXDET = "{ CALL GET_TRN_TXDET(?,?,?,?) }";
    public static String OBTIENE_INFO_DEV_ENC = "{ CALL SP_GETINFODEVOLUCIONENC(?) }";
    public static String OBTIENE_INFO_DEVOLUC = "{ CALL SP_GETINFODEVOLUCION(?) }";
    public static String OBTIENE_INFO_TURNOOPEN = "{ CALL SP_GETINFOTURNOOPENBOT() }";
    public static String OBTIENE_INFO_ARQUEOCIERRATURNO = "{ CALL S_GETINFOARQUEOCIERRATURNO(?) }";

    public static String INSERTA_INFO_CIERRA_KARDEX = "{ CALL SP_INSERTA_INFO_KARDEX(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_CIERRA_TURNO = " { CALL SP_INSERTA_INFO_TURNO(?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_CANCELACIONES = "{ CALL SP_INSERTA_INFO_CANCELACIONES(?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_CANCELACIOENC = "{ CALL SP_INSERTA_INFO_CANCELACIONESENC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_DEL_TURNO = "{ CALL SP_INFO_DEL_TURNO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_ESTADISTICAS = "{ CALL SP_INSERTA_ESTADISTICAS(?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_LOG_TRANS = "{ CALL SP_INSERTA_LOG_TRANS (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_MOV_REGA = "{ CALL SP_INSERTA_MOV_TREGALO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_LOG_REGA = "{ CALL SP_INSERTA_LOG_REGALO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_LOG_10TRANS = "{ CALL SP_INSERTA_LOG_10TRANS (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_MOV_DET = "{ CALL SP_INSERTA_MOV_DET(?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_MOV_ENC = "{ CALL SP_INSERTA_MOV_ENC(?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_VTAS_ARTI = "{ CALL SP_INSERTA_VTAS_ARTI(?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_MVTOS_ELECTRO = "{ CALL SP_INSERTA_MVTOS_ELECTRO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_TCKS_ERROR = "{ CALL SP_INSERTA_TCKS_ERROR(?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_MOVS_RETIRO = "{ CALL SP_INSERTA_MOVS_RETIRO(?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_MOVS_EVALE = "{ CALL SP_INSERTA_MOVS_EVALE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_PAGOS_VENTA = "{ CALL SP_INSERTA_PAGOS_VENTA(?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_INET_ERROR = "{ CALL SP_INSERTA_INET_ERROR(?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_INETERR_SUMM = "{ CALL SP_INSERTA_INETERROR_SUMMARY(?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_EVALE_LOG = "{ CALL SP_INSERTA_EVALE_LOG(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_INGRESO_VTAS = "{ CALL SP_INSERTA_INGRESO_VTAS(?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_HORA_TIPO = "{ CALL SP_INSERTA_HORA_TIPO(?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_TRN_TXDET = "{ CALL SP_INSERTA_TRN_TXDET(?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_DEV_ENC = "{ CALL SP_INSERTA_PV_DEVOLENC(?,?,?,?,?,?) }";
    public static String INSERTA_INFO_DEVOLUC = "{ CALL SP_INSERTA_PV_DEVOLOCION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static String INSERTA_INFO_ARQUEOCIERRATURNO = "{CALL SP_INSERTA_ARQUEO_CIERRATURNO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    public static String UPDATE_INFO_TURNO = "{ CALL SP_ACTUALIZA_CIERRA_TURNO(?,?,?) }";
    public static String UPDATE_INFO_KARDEX = "{ CALL SP_ACTUALIZA_CIERRA_KARDEX(?,?,?) }";
    public static String UPDATE_INFO_CANCELACIONES = "{ CALL SP_ACTUALIZA_INFO_SUMMARY(?,?,?) }";
    public static String UPDATE_INFO_CANCELACIONESENC = "{ CALL SP_ACTUALIZA_INFO_CANCELACIONESENC(?,?,?) }";
    public static String UPDATE_INFO_ESTADISTICAS = "{ CALL SP_ACTUALIZA_ESTADISTICAS(?,?,?) }";
    public static String UPDATE_STATUS_TURNO = "{ CALL SP_ACTULIZA_STATUS_TURNO (?,?,?) }";
    public static String UPDATE_INFO_DEVOENC = "{ CALL SP_ACTUALIZADEVOLUCIONENC(?,?,?,?) }";
    public static String UPDATE_DEVOLUCIONES = "{ CALL SP_ACTUALIZADEVOLUCION(?,?,?,?) }";
    public static String UPDATE_TURNO_CIERRA = "{ CALL SP_UPDATEINFO_DEL_TURNO(?,?,?,?,?,?,?) }";

    public static String UPDATE_INFO_REENVIATURNO = "{ CALL SP_ACTUALIZA_INFOTURNO_REEENVIO(?,?,?) }";
    public static String DELETE_INFOTURNO = "{ CALL SP_BORRA_INFO_TURNO(?,?,?,?,?,?) }";
    public static String RECALCULAINFODELTURNO = "{ CALL S_CERRAR_TURNORECALCULO(?,?,?,?,?,?) }";
    public static String RECALCULAINFOARQUEOCIERRATURNO = "{ CALL S_ARQUEOCIERRRATURNO(?,?,?) }";
    public static String REESTRUCTURA_TURNO = "{ CALL S_CERRAR_REESTRUCTURA_TURNO(?,?,?,?) }";
    public static String VALIDA_TURNO_ACTIVO = "{ CALL S_VALIDA_TURNOACTIVO(?) }";
    public static String CONSULTA_TURNOS = "{ CALL S_CONSULTA_TURNOS_TODOS() }";
    public static String CALCULA_ADICIONALES = "{ CALL S_CALCULA_ADICIONALES(?,?,?,?) }";
    
}
