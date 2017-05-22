@echo off

setlocal enableextensions
cd /d %~dp0
if exist jmat\init.cmd pushd . && goto init
if exist ..\jmat\init.cmd pushd .. & goto init
goto :eof

:init
call jmat\init.cmd
title ���� MySQL ����
goto check

:check
sc query |find /i "%mysql_service_name%" >nul 2>nul
if not errorlevel 1 (goto mysql_service_exist) else goto start_mysql_service

:mysql_service_exist
echo -----------------------------------------------------------------
echo MySQL �����Ѿ�����
echo -----------------------------------------------------------------
set /p input=�Ƿ����?(Y/N)
if /i "%input%"=="y" goto start_mysql_service
echo.
goto end

:start_mysql_service
echo Starting MySQL, please wait ...
if not exist "jmat\netstat.exe" echo jmat\netstat.exe ������. & pause & exit
if not exist "jmat\tasklist.exe" echo jmat\tasklist.exe ������. & pause & exit
%java% CheckPort "%jtm_path%\jmat\netstat.exe" "%jtm_path%\jmat\tasklist.exe" "%mysql_port%"
if errorlevel 1 pause & echo. & goto end
%mysql_dir%\bin\mysqld.exe --install %mysql_service_name% --defaults-file="%jtm_path%\%mysql_dir%\my.ini"
net start %mysql_service_name%
echo.
goto end

:end
popd