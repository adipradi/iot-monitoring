package com.example.plantdiseaseapp

object Chatbot {
    fun getResponse(label: String): String {
        return when (label.lowercase()) {
            "late_blight" -> """
                🌿 Penyakit: Hawar Daun (Late Blight)
                🔍 Gejala: Bercak kecokelatan, batang busuk, daun layu
                💡 Solusi:
                - Gunakan fungisida berbasis tembaga
                - Pangkas daun terinfeksi
                - Hindari penyiraman berlebih
            """.trimIndent()

            "early_blight" -> """
                🌿 Penyakit: Bercak Daun Awal (Early Blight)
                🔍 Gejala: Bercak bulat hitam di daun tua
                💡 Solusi:
                - Gunakan fungisida klorotalonil atau mankozeb
                - Buang daun terinfeksi
                - Jaga kelembapan optimal
            """.trimIndent()

            "healthy" -> """
                ✅ Tanaman sehat!
                🌿 Teruskan perawatan rutin:
                - Cukup sinar matahari
                - Penyiraman teratur
                - Cek rutin hama & penyakit
            """.trimIndent()

            else -> """
                🤖 Maaf, saya belum tahu penyakit dengan label: \"$label\"
                Coba lagi dengan gambar lain.
            """.trimIndent()
        }
    }
}
