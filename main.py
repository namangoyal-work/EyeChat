import cv2
import time
import numpy as np
import os
import socket

from utils import obj

def espeak(st):
    os.system("espeak "+st)

eye = obj("Eyes",["Open", "Close"],[[0.07,0.3,0.05,0.6],[0.7,0.93,0.05,0.6]],'/home/k00lk0der1/opencv/data/haarcascades/haarcascade_frontalface_default.xml','/home/k00lk0der1/opencv/data/haarcascades/haarcascade_mcs_eyepair_big.xml')
cap = eye.initialize(espeak)
eye.initialize_means_roi()
font = cv2.FONT_HERSHEY_SIMPLEX
send=False
while(True):
    ret, img = cap.read()
    ty, st = eye.detect2(img)
    if(send):
        s.send((st+"\n").encode('utf-8'))
    cv2.putText(img, st, (20,40), font, 1,(255,255,255),2)
    cv2.imshow('imgSate', img)
    if 0xFF & cv2.waitKey(5) == 27:
        break
    if cv2.waitKey(5) == 32:
        if(not send):
            print("Connect")
            s = socket.socket()
            s.connect(("10.1.28.125", 8960))#Change IP here
            send=True
    
cv2.destroyAllWindows()
cap.release()
