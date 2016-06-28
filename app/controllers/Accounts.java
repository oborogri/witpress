package controllers;

import play.*;
import play.mvc.*;

import java.util.List;

import java.util.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import models.*;

public class Accounts extends Controller {

	/**
	 * Renders signup page
	 */
	public static void signup() {
		render();
	}

	/**
	 * Renders login page
	 */
	public static void login() {
		render();
	}
}
