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
public class LinhaVendaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_PRODUTO")
    private BigInteger idProduto;
    @Basic(optional = false)
    @Column(name = "ID_VENDA")
    private BigInteger idVenda;

    public LinhaVendaPK() {
    }

    public LinhaVendaPK(BigInteger idProduto, BigInteger idVenda) {
        this.idProduto = idProduto;
        this.idVenda = idVenda;
    }

    public BigInteger getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(BigInteger idProduto) {
        this.idProduto = idProduto;
    }

    public BigInteger getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(BigInteger idVenda) {
        this.idVenda = idVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        hash += (idVenda != null ? idVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinhaVendaPK)) {
            return false;
        }
        LinhaVendaPK other = (LinhaVendaPK) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        if ((this.idVenda == null && other.idVenda != null) || (this.idVenda != null && !this.idVenda.equals(other.idVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ligacaobd.Models.LinhaVendaPK[ idProduto=" + idProduto + ", idVenda=" + idVenda + " ]";
    }
    
}
