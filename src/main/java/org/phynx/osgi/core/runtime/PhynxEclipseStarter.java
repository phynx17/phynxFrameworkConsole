package org.phynx.osgi.core.runtime;

import org.eclipse.core.runtime.adaptor.EclipseStarter;
import org.phynx.osgi.PhynxFrameworkConsole;

/**
 * This class provides a custom bootstrap for Eclipse starter, and calls
 * necessary initialization
 * 
 * 
 * @author Pandu Pradhana
 * 
 */
public class PhynxEclipseStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Override stuff
		 */
		System.setProperty("osgi.consoleClass", PhynxFrameworkConsole.class.getName());
		
		try {
			EclipseStarter.main(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
