import groovy.json.JsonSlurper

def size = args[0] as Integer
def json = new URL("http://localhost:8080/web/rest/one/$size").text
def cols = new JsonSlurper().parseText(json)

cols.each {pos ->
  println " " * pos + "*"
}

