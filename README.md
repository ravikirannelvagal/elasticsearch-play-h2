# Holidu Search Challenge

This challenge is based on a example project provided by play.
https://github.com/playframework/play-java-ebean-example

## Requirements
- Java
- SBT

## Usage
1. Change the directory to the project
2. Execute `sbt`
3. After the project is loaded execute `run`
4. Open `localhost:9000` in your browser
5. You may be prompted by the apply evolutions screen, simply press `Apply this script now!`. If everything is up 
and running smoothly, you will see the holidu welcome response

```
{
  title: "Holidu Search Challenge",
  version: "1"
}
```


## Coding
Usually you don't have to stop and start the application while you are implementing the features.
Just safe the code and refresh the page in the browser.

But in case you experience some weird issues you should stop the application (CTRL+D) and execute `run` again.

NOTE: CTRL+C will also stop sbt and you need to execute `sbt` again and afterwards `run`.

## Testing
There are some 
``` 
sbt
test-only com.holidu.HomeControllerFunctionalTest
test-only com.holidu.HomeControllerIntegrationTest
test-only com.holidu.SampleModelTest
```

## IDE
We suggest using IntelliJ Ultimate e.g. as a free 30 days trial.

## Samples
There is a `SampleModel` to demonstrate the usage of Ebean.

There is a `SampleController` to demonstrate the usage of routes and Elasticsearch.

Get sample by id from the database:
```
curl -XGET 'localhost:9000/sample/1'
```


Add a new sample to the database (if you use Postman you need to specify the Content-Type header to application/json):

```
curl -XPOST -H "Content-Type: application/json" 'localhost:9000/sample' -d '{
    "id": 4,
    "name": "second sample"
}'
```

Index a sample from the database to Elasticsearch:
```
curl -XGET 'localhost:9000/sample/index/1'
``` 

Search in Elasticsearch for samples with contain "first" in the name:
```
curl -XGET 'localhost:9000/sample/search?name=first'
``` 

Search documents in Elasticsearch directly where every document matches:
```
curl -XPOST 'http://search-challange.holidu.com:9200/sample_index/_search?pretty' -d '{
    "query": {
        "match_all": {}
    }
}'
```

Search documents in Elasticsearch directly where the name contains "first":
```
curl -XPOST 'http://search-challange.holidu.com:9200/sample_index/_search?pretty' -d '{
    "query" : {
        "match": {
            "name": "first"
        }
    }
}'
```

## Scoring

Things to keep in mind:

* Write clean code. Document where ever you feel it is necessary to explain something.
* Tests are always welcome ! They put a smile on our face 🙂
* Do not re-invent the wheel.
* Simpler is better.
* Some major points to remember from the [Zen of Python](https://www.python.org/dev/peps/pep-0020/)
    * Beautiful is better than ugly.
    * Simple is better than complex.
    * Complex is better than complicated.
