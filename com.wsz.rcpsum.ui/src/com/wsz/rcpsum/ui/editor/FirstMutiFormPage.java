package com.wsz.rcpsum.ui.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

public class FirstMutiFormPage extends FormPage{

	public static final String ID = "com.wsz.rcpsum.ui.editor.firstMutiFormPage";
	
	public FirstMutiFormPage(FormEditor editor) {
		super(editor, ID, "第一页");
	}

	// 创建表单区域的各种控件
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		
		// 获取表单工具对象
		FormToolkit toolkit = managedForm.getToolkit();
		
		// 获取可滚动的表单对象
		final ScrolledForm form = managedForm.getForm();
		
		// 设置表单文本（头部）
		form.setText("这是第一页");
		
		// 获取表单的主体部分
		Composite body = form.getBody();
		
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		
		// 使用表单表格布局
		TableWrapLayout tableWrapLayout = new TableWrapLayout();
		tableWrapLayout.numColumns = 2;
		body.setLayout(tableWrapLayout);
		
		// ======== 第一个section部分 =======
		Section section = toolkit.createSection(body, Section.TWISTIE | Section.TITLE_BAR | Section.DESCRIPTION);
		TableWrapData tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB,TableWrapData.TOP,1,1); 
		section.setLayoutData(tableWrapData);
		
		section.setText("第一个内容区");  //设置标题
		section.setDescription("这是标题栏下的一段描述"); //设置描述信息
		section.setExpanded(true);
		
		Composite sectionClient = toolkit.createComposite(section); //创建内容区折叠的面板
		sectionClient.setLayout(new GridLayout());
		Button btn1 = toolkit.createButton(sectionClient, "checkbox 1", SWT.CHECK);
		Button btn2 = toolkit.createButton(sectionClient, "checkbox 2", SWT.CHECK);
		section.setClient(sectionClient); //设置内容区控件
		
//		section.addExpansionListener(new ExpansionAdapter(){
//			@Override
//			public void expansionStateChanged(ExpansionEvent e) {
//				// 根据控件的新尺寸重新定位和更新滚动条
//				form.reflow(true);
//			}
//		});
		
	}
}
