package App;

import java.util.Enumeration;

import gnu.io.CommPortIdentifier;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Program started");
		
		//déclaration d'un identifieur de ports
	    CommPortIdentifier serialPortId;
	    
	    //static CommPortIdentifier sSerialPortId;
	    Enumeration enumComm;
	    
	    //SerialPort serialPort;

	    enumComm = CommPortIdentifier.getPortIdentifiers();
	    while (enumComm.hasMoreElements()) {
	     	serialPortId = (CommPortIdentifier) enumComm.nextElement();
	     	if(serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
	    		System.out.println(serialPortId.getName());
	    	}
	    }

		System.out.println("Finished successfully");
	}

}
