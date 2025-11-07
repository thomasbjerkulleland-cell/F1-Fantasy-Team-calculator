setlocal

set JAR=target\calculator-run.jar

if not exist "%JAR%" (
    call mvn clean package
    goto run
)

for %%A in ("%JAR%") do set JAR_TIME=%%~tA

set REBUILD=false
for /r src %%f in (*.java) do (
    for %%B in ("%%f") do (
        if "%%~tB" GTR "%JAR_TIME%" (
            set REBUILD=true
            goto rebuild
        )
    )
)

:rebuild
if "%REBUILD%"=="true" (
    call mvn clean package
)

:run
cmd /c "java -cp %JAR% Calculator"

endlocal