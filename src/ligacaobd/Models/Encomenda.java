/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligacaobd.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "ENCOMENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encomenda.findAll", query = "SELECT e FROM Encomenda e"),
    @NamedQuery(name = "Encomenda.findById", query = "SELECT e FROM Encomenda e WHERE e.id = :id"),
    @NamedQuery(name = "Encomenda.findByData", query = "SELECT e FROM Encomenda e WHERE e.data = :data")})
public class Encomenda implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "ID_FORNECEDOR", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fornecedor idFornecedor;
    @JoinColumn(name = "ID_UTILI", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Utilizador idUtili;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encomenda", fetch = FetchType.LAZY)
    private List<LinhaEncomenda> linhaEncomendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encomenda1", fetch = FetchType.LAZY)
    private List<LinhaEncomenda> linhaEncomendaList1;

    public Encomenda() {
    }

    public Encomenda(BigDecimal id) {
        this.id = id;
    }

    public Encomenda(BigDecimal id, Date data) {
        this.id = id;
        this.data = data;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Utilizador getIdUtili() {
        return idUtili;
    }

    public void setIdUtili(Utilizador idUtili) {
        this.idUtili = idUtili;
    }

    @XmlTransient
    public List<LinhaEncomenda> getLinhaEncomendaList() {
        return linhaEncomendaList;
    }

    public void setLinhaEncomendaList(List<LinhaEncomenda> linhaEncomendaList) {
        this.linhaEncomendaList = linhaEncomendaList;
    }

    @XmlTransient
    public List<LinhaEncomenda> getLinhaEncomendaList1() {
        return linhaEncomendaList1;
    }

    public void setLinhaEncomendaList1(List<LinhaEncomenda> linhaEncomendaList1) {
        this.linhaEncomendaList1 = linhaEncomendaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encomenda)) {
            return false;
        }
        Encomenda other = (Encomenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ligacaobd.Models.Encomenda[ id=" + id + " ]";
    }
    
}
