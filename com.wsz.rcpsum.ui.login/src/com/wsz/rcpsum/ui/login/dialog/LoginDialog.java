package com.wsz.rcpsum.ui.login.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LoginDialog extends TitleAreaDialog{
	
	private Text username;
	private Text password;

	public LoginDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		
		//设置标题
		setTitle("欢迎登录XXX系统");
		setMessage("请输入用户名和密码！");
		//setTitleImage(newTitleImage); //设置标题区域背景图片
		
		Composite area = (Composite) super.createDialogArea(parent);
		Composite composite = new Composite(area, SWT.NONE);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(composite);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(composite);
		
		//用户登录名
		new Label(composite, SWT.WRAP).setText("用户名：");
		username = new Text(composite, SWT.BORDER);
		setStyle4Text(username);
		
		//登录密码
		new Label(composite, SWT.WRAP).setText("密码：");
		password = new Text(composite, SWT.PASSWORD);
		setStyle4Text(password);
		
		//占位使用
		new Label(composite, SWT.WRAP);
		
		//是否自动登录
		Button autoLogin = new Button(composite, SWT.CHECK);
		autoLogin.setText("是否自动登录");
		GridDataFactory.swtDefaults().applyTo(autoLogin);
		
		return area;
	}
	
	/** 配置窗口标题 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("欢迎登录");
	}
	

	/** 配置窗口样式 */
	@Override
	protected int getShellStyle() {
		return super.getShellStyle() | SWT.RESIZE | SWT.MAX;
	}
	
	/** 初始化窗口大小 */
	@Override
	protected Point getInitialSize() {
		return new Point(354, 246);
	}
	
	// =========== 修改对话框默认按钮 =============
	@Override
	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
		return null;
	}
	
	@Override
	protected void initializeBounds() {
		Composite composite = (Composite) getButtonBar();
		super.createButton(composite, IDialogConstants.OK_ID, "登录", true);
		super.createButton(composite, IDialogConstants.CANCEL_ID, "取消", false);
		
		super.initializeBounds();
	}
	
	/** 按钮执行事件 */
	@Override
	protected void buttonPressed(int buttonId) {
		if (IDialogConstants.OK_ID == buttonId) {
			// 验证必填项 
			if(verifyRequiredIsNot()){
				return;
			}
			// wszTODO mina 通信，向数据库发送验证
			okPressed();
		} else if (IDialogConstants.CANCEL_ID == buttonId) {
			cancelPressed();
		}
	}
	// ========== 修改对话框默认按钮 end ===========
	
	/**
	 * 用户名、密码文本框样式。尽量横向占满空间。
	 */
	private void setStyle4Text(Text text){
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(text);
	}
	
	/**
	 * 验证必填项是否没有全部填写。
	 * @return boolean true 有必填内容未填或填写格式不对
	 */
	private boolean verifyRequiredIsNot(){
		String result = ""; //结果信息 
		if (username.getText().length() < 1) {
			username.setFocus();
			result = "请输入用户名";
		}else if (password.getText().length() < 1) {
			password.setFocus();
			result = "请输入登录密码";
		}
		
		if (result.length() > 0) {
			setMessage(result, IMessageProvider.ERROR); //显示验证结果信息
			return true;
		}
		return false;
	}
	
}
