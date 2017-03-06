public class MyFXDialogLibary{
	public static void showInfoDialog(String titelText, String contentText){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(titelText);
		alert.setHeaderText(null);
		alert.setContentText(contentText);
	
		alert.showAndWait();
	}	
	
	public static void showWarningDialog(String titelText, String headerText, String contentText){
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(titelText);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);

		alert.showAndWait();
	}	
	
	public String showTextInputDialog(String titelText, String headerText, String contentText){
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle(titelText);
		dialog.setHeaderText(headerText);
		dialog.setContentText(contentText);

		Optional<String> result = dialog.showAndWait();
		return result.get();
	}	
	
		public String showChioceDialog(String titelText, String headerText, String contentText, ArrayList<E> choices){
		ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
		dialog.setTitle(titelText);
		dialog.setHeaderText(headerText);
		dialog.setContentText(contentText);

		Optional<String> result = dialog.showAndWait();
		return result.get();
	}
}
