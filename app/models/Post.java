package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Lob;
import play.db.jpa.Model;
import java.util.List;

/**
 * Class that facilitates creating Post objects
 * 
 * @author Grigore Oboroceanu
 *
 */
@Entity
public class Post extends Model {
	public String title;
	@Lob
	public String content;

	@OneToMany(cascade = CascadeType.ALL)
	public List<Comment> comments;

	/**
	 * Creates post object that concludes title and content
	 * 
	 * @param title
	 * @param content
	 */
	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}

	/**
	 * Facilitates associating a specific comment to a post object
	 * 
	 * @param comment
	 */
	public void addComment(Comment comment) {
		comments.add(comment);
	}

	/**
	 * Overrides post toString method returns post title
	 * 
	 */
	public String toString() {
		return title;
	}
}