package it.jac.javadb.entity;

/* Bean utilizzato per create la tabella user_activity, che terrà il registro di tutte le richieste http, 
 * includenso sia quelle di modifica del db, sia quelle di semplice lettura, riposrtando una breve descrizione e 
 * l'utente che ha effettuato l'attività con relativa ora
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user_activity")
public class UserActivity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "activity_desc", length = 50)
	private String activityDesc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "activity_time")
	private Date activityTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getActivityDesc() {
		return activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}

	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

}
