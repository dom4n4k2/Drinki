import cv2

import pytesseract

pytesseract.pytesseract.tesseract_cmd=r'C:\\Program Files\\Tesseract-OCR\\tesseract.exe'



img = cv2.imread('drinki_output\\Scan_20210305 (1)a2.jpg')
text = pytesseract.image_to_string(img)
print(text)