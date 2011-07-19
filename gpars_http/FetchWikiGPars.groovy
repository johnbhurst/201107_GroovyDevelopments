import groovyx.gpars.GParsPool

def urls = [
  "http://en.wikipedia.org/wiki/Groovy_(programming_language)",
  "http://en.wikipedia.org/wiki/Object-oriented_programming",
  "http://en.wikipedia.org/wiki/Programming_paradigm",
  "http://en.wikipedia.org/wiki/Paradigm",
  "http://en.wikipedia.org/wiki/Science",
  "http://en.wikipedia.org/wiki/Knowledge",
  "http://en.wikipedia.org/wiki/Fact",
  "http://en.wikipedia.org/wiki/Information",
  "http://en.wikipedia.org/wiki/Sequence",
  "http://en.wikipedia.org/wiki/Mathematics",
  "http://en.wikipedia.org/wiki/Quantity",
  "http://en.wikipedia.org/wiki/Property_(philosophy)",
  "http://en.wikipedia.org/wiki/Modern_philosophy",
  "http://en.wikipedia.org/wiki/Philosophy"
]

def fetch = {url ->
  def filename = url.replace("http://en.wikipedia.org/wiki/", "").replace("(", "").replace(")", "") + ".html"
  println "Fetching $url..."
  new File(filename).text = new URL(url).text
  println "Saved $filename"
}

GParsPool.withPool() {
  def fetchAsync = fetch.async()
  urls.each {url ->
    fetchAsync(url)
  }
}

