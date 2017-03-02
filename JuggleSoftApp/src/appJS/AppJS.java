package appJS;

import java.util.Enumeration;

import gnu.io.CommPortIdentifier;

public class AppJS {

	/**
	 * Main
	 * @throws Exception 
	 * */
	
	public static void main(String[] args) throws Exception {
		System.out.println("Program started");
		
		//declaration of port identifier
	    CommPortIdentifier port;
	    
	    //declaration of iterator of port
	    Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();
	    
	    while (ports.hasMoreElements()) {
	    	port = (CommPortIdentifier) ports.nextElement();
	     	if(port.getPortType() == CommPortIdentifier.PORT_SERIAL) {
	     		ConnectSerialPort.log("Port " + port.getName());
	    	}
	    }

	    ConnectSerialPort sp = new ConnectSerialPort();
	    sp.OpenPort();
	    
	    /*while(true){
	    	log("Send " + CONSTANTES.BLEU);
		    sp.serialOut.write(CONSTANTES.BLEU.getBytes());
		    Thread.sleep(1000);
		    log("Send " + CONSTANTES.ROUGE);
		    sp.serialOut.write(CONSTANTES.ROUGE.getBytes());
		    Thread.sleep(1000);
	    }*/
	    
		//System.out.println("Finished successfully");
	}

}
