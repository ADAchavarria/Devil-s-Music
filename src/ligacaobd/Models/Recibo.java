/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligacaobd.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "RECIBO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recibo.findAll", query = "SELECT r FROM Recibo r"),
    @NamedQuery(name = "Recibo.findById", query = "SELECT r FROM Recibo r WHERE r.id = :id"),
    @NamedQuery(name = "Recibo.findByData", query = "SELECT r FROM Recibo r WHERE r.data = :data"),
    @NamedQuery(name = "Recibo.findByValor", query = "SELECT r FROM Recibo r WHERE r.valor = :valor"),
    @NamedQuery(name = "Recibo.findByNif", query = "SELECT r FROM Recibo r WHERE r.nif = :nif")})
public class Recibo implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "VALOR")
    private double valor;
    @Basic(optional = false)
    @Column(name = "NIF")
    private BigInteger nif;
    @JoinColumn(name = "ID_FATURA", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fatura idFatura;

    public Recibo() {
    }

    public Recibo(BigDecimal id) {
        this.id = id;
    }

    public Recibo(BigDecimal id, Date data, double valor, BigInteger nif) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.nif = nif;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public BigInteger getNif() {
        return nif;
    }

    public void setNif(BigInteger nif) {
        this.nif = nif;
    }

    public Fatura getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(Fatura idFatura) {
        this.idFatura = idFatura;
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
        if (!(object instanceof Recibo)) {
            return false;
        }
        Recibo other = (Recibo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ligacaobd.Models.Recibo[ id=" + id + " ]";
    }
    
}
