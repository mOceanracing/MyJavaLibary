

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

import ch.abacus.util.StringFormat;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DialogHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(DialogHandler.class);

  private static final String EMPTY = "";
  private static final String CANCEL = "Cancel";
  private static final String STACKTRACE = "Stacktrace:";
  private static final String EXCEPTION_S_S = "Exception: %s \n %s";
  private static final String ICON_PATH = "";

  /**
   * This Method generate a Information-Dialog.
   *
   * @param titelText
   * @param headerText
   * @param contentText
   * @param logContent
   */
  public static void showInfoDialog(@Nonnull final String titelText, @Nonnull final String headerText, @Nonnull final String contentText, final boolean logContent) {
    showDialog(Alert.AlertType.INFORMATION, titelText, headerText, contentText, logContent);
  }

  /**
   * This Method generate a Information-Dialog.
   *
   * @param titelText
   * @param contentText
   * @param logContent
   */
  public static void showInfoDialog(@Nonnull final String titelText, @Nonnull final String contentText, final boolean logContent) {
    showInfoDialog(titelText, EMPTY, contentText, logContent);
  }

  /**
   * This Method generate a Warning-Dialog.
   *
   * @param titelText
   * @param headerText
   * @param contentText
   * @param logContent
   */
  public static void showWarningDialog(@Nonnull String titelText, @Nonnull final String headerText, @Nonnull final String contentText, final boolean logContent) {
    showDialog(Alert.AlertType.WARNING, titelText, headerText, contentText, logContent);
  }

  /**
   * This Method generate a Warning-Dialog.
   *
   * @param titelText
   * @param contentText
   * @param logContent
   */
  public static void showWarningDialog(@Nonnull final String titelText, @Nonnull final String contentText, final boolean logContent) {
    showWarningDialog(titelText, EMPTY, contentText, logContent);
  }

  /**
   * This Method generate a Error-Dialog.
   *
   * @param titelText
   * @param headerText
   * @param contentText
   * @param logContent
   */
  public static void showErrorDialog(@Nonnull final String titelText, @Nonnull final String headerText, @Nonnull final String contentText, final boolean logContent) {
    showDialog(Alert.AlertType.ERROR, titelText, headerText, contentText, logContent);
  }

  /**
   * This Method generate a Error-Dialog.
   *
   * @param titelText
   * @param contentText
   * @param logContent
   */
  public static void showErrorDialog(@Nonnull final String titelText, @Nonnull final String contentText, final boolean logContent) {
    showErrorDialog(titelText, EMPTY, contentText, logContent);
  }

  /**
   * This Method generate a Text-Input-Dialog with a defalut-value.
   *
   * @param titelText
   * @param headerText
   * @param contentText
   * @param defaultValue
   * @param logContent
   * @return the text-entry
   */
  public static String showTextInputDialog(@Nonnull final String titelText, @Nonnull final String headerText, @Nonnull final String contentText, @Nonnull final String defaultValue, final boolean logContent) {
    final TextInputDialog dialog = new TextInputDialog(defaultValue);
    final Optional<String> result = dialog.showAndWait();

    dialog.setTitle(titelText);
    dialog.setHeaderText(headerText);
    dialog.setContentText(contentText);

    if (logContent) {
      LOGGER.info(String.format("Show Text-Input-Dialog. \n Titel: %s \n Header: %s \n Content: %s", titelText, headerText, contentText));
      if (headerText == null) {
        LOGGER.info(String.format("Show Text-Input-Dialog. \n Titel: %s \n Content: %s", titelText, contentText));
      }
    }

    dialog.showAndWait();

    return result.get();
  }

  /**
   * This Method generate a Text-Input-Dialog with a defalut-value.
   *
   * @param titelText
   * @param contentText
   * @param defaultValue
   * @param logContent
   * @return the text-entry
   */
  public static String showTextInputDialog(@Nonnull final String titelText, @Nonnull final String contentText, @Nonnull final String defaultValue, final boolean logContent) {
    return showTextInputDialog(titelText, EMPTY, contentText, defaultValue, logContent);
  }

  /**
   * This Method generate a Text-Input-Dialog with a defalut-value.
   *
   * @param titelText
   * @param contentText
   * @param logContent
   * @return the text-entry
   */
  public static String showTextInputDialog(@Nonnull final String titelText, @Nonnull final String contentText, final boolean logContent) {
    return showTextInputDialog(titelText, EMPTY, contentText, EMPTY, logContent);
  }

  /**
   * This Method generate a Confrimation-Dialog with the customization answers.
   *
   * @param titelText
   * @param headerText
   * @param contentText
   * @param buttonTextA => Text of the answers-button one
   * @param buttonTextB => Text of the answers-button two
   * @param logContent
   * @return
   */
  @Nonnull
  public static String showConfirmationDialog_A_or_B(@Nonnull final String titelText, @Nonnull final String headerText, @Nonnull final String contentText, @Nonnull final String buttonTextA, @Nonnull final String buttonTextB, final boolean logContent) {
    final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    final ButtonType buttonTypeOne = new ButtonType(buttonTextA);
    final ButtonType buttonTypeTwo = new ButtonType(buttonTextB);
    final ButtonType buttonTypeCancel = new ButtonType(CANCEL, ButtonBar.ButtonData.CANCEL_CLOSE);
    final Optional<ButtonType> result = alert.showAndWait();

    alert.setTitle(titelText);
    alert.setHeaderText(headerText);
    alert.setContentText(contentText);
    alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

    if (logContent) {
      LOGGER.info(String.format("Show Confirmation-Dialog. \n Titel: %s \n Header: %s \n Content: %s", titelText, headerText, contentText));
      if (headerText == null) {
        LOGGER.info(String.format("Show Confirmation-Dialog. \n Titel: %s \n Content: %s", titelText, contentText));
      }
    }

    return result.get().getText();
  }

  /**
   * This Method generate a Confrimation-Dialog with the customization answers.
   *
   * @param titelText
   * @param contentText
   * @param buttonTextA => Text of the answers-button one
   * @param buttonTextB => Text of the answers-button two
   * @param logContent
   * @return
   */
  @Nonnull
  public static String showConfirmationDialog_A_or_B(@Nonnull final String titelText, @Nonnull final String contentText, @Nonnull final String buttonTextA, @Nonnull final String buttonTextB, final boolean logContent) {
    return showConfirmationDialog_A_or_B(titelText, EMPTY, contentText, buttonTextA, buttonTextB, logContent);
  }

  /**
   * Show the Choice-Dialog with the values of the given list.
   *
   * @param titelText
   * @param headerText
   * @param contentText
   * @param logContent
   * @param values
   * @return
   */
  @Nonnull
  public static String showChoiceDialog(@Nonnull final String titelText, @Nonnull final String headerText, @Nonnull final String contentText, final boolean logContent, @Nonnull final List<String> values) {
    final ChoiceDialog<String> dialog = new ChoiceDialog(values.get(0), values);
    Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();

    dialog.setTitle(titelText);
    dialog.setHeaderText(headerText);
    dialog.setContentText(contentText);

    stage = addIcon(stage);

    if (logContent) {
      LOGGER.info(String.format("Show Choice-Dialog. \n Titel: %s \n Header: %s \n Content: %s", titelText, headerText, contentText));
      if (headerText == null) {
        LOGGER.info(String.format("Show Choice-Dialog. \n Titel: %s \n Content: %s", titelText, contentText));
      }
    }

    return dialog.showAndWait().orElse(EMPTY);
  }

  /**
   * Show the Choice-Dialog with the values of the given list.
   *
   * @param titelText
   * @param contentText
   * @param logContent
   * @param values
   * @return
   */
  @Nonnull
  public static String showChoiceDialog(@Nonnull final String titelText, @Nonnull final String contentText, final boolean logContent, @Nonnull final List<String> values) {
    return showChoiceDialog(titelText, EMPTY, contentText, logContent, values);
  }

  /**
   * This Method generate a Exception-Dialog with stacktrace.
   *
   * @param titelText
   * @param headerText
   * @param contentText
   * @param exceptionMessage
   * @param logContent
   */
  @Nonnull
  public static void showExceptionDialog(@Nonnull final String titelText, @Nonnull final String headerText, @Nonnull final Exception exception, final boolean logContent) {
    final Alert alert = new Alert(Alert.AlertType.ERROR);
    final Label label = new Label(STACKTRACE);
    final TextArea textArea = new TextArea(StringFormat.getStackTrace(exception));
    final GridPane expContent = new GridPane();
    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

    alert.setTitle(titelText);
    alert.setHeaderText(headerText);
    alert.setContentText(exception.getMessage());

    stage = addIcon(stage);

    textArea.setEditable(false);
    textArea.setWrapText(true);

    textArea.setMaxWidth(Double.MAX_VALUE);
    textArea.setMaxHeight(Double.MAX_VALUE);
    GridPane.setVgrow(textArea, Priority.ALWAYS);
    GridPane.setHgrow(textArea, Priority.ALWAYS);

    expContent.setMaxWidth(Double.MAX_VALUE);
    expContent.add(label, 0, 0);
    expContent.add(textArea, 0, 1);

    alert.getDialogPane().setExpandableContent(expContent);

    if (logContent) {
      LOGGER.info(String.format("Show Exception-Dialog. \n Titel: %s \n Header: %s \n StackTrace: %s", titelText, headerText, StringFormat.getStackTrace(exception)));
      if (headerText == null) {
        LOGGER.info(String.format("Show Exception-Dialog. \n Titel: %s \n StackTrace: %s", titelText, StringFormat.getStackTrace(exception)));
      }
    }

    alert.showAndWait();
  }

  /**
   * This Method generate a Dialog from the given AlertType.
   *
   * @param alertType
   * @param titelText
   * @param headerText
   * @param contentText
   * @param logContent
   */
  @Nonnull
  public static void showDialog(@Nonnull final Alert.AlertType alertType, @Nonnull final String titelText, @Nonnull final String headerText, @Nonnull final String contentText, final boolean logContent) {
    final Alert alert = new Alert(alertType);
    alert.setTitle(titelText);
    alert.setHeaderText(headerText);
    alert.setContentText(contentText);

    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    stage = addIcon(stage);

    if (logContent) {
      LOGGER.info(String.format("Show %s-Dialog. \n Titel: %s \n Header: %s \n Content: %s", alertType, titelText, headerText, contentText));
      if (headerText == null) {
        LOGGER.info(String.format("Show %s-Dialog. \n Titel: %s \n Content: %s", alertType, titelText, contentText));
      }
    }

    alert.showAndWait();
  }

  //Helper methods
  @Nonnull
  private static Stage addIcon(@Nonnull final Stage stage) {
    if (!ICON_PATH.isEmpty()) {
      stage.getIcons().add(new Image(DialogHandler.class.getResource(ICON_PATH).toString()));
    }
    return stage;
  }
}
