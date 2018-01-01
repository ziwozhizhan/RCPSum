package com.wsz.rcpsum.ui.login;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle。<br>
 * 登录界面插件。
 * @author wsz 2017-11-16
 */
public class LoginPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.wsz.rcpsum.ui.login"; //$NON-NLS-1$

	// The shared instance
	private static LoginPlugin plugin;
	
	/**
	 * The constructor
	 */
	public LoginPlugin() {
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
	public static LoginPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path
	 * 
	 * @param path the image file at the given plug-in relative path
	 * @return
	 */
	public ImageDescriptor getImageDescriptor(String path){
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
