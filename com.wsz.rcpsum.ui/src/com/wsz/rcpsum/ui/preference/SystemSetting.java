package com.wsz.rcpsum.ui.preference;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class SystemSetting extends PreferencePage implements IWorkbenchPreferencePage {

	public SystemSetting() {
	}

	public SystemSetting(String title) {
		super(title);
	}

	public SystemSetting(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	public void init(IWorkbench workbench) {

	}

	@Override
	protected Control createContents(Composite parent) {
		return null;
	}

}
