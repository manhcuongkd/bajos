/*
 * HWR-Berlin, Fachbereich Berufsakademie, Fachrichtung Informatik
 * See the file "license.terms" for information on usage and redistribution of this file.
 */
//@authors  22.02.2008; Anna Maria Damm; FHW-BA Berlin; Bayer Schering Pharma AG
//	 		H.-Christian Hecht, FHW-BA Berlin; CoMedServ GmbH
//			Adrian Lang,FHW-BA Berlin; Fritz-Haber-Institut
//			Stephan Bauer; FHW-BA Berlin; Bayer Schering Pharma AG
//	    13.02.2009; Sebastian Starroske; FHW-BA Berlin; Bayer Schering Pharma AG
//	    09.03.2009; Friedrich Grosse; FHW-BA Berlin; Deutsche Post IT-Services
//			Rainer Kirchhoff ; FHW-BA Berlin; MSA Auer GmbH

package platform;

public class PlatForm {

	/*
	 * interrupts
	 */

	public static final byte RESET = 0;
	public static final byte INT0 = 1;
	public static final byte INT1 = 2;
	public static final byte INT2 = 3;
	public static final byte INT3 = 4;
	public static final byte INT4 = 5;
	public static final byte INT5 = 6;
	public static final byte INT6 = 7;
	public static final byte INT7 = 8;
	public static final byte PCINT0 = 9;
	public static final byte PCINT1 = 10;
	public static final byte PCINT2 = 11;
	public static final byte WDT = 12;
	public static final byte TIMER2_COMPA = 13;
	public static final byte TIMER2_COMPB = 14;
	public static final byte TIMER2_OVF = 15;
	public static final byte TIMER1_CAPT = 16;
	public static final byte TIMER1_COMPA = 17;
	public static final byte TIMER1_COMPB = 18;
	public static final byte TIMER1_COMPC = 19;
	public static final byte TIMER1_OVF = 20;
	public static final byte TIMER0_COMPA = 21;
	public static final byte TIMER0_COMPB = 22;
	public static final byte TIMER0_OVF = 23;
	public static final byte SPI_STC = 24;
	public static final byte USART0_RX = 25;
	public static final byte USART0_UDRE = 26;
	public static final byte USART0_TX = 27;
	public static final byte ANALOG_COMP = 28;
	public static final byte ADC = 29;
	public static final byte EE_READY = 30;
	public static final byte TIMER3_CAPT = 31;
	public static final byte TIMER3_COMPA = 32;
	public static final byte TIMER3_COMPB = 33;
	public static final byte TIMER3_COMPC = 34;
	public static final byte TIMER3_OVF = 35;
	public static final byte USART1_RX = 36;
	public static final byte USART1_UDRE = 37;
	public static final byte USART1_TX = 38;
	public static final byte TWI = 39;
	public static final byte SPM_READY = 40;
	public static final byte TIMER4_CAPT = 41;
	public static final byte TIMER4_COMPA = 42;
	public static final byte TIMER4_COMPB = 43;
	public static final byte TIMER4_COMPC = 44;
	public static final byte TIMER4_OVF = 45;
	public static final byte TIMER5_CAPT = 46;
	public static final byte TIMER5_COMPA = 47;
	public static final byte TIMER5_COMPB = 48;
	public static final byte TIMER5_COMPC = 49;
	public static final byte TIMER5_OVF = 50;
	public static final byte USART2_RX = 51;
	public static final byte USART2_UDRE = 52;
	public static final byte USART2_TX = 53;
	public static final byte USART3_RX = 54;
	public static final byte USART3_UDRE = 55;
	public static final byte USART3_TX = 56;

