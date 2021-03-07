# Improting Image class from PIL module
from PIL import Image

# Opens a image in RGB mode

start_file_name ="Scan_20210305 ("
start_file_read_count = 1
stop_file_read_count = 26
input_folder_name = "shoty"
output_folder_name = "shoty_output"
while start_file_read_count <= stop_file_read_count:
    img_name = input_folder_name +"\\"+ start_file_name + str(start_file_read_count) + ").jpg"
    print(img_name)
    im = Image.open(img_name)
    width, height = im.size

    left_a1=0
    top_a1=0
    right_a1=0.2455*width
    bottom_a1 = 0.577*height

    left_a2=0
    top_a2=0.475*height
    right_a2=0.2455*width
    bottom_a2 =height

    left_b1=0.2455*width
    top_b1=0
    right_b1=0.5*width
    bottom_b1 = 0.577*height

    left_b2=0.2455*width
    top_b2=0.475*height
    right_b2=0.5*width
    bottom_b2 =height


    left_c1=0.5*width
    top_c1=0
    right_c1=0.7572*width
    bottom_c1 = 0.577*height

    left_c2=0.5*width
    top_c2=0.475*height
    right_c2=0.7572*width
    bottom_c2 =height

    left_d1=0.7572*width
    top_d1=0
    right_d1=width
    bottom_d1 = 0.577*height

    left_d2=0.7572*width
    top_d2=0.475*height
    right_d2=width
    bottom_d2 =height





    im1 = im.crop((left_a1, top_a1, right_a1, bottom_a1))
    im2 = im.crop((left_a2, top_a2, right_a2, bottom_a2))

    im3 = im.crop((left_b1, top_b1, right_b1, bottom_b1))
    im4 = im.crop((left_b2, top_b2, right_b2, bottom_b2))

    im5 = im.crop((left_c1, top_c1, right_c1, bottom_c1))
    im6 = im.crop((left_c2, top_c2, right_c2, bottom_c2))

    im7 = im.crop((left_d1, top_d1, right_d1, bottom_d1))
    im8 = im.crop((left_d2, top_d2, right_d2, bottom_d2))

    # Shows the image in image viewer
    im1.save(output_folder_name +"\\" + start_file_name + str(start_file_read_count) +")a1.jpg" )
    im2.save(output_folder_name +"\\" + start_file_name + str(start_file_read_count) +")a2.jpg" )
    im3.save(output_folder_name +"\\" + start_file_name + str(start_file_read_count) +")b1.jpg" )
    im4.save(output_folder_name +"\\" + start_file_name + str(start_file_read_count) +")b2.jpg" )
    im5.save(output_folder_name +"\\" + start_file_name + str(start_file_read_count) +")c1.jpg" )
    im6.save(output_folder_name +"\\" + start_file_name + str(start_file_read_count) +")c2.jpg" )
    im7.save(output_folder_name +"\\" + start_file_name + str(start_file_read_count) +")d1.jpg" )
    im8.save(output_folder_name +"\\" + start_file_name + str(start_file_read_count) +")d2.jpg" )
    start_file_read_count =start_file_read_count + 1