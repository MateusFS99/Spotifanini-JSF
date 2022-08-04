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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mateus
 */
@Entity
@Table(name = "musicplaylist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musicplaylist.findAll", query = "SELECT m FROM Musicplaylist m")
    , @NamedQuery(name = "Musicplaylist.findById", query = "SELECT m FROM Musicplaylist m WHERE m.id = :id")})
public class Musicplaylist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_music", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Music idMusic;
    @JoinColumn(name = "id_playlist", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Playlist idPlaylist;

    public Musicplaylist() {
    }

    public Musicplaylist(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Music getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(Music idMusic) {
        this.idMusic = idMusic;
    }

    public Playlist getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Playlist idPlaylist) {
        this.idPlaylist = idPlaylist;
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
        if (!(object instanceof Musicplaylist)) {
            return false;
        }
        Musicplaylist other = (Musicplaylist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Musicplaylist[ id=" + id + " ]";
    }
    
}
