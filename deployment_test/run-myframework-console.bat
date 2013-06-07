@REM Copyright (c) 2010 Phynx System

set PATH_PREFIX=%~dp0

@REM -----------------------------------------------------------------------
@REM 							CLASSPATH
@REM -----------------------------------------------------------------------
set EQUINOX_LIB=%PATH_PREFIX%\org.eclipse.osgi_3.4.2.R34x_v20080826-1230.jar
set PHYNX_LIB=%PATH_PREFIX%\phynx.fconsole-1.0.0.jar

set MYCLASSPATH=%PHYNX_LIB%;%EQUINOX_LIB%


@REM -----------------------------------------------------------------------
@REM 						JVM PROPERTIES
@REM -----------------------------------------------------------------------

set JVM_JMX=-Dcom.sun.management.jmx@REMote

set OSGI_CONSOLE_CLASS=-Dosgi.consoleClass=org.phynx.osgi.PhynxFrameworkConsole
set OSGI_DEBUG_FILE_OPT=-Dosgi.debug=debug.properties 

set PAX_LOGGING_CONFIGURATION=-Dbundles.configuration.location=configuration
set PAX_LOGGING_LEVEL=-Dorg.ops4j.pax.logging.DefaultServiceLog.level=DEBUG

set JVM_PROPS=%JVM_JMX% %OSGI_CONSOLE_CLASS% %OSGI_DEBUG_FILE_OPT% %PAX_LOGGING_CONFIGURATION% %PAX_LOGGING_LEVEL%

@REM -----------------------------------------------------------------------
@REM 						System PROPERTIES
@REM -----------------------------------------------------------------------

set CONSOLE_PORT=-console 35517


java -classpath %MYCLASSPATH% %JVM_PROPS% org.phynx.osgi.core.runtime.PhynxEclipseStarter %CONSOLE_PORT% > out2.log