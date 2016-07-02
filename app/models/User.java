package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.jpa.Model;
import play.Logger;
import play.db.jpa.Blob;

import java.util.List;
import java.util.ArrayList;

/**
 * Class that creates User objects Facilitates associating specific posts with
 * user
 * 
 * @author G. Oboroceanu
 *
 */
@Entity
public class User extends Model {
	public String firstName;
	public String lastName;
	public String email;
	public String password;

	@OneToMany(cascade = CascadeType.ALL)
	public List<Post> posts;

	/**
	 * Constructor for user object
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 */
	public User(String firstName, String lastName, String email, String password) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;

	}

	/**
	 * Facilitates adding specific post to user posts list
	 * 
	 * @param post
	 */
	public void addPost(Post post) {
		posts.add(post);
	}

	/**
	 * Facilitates identifying a user by their e-mail
	 * 
	 * @param email
	 * @return user
	 */
	public static User findByEmail(String email) {
		return find("email", email).first();
	}

	/**
	 * Validates user password
	 * 
	 * @param password
	 * @return true if password match
	 */
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

	/**
	 * Overrides toString method returns user first name
	 */
	public String toString() {
		return firstName;
	}

	/**
	 * Facilitates writing user full name
	 * 
	 * @return user full name
	 */

	public String getName() {

		String userName = this.firstName + " " + this.lastName;
		return userName;

	}
}