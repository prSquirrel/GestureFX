package net.kurobako.gesturefx.sample;

import net.kurobako.gesturefx.GesturePane;
import net.kurobako.gesturefx.sample.SamplerController.Sample;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

public class ArbitraryNodeSample implements Sample{
	@Override
	public Node mkRoot() {
		try {
			Parent node  = FXMLLoader.load(getClass().getResource("/ComplexScene.fxml"));
			node.setPickOnBounds(true);
			node.setMouseTransparent(true);
			WebView webview = (WebView) node.lookup("webview");
			if(webview != null){
				webview.getEngine().load("http://purecss3.net/doraemon/doraemon_css3.html");
			}

			GesturePane pane = new GesturePane(new SubScene(node, 500, 500));
			VBox.setVgrow(pane, Priority.ALWAYS);
			Label description = new Label("Zoom and scroll on the SubScene below, " +
					                              "observe that controls in JavaFX are vectors " +
					                              "and that lighting effects are respected" +
					                              "(different zoom alters light distance).");
			description.setWrapText(true);
			description.setPadding(new Insets(16));
			return new VBox(description, pane);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
