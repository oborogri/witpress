package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import models.Comment;
import models.Post;
import models.User;
import play.Logger;
import play.mvc.Controller;

/**
 * Class that identifies and displays all users who have created at least one
 * blog post.
 * 
 * @author G Oboroceanu
 *
 */
public class PublicBlogDirectory extends Controller {

	/**
	 * Displays all users that have at least one blog
	 */

	public static void index() {
		ArrayList<User> usersWithBlogs = new ArrayList<User>();

		List<User> users = User.findAll();
		for (User user : users) {
			if (user.posts.size() > 0) {
				usersWithBlogs.add(user);
			}
		}
		render(usersWithBlogs);
	}
}