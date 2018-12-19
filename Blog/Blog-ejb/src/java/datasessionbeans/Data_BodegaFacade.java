package datasessionbeans;

import data.Bodega;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Data_BodegaFacade extends Data_AbstractFacade<Bodega> implements Data_BodegaFacadeLocal {

    @PersistenceContext(unitName = "Blog-ejbPU")

    private EntityManager em;

    public Data_BodegaFacade() {
        super(Bodega.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(Bodega bodega) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Bodega bodega) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Bodega bodega) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bodega find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bodega> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bodega> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
