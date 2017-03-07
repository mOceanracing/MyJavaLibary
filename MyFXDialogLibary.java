public class MyFXDialogLibary {
    /**
   * This Method generate a Information-Dialog with a header-text.
   * @param titelText
   * @param headerText
   * @param contentText
   */
  public static void showInfoDialog(String titelText, String headerText, String contentText) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(titelText);
    alert.setHeaderText(headerText);
    alert.setContentText(contentText);

    alert.showAndWait();
  }

  /**
   * This Method generate a Information-Dialog without a header-text.
   * @param titelText
   * @param contentText
   */
  public static void showInfoDialogWithoutHeader(String titelText, String contentText) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(titelText);
    alert.setHeaderText(null);
    alert.setContentText(contentText);

    alert.showAndWait();
  }

  /**
   * This Method generate a Warning-Dialog.
   * @param titelText
   * @param headerText
   * @param contentText
   */
  public static void showWarningDialog(String titelText, String headerText, String contentText) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(titelText);
    alert.setHeaderText(headerText);
    alert.setContentText(contentText);

    alert.showAndWait();
  }

  /**
   * This Method generate a Error-Dialog..
   * @param titelText
   * @param headerText
   * @param contentText
   */
  public static void showErrorDialog(String titelText, String headerText, String contentText) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(titelText);
    alert.setHeaderText(headerText);
    alert.setContentText(contentText);

    alert.showAndWait();
  }

  /**
   * This Method generate a Text-Input-Dialog with a defalut-value.
   * @param titelText
   * @param headerText
   * @param contentText
   * @param defaultValue
   * @return the text-entry
   */
  public static String showTextInputDialog(String titelText, String headerText, String contentText, String defaultValue) {
    TextInputDialog dialog = new TextInputDialog(defaultValue);
    dialog.setTitle(titelText);
    dialog.setHeaderText(headerText);
    dialog.setContentText(contentText);

    Optional<String> result = dialog.showAndWait();
    return result.get();
  }


  public static String showChioceDialog(String titelText, String headerText, String contentText) {
    ChoiceDialog<String> dialog = new ChoiceDialog();
    dialog.setTitle(titelText);
    dialog.setHeaderText(headerText);
    dialog.setContentText(contentText);

    Optional<String> result = dialog.showAndWait();
    return result.get();
  }

  /**
   * This Method generate a Exception-Dialog with stacktrace.
   * @param titelText
   * @param headerText
   * @param contentText
   * @param exceptionText
   */
  public static void showExceptionDialog(String titelText, String headerText, String contentText, String exceptionText) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(titelText);
    alert.setHeaderText(headerText);
    alert.setContentText(contentText);

    Label label = new Label("The exception stacktrace was:");

    TextArea textArea = new TextArea(exceptionText);
    textArea.setEditable(false);
    textArea.setWrapText(true);

    GridPane expContent = new GridPane();
    expContent.setMaxWidth(Double.MAX_VALUE);
    expContent.add(label, 0, 0);
    expContent.add(textArea, 0, 1);

    alert.showAndWait();
  }

  /**
   * This Method generate a Confrimation-Dialog with the customization answers.
   * @param titelText
   * @param headerText
   * @param contentText
   * @param buttonTextA => Text of the answers-button one
   * @param buttonTextB => Text of the answers-button two
   * @return
   */
  public static String showConfirmationDialog_A_or_B(String titelText, String headerText, String contentText, String buttonTextA, String buttonTextB) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle(titelText);
    alert.setHeaderText(headerText);
    alert.setContentText(contentText);

    ButtonType buttonTypeOne = new ButtonType(buttonTextA);
    ButtonType buttonTypeTwo = new ButtonType(buttonTextB);
    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

    alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

    Optional<ButtonType> result = alert.showAndWait();
    return result.get().getText();
  }
}

