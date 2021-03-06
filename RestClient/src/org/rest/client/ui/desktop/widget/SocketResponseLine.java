package org.rest.client.ui.desktop.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class SocketResponseLine extends Composite {

	private static SocketResponseLineUiBinder uiBinder = GWT
			.create(SocketResponseLineUiBinder.class);

	interface SocketResponseLineUiBinder extends
			UiBinder<Widget, SocketResponseLine> {
	}
	
	
	final boolean isResponse;
	final String message;
	
	@UiField SpanElement typeDisplay;
	@UiField SpanElement messageDisplay;
	@UiField HTMLPanel container;
	
	public SocketResponseLine(boolean isResponse, String message) {
		initWidget(uiBinder.createAndBindUi(this));
		this.isResponse = isResponse;
		this.message = message;
		styleRow();
	}
	
	private void styleRow(){
		if(isResponse){
			typeDisplay.setInnerText(">>>");
			container.addStyleName("Socket_Response_Line_received");
		} else {
			typeDisplay.setInnerText("<<<");
		}
		messageDisplay.setInnerText(message);
	}

}
