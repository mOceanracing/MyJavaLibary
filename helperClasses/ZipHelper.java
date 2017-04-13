
import javax.annotation.Nonnull;
import java.io.File;
import java.util.ArrayList;

import ch.abacus.util.Consts;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Need this Maven-dependency
 *
 * <dependency>
 * <groupId>org.apache.commons</groupId>
 * <artifactId>commons-compress</artifactId>
 * <version>1.13</version>
 * </dependency>
 */
public class ZipFileHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(ZipFileHandler.class);
  private static final String FILE_EXTENSION_ZIP = ".zip";
  private static final String SLASH = "/";
  private static final String SLASH_DOT = "/.";

  public static ZipFile zipFile(@Nonnull final String targetDirectoryOfZipFile, @Nonnull final String nameOfZIPFile, @Nonnull final File... contentForZipFile) throws Exception {
    ZipFile zipFile = new ZipFile(targetDirectoryOfZipFile + "/" + nameOfZIPFile + FILE_EXTENSION_ZIP);

    ArrayList filesToAdd = new ArrayList();
    for (File file : contentForZipFile) {
      filesToAdd.add(file);
    }

    ZipParameters parameters = new ZipParameters();
    parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
    parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

    zipFile.addFiles(filesToAdd, parameters);
    return zipFile;
  }

  public static void unZipFile(@Nonnull final String filePath, @Nonnull final String destination, @Nonnull final String nameOfHiddenFolder) throws Exception {
    final File source = new File(filePath);
    if (!existHiddenFolder(nameOfHiddenFolder)) {
      createHiddenFolder(nameOfHiddenFolder);
    } else {
      clearHiddenFolder(nameOfHiddenFolder);
    }

    try {
      ZipFile zipFile = new ZipFile(source);
      zipFile.extractAll(destination);
    } catch (ZipException e) {
      LOGGER.error(e.getMessage());
      LOGGER.info(Consts.UNZIP_WAS_FAILED);
    }
    LOGGER.info(Consts.UNZIP_WAS_SUCCESSFUL);
  }

  private static boolean existHiddenFolder(@Nonnull final String nameOfHiddenFolder) {
    if (new File(Consts.USER_HOME + SLASH + nameOfHiddenFolder).exists()) {
      return true;
    }
    return false;
  }

  private static void createHiddenFolder(@Nonnull final String nameOfHiddenFolder) {
    new File(Consts.USER_HOME + SLASH_DOT + nameOfHiddenFolder).mkdir();
  }

  private static void clearHiddenFolder(@Nonnull final String nameOfHiddenFolder) {
    File[] files = new File(Consts.USER_HOME + SLASH_DOT + nameOfHiddenFolder).listFiles();
    for (File file : files) {
      file.delete();
    }
  }
}
