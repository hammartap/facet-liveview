# facet-liveview

An example application which demonstrates liveview retrieving of Sony Remote Camera Control API Beta.

## Usage
1. Make sure your machine is connected Sony Camera via WiFi.
2. Clone this repository, then fire up REPL.
3. Import the library and execute `(-main)`

```bash
$ git clone https://github.com/hammartap/facet-liveview.git
$ cd facet-liveview
$ lein repl
bash

```clj
;; Change namespace.
;; This is optional. But it is helpful when playing with it.
(ns facet-liveview.core)

;; Import a library.
(use 'facet-liveview.core )

;; Then, call main function.
(-main)

;; Take a picture.
;; This will returns a map which contains URL of a photo and API executed id.
(takeAndFetchPicture)

;; Finish the window.
(ql/sketch-close liveview)
clj

## License

Copyright © 2014 hammartap

Distributed under the Eclipse Public License, the same as Clojure.