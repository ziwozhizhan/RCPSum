package com.wsz.rcpsum.util.commons;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle。<br/>
 * 本插件提供通用工具的支持。提供apache commons jar包的支持。
 * @author wsz 2017-11-11
 */
public class CommonsPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.wsz.rcpsum.util.commons"; //$NON-NLS-1$

	// The shared instance
	private static CommonsPlugin plugin;
	
	/**
	 * The constructor
	 */
	public CommonsPlugin() {
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
	public static CommonsPlugin getDefault() {
		return plugin;
	}

}
