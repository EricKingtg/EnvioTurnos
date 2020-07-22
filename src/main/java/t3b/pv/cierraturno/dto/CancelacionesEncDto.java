/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 19/02/2019
 *
 */
package t3b.pv.cierraturno.dto;

public class CancelacionesEncDto {

    public int atmseq;
    public int turnoid;
    public String tclave;
    public String caja;
    public String atmfecha;
    public int num_ticket;
    public int iclave;
    public String icb;
    public int userid;
    public int atmcant;
    public double atmventa;
    public int status;
    public String fecha;
    public int useridcanc;

    @Override
    public String toString() {
        return "CancelacionesEncDto{" + "atmseq=" + atmseq + ", turnoid=" + turnoid + ", tclave=" + tclave + ", caja=" + caja + ", atmfecha=" + atmfecha + ", num_ticket=" + num_ticket + ", iclave=" + iclave + ", icb=" + icb + ", userid=" + userid + ", atmcant=" + atmcant + ", atmventa=" + atmventa + ", status=" + status + ", fecha=" + fecha + ", useridcanc=" + useridcanc + '}';
    }    

    /**
     * @return the atmseq
     */
    public int getAtmseq() {
        return atmseq;
    }

    /**
     * @param atmseq the atmseq to set
     */
    public void setAtmseq(int atmseq) {
        this.atmseq = atmseq;
    }

    /**
     * @return the turnoid
     */
    public int getTurnoid() {
        return turnoid;
    }

    /**
     * @param turnoid the turnoid to set
     */
    public void setTurnoid(int turnoid) {
        this.turnoid = turnoid;
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
     * @return the atmcant
     */
    public int getAtmcant() {
        return atmcant;
    }

    /**
     * @param atmcant the atmcant to set
     */
    public void setAtmcant(int atmcant) {
        this.atmcant = atmcant;
    }

    /**
     * @return the atmventa
     */
    public double getAtmventa() {
        return atmventa;
    }

    /**
     * @param atmventa the atmventa to set
     */
    public void setAtmventa(double atmventa) {
        this.atmventa = atmventa;
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
     * @return the useridcanc
     */
    public int getUseridcanc() {
        return useridcanc;
    }

    /**
     * @param useridcanc the useridcanc to set
     */
    public void setUseridcanc(int useridcanc) {
        this.useridcanc = useridcanc;
    }

}
