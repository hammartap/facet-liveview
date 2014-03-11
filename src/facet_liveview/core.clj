(ns facet-liveview.core
  (:require [quil.core :as ql])
  (:require [facet.core :as ft])

  ;;(:import java.io.File)
  (:import javax.imageio.ImageIO)
  (:import java.io.ByteArrayInputStream)

  (:import [processing.core PConstants])
  (:gen-class))


;; An agent which holds current liveview image data.
(def liveview-agt (agent nil))


;; ## Setup function for Quil
(defn setup []
  ;; Call smooth function or too fast frame-rate setting may result in strange error.
  ;; (ql/smooth)
  (ql/frame-rate 30)
  
  ;; Set the background colour to a nice shade of grey.
  (ql/background 200)
  
  ;; Initialize the camera.
  ;; And start retrieving liveview images.
  (ft/init)
  ;; Wai a bit.
  (Thread/sleep 1000)
  (ft/retrieveLiveView liveview-agt))


;; ## Draw function for Quil
(defn draw []
  (when-not (= @liveview-agt nil)
    ;; Bind BufferedImage type  data to bimg
    ;; Bind PImage type data, which we want to display in a sketch, to pimg
    (let [bimg   (ImageIO/read (ByteArrayInputStream. @liveview-agt))
          pimg   (ql/create-image (.getWidth bimg) (.getHeight bimg) PConstants/RGB)
          width  (.width pimg)
          height (.height pimg)
          pixels (.pixels pimg)
          ]
      ;; Set pimg pixels array as bimg pixels array.
      (-> bimg (.getRGB 0 0 width height pixels 0 width))
      (.updatePixels pimg)
      ;; And, display it!
      (ql/image pimg 0 0)
      )))


;; ## Sketch defenition for Quil
(defn -main
  "This is liveview example."
  [& args]
  (ql/defsketch liveview                 ;; Define a new sketch named liveview
    :title "Sony Camera Livevew Sample." ;; Set the title of the sketch
    :setup setup                         ;; Specify the setup fn
    :draw draw                           ;; Specify the draw fn
    :size [640 480])                     ;; You struggle to beat the golden ratio
  )