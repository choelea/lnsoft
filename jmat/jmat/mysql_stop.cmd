@echo off


setlocal enableextensions
cd /d %~dp0
if exist jmat\init.cmd pushd . && goto init
if exist ..\jmat\init.cmd pushd .. & goto init
goto :eof

:init
call jmat\init.cmd
title 停止 MySQL 服务
goto check

:check
sc query |find /i "%mysql_service_name%" >nul 2>nul
if not errorlevel 1 (goto stop_mysql_service) else goto mysql_service_not_exist

:mysql_service_not_exist
echo -----------------------------------------------------------------
echo MySQL 服务未启动
echo -----------------------------------------------------------------
set /p input=是否继续?(Y/N)
if /i "%input%"=="y" goto stop_mysql_service
echo.
goto end

:stop_mysql_service
echo Current location: %cd%
echo Shutting down MySQL service: %mysql_service_name%, please wait ...
net stop %mysql_service_name%
mysql\bin\mysqld.exe --remove %mysql_service_name%
echo.
goto end

:end
popd