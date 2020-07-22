/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 19/12/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class MovEncDto {

    public long vendedores;
    public float total;
    public long operaciones;
    public String tclave;
    public String caja;
    public int idturno;
    public String atmfecha;

    @Override
    public String toString() {
        return "MovEncDto{" + "vendedores=" + vendedores + ", total=" + total + ", operaciones=" + operaciones + ", tclave=" + tclave + ", caja=" + caja + ", idturno=" + idturno + ", atmfecha=" + atmfecha + '}';
    }

    /**
     * @return the vendedores
     */
    public long getVendedores() {
        return vendedores;
    }

    /**
     * @param vendedores the vendedores to set
     */
    public void setVendedores(long vendedores) {
        this.vendedores = vendedores;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the operaciones
     */
    public long getOperaciones() {
        return operaciones;
    }

    /**
     * @param operaciones the operaciones to set
     */
    public void setOperaciones(long operaciones) {
        this.operaciones = operaciones;
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
