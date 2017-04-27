
char coordonnee[20];
char oldCoordonnee[20];
long x,y,z,a,b,c;

void setup() {
  Serial.begin(9600);
}

void getInputs(){   
    sprintf(coordonnee, "B1_XYZ:%d-%d-%d::ABC:%d-%d-%d",
        x,
        y,
        z,
        a,
        b,
        c
    );
}

void randomXYZ(){
  x = random(0, 100);
  y = random(0, 100);
  z = random(0, 100);
}

void loop() {
    randomXYZ();
    getInputs();
    if( strcmp(coordonnee, oldCoordonnee) != 0){
        strcpy(oldCoordonnee, coordonnee);
        Serial.println(coordonnee);
        delay(333);
    }
}
