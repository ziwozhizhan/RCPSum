package com.wsz.rcpsum.ui.preference;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.FontFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.PathEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.preference.ScaleFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class EditorField extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	public EditorField() {
		super(GRID); //默认  FLAT
	}
	@Override
	public void init(IWorkbench workbench) {
		
	}

	@Override
	protected void createFieldEditors() {
//		// 在默认 style = FLAT下灵活修改布局
//		//自定义布局方式
//		Composite tomp = getFieldEditorParent();
//		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(tomp);
//		GridDataFactory.fillDefaults().grab(true, false).applyTo(tomp);
//		
//		Composite c1 = new Composite(tomp, SWT.NONE);
//		StringFieldEditor strfe1 = new StringFieldEditor("String", "String1", c1);
//		addField(strfe1);
//		
//		Composite c2 = new Composite(tomp, SWT.NONE);
//		StringFieldEditor strfe2 = new StringFieldEditor("String", "String2", c2);
//		addField(strfe2);
		
		// 字符型
		StringFieldEditor strfe = new StringFieldEditor("String", "String", getFieldEditorParent());
		addField(strfe);  //添加到fields域中以便循环保存
		
		// 布尔型
		BooleanFieldEditor bfe = new BooleanFieldEditor("boolean", "Boolean", BooleanFieldEditor.DEFAULT, getFieldEditorParent());
		addField(bfe);
		
		// 颜色
		ColorFieldEditor color = new ColorFieldEditor("color", "Color", getFieldEditorParent());
		addField(color);
		
		// 字体
		FontFieldEditor font = new FontFieldEditor("font", "Font", "万深圳", getFieldEditorParent());
		addField(font);
		
		// 路径列表
		PathEditor path = new PathEditor("path", "Path", "", getFieldEditorParent());
		addField(path);
		
		// 单选按钮组
		RadioGroupFieldEditor rgfe = new RadioGroupFieldEditor("group", // 选项的key，保存到首选项中的key
				"RadioGroup", // 分组框显示的文本
				2, // 一行显示的单选的按钮的个数
				new String[][] { { "Radio one", "one" }, { "Radio two", "two" }, { "Radio three", "three" },
						{ "Radio four", "four" } }, // 单选按钮
				getFieldEditorParent(), true);
		addField(rgfe);
		
		// 刻度条
		ScaleFieldEditor scale = new ScaleFieldEditor("scale", "Scale", getFieldEditorParent(), 0, 10, 1, 2);
		addField(scale);
		
		// 整数型字段
		IntegerFieldEditor ife = new IntegerFieldEditor("integer", "Integer", getFieldEditorParent(), 10);
		addField(ife);
		
		// 选择路径
		DirectoryFieldEditor directory = new DirectoryFieldEditor("directory", "Directory", getFieldEditorParent());
		addField(directory);
		
		// 选择文件
		FileFieldEditor file = new FileFieldEditor("file", "File", false, getFieldEditorParent());
		addField(file);
	}
}
