package appJS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class ConnectSerialPort implements SerialPortEventListener{
	
	//data receive
	public String dataRec;
	
	// Seial port 
	private SerialPort serialPort;
			
	// Streams 
	private InputStream serialIn;
	private OutputStream serialOut;
	private BufferedReader serialReader;

	/**
	 * Open the serial port
	 * @throws Exception In fail case like: NoSuchPortException, PortInUseException, UnsupportedCommOperationException 
	 */
	public void OpenPort() throws Exception{
		
		CommPortIdentifier port = CommPortIdentifier.getPortIdentifier(CONSTANTES.PORT); 
        CommPort commPort = port.open(this.getClass().getName(),2000);
        serialPort = (SerialPort) commPort;
        serialPort.setSerialPortParams(/*115200*/9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		serialIn = serialPort.getInputStream();
		serialOut = serialPort.getOutputStream();
		serialReader = new BufferedReader( new InputStreamReader(serialIn) );
        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
        
	}
	
	/**
	 * Each data send by arduino is taken here
	 */
	@Override
	public void serialEvent(SerialPortEvent arg0) {
		// TODO Auto-generated method stub
		try {
			dataRec = serialReader.readLine();
			log("Readed from serial : " + dataRec);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Send the color which lignt at the arduino
	 * */
	public void sendDataColor(){
		try {
			serialOut.write(CONSTANTES.BLEU.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * see data in console
	 * */
	public static void log(String line){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println( sdf.format(new Date()) + " --> " + line);
	}
}
