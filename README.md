# hackday2015-locum-app
Hack Day 2015 Locum App

## Service Host
Pupfish01 tomcat instance:
- http://pupfish01.internal.bmjgroup.com:8080/manager/html

## Service URL
- http://pupfish01.internal.bmjgroup.com:8080/locumservice

## Search JSON request
--
{
 "role":"doctor",
 "grade":"registrar",
 "specialty":"geriatrics"
}
--

## Run application
- nohup java -jar locumservice.jar &

## View output
-  tail -f nohup.out

## Get application PID
-  ps -ef | grep 'java' | grep 'locumservice.jar' | cut -d' '  -f 4

## Stop application
-  kill -9 <PID>
