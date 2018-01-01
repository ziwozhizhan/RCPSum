package com.wsz.rcpsum.platform.application;

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.wsz.rcpsum.platform.RCPSumPlugin;
import com.wsz.rcpsum.ui.login.user.LoginUserContributionItem;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(400, 300)); // 初始大小
		configurer.setShowCoolBar(true); // 显示工具栏
		configurer.setShowStatusLine(true); // 显示状态栏
		configurer.setShowMenuBar(true); // 显示菜单栏
		configurer.setShowFastViewBars(true); // 显示快速视图条
		configurer.setShowPerspectiveBar(true); // 显示透视图工具栏
		configurer.setShowProgressIndicator(true); // 显示进度条

		// wszTODO 实现国际化
		configurer.setTitle("研究RCP技术"); // 显示标题内容
	}

	@Override
	public void postWindowCreate() {
		super.postWindowCreate();

		// 设置位置居中
		Rectangle rectangle = Display.getCurrent().getBounds();
		Shell shell = getWindowConfigurer().getWindow().getShell();
		Point shellSize = shell.getSize();
		int x = (rectangle.width - shellSize.x) / 2;
		int y = (rectangle.height - shellSize.y) / 2;
		shell.setLocation(x, y);

		// 设置启动时全屏
		getWindowConfigurer().getWindow().getShell().setMaximized(true);
	}

	@Override
	public void postWindowOpen() {
		super.postWindowOpen();

		// 创建系统托盘
		createSystemTray();

		// wszTODO 需要补充完善
		// 状态栏显示已登陆的用户
		addLoginUserStatusLine();
	}

	// 窗口关闭之前执行
	@Override
	public boolean preWindowShellClose() {
		// 设置点击窗口关闭按钮最小化到托盘
		// Shell shell = getWindowConfigurer().getWindow().getShell();
		// shell.setVisible(false);
		//
		// return false; //true 允许关闭

		return super.preWindowShellClose();
	}
	
	/**
	 * 状态栏添加已登陆的用户
	 */
	private void addLoginUserStatusLine(){
		IStatusLineManager statusLine = getWindowConfigurer().getActionBarConfigurer().getStatusLineManager();
		LoginUserContributionItem item = new LoginUserContributionItem();
		statusLine.add(item);
		
		statusLine.update(true);  //很重要
	}

	/**
	 * 创建系统托盘，确保在程序窗口打开后执行此方法。自定义方法。
	 */
	private void createSystemTray() {
		// 取得系统托盘对象
		final Shell shell = getWindowConfigurer().getWindow().getShell();
		Tray tray = shell.getDisplay().getSystemTray();

		if (tray != null) {
			TrayItem item = new TrayItem(tray, SWT.NONE);
			item.setToolTipText("研究RCP技术");
			item.setImage(RCPSumPlugin.getDefault().getImageDescriptor("icons/alt_window_32.gif").createImage());
			// 默认文字提示样式时长方形框，可以使用下面修改样式
			final ToolTip toolTip = new ToolTip(shell, SWT.BALLOON | SWT.ICON_INFORMATION);
			item.setToolTip(toolTip);

			// 添加右键菜单
			final Menu menu = new Menu(shell, SWT.POP_UP);
			final MenuItem showMenu = new MenuItem(menu, SWT.PUSH);
			showMenu.setText("&隐藏");
			showMenu.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					boolean showFlag = shell.isVisible();
					shell.setVisible(!showFlag);
					showMenu.setText(showFlag ? "&显示" : "&隐藏");
					toolTip.setText("RCP托盘");
					toolTip.setMessage("右键图标，显示右键菜单");
					toolTip.setVisible(showFlag);
				}
			});

			MenuItem exitMenu = new MenuItem(menu, SWT.PUSH);
			exitMenu.setText("&退出");
			exitMenu.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					System.exit(0);
				}
			});

			item.addListener(SWT.MenuDetect, new Listener() {
				public void handleEvent(Event event) {
					menu.setVisible(true); // 右键单击鼠标时，显示菜单
				}
			});
		}
	}
}
