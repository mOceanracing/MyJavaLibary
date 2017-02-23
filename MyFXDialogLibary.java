public class MyFXDialogLibary{
	public static void showInfoDialog(String titelText, String contentText){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titelText);
		alert.setHeaderText(null);
		alert.setContentText(contentText);
	
		alert.showAndWait();
	}	
	
	public static void showWarningDialog(String titelText, String headerText, String contentText){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(titelText);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);

		alert.showAndWait();
	}	
}
