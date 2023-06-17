javac Ameaca\Entities\*.java -d ./build
@REM javac src\Repositories\*.java -d .
javac Ameaca\Services\*.java -d ./build
@REM javac src\Views\*.java -d .
javac -cp ".;sqlite-jdbc-3.42.0.0.jar" Ameaca\*.java -d ./build
copy Ameaca\dumpdb build\
copy Ameaca\Views\assets\*.png build\
timeout /t 3
cd build
java -cp ".;../sqlite-jdbc-3.42.0.0.jar" Ameaca.Principal
pause