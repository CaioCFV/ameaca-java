javac Ameaca\Entities\*.java -d ./build
javac Ameaca\Repositories\*.java -d ./build
javac Ameaca\Services\*.java -d ./build
javac Ameaca\Views\*.java -d ./build
javac -cp ".;sqlite-jdbc-3.42.0.0.jar" Ameaca\*.java -d ./build
copy Ameaca\dumpdb build\
copy Ameaca\Views\assets\*.png build\
cd build
java -cp ".;../sqlite-jdbc-3.42.0.0.jar" Ameaca.Principal
pause