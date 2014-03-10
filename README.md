yaus
====

Yet Another URL Shortener
-------------------------

Demo site: http://yaus.no-ip.biz

Grails implementation of an URL Shortener based on a Base62 bijective function, no collision is possible.

Generated URL length will grow with the need of more URL shortenings. 

The URL space will grow exponentially by adding characters.

A checksum character has been added to avoid direct iteration of the URL space.

If the shortening of an existing URL is done, a new code is generated:
 - performance is increased when shortening
 - future features: 2 users may shorten same URL and keep track of their own link

Expected future features:
 - Keep track of visited short links to grab some stats
 - Cache last generated and most visited URLs
 - User account: view stats
 - Usability improvements:
  - Copy short URL to clipboard
  - Go back on short URL view
