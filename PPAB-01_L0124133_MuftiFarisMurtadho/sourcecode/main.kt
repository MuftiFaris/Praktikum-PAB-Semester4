// ==========================================
// [WAJIB 1] DATA TYPES & VARIABLES
// ==========================================
data class Mahasiswa(
    val nim: String,      // String (data type), val (immutable variable)
    var nama: String,     // String (data type), var (mutable variable)
    var nilai: Int        // Int (data type)
)

// ==========================================
// [WAJIB 2] CLASS + FUNCTIONS (selain main)
// ==========================================
class SistemMahasiswa {

    private val data: MutableList<Mahasiswa> = mutableListOf()

    // ---------------------------------------------------------
    // [TAMBAHAN 3] VARIABLE ARGUMENT (VARARG)
    // Memungkinkan memasukkan lebih dari 1 mahasiswa sekaligus
    // ---------------------------------------------------------
    fun tambah(vararg mahasiswas: Mahasiswa) {
        for (m in mahasiswas) {
            data.add(m)
        }
    }

    // ---------------------------------------------------------
    // [TAMBAHAN 2] DEFAULT ARGUMENT
    // Parameter pesanKosong memiliki nilai default jika tidak diisi
    // ---------------------------------------------------------
    fun tampil(pesanKosong: String = "Data kosong") {
        if (data.isEmpty()) {
            println(pesanKosong) 
        } else {
            data.forEachIndexed { i, m ->

                val nomor = i + 1
                println(nomor.toString() + ". " + m.nim + " - " + m.nama + " - " + m.nilai.toString())
            }
        }
    }
        
    // ==========================================
    // [WAJIB 3] NULLABLE TYPES & [WAJIB 4] SAFE CALLS
    // Parameter keyword adalah Nullable (String?)
    // ==========================================
    fun cari(keyword: String?) { 
        // [WAJIB 4] Safe call (?.)
        val trimmed = keyword?.trim()

        val key = if (trimmed != null) trimmed else ""   

        val hasil = data.filter {
            it.nim.contains(key, ignoreCase = true)
        }

        if (hasil.isEmpty()) {
            println("Tidak ditemukan")
            return
        }

        if (hasil.size == 1) {
            val m = hasil[0]
            println("Ditemukan: " + m.nim + " - " + m.nama + " - " + m.nilai.toString())
            return
        }

        println("Ditemukan lebih dari satu:")
        hasil.forEachIndexed { i, m ->
            val nomor = i + 1
            println(nomor.toString() + ". " + m.nim + " - " + m.nama)
        }

        print("Pilih nomor: ")
        val pilih = readLine()?.toIntOrNull() // Safe call

        if (pilih == null || pilih !in 1..hasil.size) {
            println("Pilihan tidak valid")
            return
        }

        val m = hasil[pilih - 1]
        println("Hasil final: " + m.nim + " - " + m.nama + " - " + m.nilai.toString())
    }

    fun hapus(keyword: String?) {
        val trimmed = keyword?.trim()
        val key = if (trimmed != null) trimmed else ""

        val hasil = data.filter {
            it.nim.contains(key, ignoreCase = true)
        }

        if (hasil.isEmpty()) {
            println("Tidak ditemukan")
            return
        }

        // ==========================================
        // [WAJIB 5] IF EXPRESSION (Mengembalikan nilai ke variabel)
        // ==========================================
        val target = if (hasil.size == 1) {
            hasil[0]
        } else {
            println("Ditemukan lebih dari satu:")
            hasil.forEachIndexed { i, m ->
                val nomor = i + 1
                println(nomor.toString() + ". " + m.nim + " - " + m.nama)
            }

            print("Pilih nomor yang akan dihapus: ")
            val pilih = readLine()?.toIntOrNull()

            if (pilih == null || pilih !in 1..hasil.size) {
                println("Pilihan tidak valid")
                return
            }
            hasil[pilih - 1]
        }

        print("Apakah anda yakin menghapus " + target.nim + "? (y/n): ")
        
        val inputConfirm = readLine()?.lowercase() // Safe call
        val confirm = if (inputConfirm != null) inputConfirm else ""

        if (confirm == "y") {
            data.remove(target)
            println("Data dihapus")
        } else {
            println("Dibatalkan")
        }
    }

