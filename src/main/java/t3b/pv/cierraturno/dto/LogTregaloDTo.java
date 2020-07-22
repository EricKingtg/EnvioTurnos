/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 20/12/2018
 *
 */
package t3b.pv.cierraturno.dto;

public class LogTregaloDTo {

    public int log_id;
    public int log_server_id;
    public int user_id;
    public int tarjeta_id;
    public String tarjeta_num;
    public String tienda;
    public String caja;
    public int num_ticket;
    public String fech;
    public float monto;
    public String atmdesc;
    public String nc_envio;
    public String nc_recibo;
    public String ip_local;
    public String ip_trans;
    public int st_sldo;
    public int st_nce;
    public int st_ncr;
    public int st_server;
    public int idturno;

    @Override
    public String toString() {
        return "LogTregaloDTo{" + "log_id=" + log_id + ", log_server_id=" + log_server_id + ", user_id=" + user_id + ", tarjeta_id=" + tarjeta_id + ", tarjeta_num=" + tarjeta_num + ", tienda=" + tienda + ", caja=" + caja + ", num_ticket=" + num_ticket + ", fech=" + fech + ", monto=" + monto + ", atmdesc=" + atmdesc + ", nc_envio=" + nc_envio + ", nc_recibo=" + nc_recibo + ", ip_local=" + ip_local + ", ip_trans=" + ip_trans + ", st_sldo=" + st_sldo + ", st_nce=" + st_nce + ", st_ncr=" + st_ncr + ", st_server=" + st_server + ", idturno=" + idturno + '}';
    }

    /**
     * @return the log_id
     */
    public int getLog_id() {
        return log_id;
    }

    /**
     * @param log_id the log_id to set
     */
    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    /**
     * @return the log_server_id
     */
    public int getLog_server_id() {
        return log_server_id;
    }

    /**
     * @param log_server_id the log_server_id to set
     */
    public void setLog_server_id(int log_server_id) {
        this.log_server_id = log_server_id;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the tarjeta_id
     */
    public int getTarjeta_id() {
        return tarjeta_id;
    }

    /**
     * @param tarjeta_id the tarjeta_id to set
     */
    public void setTarjeta_id(int tarjeta_id) {
        this.tarjeta_id = tarjeta_id;
    }

    /**
     * @return the tarjeta_num
     */
    public String getTarjeta_num() {
        return tarjeta_num;
    }

    /**
     * @param tarjeta_num the tarjeta_num to set
     */
    public void setTarjeta_num(String tarjeta_num) {
        this.tarjeta_num = tarjeta_num;
    }

    /**
     * @return the tienda
     */
    public String getTienda() {
        return tienda;
    }

    /**
     * @param tienda the tienda to set
     */
    public void setTienda(String tienda) {
        this.tienda = tienda;
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
     * @return the monto
     */
    public float getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(float monto) {
        this.monto = monto;
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
     * @return the nc_envio
     */
    public String getNc_envio() {
        return nc_envio;
    }

    /**
     * @param nc_envio the nc_envio to set
     */
    public void setNc_envio(String nc_envio) {
        this.nc_envio = nc_envio;
    }

    /**
     * @return the nc_recibo
     */
    public String getNc_recibo() {
        return nc_recibo;
    }

    /**
     * @param nc_recibo the nc_recibo to set
     */
    public void setNc_recibo(String nc_recibo) {
        this.nc_recibo = nc_recibo;
    }

    /**
     * @return the ip_local
     */
    public String getIp_local() {
        return ip_local;
    }

    /**
     * @param ip_local the ip_local to set
     */
    public void setIp_local(String ip_local) {
        this.ip_local = ip_local;
    }

    /**
     * @return the ip_trans
     */
    public String getIp_trans() {
        return ip_trans;
    }

    /**
     * @param ip_trans the ip_trans to set
     */
    public void setIp_trans(String ip_trans) {
        this.ip_trans = ip_trans;
    }

    /**
     * @return the st_sldo
     */
    public int getSt_sldo() {
        return st_sldo;
    }

    /**
     * @param st_sldo the st_sldo to set
     */
    public void setSt_sldo(int st_sldo) {
        this.st_sldo = st_sldo;
    }

    /**
     * @return the st_nce
     */
    public int getSt_nce() {
        return st_nce;
    }

    /**
     * @param st_nce the st_nce to set
     */
    public void setSt_nce(int st_nce) {
        this.st_nce = st_nce;
    }

    /**
     * @return the st_ncr
     */
    public int getSt_ncr() {
        return st_ncr;
    }

    /**
     * @param st_ncr the st_ncr to set
     */
    public void setSt_ncr(int st_ncr) {
        this.st_ncr = st_ncr;
    }

    /**
     * @return the st_server
     */
    public int getSt_server() {
        return st_server;
    }

    /**
     * @param st_server the st_server to set
     */
    public void setSt_server(int st_server) {
        this.st_server = st_server;
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
