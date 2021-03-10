# Improting Image class from PIL module
from PIL import Image

# Opens a image in RGB mode

start_file_name ="Scan_20210305 ("
start_file_read_count = 1
stop_file_read_count = 26
input_folder_name = "shoty_output"
output_folder_name = "shoty_output2"
alphabet = ['a','b','c','d']

for y in range(1):
    for x in range(len(alphabet)):
        while start_file_read_count <= stop_file_read_count:
            img_name = input_folder_name +"\\"+ start_file_name + str(start_file_read_count) + ")"+alphabet[x]+str(y+1)+".jpg"
            print(img_name)
            im = Image.open(img_name)
            width, height = im.size

            left_a1=120
            top_a1=120
            right_a1=1330
            bottom_a1 = 2000


            im1 = im.crop((left_a1, top_a1, right_a1, bottom_a1))
            newsize = (200,300)
            im1 = im1.resize(newsize)
            # Shows the image in image viewer
            im1.save(output_folder_name +"\\" + start_file_name + str(start_file_read_count) +")"+alphabet[x]+str(y+1)+".jpg" )
            start_file_read_count =start_file_read_count + 1
        start_file_read_count = 1