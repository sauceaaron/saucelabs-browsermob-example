# saucelabs-browsermob-example

This demonstrates how to run Browsermob proxy and have it filter requests and rewrite a URL.

For example, it will change requests from `http://foo.example.com/foo.html` to `http://bar.example.com/bar.html`

To use browsermob with Sauce Connect see the following documentation:
https://wiki.saucelabs.com/display/DOCS/Sauce+Connect+Proxy+with+an+Additional+Proxy+Setup

or just run sauce connect and browsermob (on the same host) like this:

```
sc --proxy localhost:55555
```

Note that the default port for browsermob proxy is random, but in my example is set to 55555.


You can also use a PAC file to specify when to use browsermob proxy:

sc -PAC browsermob.js

(see the included browsermob.js file.  You may need to change the port if you are not using 55555.)