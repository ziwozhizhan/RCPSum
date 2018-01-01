package com.wsz.rcpsum.ui.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

import com.wsz.rcpsum.ui.editor.MutiFormEditor;
import com.wsz.rcpsum.ui.editor.MutiFormEditorInput;

public class TestConfigView extends ViewPart {

	public TestConfigView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());
		Button button = new Button(composite, SWT.PUSH);
		button.setText("22222");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new MutiFormEditorInput(), MutiFormEditor.ID);
				} catch (PartInitException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	@Override
	public void setFocus() {

	}

}
