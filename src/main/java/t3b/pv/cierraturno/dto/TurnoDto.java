/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 13/11/2018
 *
 */

package t3b.pv.cierraturno.dto;


public class TurnoDto {

    public int idturno;
    public String caja;
    public String tclave;
    public int activo;
    public int ticket_ini;
    public int ticket_fin;
    public int userid;
    public int useridabre;
    public int useridcierre;
    public String fecha_ini;
    public String fecha_fin;    
    public String fecha;
    public int status;
    public int turno;
    public float fondo;
    public float total_ps;
    public int cantidad_retiros;
    public float monto_retiros;

    @Override
    public String toString() {
        return "TurnoDto{" + "idturno=" + idturno + ", caja=" + caja + ", tclave=" + tclave + ", activo=" + activo + ", ticket_ini=" + ticket_ini + ", ticket_fin=" + ticket_fin + ", userid=" + userid + ", useridabre=" + useridabre + ", useridcierre=" + useridcierre + ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", fecha=" + fecha + ", status=" + status + ", turno=" + turno + ", fondo=" + fondo + ", total_ps=" + total_ps + ", cantidad_retiros=" + cantidad_retiros + ", monto_retiros=" + monto_retiros + '}';
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
     * @return the activo
     */
    public int getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(int activo) {
        this.activo = activo;
    }

    /**
     * @return the ticket_ini
     */
    public int getTicket_ini() {
        return ticket_ini;
    }

    /**
     * @param ticket_ini the ticket_ini to set
     */
    public void setTicket_ini(int ticket_ini) {
        this.ticket_ini = ticket_ini;
    }

    /**
     * @return the ticket_fin
     */
    public int getTicket_fin() {
        return ticket_fin;
    }

    /**
     * @param ticket_fin the ticket_fin to set
     */
    public void setTicket_fin(int ticket_fin) {
        this.ticket_fin = ticket_fin;
    }

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
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
     * @return the fecha_ini
     */
    public String getFecha_ini() {
        return fecha_ini;
    }

    /**
     * @param fecha_ini the fecha_ini to set
     */
    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    /**
     * @return the fecha_fin
     */
    public String getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * @return the useridcierre
     */
    public int getUseridcierre() {
        return useridcierre;
    }

    /**
     * @param useridcierre the useridcierre to set
     */
    public void setUseridcierre(int useridcierre) {
        this.useridcierre = useridcierre;
    }


   

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the useridabre
     */
    public int getUseridabre() {
        return useridabre;
    }

    /**
     * @param useridabre the useridabre to set
     */
    public void setUseridabre(int useridabre) {
        this.useridabre = useridabre;
    }

    /**
     * @return the turno
     */
    public int getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the fondo
     */
    public float getFondo() {
        return fondo;
    }

    /**
     * @param fondo the fondo to set
     */
    public void setFondo(float fondo) {
        this.fondo = fondo;
    }

    /**
     * @return the total_ps
     */
    public float getTotal_ps() {
        return total_ps;
    }

    /**
     * @param total_ps the total_ps to set
     */
    public void setTotal_ps(float total_ps) {
        this.total_ps = total_ps;
    }

    /**
     * @return the cantidad_retiros
     */
    public int getCantidad_retiros() {
        return cantidad_retiros;
    }

    /**
     * @param cantidad_retiros the cantidad_retiros to set
     */
    public void setCantidad_retiros(int cantidad_retiros) {
        this.cantidad_retiros = cantidad_retiros;
    }

    /**
     * @return the monto_retiros
     */
    public float getMonto_retiros() {
        return monto_retiros;
    }

    /**
     * @param monto_retiros the monto_retiros to set
     */
    public void setMonto_retiros(float monto_retiros) {
        this.monto_retiros = monto_retiros;
    }
    
}
