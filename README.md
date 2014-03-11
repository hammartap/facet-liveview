# facet-liveview

An example application which demonstrates liveview retrieving of Sony Remote Camera Control API Beta.

This example uses [facet](https://github.com/hammartap/facet) for retrieve liveview from Sony camera, and [Quil](https://github.com/quil/quil) for visualisation.

## Usage
1. Make sure your machine is connected Sony Camera via WiFi.
2. Clone this repository, then fire up REPL.
3. Import the library and execute `(-main)`

```
    $ git clone https://github.com/hammartap/facet-liveview.git
    $ cd facet-liveview
    $ lein repl
```

```clojure
;; Change namespace.
;; This is optional. But it is helpful when playing with it.
(ns facet-liveview.core)

;; Import a library.
(use 'facet-liveview.core)

;; Then, call main function.
(-main)

;; Take a picture.
;; This will returns a map which contains URL of a photo and API executed id.
(takeAndFetchPicture)

;; Finish the window.
(ql/sketch-close liveview)
```

## License

Copyright © 2014 hammartap

Distributed under the Eclipse Public License, the same as Clojure.
