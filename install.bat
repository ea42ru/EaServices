set PR_PATH=%CD%
set JavaHome="P:\IdeaProjects\jre8_111\"
SET PR_SERVICE_NAME=MyService
SET PR_JAR=MyService.jar
SET START_CLASS=ru.ea42.EaServices.EngineLauncher
SET START_METHOD=start
SET STOP_CLASS=ru.ea42.EaServices.EngineLauncher
SET STOP_METHOD=stop
SET JVM_OPTIONS=-Dapp.home=%PR_PATH%

prunsrv.exe //DS//%PR_SERVICE_NAME%
prunsrv.exe //IS//%PR_SERVICE_NAME% --Install="%PR_PATH%\prunsrv.exe" --Jvm=auto --Startup=manual --StartMode=jvm --StartClass=%START_CLASS% --StartMethod=%START_METHOD% --StopMode=jvm --StopClass=%STOP_CLASS% --StopMethod=%STOP_METHOD% --Classpath="%PR_PATH%\%PR_JAR%" --DisplayName="%PR_SERVICE_NAME%" ++JvmOptions=%JVM_OPTIONS% --JavaHome=%JavaHome%
