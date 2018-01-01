package com.wsz.rcpsum.ui.login.user;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.wsz.rcpsum.ui.login.LoginPlugin;

/**
 * 状态栏显示当前登录用户的信息，并可进行修改密码、查看个人信息（向导页）、退出等右键菜单操作。
 * 
 * @author wsz 2017-12-12
 * 
 */
public class LoginUserContributionItem extends ControlContribution {

	private CLabel userLabel;
	private Image image;

	// private LoginUserAction action;

	public LoginUserContributionItem() {
		super("loginUser");
		// action = new LoginUserAction();
	}

	@Override
	protected Control createControl(Composite parent) {
		userLabel = new CLabel(parent, SWT.NONE);
		userLabel.setText("万深圳");
		// if(action.getImageDescriptor() != null) {
		// image = action.getImageDescriptor().createImage();
		// userLabel.setImage(image);
		// }
		image = LoginPlugin.getDefault().getImageDescriptor("icons/user.png").createImage();
		userLabel.setImage(image);
		userLabel.addMouseTrackListener(new MouseTrackAdapter() {

			@Override
			public void mouseExit(MouseEvent e) {
				userLabel.setBackground((Color) null);
			}

			@Override
			public void mouseEnter(MouseEvent e) {
				userLabel.setBackground(e.display.getSystemColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
			}
		});
		// userLabel.addListener(SWT.MouseUp, new Listener() {
		//
		// @Override
		// public void handleEvent(Event event) {
		// action.runWithEvent(event);
		// }
		// });
		
		addPopMenu();
		
		return userLabel;
	}

	@Override
	public void dispose() {
		if (image != null) {
			image.dispose();
		}
		super.dispose();
	}
	
	/**
	 * 添加右键菜单。
	 */
	private void addPopMenu(){
		
		final Menu menu = new Menu(userLabel);
		MenuItem personalItem = new MenuItem(menu, SWT.PUSH);
		personalItem.setText("查看个人信息");
		
		MenuItem passwordItem = new MenuItem(menu, SWT.PUSH);
		passwordItem.setText("修改密码");
		
		MenuItem exitItem = new MenuItem(menu, SWT.PUSH);
		exitItem.setText("退出");
		
		userLabel.addListener(SWT.MenuDetect, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				menu.setVisible(true);
			}
		});
	}
}
