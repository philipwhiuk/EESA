package eesa.file;
/**
 * Abstract class representing a file loader
 * @author Philip Whitehouse
 *
 */
public interface FileLoader {
	/**
	 * 
	 * @param ext Extension
	 * @return whether the loader supports that extension
	 */
	boolean canLoad(String ext);
	/**
	 * 
	 * @param file File
	 * @return The loaded file
	 */
	File loadFile(java.io.File file);

}
