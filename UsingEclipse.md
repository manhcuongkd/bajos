#Using Eclipse as BAJOS IDE for CORE Development

# Introduction #

This page describes, how you could work with bajos using eclipse if you want to develop on the core of BAJOS


# Getting Source #

Read this http://code.google.com/p/bajos/source/checkout information about how to get the source code or download stable releases from here: http://code.google.com/p/bajos/downloads/list

# Requirements #
  * Eclipse with CDT Plugin (Tested with Eclipse Helios)
  * C-Compiler depending on used hardware platform (avr-gcc,avr32-gcc,gcc,cygwin...)
  * [optional](optional.md) Eclipse SVN Plugin

# Adding BAJOS project to eclipse #

After you get the source start the Eclipse import dialog from File->Import..

Select Existing Projects into Workspace:

![http://ceh-photo.de/bajos/import_eclipse_project.png](http://ceh-photo.de/bajos/import_eclipse_project.png)

Select the bajos root folder on your machine (./bajos)

![http://ceh-photo.de/bajos/import_eclipse_project2.png](http://ceh-photo.de/bajos/import_eclipse_project2.png)

And press Finish.

# Using BAJOS inside Eclipse #

Here you see the bajos project in the project explorer:

![http://ceh-photo.de/bajos/bajos_in_eclipse.png](http://ceh-photo.de/bajos/bajos_in_eclipse.png)

## Build ##
For building bajos click on the hammer icon. With the dropdown arrow near the hammer icon you are able to switch the configuration. If you select the debug configuration BAJOS will be build with more debug information outputs.

Cleaning your current target is also possible with default eclipse methods: Project->Clean.. and select the bajos project.

## Configuration ##

### Change the target hardware ###

For changeing the hardware platform and setting other options go into the projet preferences (right click on the project root) and navigate to C/C++ Build-> Environment. In this dialog you are able to change the value vor TARGETHW which specifies your build target.

![http://ceh-photo.de/bajos/eclipse_configuration.png](http://ceh-photo.de/bajos/eclipse_configuration.png)

The available values for TARGETHW correspond to the MAKEFILE. At the moment you could use:
  * arduinomega,am
  * charon,ch
  * evk1100
  * evk1104
  * ngw100
  * STK1000
  * XMEGA
  * linux

### Use TINYBAJOS option ###
If you change the value of TINYBAJOS to yes, BAJOS will be build with a reduced feature set, which provides a much lower flash usage.

### Change MAKE target ###

On default BAJOS will be build with all target which forces make to clean the sources and build everything again, also it triggers the configured flasher of your target. If you want to change to compile make target go to project preferences->C/C++ Build and change to the "Behavior" tab. In the textbox "Build (Incremental build" you could change the target from all to compile or something else.

Example:

![http://ceh-photo.de/bajos/eclipse_change_compile_mode.png](http://ceh-photo.de/bajos/eclipse_change_compile_mode.png)






