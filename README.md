# payment-gateway-checkout.com-task

#run database with docker container -> the below command:

$ docker run -d --name paymentdb -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_USER=pay -e MYSQL_DATABASE=payment -e MYSQL_PASSWORD=pass -p 3306:3306 mysql:latest