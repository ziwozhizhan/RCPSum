package com.wsz.rcpsum.ui.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

public class MutiFormEditor extends FormEditor {
	
	public static final String ID = "com.wsz.rcpsum.ui.editor.mutiform";
	
	public MutiFormEditor(){
		super();
	}

	@Override
	protected void addPages() {
		try {
			addPage(new FirstMutiFormPage(this));
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	// 保存编辑器时调用
	@Override
	public void doSave(IProgressMonitor monitor) {
		
	}

	// 另存为
	@Override
	public void doSaveAs() {
		
	}

	// 是否允许保存
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		
		setPartName(input.getName());  //设置编辑器名称
	}
}
