

# Intro #
For all windows user:
This is a step by step description how to compile bajos in a windows environment.

Bajos is originally created in a linux environment, but it's possible to also compile it in a windows environment.


# Install java jdk #
Because the java compiler is needed, you have to hava a java jdk installed.
If you still don't have, visit http://www.java.com and look for the current jdk.
Then download and install it.

# Install cygwin environment #
You neet to download and install a cygwin environment to have all the linux command available (http://www.cygwin.org).
If you also want to create a "windows" bajos you need to install the gnu c compiler too.


# Install avr compiler #
If it's not already on the system, install the free avr compiler "winavr" (http://sourceforge.net/projects/winavr/files/)


# Path checking #
You need to check your path settings!
There seems to be a failure in one of the utilities of winavr, so check that the cygwin folder is before the winavr entry.

To check the path settings:
Open a command window and type `path<enter>`

The output should look like this:
```
PATH=C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;...;C:\Program Files\TortoiseSVN\bin;c:\cygwin\bin;C:\Program Files\Java\jdk1.6.0_25\bin;C:\WinAVR-20100110\bin;C:\WinAVR-20100110\utils\bin;
```


Be shure that the entry or gygwin is before the winarv entries.
If not, edit the path entries (Computer - Properties - extended settings - environment)


# Installing bajos #
Download and install the bajos sources (http://code.google.com/p/bajos/downloads/list)


# Adapting the make files #
You need to make some small changes in a file used by the make utility.
Load the file "arduinomega.inc" (located in the root folder of bajos) in an editor of your choice.
Look for the line beginning with `bindir`.
Comment out this line by adding a # at the beginning of the line.
Create a new line defining `bindir` to be empty.
```
#BINDIR	= /opt/cross/as4e-ide/plugins/com.atmel.avr.toolchains.linux.x86_64_*/os/linux/x86_64/bin/
#for win and avr-gcc in path
BINDIR =
```

Some lines below there are some lines looking like that
```
#FLASHER	= stk500 -P/dev/ttyUSB0
#FLASHER 	= stk200 
#FLASHER 	= avrispmkII -P usb 
FLASHER = stk500 -P com4
```

This line is setting the variable "FLASHER". The contens of FLASHER is given as programming parameters for "avrdude" to program the
atmega.
You need to "aktivate" one line or edit the one with no "#" at the begining according to the programmer you have and the port where the programmer is connected to.
On my computer I have a stk500 compatible isp programmer at serial port "com4".

Attention (own experience):
> On a 64bit system avrdude can't connect to a avrispmk2 via usb!


# Copy platform file #
Before performing a test you need to copy the java "interface" file for the system components ("Arduinomega") what can be accessed by java to the correct folder.
Open an explorer window and locate the folder `"...\bajos\BAJOSBOOT\sources\platform\arduinomega"`.
Copy the file "platform.java" from this folder to the parent folder (`"...\bajos\BAJOSBOOT\sources\platform"`).


# First test #
Now it's time to test if all of the step's above where done in the right way.
Open a command window and change to the bajos root folder.
Then type `make all am<enter>`
The make process should start and produce a lot of "output"...

Comment:
> The last step will take some minutes (really!). The make script is using some shell comands to fill the binary with some bytes. On a windows system, this step will take up to 10 minutes. If the command prompt don't appears at once, so don't despair, you are on a good way!

Mostly make will report an error at the end, normaly it's because you haven't connected the programer.
If you have come that far, so connect your arduino mega and the programer and retype the command to call "avrdude" (you normally should see the command make tried to call avrdude).

# Test of burned bajos with sample application #
So when bajos with the sample application is burned into to arduinomega we should test if bajos is really working.
You need a terminal program (of you choice; WinXP user can use Hyperterminal - On Vista and Win7 Hyperterminal is not longer bundled with, but you can download and install it from http://www.itler.net/download/hyperterminal-itler.zip).
Set the communication parameters to the serial port the arduinomega is using, 57600 Baud, 8 data bits, 1 stop bit and no parity.
After pressing the reset button on the arduino, it should send some startup messages like that:
```
bootclass: 0 length:155 loaded
bootclass: 1 length:86 loaded
bootclass: 2 length:c4b loaded
bootclass: 3 length:cc1 loaded
bootclass: 4 length:90 loaded
bootclass: 5 length:547 loaded
bootclass: 6 length:5ac loaded
bootclass: 7 length:19b loaded
bootclass: 8 length:2b8 loaded
bootclass: 9 length:4a4 loaded
bootclass: a length:133 loaded
bootclass: b length:89 loaded
bootclass: c length:8bb loaded
bootclass: d length:4d1 loaded
load java application classes:
appclass: f length:3f8 loaded
Bajos starting
SP: 21fc cs: 4ef cFB: 0 hB: 8e5 oPSB: 1b26 mSB: 1c28
start clinit  -> run <main> :
currentTimeMillis Test, type any key -> e for end
```

Welcome to the world of java on a micro!

# Using an own java application #
In the test make above we used a java application (AM.java) that was delivered with bajos (located in "...\bajos\javatests").
To use a java file of your own, you have to change a line in "arduinomega.inc".
Open this file in an editor and search for "JAVAAPPSOURCES".
You should find this:
```
# JAVA SOURCES
#JAVAAPPSOURCES		= javatests/LockSimple.java
JAVAAPPSOURCES		= javatests/AM.java
#JAVAAPPSOURCES		= javatests/T1.java javatests/T2.java
#JAVAAPPSOURCES		= javatests/SchedulerTest.java
#JAVAAPPSOURCES		= javatests/InterruptTest.java
```

Change the "active" declaration of JAVAAPPSOURCES by adding your own java files, or comment out that line and add a new declaration of JAVAAPPSOURCES.

Remember:
> If you don't put your java files in the javatests folder, you have to add the folder information to your file relative to the bajos root folder!

Then start the make process by typing `make all am`.

# boosting make process #
Because make process takes a long time only to append some bytes to the binary, I wrote a small java utility to speed up the make process a "little".
In the download area (http://code.google.com/p/bajos/downloads/list) you'll find "CopyAndAppend.jar".
Download this file and copy it to the bajos root folder.
Then open the file "arduinomega.inc" (also in bajos root folder) in an editor and locate the following lines:
```
bajospack:
	$(VERBOSE_CMD) cat $(BIN) > bajos.bin
	$(VERBOSE_CMD)(i=`ls -l $(BIN) | cut -f5 -d' '`; limit=`expr 2 \* $$(($(CLASSFILEBASE)))`;while [ "$$i" -lt "$$limit" ];  do  i=$$(($$i+1));echo -n 'x' >> bajos.bin;  done)
	cat avr8bootpack >> bajos.bin
	cat amapp >> bajos.bin
	@echo Creating binary image to \`bajos.bin\'	.
	@${CC} --version
```

Change them to look like this:
```
bajospack:
	#$(VERBOSE_CMD) cat $(BIN) > bajos.bin
	#$(VERBOSE_CMD)(i=`ls -l $(BIN) | cut -f5 -d' '`; limit=`expr 2 \* $$(($(CLASSFILEBASE)))`;while [ "$$i" -lt "$$limit" ];  do  i=$$(($$i+1));echo -n 'x' >> bajos.bin;  done)
	java -jar copyandappend.jar $(BIN) bajos.bin -t $(CLASSFILEBASE) -b 0x78 -m2
	cat avr8bootpack >> bajos.bin
	cat amapp >> bajos.bin
	@echo Creating binary image to \`bajos.bin\'	.
	@${CC} --version
```

If you now start a make, it will only take seconds (instead of minutes).