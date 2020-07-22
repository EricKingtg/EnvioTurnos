/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 26/12/2018
 *
 */
package t3b.pv.cierraturno.logic;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import t3b.pv.cierraturno.dto.DtoTrnTxDet;
import t3b.pv.cierraturno.dto.TrnTxDetDto;

public class LogicTrxDetalleDao {
    
    private final static Logger log = Logger.getLogger(LogicTrxDetalleDao.class);

    public List<TrnTxDetDto> ConvertInfoTrxDet(DtoTrnTxDet obj, String tienda, String caja, int idturno, String fecha) {
        log.info("Convirtiendo la informacion de TRXDET");
        List<TrnTxDetDto> listaOut = new ArrayList<TrnTxDetDto>();
        for (int i = 1; i <= 32; i++) {
            listaOut.add(this.obtieneInfoIndividual(i, obj, tienda, caja, idturno, fecha));
        }
        log.info("Se partio la informacion de TRXDET para poder insertarla en BOT");
        return listaOut;
    }

    public TrnTxDetDto obtieneInfoIndividual(int opcion, DtoTrnTxDet dato, String tienda, String caja, int idturno, String fecha) {
        TrnTxDetDto out = new TrnTxDetDto();
        switch (opcion) {
            case 1:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de la Venta");
                out.setTimporte(dato.getTotalVenta());
                out.setTtrans(0);
                break;
            case 2:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de articulos");
                out.setTimporte(dato.getTotalArticulos());
                out.setTtrans(0);
                break;
            case 3:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de efectivo");
                out.setTimporte(dato.getTotalEfectivo());
                out.setTtrans(dato.getTotalOperacionesEfectivo());
                break;
            case 4:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de TDC");
                out.setTimporte(dato.getTotalTDC());
                out.setTtrans(dato.getTotalOperacionesTDC());
                break;
            case 5:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de Pago de Servicios");
                out.setTimporte(dato.getTotalPS());
                out.setTtrans(0);
                break;
            case 6:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de VX");
                out.setTimporte(dato.getTotalVX());
                out.setTtrans(dato.getTotalOperVX());
                break;
            case 7:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de VD");
                out.setTimporte(dato.getTotalVD());
                out.setTtrans(dato.getTotalOperVD());
                break;
            case 8:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de VA");
                out.setTimporte(dato.getTotalVA());
                out.setTtrans(dato.getTotalOperVA());
                break;
            case 9:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de Vales de Papel 3B");
                out.setTimporte(dato.getTotalVales3B());
                out.setTtrans(dato.getTotOperVal3B());
                break;
            case 10:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de Efectivale");
                out.setTimporte(dato.getTotalValesOtros());
                out.setTtrans(dato.getTotOperValOtro());
                break;
            case 11:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de Vales Elctronicos");
                out.setTimporte(dato.getTotalVales3BElectro());
                out.setTtrans(dato.getTotOperVal3bElec());
                break;
            case 12:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de Forma de pago 6");
                out.setTimporte(dato.getFormaPago6());
                out.setTtrans(dato.getTotOperForPag6());
                break;
            case 13:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de Forma de pago 7");
                out.setTimporte(dato.getFormaPago7());
                out.setTtrans(dato.getTotOperForPag7());
                break;
            case 14:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de Forma de pago 8");
                out.setTimporte(dato.getFormaPago8());
                out.setTtrans(dato.getTotOperForPag8());
                break;
            case 15:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de Forma de pago 9");
                out.setTimporte(dato.getFormaPago9());
                out.setTtrans(dato.getTotOperForPag9());
                break;
            case 16:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total de Forma de pago 10");
                out.setTimporte(dato.getFormaPago10());
                out.setTtrans(dato.getTotOperForPag10());
                break;
            case 17:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total Venta");
                out.setTimporte(dato.getTotalventaSinIva());
                out.setTtrans(0);
                break;
            case 18:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total Venta");
                out.setTimporte(dato.getTotalVentaIvaNo());
                out.setTtrans(0);
                break;
            case 19:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total Venta");
                out.setTimporte(dato.getTotalVentaConIva());
                out.setTtrans(0);
                break;
            case 20:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total Venta");
                out.setTimporte(dato.getTotalVentaOtroIva());
                out.setTtrans(0);
                break;
            case 21:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total IVA");
                out.setTimporte(dato.getTotalIvaVenta());
                out.setTtrans(0);
                break;
            case 22:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total IVA");
                out.setTimporte(dato.getTotalIvaVenta2());
                out.setTtrans(0);
                break;
            case 23:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total IVA");
                out.setTimporte(dato.getTotalIvaVenta3());
                out.setTtrans(0);
                break;
            case 24:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total IVA");
                out.setTimporte(dato.getTotalIvaVenta4());
                out.setTtrans(0);
                break;
            case 25:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total Venta");
                out.setTimporte(dato.getTotalVentaIEPS());
                out.setTtrans(0);
                break;
            case 26:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total Venta");
                out.setTimporte(dato.getTotalVentaIEPS2());
                out.setTtrans(0);
                break;
            case 27:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total Venta");
                out.setTimporte(dato.getTotalVentaIEPS3());
                out.setTtrans(0);
                break;
            case 28:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total Venta");
                out.setTimporte(dato.getTotalVentaIEPS4());
                out.setTtrans(0);
                break;
            case 29:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total IEPS");
                out.setTimporte(dato.getTotalIEPS());
                out.setTtrans(0);
                break;
            case 30:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total IEPS");
                out.setTimporte(dato.getTotalIEPS2());
                out.setTtrans(0);
                break;
            case 31:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total IEPS");
                out.setTimporte(dato.getTotalIEPS3());
                out.setTtrans(0);
                break;
            case 32:
                out.setTclave(tienda);
                out.setCaja(caja);
                out.setIdturno(idturno);
                out.setFecha(fecha);
                out.setTtrans_clave(opcion);
                out.setTtrans_desc("Total IEPS");
                out.setTimporte(dato.getTotalIEPS4());
                out.setTtrans(0);
                break;
        }

        return out;
    }

}
