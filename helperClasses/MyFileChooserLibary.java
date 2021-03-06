package helperClasses;

import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Objects;

public class MyFileChooserLibary {

    public static File showFileChooser(@Nonnull final String titel, @Nonnull final String description, @Nonnull final Modality modality, @Nonnull final String... extensions) {
        FileChooser fileChooser = new FileChooser();
        Stage fileChooserStage = new Stage();


        fileChooserStage.setTitle(titel);
        fileChooserStage.initModality(modality);

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(description, extensions);
        fileChooser.getExtensionFilters().add(extensionFilter);

        File file = fileChooser.showOpenDialog(fileChooserStage);
        if (file.equals(null)) {
            return new File("");
        }
        return file;
    }
}
