package com.wsz.rcpsum.ui.view;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class CreateUsersView extends ViewPart {
	
	public final static String ID = "com.wsz.rcpsum.ui.view.createUsers";

	public CreateUsersView() {
	}

	@Override
	public void createPartControl(Composite parent) {
			parent.setLayout(new FillLayout());
			Composite tomp = new Composite(parent, SWT.NONE);
			GridLayoutFactory.swtDefaults().numColumns(2).applyTo(tomp);
			
			new Label(tomp,SWT.WRAP).setText("姓名：");
			Text name = new Text(tomp, SWT.BORDER);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(name);
	}

	@Override
	public void setFocus() {

	}

}
