package ch.fhnw.richards.lecture13_Networking.browser_url;

public class BrowserController {

	final private BrowserModel model;
	final private BrowserView view;

	protected BrowserController(BrowserModel model, BrowserView view) {
		this.model = model;
		this.view = view;

		// register ourselves to listen for button clicks
		view.btnGo.setOnAction(e -> {
			String url = view.txtURL.getText();
			String webPage = model.browse(url);
			view.txtWebPage.setText(webPage);
		});
	}
}
