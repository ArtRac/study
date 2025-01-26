# Spark exercises

- [Uruchomienie Sparka na Dockerze](https://medium.com/@ay.workable/running-apache-spark-on-docker-made-simple-501eb7693856)
- [Przygotowanie IJ do pracy z PySpark](https://vincent.doba.fr/posts/20210124_pyspark-setup-for-intellij-idea/)
- [Zapisanie wyników do pliku csv](https://stackoverflow.com/questions/31937958/how-to-export-data-from-spark-sql-to-csv)

Można program uruchomić w ten sposób ...
```shell
docker exec -it spark-docker_spark_1 ./bin/spark-submit --master spark://spark:7077 ./work/simple-app.py
```
Można też bezpośrednio w konsoli mastera uruchomić interpreter Pythona ...

```shell
/opt/bitnami/spark$ ./bin/pyspark 
```

```python
df = spark.read.format("csv").option("delimiter",";").load("./work/resources/polimorfologik-2.1.txt")
df.show()
...
df.createOrReplaceTempView("temptable")
spark.sql("select count(length(_c0)) from temptable where _c0 like 'a%ll%'").show()
```
```shell
+------------------+
|count(length(_c0))|
+------------------+
|               836|
+------------------+
```
```python
df2.coalesce(1).write.format("csv").option("delimiter",";").save("./work/resources/polimorfologik.csv")
```
`coalesce(1)` - zapis wyniku do jednego pliku