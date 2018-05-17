/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligacaobd.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "UTILIZADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilizador.findAll", query = "SELECT u FROM Utilizador u"),
    @NamedQuery(name = "Utilizador.findById", query = "SELECT u FROM Utilizador u WHERE u.id = :id"),
    @NamedQuery(name = "Utilizador.findByUsername", query = "SELECT u FROM Utilizador u WHERE u.username = :username"),
    @NamedQuery(name = "Utilizador.findByPassword", query = "SELECT u FROM Utilizador u WHERE u.password = :password"),
    @NamedQuery(name = "Utilizador.findByEmail", query = "SELECT u FROM Utilizador u WHERE u.email = :email"),
    @NamedQuery(name = "Utilizador.findByTelefone", query = "SELECT u FROM Utilizador u WHERE u.telefone = :telefone"),
    @NamedQuery(name = "Utilizador.findByLocalidade", query = "SELECT u FROM Utilizador u WHERE u.localidade = :localidade"),
    @NamedQuery(name = "Utilizador.findByCodigopostal", query = "SELECT u FROM Utilizador u WHERE u.codigopostal = :codigopostal")})
public class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "TELEFONE")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "LOCALIDADE")
    private String localidade;
    @Basic(optional = false)
    @Column(name = "CODIGOPOSTAL")
    private BigInteger codigopostal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilizador", fetch = FetchType.LAZY)
    private List<Venda> vendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtili", fetch = FetchType.LAZY)
    private List<Encomenda> encomendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtili", fetch = FetchType.LAZY)
    private List<Tipoutilizador> tipoutilizadorList;

    public Utilizador() {
    }

    public Utilizador(BigDecimal id) {
        this.id = id;
    }

    public Utilizador(BigDecimal id, String username, String password, String email, String telefone, String localidade, BigInteger codigopostal) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telefone = telefone;
        this.localidade = localidade;
        this.codigopostal = codigopostal;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public BigInteger getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(BigInteger codigopostal) {
        this.codigopostal = codigopostal;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @XmlTransient
    public List<Encomenda> getEncomendaList() {
        return encomendaList;
    }

    public void setEncomendaList(List<Encomenda> encomendaList) {
        this.encomendaList = encomendaList;
    }

    @XmlTransient
    public List<Tipoutilizador> getTipoutilizadorList() {
        return tipoutilizadorList;
    }

    public void setTipoutilizadorList(List<Tipoutilizador> tipoutilizadorList) {
        this.tipoutilizadorList = tipoutilizadorList;
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
        if (!(object instanceof Utilizador)) {
            return false;
        }
        Utilizador other = (Utilizador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ligacaobd.Models.Utilizador[ id=" + id + " ]";
    }
    
}
