int trig = 11;
int echo_read;
int echo = 10;
int cm;
int led=9;

void setup() {
  // put your setup code here, to run once:
pinMode(trig,OUTPUT);
digitalWrite(trig,LOW);
pinMode(echo,INPUT);

Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
digitalWrite(trig,HIGH);
delayMicroseconds(10);
digitalWrite(trig,LOW);

echo_read = pulseIn(echo,HIGH);
cm = echo_read/58;

Serial.print("Distance en cm:");
Serial.println(cm);
delay(150);
if (cm<8){
  digitalWrite(led,HIGH);
}
else{
  digitalWrite(led,LOW);}
}
  
