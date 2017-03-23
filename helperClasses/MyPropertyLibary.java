import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyPropertyLibary {

	public static String getPropertyName(@Nonnull final String name) {
		return name.toUpperCase();
	}
	

	public static String getPropertyFileName(@Nonnull final String fileName) {
		return fileName.toLowerCase() + ".property";
	}
	
	public static File createNewPropertyFile(@Nonnull final String fileName, @Nonnull final String directory) {
		//TODO implement create new file in the given directory
		return new File("");
	}
	
	public static File createNewPropertyFile(@Nonnull final String fileName, @Nonnull final String directory, @Nonnull final String... properyName) {
		List propertys = new ArrayList<>();
		
		File file = createNewPropertyFile(fileName, directory);
		
		for(String property: properyName){
			propertys.add(getPropertyName(property));
		}
		
		if(!propertys.isEmpty()){
			// Save into new File
		}
	}
	
	
	private File createNewHiddenDirectory(@Nonnull final String directoryName, @Nonnull final String directoryPath){
		return new File(directoryPath + "/." + directoryName);
	}
	
	
	/**
	 * Laod the property from the File.
	 * @param properyName
	 * @param properyFile
	 * @return
	 */
	public static String loadProperty(@Nonnull final String properyName, @Nonnull final String properyFile) {
		
	}
	
	/**
	 * Save the String into the ProperyFile
	 * @param properyName
	 * @param properyFile
	 * @return
	 */
	public static String saveProperty(@Nonnull final String properyName, @Nonnull final String properyFile) {
		properyName = properyName.toUpperCase();
	}

	
}
