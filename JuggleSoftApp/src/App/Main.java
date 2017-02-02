package App;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class Main {
	
	// Seial port 
	SerialPort serialPort;
			
	// Streams 
	private InputStream    serialIn;
	private OutputStream   serialOut;
	private BufferedReader serialReader;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Show Console
		 * 
		 * Show window and open the serial port
		 * 
		 * @throws Exception In fail case like: NoSuchPortException, PortInUseException, UnsupportedCommOperationException 
		 */
		/**
		public void begin() throws Exception{
			
			// Open port
			CommPortIdentifier port = CommPortIdentifier.getPortIdentifier("COM15"); 
	        CommPort commPort = port.open(this.getClass().getName(),2000);
	        serialPort = (SerialPort) commPort;
	        serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			serialIn=serialPort.getInputStream();
			serialOut=serialPort.getOutputStream();
			serialReader = new BufferedReader( new InputStreamReader(serialIn) );
	        serialPort.addEventListener(this);
	        serialPort.notifyOnDataAvailable(true);
	        
		}
		*/
		
		System.out.println("Program started");
		
		//déclaration d'un identifieur de ports
	    CommPortIdentifier port;
	    
	    //déclaration d'itérateur de port
	    Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();
	    
	    while (ports.hasMoreElements()) {
	    	port = (CommPortIdentifier) ports.nextElement();
	     	if(port.getPortType() == CommPortIdentifier.PORT_SERIAL) {
	    		System.out.println(port.getName());
	    	}
	    }

		System.out.println("Finished successfully");
	}

}
