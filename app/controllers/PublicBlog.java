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
 * Class that facilitates displaying posts and associated comments
 * 
 * @author G Oboroceanu
 *
 */

public class PublicBlog extends Controller {

	/**
	 * Displays posts from an associated logged in user id
	 * 
	 * @param id
	 */
	public static void show(Long id) {
		Logger.info("Request to show blogs for user id: " + id);
		User user = User.findById(id);
		List<Post> reversePosts = new ArrayList<Post>(user.posts);
		Collections.reverse(reversePosts);

		User loggedInUser = null;
		if (session.contains("logged_in_userid")) {
			String userId = session.get("logged_in_userid");
			loggedInUser = User.findById(Long.parseLong(userId));
		}
		render(user, loggedInUser, reversePosts);
	}

	/**
	 * Facilitates creating new comment
	 * 
	 * @param postid
	 * @param userID
	 * @param loggedInUserID
	 * @param content
	 */
	public static void newComment(Long postid, Long userID, Long loggedInUserID, String content) {
		Logger.info("Post ID = " + postid);
		Post post = Post.findById(postid);
		Comment comment = new Comment(content);

		post.addComment(comment);
		post.save();
		show(userID);
	}
}
