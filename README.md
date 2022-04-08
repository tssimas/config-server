# config-server

## Get Config
> curl --location --request GET 'http://localhost:9400/processor/default/main' --header 'Authorization: Basic YWRtaW46YWRtaW4='

## Health Check
> curl --location --request GET 'http://localhost:9400/actuator/health' --header 'Authorization: Basic Y29uZmlnLXNlcnZlcjpjb25maWctc2VydmVy'

## Encrypt
> curl --location --request POST 'http://localhost:9400/encrypt' --header 'Authorization: Basic YWRtaW46YWRtaW4=' --header 'Content-Type: text/plain' --data-raw 'password'

## Decrypt
> curl --location --request POST 'http://localhost:9400/decrypt' --header 'Content-Type: text/plain' --header 'Authorization: Basic YWRtaW46YWRtaW4=' --data-raw 'AQA2986pttnsYbxRT2S8CY7/crV+B3V99PRkl8I9NCY+NNP2Wz5vWdRP/S6w1zrSBvDt7ixMhpgV3ePdlUMstdWNR4MXyocWyHGyLpTb/tk5vhzMS1AI4MLDN+WWlESrAbh39UopTZQ8a4Px8jzNYbwmB4ZZZksflNeYnZtVfGnMV/go9z+Z/3NsSz2oRtdQV6dAiW2IiZ1A8qht3rafh/HmMT02X9OwlZqnJHwEeLeddCVgTyMxfldQ6oHBZ9NNjVxrm35nGMclL9xhn852N2kuZv3NSrhhECPP9PFJBUT4dVuyaaALV1DnNRASmHmkY7k2tmLtyKFWaHGsAWlPEeMN0GC5CAs1AShjdI5iXzATMJ+6sCNjnDpIzBLGqy5wE0I='
