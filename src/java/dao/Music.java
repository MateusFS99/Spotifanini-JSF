/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mateus
 */
@Entity
@Table(name = "music")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Music.findAll", query = "SELECT m FROM Music m")
    , @NamedQuery(name = "Music.findById", query = "SELECT m FROM Music m WHERE m.id = :id")
    , @NamedQuery(name = "Music.findByName", query = "SELECT m FROM Music m WHERE m.name = :name")
    , @NamedQuery(name = "Music.findByRelease", query = "SELECT m FROM Music m WHERE m.release = :release")
    , @NamedQuery(name = "Music.findByGenre", query = "SELECT m FROM Music m WHERE m.genre = :genre")})
public class Music implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "name")
    private String name;
    @Size(max = 4)
    @Column(name = "release")
    private String release;
    @Size(max = 40)
    @Column(name = "genre")
    private String genre;
    @JoinColumn(name = "artist", referencedColumnName = "id")
    @ManyToOne
    private Artist artist;

    public Music() {
    }

    public Music(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
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
        if (!(object instanceof Music)) {
            return false;
        }
        Music other = (Music) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Music[ id=" + id + " ]";
    }
    
}
