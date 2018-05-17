/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligacaobd.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "TIPOUTILIZADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoutilizador.findAll", query = "SELECT t FROM Tipoutilizador t"),
    @NamedQuery(name = "Tipoutilizador.findById", query = "SELECT t FROM Tipoutilizador t WHERE t.id = :id"),
    @NamedQuery(name = "Tipoutilizador.findByTipo", query = "SELECT t FROM Tipoutilizador t WHERE t.tipo = :tipo")})
public class Tipoutilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @JoinColumn(name = "ID_UTILI", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Utilizador idUtili;

    public Tipoutilizador() {
    }

    public Tipoutilizador(BigDecimal id) {
        this.id = id;
    }

    public Tipoutilizador(BigDecimal id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Utilizador getIdUtili() {
        return idUtili;
    }

    public void setIdUtili(Utilizador idUtili) {
        this.idUtili = idUtili;
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
        if (!(object instanceof Tipoutilizador)) {
            return false;
        }
        Tipoutilizador other = (Tipoutilizador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ligacaobd.Models.Tipoutilizador[ id=" + id + " ]";
    }
    
}
