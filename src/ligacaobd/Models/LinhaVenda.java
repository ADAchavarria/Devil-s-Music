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
@Table(name = "LINHA_VENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LinhaVenda.findAll", query = "SELECT l FROM LinhaVenda l"),
    @NamedQuery(name = "LinhaVenda.findByIdProduto", query = "SELECT l FROM LinhaVenda l WHERE l.linhaVendaPK.idProduto = :idProduto"),
    @NamedQuery(name = "LinhaVenda.findByIdVenda", query = "SELECT l FROM LinhaVenda l WHERE l.linhaVendaPK.idVenda = :idVenda"),
    @NamedQuery(name = "LinhaVenda.findByQuantidade", query = "SELECT l FROM LinhaVenda l WHERE l.quantidade = :quantidade"),
    @NamedQuery(name = "LinhaVenda.findByPrecounit", query = "SELECT l FROM LinhaVenda l WHERE l.precounit = :precounit"),
    @NamedQuery(name = "LinhaVenda.findByValortotlinha", query = "SELECT l FROM LinhaVenda l WHERE l.valortotlinha = :valortotlinha"),
    @NamedQuery(name = "LinhaVenda.findByIva", query = "SELECT l FROM LinhaVenda l WHERE l.iva = :iva")})
public class LinhaVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LinhaVendaPK linhaVendaPK;
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
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produto;
    @JoinColumn(name = "ID_VENDA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Venda venda;

    public LinhaVenda() {
    }

    public LinhaVenda(LinhaVendaPK linhaVendaPK) {
        this.linhaVendaPK = linhaVendaPK;
    }

    public LinhaVenda(LinhaVendaPK linhaVendaPK, BigInteger quantidade, double precounit, double valortotlinha, double iva) {
        this.linhaVendaPK = linhaVendaPK;
        this.quantidade = quantidade;
        this.precounit = precounit;
        this.valortotlinha = valortotlinha;
        this.iva = iva;
    }

    public LinhaVenda(BigInteger idProduto, BigInteger idVenda) {
        this.linhaVendaPK = new LinhaVendaPK(idProduto, idVenda);
    }

    public LinhaVendaPK getLinhaVendaPK() {
        return linhaVendaPK;
    }

    public void setLinhaVendaPK(LinhaVendaPK linhaVendaPK) {
        this.linhaVendaPK = linhaVendaPK;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linhaVendaPK != null ? linhaVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinhaVenda)) {
            return false;
        }
        LinhaVenda other = (LinhaVenda) object;
        if ((this.linhaVendaPK == null && other.linhaVendaPK != null) || (this.linhaVendaPK != null && !this.linhaVendaPK.equals(other.linhaVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ligacaobd.Models.LinhaVenda[ linhaVendaPK=" + linhaVendaPK + " ]";
    }
    
}
