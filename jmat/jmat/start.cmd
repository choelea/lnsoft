@echo off

setlocal enableextensions
cd /d %~dp0
if exist jmat\init.cmd pushd . && goto init
if exist ..\jmat\init.cmd pushd .. & goto init
goto :eof

:init
call jmat\init.cmd
ttle 启动 Tomcat 和 MySQL 服务
call :execute jmat\mysql_start.cmd
call :execute jmat\tomcat_start.cmd


:execute
if exist %1 (call %1 && goto :eof) else echo %1 不存在. & pause & exit