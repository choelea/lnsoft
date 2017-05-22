@echo off


setlocal enableextensions
cd /d %~dp0
if exist jmat\init.cmd pushd . && goto init
goto :eof

:init
call jmat\init.cmd
title JMAT %version%
goto menu

:menu
cls
echo Tomcat Port: %tomcat_port%
echo MySQL  Port: %mysql_port%
echo -----------------------------------------------------------------
echo 1  -  ����Tomcat + MySQL                 2  -  ֹͣTomcat + MySQL
echo 3  -  ����Tomcat                         4  -  ֹͣTomcat
echo 5  -  ����MySQL                          6  -  ֹͣMySQL
echo 7  -  ����Tomcat�˿�                     8  -  ����MySQL�˿�
echo 9  -  ���˿�״̬                       10 -  ����MySQL root����
echo -----------------------------------------------------------------
set /p input=��ѡ��: 
cls
if "%input%"=="1" call :execute jmat\start.cmd
if "%input%"=="2" call :execute jmat\stop.cmd
if "%input%"=="3" call :execute jmat\tomcat_start.cmd
if "%input%"=="4" call :execute jmat\tomcat_stop.cmd
if "%input%"=="5" call :execute jmat\mysql_start.cmd
if "%input%"=="6" call :execute jmat\mysql_stop.cmd
if "%input%"=="7" call goto change_tomcat_port
if "%input%"=="8" call goto change_mysql_port
if "%input%"=="9" call goto check_port
if "%input%"=="10" call goto change_mysql_root_password
goto end

:change_tomcat_port
cls
set /p new_tomcat_port=������ Tomcat �¶˿�(1-65535): 
if "%new_tomcat_port%"=="" goto change_tomcat_port
set CATALINA_HOME=%jtm_path%\%tomcat_dir%
%java% ChangeTomcatPort "%CATALINA_HOME%" "%new_tomcat_port%"
if errorlevel 1 pause & cls & goto change_tomcat_port
cls
set tomcat_port=%new_tomcat_port%
echo Tomcat �˿��޸ĳɹ�.
pause
sc query |find /i "%tomcat_service_name%" >nul 2>nul
if not errorlevel 1 goto restart_tomcat
goto end

:restart_tomcat
cls
echo ������������ Tomcat ...
net stop %tomcat_service_name% & net start %tomcat_service_name%
goto end

:change_mysql_port
cls
set /p new_mysql_port=������ MySQL �¶˿�(1-65535): 
if "%new_mysql_port%"=="" goto change_mysql_port
set MYSQL_HOME=%jtm_path%\%mysql_dir%
%java% ChangeMySQLPort "%MYSQL_HOME%" "%new_mysql_port%"
if errorlevel 1 pause & cls & goto change_mysql_port
cls
set mysql_port=%new_mysql_port%
echo MySQL �˿��޸ĳɹ�.
pause
sc query |find /i "%mysql_service_name%" >nul 2>nul
if not errorlevel 1 goto restart_mysql
goto end

:restart_mysql
cls
echo ������������ MySQL ...
net stop %mysql_service_name% & net start %mysql_service_name%
goto end

:change_mysql_root_password
cls
set /p new_mysql_root_password=������ root ������: 
if "%new_mysql_root_password%"=="" goto change_mysql_root_password
set jtm_temp=%jtm_path%\jmat\%RANDOM%.%RANDOM%
echo SET PASSWORD FOR 'root'@'localhost' = PASSWORD('%new_mysql_root_password%');>"%jtm_temp%"
if exist "%mysql_dir%\data\%COMPUTERNAME%.pid" net stop %mysql_service_name%
start /b %mysql_dir%\bin\mysqld.exe --defaults-file="%jtm_path%\%mysql_dir%\my.ini" --init-file="%jtm_temp%"
%mysql_dir%\bin\mysqladmin.exe shutdown -uroot -p"%new_mysql_root_password%"
%java% WaitMySQLStop "%COMPUTERNAME%" "%jtm_path%\%mysql_dir%"
echo.>"%jtm_temp%"
del "%jtm_temp%" /Q
net start %mysql_service_name%
cls
echo MySQL root �����޸ĳɹ�.
pause
goto end

:check_port
if not exist "jmat\netstat.exe" echo jmat\netstat.exe ������. & pause & exit
if not exist "jmat\tasklist.exe" echo jmat\tasklist.exe ������. & pause & exit
%java% CheckPort "%jtm_path%\jmat\netstat.exe" "%jtm_path%\jmat\tasklist.exe" "%tomcat_port%"
if not errorlevel 1 echo �˿� %tomcat_port% δ��ռ��.
%java% CheckPort "%jtm_path%\jmat\netstat.exe" "%jtm_path%\jmat\tasklist.exe" "%mysql_port%"
if not errorlevel 1 echo �˿� %mysql_port% δ��ռ��.
pause
goto menu

:execute
if exist %1 (call %1 && goto :eof) else echo %1 ������. & pause & exit

:end
popd