@echo off


setlocal enableextensions
cd /d %~dp0
if exist jmat\init.cmd pushd . && goto init
if exist ..\jmat\init.cmd pushd .. & goto init
goto :eof

:init
call jmat\init.cmd
title 启动 Tomcat 服务
goto check

:check
sc query |find /i "%tomcat_service_name%" >nul 2>nul
if not errorlevel 1 (goto tomcat_service_exist) else goto start_tomcat_service

:tomcat_service_exist
echo -----------------------------------------------------------------
echo Tomcat 服务已经启动
echo -----------------------------------------------------------------
set /p input=是否继续?(Y/N)
if /i "%input%"=="y" goto start_tomcat_service
echo.
goto end

:start_tomcat_service
echo Starting Tomcat, please wait ...
if not exist "jmat\netstat.exe" echo jmat\netstat.exe 不存在. & pause & exit
if not exist "jmat\tasklist.exe" echo jmat\tasklist.exe 不存在. & pause & exit
%java% CheckPort "%jtm_path%\jmat\netstat.exe" "%jtm_path%\jmat\tasklist.exe" "%tomcat_port%"
if errorlevel 1 pause & echo. & goto end
set CATALINA_HOME=%jtm_path%\%tomcat_dir%
set JAVA_HOME=%jtm_path%\%jdk_dir%
pushd %tomcat_dir%
bin\service.bat install %tomcat_service_name% & net start %tomcat_service_name%
popd
echo.
goto end

:end
popd