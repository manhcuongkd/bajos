# Bajos #

Welcome to the bajos wiki!

Bajos is a Java runtime environment for microcontrollers. It consists of BAJVM, a Java Virtual Machine and of BAJOSBOOT, a collection of system classes. BAJOS can be adapted to Embedded Systems with/without operating system easily. We use it for 8 and 32 bit AVR controllers (atmega128, UC3A, AP7000). It works on PC's with linux also.

Bajos has been tested yet at:<br>
<ul><li>32 Bit and 64 Bit PC-linux systems (most development and testing is carried out here)<br>
</li><li>MICA2 Board (mote) with atmega128 only equipped with internal 4K Byte data ram<br>
</li><li>Charon2 board with atmega128 and 32K data ram and resident monitor program bamo128 <a href='http://bamo128.googlecode.com'>http://bamo128.googlecode.com</a>
</li><li>NGW100 with/without linux<br>
</li><li>STK1000 with/without linux<br>
</li><li>EVK1100 with/without resident monitor bamo32 <a href='http://cs.ba-berlin.de'>http://cs.ba-berlin.de</a>
</li><li>EVK1104 with/without resident monitor bamo32<br>
</li><li>ArduinoMega <a href='http://arduino.cc/en/Main/ArduinoBoardMega'>http://arduino.cc/en/Main/ArduinoBoardMega</a> with/without preinstalled arduino bootloader or installable resident monitor bamo128 <a href='http://bamo128.googlecode.com'>http://bamo128.googlecode.com</a>
</li><li>XPLAIN- board with atxmega128A1 (in development, see this repository)</li></ul>

The modular software structure make it simple to adapt the software to other boards or microcontrollers with a minimum of flash and data memory.<br>
Check download area for latest stable revision.<br>

<h3>Bajos at Arduino controls a Lego-Robot and an alphanumeric display</h3>
<p><img src='http://cs.ba-berlin.de/Bild3-800.jpg' alt='' width='640' height='480' />

<img src='http://cs.ba-berlin.de/P3120061-800r.jpg' alt='' width='480' height='480' /></p>

<h3>Bajos at atmel's STK1000 (32 Bit AP7000) as standalone application with an graphic demo (affine transforms, projection, bilinear interpolation,HLHSR-algorithm,...)</h3>
<p><img src='http://cs.ba-berlin.de/stk1.jpg' alt='' width='640' height='480' /></p>

<p><img src='http://cs.ba-berlin.de/stk2.jpg' alt='' width='520' height='384' /></p>