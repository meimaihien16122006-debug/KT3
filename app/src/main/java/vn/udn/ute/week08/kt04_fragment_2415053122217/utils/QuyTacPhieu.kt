package vn.udn.ute.week08.kt04_fragment_2415053122217.utils

fun String.chuanHoaten_2217(): String {
    return this.trim().replace(Regex("\\s+"), " ")
}
object QuyTacPhieu_2217 {
    private var currentIndex = 1
    fun taoMaPhieu_2217(soThutu: Int): String {
        return "VE$soThutu"
    }
    fun getNextIndex(): Int = currentIndex++
}