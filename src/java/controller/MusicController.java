package controller;

import dao.Music;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import bean.MusicFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("musicController")
@SessionScoped
public class MusicController implements Serializable {

    @EJB
    private bean.MusicFacade ejbFacade;
    private List<Music> items = null;
    private Music selected;

    public MusicController() {
    }

    public Music getSelected() {
        return selected;
    }

    public void setSelected(Music selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MusicFacade getFacade() {
        return ejbFacade;
    }

    public Music prepareCreate() {
        selected = new Music();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        
        boolean flag = true;
        
        for(Music music : ejbFacade.findAll())
            if(music.getName().equals(selected.getName()) && music.getArtist().getId() == selected.getArtist().getId())
                flag = false;
        if(flag) {
            
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MusicCreated"));
            if(!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
        } 
        else
            JsfUtil.addErrorMessage("Música já Cadastrada!!");
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MusicUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MusicDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Music> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Music getMusic(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Music> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Music> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Music.class)
    public static class MusicControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MusicController controller = (MusicController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "musicController");
            return controller.getMusic(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Music) {
                Music o = (Music) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Music.class.getName()});
                return null;
            }
        }

    }

}
