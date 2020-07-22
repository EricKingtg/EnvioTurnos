/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 11/02/2019
 *
 */
package t3b.pv.cierraturno.dto;

public class DevolucionesEncabezado {

    public int folio;
    public String atmfecha;
    public int estatus;
    public int idturno;

    @Override
    public String toString() {
        return "DevolucionesEncabezado{" + "folio=" + getFolio() + ", atmfecha=" + getAtmfecha() + ", estatus=" + getEstatus() + ", idturno=" + getIdturno() + '}';
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
