import tensorflow as tf
import numpy as np
from PIL import Image

interpreter = tf.lite.Interpreter(model_path="plant_disease_model.tflite")
interpreter.allocate_tensors()

input_details = interpreter.get_input_details()
output_details = interpreter.get_output_details()

img = Image.open("D:\PKL_Adip Radi Triya\lomba\image.png").resize((224, 224))
img = np.array(img, dtype=np.float32) / 255.0
img = np.expand_dims(img, axis=0)

interpreter.set_tensor(input_details[0]['index'], img)
interpreter.invoke()

output_data = interpreter.get_tensor(output_details[0]['index'])
predicted_label = np.argmax(output_data)

print("Prediksi Index:", predicted_label)
print("Probabilitas Tiap Label:", output_data)
