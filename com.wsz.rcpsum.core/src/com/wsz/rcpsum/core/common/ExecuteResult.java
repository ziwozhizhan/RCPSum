package com.wsz.rcpsum.core.common;


/**
 * 操作结果模型类。执行增删改等需要对结果进行判断时，可以使用此模型封装结果信息。
 * 
 * <p>
 * 使用举例：
 * </p>
 * <pre>
 * 1.设置执行结果
 * <code>
 * 	public ExecuteResult temp() {
 *		ExecuteResult result = new ExecuteResult();
 *
 *		try {
 *			// 执行数据库增、删、改
 *			result.executeOK();
 *		} catch (Exception e) {
 *			result.executeNOT(); // 或 result.setErrorCode(0x123);
 *			result.setError(e.getMessage());
 *		}
 *
 *		return result;
 *	}</code>
 *2.对执行结果进行处理（其它类中调用temp()的方法）
 *<code>
 *	public void otherClassMethod() {
 *		ExecuteResult result = temp();
 *		if (result.isOK()) {
 *			// 执行后续成功的处理逻辑
 *			// ...
 *		} else {
 *			// temp()执行失败，对错误结果进行处理
 *			// 例：将出错信息展示到界面中
 *			// String msg = "错误码【"+result.getErrorCode()+"】错误信息："+result.getError();
 *			// MessageDialog.openError(shell, title, msg);
 *			// ...
 *		}
 *	}</code>
 * </pre>
 * @author wsz
 * 
 */
public class ExecuteResult {
	private final static int OK = 0;
	private final static int NOT = -1;

	private Integer result = null;
	private String error = null;

	/**
	 * 操作结果是否为成功
	 * 
	 * @return
	 */
	public boolean isOK() {
		if (result != null && result == OK) {
			return true;
		}
		return false;
	}

	/**
	 * 设置操作结果为成功
	 * 
	 * @return
	 */
	public void executeOK() {
		result = OK;
	}

	/**
	 * 设置操作结果为失败,错误码默认-1
	 * 
	 * @return
	 */
	public void executeNOT() {
		result = NOT;
	}

	/**
	 * 自定义设置错误码，不能为0或-1。<br/>
	 * 调用此方法后无需调用executeNOT()
	 * 
	 * @return
	 */
	public void setErrorCode(int code) {
		result = code;
	}

	/**
	 * 获取错误码
	 * 
	 * @return
	 */
	public Integer getErrorCode() {
		return result;
	}

	/**
	 * 获取错误信息
	 * 
	 * @return
	 */
	public String getError() {
		return error;
	}

	/**
	 * 设置操作失败时的错误信息
	 * 
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}

}
