package com.wsz.rcpsum.server.model;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle。<br/>
 * 本插件存放数据库定义的模型类，实现与数据库交互的方法。
 * @author wsz 2017-11-6
 */
public class ModelPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.wsz.rcpsum.server.model"; //$NON-NLS-1$

	// The shared instance
	private static ModelPlugin plugin;
	
	/**
	 * The constructor
	 */
	public ModelPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ModelPlugin getDefault() {
		return plugin;
	}

}
