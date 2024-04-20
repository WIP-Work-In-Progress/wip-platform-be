@echo off

set mongodb=mongodb_wip
set redis=redis_wip

docker ps -a | findstr /C:"%mongodb%" > nul
if %errorlevel% equ 0 (
    echo Container %mongodb% is already running!
) else (
    docker run --rm -d --name %mongodb% -p 27017:27017 -v C:/mongodb/wip-be-data:/data/db mongo:7.0.8
)

docker ps -a | findstr /C:"%redis%" > nul
if %errorlevel% equ 0 (
    echo Container %redis% is already running!
) else (
    docker run --rm -d --name %redis% -p 6379:6379 redis:7.2.4
)

