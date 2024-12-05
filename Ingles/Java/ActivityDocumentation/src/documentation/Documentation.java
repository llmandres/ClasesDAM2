package documentation;

public class Documentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	
	/*
	 * This function verifies if the user and password introduced are registered in the system
	 * 
	 * It will return true in case the information introduced is valid. Will return false if the 
	 * password or user do not meet the requirements or if they are not valid.
	 */
	public boolean checkCredentials (String username, String password) { 	
	if (username.length() < 3 || password.length() <6) { 
	return false; // The username is less than 3 characters OR the password is less than 6 characters
	}
	if (username.equals("admin") && password.equals("admin123")) {
	return true; // Access to system successfully
	} 
	else {
	return false; // Denied Access / Wrong password or username
	}
}
	
	/**
	 * This method register a user using the information received by input parameters if the
	 * information meets the requirements.
	 * 
	 * A user will not be registered when
	 * - The email is empty OR the email does not contain a "@".
	 * - The password length is less than 8 characters.
	 * 
	 * If the information received meets the requirements will register successfully
	 * 
	 * @param email , a String that must not be empty or must contain "@"
	 * @param password, a String that must be above 8 characters length.
	 * 
	 * @return This method will return 
	 * - "User registered successfully." - In case the information received meets the requirement.
	 * - "Invalid email address." - In case the email received by input does not meet the requirements.
	 * - "Password must be at least 8 characters." - In case the password received by input does not meet 
	 * 												 the requirements.
	 */
	public String registerUser(String email, String password) {
		if (email.isEmpty() || !email.contains("@")) {
			return "Invalid email address.";
		}
		if (password.length() < 8) {
			return "Password must be at least 8 characters.";
		}
		return "User registered successfully.";

	}
}
