@echo off


setlocal enableextensions
cd /d %~dp0
if exist jmat\init.cmd pushd . && goto init
if exist ..\jmat\init.cmd pushd .. & goto init
goto :eof

:init
call jmat\init.cmd
title ֹͣ Tomcat �� MySQL ����
call :execute jmat\tomcat_stop.cmd
echo.
call :execute jmat\mysql_stop.cmd

:execute
if exist %1 (call %1 && goto :eof) else echo %1 ������. & pause & exit