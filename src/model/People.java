package model;

<<<<<<< HEAD
import java.io.Serializable;

public class People implements Serializable{
=======
/**
 * This class contains methods, attributes,  and relations of a aliens invaders.
 * @version 1
 * @author Santiago Trochez Velasco, https://github.com/Santiagokmids <br>
 * @author Luis Miguel Ossa Arias, https://github.com/Itsumohitoride <br>
 */

public class People {
>>>>>>> a89991f4d91b14837e8954bbe593cb69e55faa90
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
