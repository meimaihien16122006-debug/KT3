package vn.udn.ute.kt04_fragment_2415053122217.utils

fun String.chuanHoaten(): String {
    return this.trim().replace(Regex("\\s+"), " ")
}
object QuyTacPhieu {
    private var currentIndex = 1
    fun taoMaPhieu(soThutu: Int): String {
        return "VE$soThutu"
    }
    fun getNextIndex(): Int = currentIndex++
}