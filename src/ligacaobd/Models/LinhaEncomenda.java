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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "LINHA_ENCOMENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LinhaEncomenda.findAll", query = "SELECT l FROM LinhaEncomenda l"),
    @NamedQuery(name = "LinhaEncomenda.findByIdEncomenda", query = "SELECT l FROM LinhaEncomenda l WHERE l.linhaEncomendaPK.idEncomenda = :idEncomenda"),
    @NamedQuery(name = "LinhaEncomenda.findByIdProduto", query = "SELECT l FROM LinhaEncomenda l WHERE l.linhaEncomendaPK.idProduto = :idProduto"),
    @NamedQuery(name = "LinhaEncomenda.findByQuantidade", query = "SELECT l FROM LinhaEncomenda l WHERE l.quantidade = :quantidade"),
    @NamedQuery(name = "LinhaEncomenda.findByPrecounit", query = "SELECT l FROM LinhaEncomenda l WHERE l.precounit = :precounit"),
    @NamedQuery(name = "LinhaEncomenda.findByValortotlinha", query = "SELECT l FROM LinhaEncomenda l WHERE l.valortotlinha = :valortotlinha"),
    @NamedQuery(name = "LinhaEncomenda.findByIva", query = "SELECT l FROM LinhaEncomenda l WHERE l.iva = :iva")})
public class LinhaEncomenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LinhaEncomendaPK linhaEncomendaPK;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private BigInteger quantidade;
    @Basic(optional = false)
    @Column(name = "PRECOUNIT")
    private double precounit;
    @Basic(optional = false)
    @Column(name = "VALORTOTLINHA")
    private double valortotlinha;
    @Basic(optional = false)
    @Column(name = "IVA")
    private double iva;
    @JoinColumn(name = "ID_ENCOMENDA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Encomenda encomenda;
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Encomenda encomenda1;

    public LinhaEncomenda() {
    }

    public LinhaEncomenda(LinhaEncomendaPK linhaEncomendaPK) {
        this.linhaEncomendaPK = linhaEncomendaPK;
    }

    public LinhaEncomenda(LinhaEncomendaPK linhaEncomendaPK, BigInteger quantidade, double precounit, double valortotlinha, double iva) {
        this.linhaEncomendaPK = linhaEncomendaPK;
        this.quantidade = quantidade;
        this.precounit = precounit;
        this.valortotlinha = valortotlinha;
        this.iva = iva;
    }

    public LinhaEncomenda(BigInteger idEncomenda, BigInteger idProduto) {
        this.linhaEncomendaPK = new LinhaEncomendaPK(idEncomenda, idProduto);
    }

    public LinhaEncomendaPK getLinhaEncomendaPK() {
        return linhaEncomendaPK;
    }

    public void setLinhaEncomendaPK(LinhaEncomendaPK linhaEncomendaPK) {
        this.linhaEncomendaPK = linhaEncomendaPK;
    }

    public BigInteger getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigInteger quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecounit() {
        return precounit;
    }

    public void setPrecounit(double precounit) {
        this.precounit = precounit;
    }

    public double getValortotlinha() {
        return valortotlinha;
    }

    public void setValortotlinha(double valortotlinha) {
        this.valortotlinha = valortotlinha;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public Encomenda getEncomenda1() {
        return encomenda1;
    }

    public void setEncomenda1(Encomenda encomenda1) {
        this.encomenda1 = encomenda1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linhaEncomendaPK != null ? linhaEncomendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinhaEncomenda)) {
            return false;
        }
        LinhaEncomenda other = (LinhaEncomenda) object;
        if ((this.linhaEncomendaPK == null && other.linhaEncomendaPK != null) || (this.linhaEncomendaPK != null && !this.linhaEncomendaPK.equals(other.linhaEncomendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ligacaobd.Models.LinhaEncomenda[ linhaEncomendaPK=" + linhaEncomendaPK + " ]";
    }
    
}
