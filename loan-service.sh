mvn clean compile install
docker build -t vinothg2309/loan-service .
docker push vinothg2309/loan-service
kubectl delete -f loan-service.yaml
kubectl apply -f loan-service.yaml
