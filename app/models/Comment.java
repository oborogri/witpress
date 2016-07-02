package models;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

/**
 * Class that facilitates creating Comment objects
 * 
 * @author Grigore O
 *
 */
@Entity
public class Comment extends Model {
	public String content;

	/**
	 * Constructor for Comment objects
	 * 
	 * @param content
	 */
	public Comment(String content) {
		this.content = content;
	}
}
