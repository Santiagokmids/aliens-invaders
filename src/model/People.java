package model;

/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class People {
	
	private String name;
	
	/**
	 * <b>name:</b> People. <br>
	 * Create an object people. <br>
	 * <b>post:</b> An object people has created. <br> 
	 * @param name is the name of the people. name != "" y name != null.
	 */

	public People(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
