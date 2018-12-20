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
}
