/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 10/05/2019
 *
 */

package t3b.pv.cierraturno.dto;


public class ArqueoCierraTurnoDto {
    
    public int atmseq;
    public String tclave;
    public String caja;
    public int idturno;
    public String fecha;  
    public String hora;   
    public String atmfecha;
    public double ventCajeroEfec;
    public double ventCajeroVales;
    public double ventCajeroValesE;
    public double ventCajeroValesTR;
    public double ventCajeroTC;
    public double ventCajeroTGDF;
    public double ventCajeroT3E;
    public double retCajeroEfec;
    public double ventCajeroTotal;
    public double retCajeroTotal;
    public double fondoEfectivo;
    public double difCajeroEfec;
    public double tckProm;
    public int operTotal;
    public String pafecha;
    
    
    @Override
    public String toString() {
        return "ArqueoCierraTurnoDto{" + "atmseq=" + getAtmseq() + ", tclave=" + getTclave() + ", caja=" + getCaja() + ", idturno=" + getIdturno() + ", fecha=" + getFecha() + ", hora=" + getHora() + ", atmfecha=" + getAtmfecha() + ", ventCajeroEfec=" + getVentCajeroEfec() + ", ventCajeroVales=" + getVentCajeroVales() + ", ventCajeroValesE=" + getVentCajeroValesE() + ", ventCajeroValesTR=" + getVentCajeroValesTR() + ", ventCajeroTC=" + getVentCajeroTC() + ", ventCajeroTGDF=" + getVentCajeroTGDF() + ", ventCajeroT3E=" + getVentCajeroT3E() + ", retCajeroEfec=" + getRetCajeroEfec() + ", ventCajeroTotal=" + getVentCajeroTotal() + ", retCajeroTotal=" + getRetCajeroTotal() + ", fondoEfectivo=" + getFondoEfectivo() + ", difCajeroEfec=" + getDifCajeroEfec() + ", tckProm=" + getTckProm() + ", operTotal=" + getOperTotal() + '}';
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
     * @return the ventCajeroEfec
     */
    public double getVentCajeroEfec() {
        return ventCajeroEfec;
    }

    /**
     * @param ventCajeroEfec the ventCajeroEfec to set
     */
    public void setVentCajeroEfec(double ventCajeroEfec) {
        this.ventCajeroEfec = ventCajeroEfec;
    }

    /**
     * @return the ventCajeroVales
     */
    public double getVentCajeroVales() {
        return ventCajeroVales;
    }

    /**
     * @param ventCajeroVales the ventCajeroVales to set
     */
    public void setVentCajeroVales(double ventCajeroVales) {
        this.ventCajeroVales = ventCajeroVales;
    }

    /**
     * @return the ventCajeroValesE
     */
    public double getVentCajeroValesE() {
        return ventCajeroValesE;
    }

    /**
     * @param ventCajeroValesE the ventCajeroValesE to set
     */
    public void setVentCajeroValesE(double ventCajeroValesE) {
        this.ventCajeroValesE = ventCajeroValesE;
    }

    /**
     * @return the ventCajeroValesTR
     */
    public double getVentCajeroValesTR() {
        return ventCajeroValesTR;
    }

    /**
     * @param ventCajeroValesTR the ventCajeroValesTR to set
     */
    public void setVentCajeroValesTR(double ventCajeroValesTR) {
        this.ventCajeroValesTR = ventCajeroValesTR;
    }

    /**
     * @return the ventCajeroTC
     */
    public double getVentCajeroTC() {
        return ventCajeroTC;
    }

    /**
     * @param ventCajeroTC the ventCajeroTC to set
     */
    public void setVentCajeroTC(double ventCajeroTC) {
        this.ventCajeroTC = ventCajeroTC;
    }

    /**
     * @return the ventCajeroTGDF
     */
    public double getVentCajeroTGDF() {
        return ventCajeroTGDF;
    }

    /**
     * @param ventCajeroTGDF the ventCajeroTGDF to set
     */
    public void setVentCajeroTGDF(double ventCajeroTGDF) {
        this.ventCajeroTGDF = ventCajeroTGDF;
    }

    /**
     * @return the ventCajeroT3E
     */
    public double getVentCajeroT3E() {
        return ventCajeroT3E;
    }

    /**
     * @param ventCajeroT3E the ventCajeroT3E to set
     */
    public void setVentCajeroT3E(double ventCajeroT3E) {
        this.ventCajeroT3E = ventCajeroT3E;
    }

    /**
     * @return the retCajeroEfec
     */
    public double getRetCajeroEfec() {
        return retCajeroEfec;
    }

    /**
     * @param retCajeroEfec the retCajeroEfec to set
     */
    public void setRetCajeroEfec(double retCajeroEfec) {
        this.retCajeroEfec = retCajeroEfec;
    }

    /**
     * @return the ventCajeroTotal
     */
    public double getVentCajeroTotal() {
        return ventCajeroTotal;
    }

    /**
     * @param ventCajeroTotal the ventCajeroTotal to set
     */
    public void setVentCajeroTotal(double ventCajeroTotal) {
        this.ventCajeroTotal = ventCajeroTotal;
    }

    /**
     * @return the retCajeroTotal
     */
    public double getRetCajeroTotal() {
        return retCajeroTotal;
    }

    /**
     * @param retCajeroTotal the retCajeroTotal to set
     */
    public void setRetCajeroTotal(double retCajeroTotal) {
        this.retCajeroTotal = retCajeroTotal;
    }

    /**
     * @return the fondoEfectivo
     */
    public double getFondoEfectivo() {
        return fondoEfectivo;
    }

    /**
     * @param fondoEfectivo the fondoEfectivo to set
     */
    public void setFondoEfectivo(double fondoEfectivo) {
        this.fondoEfectivo = fondoEfectivo;
    }

    /**
     * @return the difCajeroEfec
     */
    public double getDifCajeroEfec() {
        return difCajeroEfec;
    }

    /**
     * @param difCajeroEfec the difCajeroEfec to set
     */
    public void setDifCajeroEfec(double difCajeroEfec) {
        this.difCajeroEfec = difCajeroEfec;
    }

    /**
     * @return the tckProm
     */
    public double getTckProm() {
        return tckProm;
    }

    /**
     * @param tckProm the tckProm to set
     */
    public void setTckProm(double tckProm) {
        this.tckProm = tckProm;
    }

    /**
     * @return the operTotal
     */
    public int getOperTotal() {
        return operTotal;
    }

    /**
     * @param operTotal the operTotal to set
     */
    public void setOperTotal(int operTotal) {
        this.operTotal = operTotal;
    }

    /**
     * @return the pafecha
     */
    public String getPafecha() {
        return pafecha;
    }

    /**
     * @param pafecha the pafecha to set
     */
    public void setPafecha(String pafecha) {
        this.pafecha = pafecha;
    }

}
