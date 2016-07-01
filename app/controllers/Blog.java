package controllers;

import java.util.List;
import models.Post;
import models.User;
import play.Logger;
import play.mvc.Controller;
import java.util.Collections;
import java.util.ArrayList;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import models.*;

/**
 * Class to facilitate the display of list of posts, facilitate the creation of a new post and the deletion of a specified post
 * 
 * @author Grigore Oboroceanu
 *
 */
public class Blog extends Controller {

	/**
	 * Finds and displays a comment associated with a specified post
	 * Renders user and posts to the index page 
	 */
	public static void index() {
		User user = Accounts.getLoggedInUser();
	    List<Post> reversePosts  = new ArrayList<Post> (user.posts);
	    Collections.reverse(reversePosts);
	    render(user, reversePosts);
	  }
	
	/**
	 * Facilitates creation of a new post by user 
	 * 
	 * @param post title
	 * @param post content
	 */
	
	 public static void newPost(String title, String content)
	  {
	    User user = Accounts.getLoggedInUser();

	    Post post = new Post (title, content);
	    user.addPost(post);
	    user.save();

	    Logger.info ("title:" + title + " content:" + content);
	    index();
	  }
	 
	 /**
	  * Facilitates deletion of a post by its Id
	  *  
	  * @param postid
	  */
	 public static void deletePost(Long postid)
	  {    
	    User user = Accounts.getLoggedInUser(); 

	    Post post = Post.findById(postid);
	    user.posts.remove(post);

	    user.save();
	    post.delete();

	    index();
	  }
	}
