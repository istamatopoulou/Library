package library.core;

/**
 * This class represents a title that is offered by the library. It does NOT
 * represent an actual copy.
 * 
 * @author istamatopoulou
 */
public class Title {
	/**
	 * A unique integer id
	 */
	private int id;
	/**
	 * The title of the offered item
	 */
	private String title;

	/**
	 * @param id
	 * @param title
	 */
	public Title(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Title [id=" + id + ", title=" + title + "]";
	}

}