	// Ports
	public static final int UDR3 = 0x136;
	public static final int UBRR3H = 0x135;
	public static final int UBRR3L = 0x134;
	public static final int UCSR3C = 0x132;
	public static final int UCSR3B = 0x131;
	public static final int UCSR3A = 0x130;
	public static final int OCR5CH = 0x12d;
	public static final int OCR5CL = 0x12c;
	public static final int OCR5BH = 0x12b;
	public static final int OCR5BL = 0x12a;
	public static final int OCR5AH = 0x129;
	public static final int OCR5AL = 0x128;
	public static final int ICR5H = 0x127;
	public static final int ICR5L = 0x126;
	public static final int TCNT5H = 0x125;
	public static final int TCNT5L = 0x124;
	public static final int TCCR5C = 0x122;
	public static final int TCCR5B = 0x121;
	public static final int TCCR5A = 0x120;
	public static final int PORTL = 0x10b;
	public static final int DDRL = 0x10a;
	public static final int PINL = 0x109;
	public static final int PORTK = 0x108;
	public static final int DDRK = 0x107;
	public static final int PINK = 0x106;
	public static final int PORTJ = 0x105;
	public static final int DDRJ = 0x104;
	public static final int PINJ = 0x103;
	public static final int PORTH = 0x102;
	public static final int DDRH = 0x101;
	public static final int PINH = 0x100;
	public static final int UDR2 = 0xd6;
	public static final int UBRR2H = 0xd5;
	public static final int UBRR2L = 0xd4;
	public static final int UCSR2C = 0xd2;
	public static final int UCSR2B = 0xd1;
	public static final int UCSR2A = 0xd0;
	public static final int UDR1 = 0xce;
	public static final int UBRR1H = 0xcd;
	public static final int UBRR1L = 0xcc;
	public static final int UCSR1C = 0xca;
	public static final int UCSR1B = 0xc9;
	public static final int UCSR1A = 0xc8;
	public static final int UDR0 = 0xc6;
	public static final int UBRR0H = 0xc5;
	public static final int UBRR0L = 0xc4;
	public static final int UCSR0C = 0xc2;
	public static final int UCSR0B = 0xc1;
	public static final int UCSR0A = 0xc0;
	public static final int TWAMR = 0xbd;
	public static final int TWCR = 0xbc;
	public static final int TWDR = 0xbb;
	public static final int TWAR = 0xba;
	public static final int TWSR = 0xb9;
	public static final int TWBR = 0xb8;
	public static final int ASSR = 0xb6;
	public static final int OCR2B = 0xb4;
	public static final int OCR2A = 0xb3;
	public static final int TCNT2 = 0xb2;
	public static final int TCCR2B = 0xb1;
	public static final int TCCR2A = 0xb0;
	public static final int OCR4CH = 0xad;
	public static final int OCR4CL = 0xac;
	public static final int OCR4BH = 0xab;
	public static final int OCR4BL = 0xaa;
	public static final int OCR4AH = 0xa9;
	public static final int OCR4AL = 0xa8;
	public static final int ICR4H = 0xa7;
	public static final int ICR4L = 0xa6;
	public static final int TCNT4H = 0xa5;
	public static final int TCNT4L = 0xa4;
	public static final int TCCR4C = 0xa2;
	public static final int TCCR4B = 0xa1;
	public static final int TCCR4A = 0xa0;
	public static final int OCR3CH = 0x9d;
	public static final int OCR3CL = 0x9c;
	public static final int OCR3BH = 0x9b;
	public static final int OCR3BL = 0x9a;
	public static final int OCR3AH = 0x99;
	public static final int OCR3AL = 0x98;
	public static final int ICR3H = 0x97;
	public static final int ICR3L = 0x96;
	public static final int TCNT3H = 0x95;
	public static final int TCNT3L = 0x94;
	public static final int TCCR3C = 0x92;
	public static final int TCCR3B = 0x91;
	public static final int TCCR3A = 0x90;
	public static final int OCR1CH = 0x8d;
	public static final int OCR1CL = 0x8c;
	public static final int OCR1BH = 0x8b;
	public static final int OCR1BL = 0x8a;
	public static final int OCR1AH = 0x89;
	public static final int OCR1AL = 0x88;
	public static final int ICR1H = 0x87;
	public static final int ICR1L = 0x86;
	public static final int TCNT1H = 0x85;
	public static final int TCNT1L = 0x84;
	public static final int TCCR1C = 0x82;
	public static final int TCCR1B = 0x81;
	public static final int TCCR1A = 0x80;
	public static final int DIDR1 = 0x7f;
	public static final int DIDR0 = 0x7e;
	public static final int DIDR2 = 0x7d;
	public static final int ADMUX = 0x7c;
	public static final int ADCSRB = 0x7b;
	public static final int ADCSRA = 0x7a;
	public static final int ADCH = 0x79;
	public static final int ADCL = 0x78;
	public static final int XMCRB = 0x75;
	public static final int XMCRA = 0x74;
	public static final int TIMSK5 = 0x73;
	public static final int TIMSK4 = 0x72;
	public static final int TIMSK3 = 0x71;
	public static final int TIMSK2 = 0x70;
	public static final int TIMSK1 = 0x6f;
	public static final int TIMSK0 = 0x6e;
	public static final int PCMSK2 = 0x6d;
	public static final int PCMSK1 = 0x6c;
	public static final int PCMSK0 = 0x6b;
	public static final int EICRB = 0x6a;
	public static final int EICRA = 0x69;
	public static final int PCICR = 0x68;
	public static final int OSCCAL = 0x66;
	public static final int PRR1 = 0x65;
	public static final int PRR0 = 0x64;
	public static final int CLKPR = 0x61;
	public static final int WDTCSR = 0x60;
	public static final int SREG = 0x5f;
	public static final int SPH = 0x5e;
	public static final int SPL = 0x5d;
	public static final int EIND = 0x5c;
	public static final int RAMPZ = 0x5b;
	public static final int SPMCSR = 0x57;
	public static final int MCUCR = 0x55;
	public static final int MCUSR = 0x54;
	public static final int SMCR = 0x53;
	public static final int OCDR = 0x51;
	public static final int ACSR = 0x50;
	public static final int SPDR = 0x4e;
	public static final int SPSR = 0x4d;
	public static final int SPCR = 0x4c;
	public static final int GPIOR2 = 0x4b;
	public static final int GPIOR1 = 0x4a;
	public static final int OCR0B = 0x48;
	public static final int OCR0A = 0x47;
	public static final int TCNT0 = 0x46;
	public static final int TCCR0B = 0x45;
	public static final int TCCR0A = 0x44;
	public static final int GTCCR = 0x43;
	public static final int EEARH = 0x42;
	public static final int EEARL = 0x41;
	public static final int EEDR = 0x40;
	public static final int EECR = 0x3f;
	public static final int GPIOR0 = 0x3e;
	public static final int EIMSK = 0x3d;
	public static final int EIFR = 0x3c;
	public static final int PCIFR = 0x3b;
	public static final int TIFR5 = 0x3a;
	public static final int TIFR4 = 0x39;
	public static final int TIFR3 = 0x38;
	public static final int TIFR2 = 0x37;
	public static final int TIFR1 = 0x36;
	public static final int TIFR0 = 0x35;
	public static final int PORTG = 0x34;
	public static final int DDRG = 0x33;
	public static final int PING = 0x32;
	public static final int PORTF = 0x31;
	public static final int DDRF = 0x30;
	public static final int PINF = 0x2f;
	public static final int PORTE = 0x2e;
	public static final int DDRE = 0x2d;
	public static final int PINE = 0x2c;
	public static final int PORTD = 0x2b;
	public static final int DDRD = 0x2a;
	public static final int PIND = 0x29;
	public static final int PORTC = 0x28;
	public static final int DDRC = 0x27;
	public static final int PINC = 0x26;
	public static final int PORTB = 0x25;
	public static final int DDRB = 0x24;
	public static final int PINB = 0x23;
	public static final int PORTA = 0x22;
	public static final int DDRA = 0x21;
	public static final int PINA = 0x20;

	public native char nativeCharIn();

	public native void nativeCharOut(char c);

	public native void exit(int status);

	public native byte currentTimeMillis();

	public native byte nativeConStat();

	public native void nativeSetData(int addr, byte value); // sdram

	public native byte nativeGetData(int addr); // sdram

	public PlatForm() {
	}
}
