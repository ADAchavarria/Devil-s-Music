/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligacaobd.Models;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ricar
 */
@Embeddable
public class LinhaEncomendaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_ENCOMENDA")
    private BigInteger idEncomenda;
    @Basic(optional = false)
    @Column(name = "ID_PRODUTO")
    private BigInteger idProduto;

    public LinhaEncomendaPK() {
    }

    public LinhaEncomendaPK(BigInteger idEncomenda, BigInteger idProduto) {
        this.idEncomenda = idEncomenda;
        this.idProduto = idProduto;
    }

    public BigInteger getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(BigInteger idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public BigInteger getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(BigInteger idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncomenda != null ? idEncomenda.hashCode() : 0);
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinhaEncomendaPK)) {
            return false;
        }
        LinhaEncomendaPK other = (LinhaEncomendaPK) object;
        if ((this.idEncomenda == null && other.idEncomenda != null) || (this.idEncomenda != null && !this.idEncomenda.equals(other.idEncomenda))) {
            return false;
        }
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ligacaobd.Models.LinhaEncomendaPK[ idEncomenda=" + idEncomenda + ", idProduto=" + idProduto + " ]";
    }
    
}
