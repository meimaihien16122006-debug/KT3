package vn.udn.ute.kt04_fragment_2415053122217.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import vn.udn.ute.kt04_fragment_2415053122217.R
class XacNhanVeFragment : Fragment() {

    private lateinit var txtMaVe: TextView
    private lateinit var txtHoTen: TextView
    private lateinit var txtSoLuong: TextView
    private lateinit var txtTienGoc: TextView
    private lateinit var btnQuayLai: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_xac_nhan_ve, container, false)
        txtMaVe = view.findViewById(R.id.txtMaVe)
        txtHoTen = view.findViewById(R.id.txtHoTen)
        txtSoLuong = view.findViewById(R.id.txtSoLuong)
        txtTienGoc = view.findViewById(R.id.txtTienGoc)
        btnQuayLai = view.findViewById(R.id.btnQuayLai)
        val maVe = bundle.getString("maVe") ?: ""
        val hoTen = bundle.getString("hoTen") ?: ""
        val soLuong = bundle.getInt("soLuong", 0)
        val tienGoc = soLuong * 50000
        txtMaVe.text = "Mã vé: $maVe"
        txtHoTen.text = "Họ tên: $hoTen"
        txtSoLuong.text = "Số lượng: $soLuong"
        txtTienGoc.text = "Tiền gốc: %,d đ".format(tienGoc)
    }

    btnQuayLai.setOnClickListener {
        parentFragmentManager.popBackStack()
    }

    return view
}

