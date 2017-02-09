/*Constantes identifiant les LED*/
#define LED_B     9
#define LED_R     10

/*Buffeur de reception de données*/
char dataRecvL[2];

void setup() {
   pinMode(LED_B, OUTPUT);
   pinMode(LED_R, OUTPUT);
   Serial.begin(9600);
}

void loop() {

  if(Serial.available()){
    
    dataRecvL[0] = Serial.read();
    dataRecvL[1]= 0;
    
    if(strcmp(dataRecvL,"B")==0){
        Serial.println(dataRecvL);
        digitalWrite(LED_R, LOW); 
        digitalWrite(LED_B, HIGH);   
        delay(500);           
    }
    if(strcmp(dataRecvL,"R")==0){
        Serial.println(dataRecvL);
        digitalWrite(LED_B, LOW); 
        digitalWrite(LED_R, HIGH);   
        delay(500);     
    }      
  }
}
