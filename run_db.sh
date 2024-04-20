mongodb=mongodb_wip
redis=redis_wip
if [ "$(docker ps -a | grep -w $mongodb)" != "" ]; then
	echo "Container $mongodb is already running!"
else
	docker run --rm -d --name mongodb_wip -p 27017:27017 -v $HOME/mongodb/wip-be-data:/data/db mongo:7.0.8
fi

if [ "$(docker ps -a | grep -w $redis)" != "" ]; then
	echo "Container $redis is already running!"
else
	docker run --rm -d --name redis_wip -p 6380:6380 redis:7.2.4
fi
