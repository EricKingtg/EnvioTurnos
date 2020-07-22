/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 11/02/2019
 *
 */
package t3b.pv.cierraturno.dto;

public class DevolucionesDto {

    public int iddevolucion;
    public String tclave;
    public String caja;
    public int idturno;
    public String fecha;
    public String atmfecha;
    public int folio;
    public String mov;
    public int cve_razon;
    public int num_ticket;
    public String fecha_ticket;
    public int tipo_dc;
    public int iclave;
    public String icb;
    public float cantidad;
    public float total_precio;
    public int userid;
    public int userid_aut;
    public int userid_bot;
    public String udDATE;
    public int statusop;

    @Override
    public String toString() {
        return "DevolucionesDto{" + "iddevolucion=" + iddevolucion + ", tclave=" + tclave + ", caja=" + caja + ", idturno=" + idturno + ", fecha=" + fecha + ", atmfecha=" + atmfecha + ", folio=" + folio + ", mov=" + mov + ", cve_razon=" + cve_razon + ", num_ticket=" + num_ticket + ", fecha_ticket=" + fecha_ticket + ", tipo_dc=" + tipo_dc + ", iclave=" + iclave + ", icb=" + icb + ", cantidad=" + cantidad + ", total_precio=" + total_precio + ", userid=" + userid + ", userid_aut=" + userid_aut + ", userid_bot=" + userid_bot + ", udDATE=" + udDATE + ", statusop=" + statusop + '}';
    }

    /**
     * @return the iddevolucion
     */
    public int getIddevolucion() {
        return iddevolucion;
    }

    /**
     * @param iddevolucion the iddevolucion to set
     */
    public void setIddevolucion(int iddevolucion) {
        this.iddevolucion = iddevolucion;
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

    /**
     * @return the folio
     */
    public int getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * @return the mov
     */
    public String getMov() {
        return mov;
    }

    /**
     * @param mov the mov to set
     */
    public void setMov(String mov) {
        this.mov = mov;
    }

    /**
     * @return the cve_razon
     */
    public int getCve_razon() {
        return cve_razon;
    }

    /**
     * @param cve_razon the cve_razon to set
     */
    public void setCve_razon(int cve_razon) {
        this.cve_razon = cve_razon;
    }

    /**
     * @return the num_ticket
     */
    public int getNum_ticket() {
        return num_ticket;
    }

    /**
     * @param num_ticket the num_ticket to set
     */
    public void setNum_ticket(int num_ticket) {
        this.num_ticket = num_ticket;
    }

    /**
     * @return the fecha_ticket
     */
    public String getFecha_ticket() {
        return fecha_ticket;
    }

    /**
     * @param fecha_ticket the fecha_ticket to set
     */
    public void setFecha_ticket(String fecha_ticket) {
        this.fecha_ticket = fecha_ticket;
    }

    /**
     * @return the tipo_dc
     */
    public int getTipo_dc() {
        return tipo_dc;
    }

    /**
     * @param tipo_dc the tipo_dc to set
     */
    public void setTipo_dc(int tipo_dc) {
        this.tipo_dc = tipo_dc;
    }

    /**
     * @return the iclave
     */
    public int getIclave() {
        return iclave;
    }

    /**
     * @param iclave the iclave to set
     */
    public void setIclave(int iclave) {
        this.iclave = iclave;
    }

    /**
     * @return the icb
     */
    public String getIcb() {
        return icb;
    }

    /**
     * @param icb the icb to set
     */
    public void setIcb(String icb) {
        this.icb = icb;
    }

    /**
     * @return the cantidad
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the total_precio
     */
    public float getTotal_precio() {
        return total_precio;
    }

    /**
     * @param total_precio the total_precio to set
     */
    public void setTotal_precio(float total_precio) {
        this.total_precio = total_precio;
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
     * @return the userid_aut
     */
    public int getUserid_aut() {
        return userid_aut;
    }

    /**
     * @param userid_aut the userid_aut to set
     */
    public void setUserid_aut(int userid_aut) {
        this.userid_aut = userid_aut;
    }

    /**
     * @return the userid_bot
     */
    public int getUserid_bot() {
        return userid_bot;
    }

    /**
     * @param userid_bot the userid_bot to set
     */
    public void setUserid_bot(int userid_bot) {
        this.userid_bot = userid_bot;
    }

    /**
     * @return the udDATE
     */
    public String getUdDATE() {
        return udDATE;
    }

    /**
     * @param udDATE the udDATE to set
     */
    public void setUdDATE(String udDATE) {
        this.udDATE = udDATE;
    }

    /**
     * @return the statusop
     */
    public int getStatusop() {
        return statusop;
    }

    /**
     * @param statusop the statusop to set
     */
    public void setStatusop(int statusop) {
        this.statusop = statusop;
    }

}
