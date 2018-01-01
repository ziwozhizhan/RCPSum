package com.wsz.rcpsum.ui.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * 测试配置 透视图
 * @author wsz 2017-11-19
 *
 */
public class TestConfigPerspective implements IPerspectiveFactory {
	
	public static final String ID = "com.wsz.rcpsum.ui.perspective.testConfig";

	public void createInitialLayout(IPageLayout layout) {
//		layout.setEditorAreaVisible(false);
	}
}
