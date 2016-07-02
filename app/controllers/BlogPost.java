package controllers;

import models.Post;
import models.User;
import models.Comment;
import play.Logger;
import play.mvc.Controller;

/**
 * Class that facilitates finding and displaying a comment associated with a
 * specified post Facilitates creation of a new comment and the deletion of a
 * specified comment
 * 
 * @author Grigore Oboroceanu
 *
 */

public class BlogPost extends Controller {

	/**
	 * Finds and displays a post
	 * 
	 * @param postid
	 */
	public static void show(Long postid) {
		Logger.info("Post ID = " + postid);
		Post post = Post.findById(postid);
		render(post);
	}

	/**
	 * Facilitates adding a new comment to a specific post
	 * 
	 * @param postid
	 * @param content
	 */
	public static void newComment(Long postid, String content) {
		Logger.info("Post ID = " + postid);
		Post post = Post.findById(postid);
		Comment comment = new Comment(content);

		post.addComment(comment);
		post.save();
		show(postid);
	}

	/**
	 * Facilitates deletion of a specific comment
	 * 
	 * @param postid
	 * @param commentid
	 */

	public static void deleteComment(Long postid, Long commentid) {
		Logger.info("Post ID = " + postid);
		Comment comment = Comment.findById(commentid);
		Post post = Post.findById(postid);
		post.comments.remove(comment);
		post.save();
		show(postid);
	}
}
