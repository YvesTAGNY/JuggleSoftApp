
//Arduino nano et MPU-6050

#include <Wire.h>

// MPU-6000 I2C address is 0x68(104)
#define Addr 0x68

/*Declaration data to send*/
char coordonnee[100];
  char oldCoordonnee[100];
int x,y,z,a,b,c;

void setup()
{
  // Initialise I2C communication as Master
  Wire.begin();
  // Initialise serial communication, set baud rate = 9600
  Serial.begin(9600);
  
  // Start I2C transmission
  Wire.beginTransmission(Addr);
  // Select gyroscope configuration register
  Wire.write(0x1B);
  // Full scale range = 2000 dps
  Wire.write(0x18);
  // Stop I2C transmission
  Wire.endTransmission();
  
  // Start I2C transmission
  Wire.beginTransmission(Addr);
  // Select accelerometer configuration register
  Wire.write(0x1C);
  // Full scale range = +/-16g
  Wire.write(0x18);
  // Stop I2C transmission
  Wire.endTransmission();
  
  // Start I2C transmission
  Wire.beginTransmission(Addr);
  // Select power management register
  Wire.write(0x6B);
  // PLL with xGyro reference
  Wire.write(0x01);
  // Stop I2C transmission
  Wire.endTransmission();
  delay(300);
}

//define format data
void getInputs(){   
    sprintf(coordonnee, "B1_XYZ:%d|%d|%d::ABC:%d|%d|%d",
        x,
        y,
        z,
        a,
        b,
        c
    );
}

void loop()
{
  unsigned int data[6];

  // Start I2C transmission
  Wire.beginTransmission(Addr);
  // Select data register
  Wire.write(0x3B);
  // Stop I2C transmission
  Wire.endTransmission();
  
  // Request 6 bytes of data
  Wire.requestFrom(Addr, 6);
  
  // Read 6 byte of data 
  if(Wire.available() == 6)
  {
    data[0] = Wire.read();
    data[1] = Wire.read();
    data[2] = Wire.read();
    data[3] = Wire.read();
    data[4] = Wire.read();
    data[5] = Wire.read(); 
  }
  
  // Convert the data
  int xAccl = data[0] * 256 + data[1];
  int yAccl = data[2] * 256 + data[3];
  int zAccl = data[4] * 256 + data[5];

  // Start I2C transmission
  Wire.beginTransmission(Addr);
  // Select data register 
  Wire.write(0x43);
  // Stop I2C transmission
  Wire.endTransmission();
  
  // Request 6 bytes of data
  Wire.requestFrom(Addr, 6);
  
  // Read 6 byte of data 
  if(Wire.available() == 6)
  {
    data[0] = Wire.read();
    data[1] = Wire.read();
    data[2] = Wire.read();
    data[3] = Wire.read();
    data[4] = Wire.read();
    data[5] = Wire.read(); 
  }
  // Convert the data
  int xGyro = data[0] * 256 + data[1];
  int yGyro = data[2] * 256 + data[3];
  int zGyro = data[4] * 256 + data[5];

  // Output data to serial monitor
  x=xGyro;
  y=yGyro;
  z=zGyro;
  a=xAccl;
  b=yAccl;
  c=zAccl;
   getInputs();
    if( strcmp(coordonnee, oldCoordonnee) != 0){
        strcpy(oldCoordonnee, coordonnee);
        Serial.println(coordonnee);
    }
  delay(500);
}
