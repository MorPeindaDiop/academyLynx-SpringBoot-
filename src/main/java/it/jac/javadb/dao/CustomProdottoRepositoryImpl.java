package it.jac.javadb.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomProdottoRepositoryImpl implements CustomProdottoRepository {

	@PersistenceContext
	private EntityManager em;
	/* Annotazione utilizzata per indicare il nostro context, assimilabile a quella che abbiamo sempre visto come
	 * session. E' un gestore dell'entità, da cui possiamo creare dei criteri di filtro.
	 * Nel nostro caso non è stato implemnetato, ma è un modo per creare delle query di selezione complesse
	 * con l'utilizzo di oggetti (in questo caso l'oggetto criteria della libreria javax.persistence), senza scrivere SQL.
	 */
	
	@Override
	public boolean testConnection() {
		
		return em.isOpen();
	}

}
