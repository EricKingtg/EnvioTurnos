/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 19/12/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class VentasArticulosDto {

    public String CODIGOBAR;
    public String VENTAMULT;
    public float CANTIDAD;
    public float CANTIDADNEG;
    public String tclave;
    public String caja;
    public int idturno;
    public int pclave;
    public long tipo;
    public String atmfecha;

    @Override
    public String toString() {
        return "VentasArticulosDto{" + "CODIGOBAR=" + CODIGOBAR + ", VETNTAMULT=" + VENTAMULT + ", CANTIDAD=" + CANTIDAD + ", CANTIDADNEG=" + CANTIDADNEG + ", tclave=" + tclave + ", caja=" + caja + ", idturno=" + idturno + ", pclave=" + pclave + ", tipo=" + tipo + '}';
    }

    /**
     * @return the CODIGOBAR
     */
    public String getCODIGOBAR() {
        return CODIGOBAR;
    }

    /**
     * @param CODIGOBAR the CODIGOBAR to set
     */
    public void setCODIGOBAR(String CODIGOBAR) {
        this.CODIGOBAR = CODIGOBAR;
    }

    /**
     * @return the VETNTAMULT
     */
    public String getVETNTAMULT() {
        return VENTAMULT;
    }

    /**
     * @param VENTAMULT the VETNTAMULT to set
     */
    public void setVETNTAMULT(String VENTAMULT) {
        this.VENTAMULT = VENTAMULT;
    }

    /**
     * @return the CANTIDAD
     */
    public float getCANTIDAD() {
        return CANTIDAD;
    }

    /**
     * @param CANTIDAD the CANTIDAD to set
     */
    public void setCANTIDAD(float CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    /**
     * @return the CANTIDADNEG
     */
    public float getCANTIDADNEG() {
        return CANTIDADNEG;
    }

    /**
     * @param CANTIDADNEG the CANTIDADNEG to set
     */
    public void setCANTIDADNEG(float CANTIDADNEG) {
        this.CANTIDADNEG = CANTIDADNEG;
    }

    /**
     * @return the tclave
     */
    public String getTclave() {
        return tclave;
    }

    /**
     * @param tclave the tclave to set
     */
    public void setTclave(String tclave) {
        this.tclave = tclave;
    }

    /**
     * @return the caja
     */
    public String getCaja() {
        return caja;
    }

    /**
     * @param caja the caja to set
     */
    public void setCaja(String caja) {
        this.caja = caja;
    }

    /**
     * @return the idturno
     */
    public int getIdturno() {
        return idturno;
    }

    /**
     * @param idturno the idturno to set
     */
    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    /**
     * @return the pclave
     */
    public int getPclave() {
        return pclave;
    }

    /**
     * @param pclave the pclave to set
     */
    public void setPclave(int pclave) {
        this.pclave = pclave;
    }

    /**
     * @return the tipo
     */
    public long getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(long tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the atmfecha
     */
    public String getAtmfecha() {
        return atmfecha;
    }

    /**
     * @param atmfecha the atmfecha to set
     */
    public void setAtmfecha(String atmfecha) {
        this.atmfecha = atmfecha;
    }

}
