/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 20/12/2018
 *
 */

package t3b.pv.cierraturno.dto;


public class Log10TransDto {

    public int pvseq;
    public int enc_id;
    public String tclave;
    public String caja;
    public int num_ticket;
    public int monto;
    public String referencia;
    public String icb;
    public int iclave;
    public int pclave;
    public String fechax;
    public String hora_ini;
    public String hora_fin;
    public String duracion;
    public String confirmacion;
    public String mensaje;
    public String folio;
    public String reverso;
    public int userid;
    public String stAV;
    public String stED;
    public String stRD;
    public String stGE;
    public String stGD;
    public String stUE;
    public String stUD;
    public String stFP;
    public String stIT;
    public String stCP;
    public int idturno;

    @Override
    public String toString() {
        return "Log10TransDto{" + "pvseq=" + pvseq + ", enc_id=" + enc_id + ", tclave=" + tclave + ", caja=" + caja + ", num_ticket=" + num_ticket + ", monto=" + monto + ", referencia=" + referencia + ", icb=" + icb + ", iclave=" + iclave + ", pclave=" + pclave + ", fechax=" + fechax + ", hora_ini=" + hora_ini + ", hora_fin=" + hora_fin + ", duracion=" + duracion + ", confirmacion=" + confirmacion + ", mensaje=" + mensaje + ", folio=" + folio + ", reverso=" + reverso + ", userid=" + userid + ", stAV=" + stAV + ", stED=" + stED + ", stRD=" + stRD + ", stGE=" + stGE + ", stGD=" + stGD + ", stUE=" + stUE + ", stUD=" + stUD + ", stFP=" + stFP + ", stIT=" + stIT + ", stCP=" + stCP + ", idturno=" + idturno + '}';
    }
    
    /**
     * @return the pvseq
     */
    public int getPvseq() {
        return pvseq;
    }

    /**
     * @param pvseq the pvseq to set
     */
    public void setPvseq(int pvseq) {
        this.pvseq = pvseq;
    }

    /**
     * @return the enc_id
     */
    public int getEnc_id() {
        return enc_id;
    }

    /**
     * @param enc_id the enc_id to set
     */
    public void setEnc_id(int enc_id) {
        this.enc_id = enc_id;
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
     * @return the monto
     */
    public int getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
     * @return the fechax
     */
    public String getFechax() {
        return fechax;
    }

    /**
     * @param fechax the fechax to set
     */
    public void setFechax(String fechax) {
        this.fechax = fechax;
    }

    /**
     * @return the hora_ini
     */
    public String getHora_ini() {
        return hora_ini;
    }

    /**
     * @param hora_ini the hora_ini to set
     */
    public void setHora_ini(String hora_ini) {
        this.hora_ini = hora_ini;
    }

    /**
     * @return the hora_fin
     */
    public String getHora_fin() {
        return hora_fin;
    }

    /**
     * @param hora_fin the hora_fin to set
     */
    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    /**
     * @return the duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the confirmacion
     */
    public String getConfirmacion() {
        return confirmacion;
    }

    /**
     * @param confirmacion the confirmacion to set
     */
    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the folio
     */
    public String getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * @return the reverso
     */
    public String getReverso() {
        return reverso;
    }

    /**
     * @param reverso the reverso to set
     */
    public void setReverso(String reverso) {
        this.reverso = reverso;
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
     * @return the stAV
     */
    public String getStAV() {
        return stAV;
    }

    /**
     * @param stAV the stAV to set
     */
    public void setStAV(String stAV) {
        this.stAV = stAV;
    }

    /**
     * @return the stED
     */
    public String getStED() {
        return stED;
    }

    /**
     * @param stED the stED to set
     */
    public void setStED(String stED) {
        this.stED = stED;
    }

    /**
     * @return the stRD
     */
    public String getStRD() {
        return stRD;
    }

    /**
     * @param stRD the stRD to set
     */
    public void setStRD(String stRD) {
        this.stRD = stRD;
    }

    /**
     * @return the stGE
     */
    public String getStGE() {
        return stGE;
    }

    /**
     * @param stGE the stGE to set
     */
    public void setStGE(String stGE) {
        this.stGE = stGE;
    }

    /**
     * @return the stGD
     */
    public String getStGD() {
        return stGD;
    }

    /**
     * @param stGD the stGD to set
     */
    public void setStGD(String stGD) {
        this.stGD = stGD;
    }

    /**
     * @return the stUE
     */
    public String getStUE() {
        return stUE;
    }

    /**
     * @param stUE the stUE to set
     */
    public void setStUE(String stUE) {
        this.stUE = stUE;
    }

    /**
     * @return the stUD
     */
    public String getStUD() {
        return stUD;
    }

    /**
     * @param stUD the stUD to set
     */
    public void setStUD(String stUD) {
        this.stUD = stUD;
    }

    /**
     * @return the stFP
     */
    public String getStFP() {
        return stFP;
    }

    /**
     * @param stFP the stFP to set
     */
    public void setStFP(String stFP) {
        this.stFP = stFP;
    }

    /**
     * @return the stIT
     */
    public String getStIT() {
        return stIT;
    }

    /**
     * @param stIT the stIT to set
     */
    public void setStIT(String stIT) {
        this.stIT = stIT;
    }

    /**
     * @return the stCP
     */
    public String getStCP() {
        return stCP;
    }

    /**
     * @param stCP the stCP to set
     */
    public void setStCP(String stCP) {
        this.stCP = stCP;
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
