package com.wsz.rcpsum.ui.preference;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.wsz.rcpsum.ui.UIPlugin;

/**
 * 首选项：普通创建方式。
 * 
 * @author wsz 2018-1-2
 * 
 */
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
		setPreferenceStore(UIPlugin.getDefault().getPreferenceStore());
	}

	@Override
	protected Control createContents(Composite parent) {
		// parent 已经的布局样式是 GridLayout，所以不用再设置布局样式。
		// 创建一个子类面板
		Composite tomp = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(tomp);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(tomp);

		// 创建一个字符串label、text
		Label label = new Label(tomp, SWT.WRAP);
		label.setText("ip：");
		Text text = new Text(tomp, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(text);

		return tomp;
	}

	/**
	 * 单击【应用】按钮执行此方法
	 */
	@Override
	protected void performApply() {
		super.performApply();
	}

	/**
	 * 单击【确定】按钮执行此方法
	 */
	@Override
	public boolean performOk() {
		return false; // 不关闭首选项
		// return true; // 关闭首选项
	}

	/**
	 * 单击【取消】按钮执行此方法
	 */
	@Override
	public boolean performCancel() {
		return true; // 关闭首选项
	}
}
