wget http://localhost:8080/web/rest/one/4

groovy -e "println new URL('http://localhost:8080/web/rest/one/4').text"


