# urlshortener
A small project that provides an API that shortens URLs and also restores the original.

## To run this project
- Clone the code to your workstation.
- run mvnw package to produce a runnable .jar file.
- Set two environment variables in your runtime to use a remote instance of Redis.(REDIS_HOST and REDIS_PORT). They default to localhost and 6379

To send a request and get a shortcode ID back, run a command similar to this:
#> curl http://localhost:8080/getshortcode?q=https://www.specialized.com/us/en/allez-sprint-comp-disc/p/154235?color=239317-154235

You'll get data back with an ID whose value is a guid. This represents the shortcode.

To retrieve the full url from the shortcode, enter another curl command but this time pass in the ID you got back, and be sure to watch the response header for a 302 redirect:

#> curl -i localhost:8080/redirect?q=60e2d7f2-39a1-424d-8c55-22232b2722b2
HTTP/1.1 302 
Location: https://www.specialized.com/us/en/allez-sprint-comp-disc/p/154235?color=239317-154235
Content-Language: en
Content-Length: 0
Date: Mon, 28 Jan 2019 05:38:40 GMT

