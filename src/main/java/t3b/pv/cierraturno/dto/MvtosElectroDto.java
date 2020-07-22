/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 20/12/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class MvtosElectroDto {

    public int atmseq;
    public String tclave;
    public int num_ticket;
    public int iclave;
    public String icb;
    public String caja;
    public int pclave;
    public String fecha;
    public String atmdesc;
    public float atmventa;
    public String lclave;
    public String num_ref;
    public int num_conf;
    public int num_unico_pt;
    public int reversada;
    public int userid;
    public int estatus;
    public int idturno;

    @Override
    public String toString() {
        return "MvtosElectroDto{" + "atmseq=" + atmseq + ", tclave=" + tclave + ", num_ticket=" + num_ticket + ", iclave=" + iclave + ", icb=" + icb + ", caja=" + caja + ", pclave=" + pclave + ", fecha=" + fecha + ", atmdesc=" + atmdesc + ", atmventa=" + atmventa + ", lclave=" + lclave + ", num_ref=" + num_ref + ", num_conf=" + num_conf + ", num_unico_pt=" + num_unico_pt + ", reversada=" + reversada + ", userid=" + userid + ", estatus=" + estatus + '}';
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
     * @return the atmdesc
     */
    public String getAtmdesc() {
        return atmdesc;
    }

    /**
     * @param atmdesc the atmdesc to set
     */
    public void setAtmdesc(String atmdesc) {
        this.atmdesc = atmdesc;
    }

    /**
     * @return the atmventa
     */
    public float getAtmventa() {
        return atmventa;
    }

    /**
     * @param atmventa the atmventa to set
     */
    public void setAtmventa(float atmventa) {
        this.atmventa = atmventa;
    }

    /**
     * @return the lclave
     */
    public String getLclave() {
        return lclave;
    }

    /**
     * @param lclave the lclave to set
     */
    public void setLclave(String lclave) {
        this.lclave = lclave;
    }

    /**
     * @return the num_ref
     */
    public String getNum_ref() {
        return num_ref;
    }

    /**
     * @param num_ref the num_ref to set
     */
    public void setNum_ref(String num_ref) {
        this.num_ref = num_ref;
    }

    /**
     * @return the num_conf
     */
    public int getNum_conf() {
        return num_conf;
    }

    /**
     * @param num_conf the num_conf to set
     */
    public void setNum_conf(int num_conf) {
        this.num_conf = num_conf;
    }

    /**
     * @return the num_unico_pt
     */
    public int getNum_unico_pt() {
        return num_unico_pt;
    }

    /**
     * @param num_unico_pt the num_unico_pt to set
     */
    public void setNum_unico_pt(int num_unico_pt) {
        this.num_unico_pt = num_unico_pt;
    }

    /**
     * @return the reversada
     */
    public int getReversada() {
        return reversada;
    }

    /**
     * @param reversada the reversada to set
     */
    public void setReversada(int reversada) {
        this.reversada = reversada;
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
     * @return the estatus
     */
    public int getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(int estatus) {
        this.estatus = estatus;
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
