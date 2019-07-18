#include <SoftwareSerial.h>
#include <OneWire.h>                
#include <DallasTemperature.h>// Incluimos la librería  SoftwareSerial  
SoftwareSerial BT(10,11);    // Definimos los pines RX y TX del Arduino conectados al Bluetooth
OneWire ourWire(9);                //Se establece el pin 2  como bus OneWire
 
DallasTemperature sensors(&ourWire); //Se declara una variable u objeto para nuestro sensor

void setup()
{
  delay(100);
  BT.begin(9600);       // Inicializamos el puerto serie BT que hemos creado
  Serial.begin(9600);   // Inicializamos  el puerto serie  
}
 
void loop()
{

  if(BT.available())    // Si llega un dato por el puerto BT se envía al monitor serial
  {
    char VarChar;
    VarChar = BT.read();
    if (VarChar == '1')
    {
      char Aux='1';
      while(Aux=='1'){
        delay(2000);
        sensors.requestTemperatures();   //Se envía el comando para leer la temperatura
        float temp= sensors.getTempCByIndex(0); //Se obtiene la temperatura en ºC
        BT.print(String(temp));
        BT.print("#");
        char Aux2;
        Aux2 = BT.read();
        if (Aux2=='0'){
          Aux=0;
        }
      }
    }
  }

 }
