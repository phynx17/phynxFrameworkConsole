package org.phynx.osgi;

import java.io.IOException;


import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.internal.core.FrameworkCommandInterpreter;
import org.eclipse.osgi.framework.internal.core.FrameworkConsole;
import org.eclipse.osgi.framework.internal.core.OSGi;

/**
 * Provides a simple extension to what is lacking in current FrameworkConsole
 * 
 * @author Pandu Pradhana
 * @version 0.1
 * 
 */
public class PhynxFrameworkConsole extends FrameworkConsole {

	/**
	 * 
	 * @param osgi
	 * @param args
	 */
	public PhynxFrameworkConsole(OSGi osgi, String[] args) {
		this (osgi, 0, null);
	}
	
	/**
	 * 	
	 * @param osgi
	 * @param port
	 * @param args
	 */
	public PhynxFrameworkConsole(OSGi osgi, int port, String[] args) {
		super(osgi, port, args);			
		// register the OSGi command provider
		//this.osgicp = null;
	}

	
	
	public void console(String args[]) throws IOException {		
		// first handle any args passed in from launch
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.println("Going to execute :" + args[i]);
				docommand(args[i]);
			}
		}
	}
	
	
	/**
	 * Override *dangerous* command 
	 */
	protected void docommand(String cmdline) {
		if (cmdline != null && cmdline.length() > 0) {
			CommandInterpreter intcp = new FrameworkCommandInterpreter(cmdline, getServices(), this);
			String command = intcp.nextArgument();
			if (command != null) {
				if ("exit".equalsIgnoreCase(command) || "quit".equalsIgnoreCase(command)) {
					command = "disconnect";
				}
				if ("close".equalsIgnoreCase(command)) {
					System.out.println("Equinox is shutting down...");
				}				
				intcp.execute(command);

			}
		}
	}
	
}
