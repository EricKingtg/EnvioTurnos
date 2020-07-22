/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 21/12/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class TpvTicketError {

    public String tclave;
    public String caja;
    public int num_ticket;
    public String fec;
    public String hora;
    public float total_enc;
    public float total_det;
    public String tipo;
    public String fech;
    public String tclave_0;
    public int idturno;

    @Override
    public String toString() {
        return "TpvTicketError{" + "idturno=" + idturno + ", tclave=" + tclave + ", caja=" + caja + ", num_ticket=" + num_ticket + ", fec=" + fec + ", hora=" + hora + ", total_enc=" + total_enc + ", total_det=" + total_det + ", tipo=" + tipo + ", fech=" + fech + ", tclave_0=" + tclave_0 + '}';
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
     * @return the fec
     */
    public String getFec() {
        return fec;
    }

    /**
     * @param fec the fec to set
     */
    public void setFec(String fec) {
        this.fec = fec;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the total_enc
     */
    public float getTotal_enc() {
        return total_enc;
    }

    /**
     * @param total_enc the total_enc to set
     */
    public void setTotal_enc(float total_enc) {
        this.total_enc = total_enc;
    }

    /**
     * @return the total_det
     */
    public float getTotal_det() {
        return total_det;
    }

    /**
     * @param total_det the total_det to set
     */
    public void setTotal_det(float total_det) {
        this.total_det = total_det;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @return the tclave_0
     */
    public String getTclave_0() {
        return tclave_0;
    }

    /**
     * @param tclave_0 the tclave_0 to set
     */
    public void setTclave_0(String tclave_0) {
        this.tclave_0 = tclave_0;
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

}
