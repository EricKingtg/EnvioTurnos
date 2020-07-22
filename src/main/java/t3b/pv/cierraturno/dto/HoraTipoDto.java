/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 26/12/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class HoraTipoDto {

    public String tclave;
    public int idturno;
    public String caja;
    public int hora;
    public int iclave;
    public long cant_art;
    public float importe_art;
    public String fech;
    public long num_tickets;

    @Override
    public String toString() {
        return "HoraTipoDto{" + "tclave=" + tclave + ", idturno=" + idturno + ", caja=" + caja + ", hora=" + hora + ", iclave=" + iclave + ", cant_art=" + cant_art + ", importe_art=" + importe_art + ", fech=" + fech + ", num_ticket=" + num_tickets + '}';
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
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
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
     * @return the cant_art
     */
    public long getCant_art() {
        return cant_art;
    }

    /**
     * @param cant_art the cant_art to set
     */
    public void setCant_art(long cant_art) {
        this.cant_art = cant_art;
    }

    /**
     * @return the importe_art
     */
    public float getImporte_art() {
        return importe_art;
    }

    /**
     * @param importe_art the importe_art to set
     */
    public void setImporte_art(float importe_art) {
        this.importe_art = importe_art;
    }

    /**
     * @return the fech
     */
    public String getFech() {
        return fech;
    }

    /**
     * @param fech the fech to set
     */
    public void setFech(String fech) {
        this.fech = fech;
    }

    /**
     * @return the num_ticket
     */
    public long getNum_ticket() {
        return num_tickets;
    }

    /**
     * @param num_tickets the num_ticket to set
     */
    public void setNum_ticket(long num_tickets) {
        this.num_tickets = num_tickets;
    }

}
