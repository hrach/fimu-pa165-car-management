# Projekt z PA165.

## Oficiální zadání:
Aplikácia eviduje vozidlá vo vozovom parku imaginárnej organizácie. Pre každé auto je možné definovať servisné intervaly, ktoré sú priradené k jednotlivým vozidlám. Vozidlo je definované základnými parametrami (značka, typ, rok výroby, typ motora, VIN, pocet km ...). Každému autu je priradených viac servisných intervalov, pričom sa definuje či daná kontrola prebehla, ak áno tak kedy. Auto musí íst na kontrolu v pravidelných intervaloch. Ak dosiahne určitý stav najazdených km nesmie byť dostupné pri výbere. Aplikácia bude schopná pridávať zamestnancov, ktorí si môžu auto požičať, avšak iba také, ktoré prináleží do jeho triedy zaradenia. Každému zamestnancovi je možné evidovat jazdy, ktoré absolvoval a bude možný výpis jázd, počtu km za určité obdobie. 

## Spuštění aplikace

Pro spuštění aplikace je nutný běžící databázový server na adrese 'localhost:1527/pa165'

### Webová aplikace

Webová aplikace lze spustit pomocí 'mvn tomcat7:run' na modulu CarManagement-web. Samotná aplikace pak běží na adrese http://localhost:8080/pa165/

### SOAP API

Spuštění SOAP serveru lze provést pomocí 'mvn exec:java' na modulu CarManagement-soap-server. Následně dojde k publikaci WSDL souborů na adresu http://localhost:9000/vehicleManager?wsdl (resp. http://localhost:9000/employeeManager?wsdl).

Klientskou aplikaci, která využívá výše uvedeného SOAP API lze spustit příkazem 'mvn tomcat7:run' na modulu CarManagement-soap-client. Webová aplikace následně běží na adrese http://localhost:8081/pa165-soap-client/


## Vedoucí týmu
- Petr Zvoníček @zvonicek

## Členové týmu
- Jan Škrášek @hrach
- Tomáš Bobek @tomasbobek
- Jakub Mareček @xmarec
