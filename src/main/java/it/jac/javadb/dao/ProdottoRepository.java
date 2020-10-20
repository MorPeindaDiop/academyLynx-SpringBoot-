package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.Prodotto;

@Repository
public interface ProdottoRepository extends CrudRepository<Prodotto, Integer>, CustomProdottoRepository {}
/* Dopo aver creato le nostre entità e i nostri DTO (Data Transfer Object), passiamo alla creazione dell'interfaccia
 * annotata come @Repository, che è il livello più basso della nostra applicazione,
 * che spring interprerà come quella utilizzata per la connessione al DB.
 * Questa interfaccia estende la CrudRepository, che è una delle interfacce che si possono estendere (oltre,
 * ad esempio, alla JpaRepository). Queste interfacce contengono metodi di ricerca già implementati, come 
 * ad esempio cancellazione, totale, tramite PK, ecc.
 * Questo è il motivo per cui non è stato creato alcun metodo in questa interfaccia, perchè estende
 * CrudRepository (CRUD --> Create - Read - Update - Delete)
 * 
 * I due parametri passati sono la tipologia dell'entità e la tipologia della chiave primaria, per fare in modo
 * che i metodi richiamati rispettino eventuali PK.
 */