    fun update(keyword: String?, namaBaru: String, nilaiBaru: Int) {
        val trimmed = keyword?.trim()
        val key = if (trimmed != null) trimmed else ""

        val hasil = data.filter {
            it.nim.contains(key, ignoreCase = true)
        }

        if (hasil.isEmpty()) {
            println("Tidak ditemukan")
            return
        }

        val target = if (hasil.size == 1) {
            hasil[0]
        } else {
            println("Ditemukan lebih dari satu:")
            hasil.forEachIndexed { i, m ->
                val nomor = i + 1
                println(nomor.toString() + ". " + m.nim + " - " + m.nama)
            }

            print("Pilih nomor yang akan diupdate: ")
            val pilih = readLine()?.toIntOrNull()

            if (pilih == null || pilih !in 1..hasil.size) {
                println("Pilihan tidak valid")
                return
            }
            hasil[pilih - 1]
        }

        print("Yakin update " + target.nim + " menjadi [" + namaBaru + ", " + nilaiBaru.toString() + "]? (y/n): ")
        
        val inputConfirm = readLine()?.lowercase()
        val confirm = if (inputConfirm != null) inputConfirm else ""

        if (confirm == "y") {
            target.nama = namaBaru
            target.nilai = nilaiBaru
            println("Data diupdate")
        } else {
            println("Dibatalkan")
        }
    }
}

// Nama : Mufti Faris Murtadho
// NIM  : L0124133


fun main() {
    val sistem = SistemMahasiswa()

    while (true) {
        println("=-=-=-=-= MENU =-=-=-=-=")
        println("1. Tambah")
        println("2. Tampil")
        println("3. Cari")
        println("4. Update")
        println("5. Hapus")
        println("6. Keluar")
        print("Pilih: ")
        
        val input = readLine()
        val pilih = if (input != null) input.toIntOrNull() else null

        when (pilih) {
            1 -> {
                print("NIM: ")
                val inputNim = readLine()
                val nim = if (inputNim != null) inputNim else ""

                print("Nama: ")
                val inputNama = readLine()
                val nama = if (inputNama != null) inputNama else ""

                print("Nilai: ")
                val inputNilai = readLine()?.toIntOrNull()
                val nilai = if (inputNilai != null) inputNilai else 0

                sistem.tambah(Mahasiswa(nim, nama, nilai))
            }
            
            2 -> {
                // Memanggil dengan Default Argument (tanpa mengisi parameter)
                sistem.tampil()
            }

            3 -> {
                print("Keyword NIM: ")
                val key = readLine()
                sistem.cari(key)
            }

            4 -> {
                print("NIM: ")
                val inputNim = readLine()
                val nim = if (inputNim != null) inputNim else ""

                print("Nama baru: ")
                val inputNama = readLine()
                val nama = if (inputNama != null) inputNama else ""

                print("Nilai baru: ")
                val inputNilai = readLine()?.toIntOrNull()
                val nilai = if (inputNilai != null) inputNilai else 0

                // ---------------------------------------------------------
                // [TAMBAHAN 1] NAMED ARGUMENT
                // Menyebutkan nama parameter secara eksplisit saat pemanggilan
                // ---------------------------------------------------------
                sistem.update(keyword = nim, namaBaru = nama, nilaiBaru = nilai)
            }

            5 -> {
                print("NIM dihapus: ")
                val inputNim = readLine()
                val nim = if (inputNim != null) inputNim else ""
                sistem.hapus(nim)
            }

            6 -> return

            else -> println("Input tidak valid")
        }
    }
}