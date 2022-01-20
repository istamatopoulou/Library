

/**
 * This class represents a journal that is offered by the library.
 * (i.e. the existence of a journal, not an actual copy).
 * The class extends the Title class (a journal is a kind of title offered by the library)
 * @see Title
 * @author istamatopoulou
 */
public class Journal extends Title {
	private String editor;

	/**
	 * @param id
	 * @param title
	 * @param editor
	 */
	public Journal(int id, String title, String editor) {
		super(id, title);
		this.editor = editor;
	}

	public String getEditor() {
		return editor;
	}

	@Override
	public String toString() {
		return "Journal [editor=" + editor + ", " + super.toString()
				+ "]";
	}

}